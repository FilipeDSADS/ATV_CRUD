package com.gerenciamento.rpg.Controller;

import com.gerenciamento.rpg.Model.ItemMagico;
import com.gerenciamento.rpg.Model.Personagem;
import com.gerenciamento.rpg.Service.ItemMagicoService;
import com.gerenciamento.rpg.Service.PersonagemService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;
    @Autowired
    private ItemMagicoService itemMagicoService;

    @PostMapping("/criar-personagem")
    public ResponseEntity<Personagem> criarPersonagem(@RequestBody Personagem personagem){
        return personagemService.criarPersonagem(personagem);
    }

    @GetMapping("/lista-todos-personagens")
    public ResponseEntity<List<Personagem>> getAllPersonagem(){
        return personagemService.getAllPersonagens();
    }

    @GetMapping("/listar-personagem-id/{id}")
    public ResponseEntity<Optional<Personagem>> getPersonagemById(@PathVariable Long id){
        return personagemService.getPersonagemById(id);
    }

    @GetMapping("/personagem/{id}/amuleto")
    public ResponseEntity<ItemMagico> getAmuletoDoPersonagem(@PathVariable Long id) {
        return personagemService.buscarAmuletoDoPersonagem(id);
    }


    @DeleteMapping("/delete-personagem-id/{id}")
    public ResponseEntity<?> deletePersonagemById(@PathVariable Long id){
        return personagemService.deletePersonagemById(id);
    }

    @PutMapping("/update-personagem-id/{id}")
    public ResponseEntity<Personagem> updatePersonagem(@RequestBody Personagem personagem, @PathVariable Long id){
        return personagemService.updatePersonagemById(personagem, id);
    }

    @PostMapping("/adicionar-item/{itemId}/personagem/{personagemId}")
    public ResponseEntity<ItemMagico> atribuirItemAoPersonagem(@PathVariable Long itemId, @PathVariable Long personagemId) {
        return itemMagicoService.atribuirItemAoPersonagem(itemId, personagemId);
    }

    @PostConstruct
    public void init() {
        System.out.println("ItemMagicoService está nulo? " + (itemMagicoService == null));
    }

}
