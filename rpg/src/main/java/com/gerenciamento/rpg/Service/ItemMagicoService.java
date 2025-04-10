package com.gerenciamento.rpg.Service;

import com.gerenciamento.rpg.Model.ItemMagico;
import com.gerenciamento.rpg.Model.TipoItem;
import com.gerenciamento.rpg.Model.Personagem;
import com.gerenciamento.rpg.Repository.PersonagemRepository;
import com.gerenciamento.rpg.Repository.ItemMagicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ItemMagicoService {

    @Autowired
    private ItemMagicoRepository itemMagicoRepository;
    @Autowired
    private PersonagemRepository personagemRepository;

    public ResponseEntity<ItemMagico> criarItemMagico(@RequestBody ItemMagico itemMagico){
        if (itemMagico.getForca() == 0 && itemMagico.getDefesa() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        if (itemMagico.getForca() > 10 || itemMagico.getDefesa() > 10) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        switch (itemMagico.getTipoItem()) {
            case ARMA:
                if (itemMagico.getDefesa() != 0) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
                }
                break;
            case ARMADURA:
                if (itemMagico.getForca() != 0) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
                }
                break;
            case AMULETO:
                if (itemMagico.getPersonagem() != null) {
                    Long personagemId = itemMagico.getPersonagem().getId();

                    List<ItemMagico> itensDoPersonagem = itemMagicoRepository.findAll();
                    long amuletos = itensDoPersonagem.stream()
                            .filter(i -> i.getPersonagem() != null)
                            .filter(i -> i.getPersonagem().getId().equals(personagemId))
                            .filter(i -> i.getTipoItem() == TipoItem.AMULETO)
                            .count();

                    if (amuletos >= 1) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
                    }
                }
                break;
        }

        ItemMagico novoItemMagico = itemMagicoRepository.save(itemMagico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoItemMagico);
    }

    public ResponseEntity<List<ItemMagico>> getAllItemMagico(){
        List<ItemMagico> todosItensMagicos = itemMagicoRepository.findAll();
        return ResponseEntity.ok(todosItensMagicos);
    }

    public ResponseEntity<Optional<ItemMagico>> getItemMagicoById(@PathVariable Long id){
        Optional<ItemMagico> getItemMagicoById = itemMagicoRepository.findById(id);
        return ResponseEntity.ok(getItemMagicoById);
    }

    public ResponseEntity<?> deleteItemMagicoById(@PathVariable Long id){
        itemMagicoRepository.deleteById(id);
        return ResponseEntity.ok("Deletado!");
    }

    public ResponseEntity<ItemMagico> updateItemMagicoById(@RequestBody ItemMagico updateItemMagico, @PathVariable Long id){
        return itemMagicoRepository.findById(id).map(itemMagico -> {
            itemMagico.setNome(updateItemMagico.getNome());
            itemMagico.setTipoItem(updateItemMagico.getTipoItem());
            itemMagico.setForca(updateItemMagico.getForca());
            itemMagico.setDefesa((updateItemMagico.getDefesa()));

            ItemMagico updatedItemMagico = itemMagicoRepository.save(itemMagico);
            return ResponseEntity.ok(updatedItemMagico);
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    public ResponseEntity<ItemMagico> atribuirItemAoPersonagem(Long itemId, Long personagemId) {
        Optional<ItemMagico> itemMag = itemMagicoRepository.findById(itemId);
        Optional<Personagem> personagemOpt = personagemRepository.findById(personagemId);

        if (itemMag.isPresent() && personagemOpt.isPresent()) {
            ItemMagico item = itemMag.get();
            Personagem personagem = personagemOpt.get();

            if (item.getTipoItem() == TipoItem.AMULETO) {
                long amuletos = personagem.getItensMagicos().stream().filter(i -> i.getTipoItem() == TipoItem.AMULETO).count();
                if (amuletos >= 1) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
                }
            }

            item.setPersonagem(personagem);

            if (!personagem.getItensMagicos().contains(item)) {
                personagem.getItensMagicos().add(item);
            }

            itemMagicoRepository.save(item);
            return ResponseEntity.ok(item);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


}
