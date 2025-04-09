package com.gerenciamento.rpg.Service;

import com.gerenciamento.rpg.Model.Personagem;
import com.gerenciamento.rpg.Repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public ResponseEntity<Personagem> criarPersonagem(@RequestBody Personagem personagem){
        Personagem novoPersonagem = personagemRepository.save(personagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPersonagem);
    }

    public ResponseEntity<List<Personagem>> getAllPersonagens(){
        List<Personagem> todosPersonagens = personagemRepository.findAll();
        return ResponseEntity.ok(todosPersonagens);
    }

    public ResponseEntity<Optional<Personagem>> getPersonagemById(@PathVariable Long id){
        Optional<Personagem> getPersonagemById = personagemRepository.findById(id);
        return ResponseEntity.ok(getPersonagemById);
    }

    public ResponseEntity<?> deletePersonagemById(@PathVariable Long id){
        personagemRepository.deleteById(id);
        return ResponseEntity.ok("Deletado!");
    }

    public ResponseEntity<Personagem> updatePersonagemById(@RequestBody Personagem updatePersonagem, @PathVariable Long id){
        return personagemRepository.findById(id).map(personagem -> {
            personagem.setNome(updatePersonagem.getNome());
            personagem.setNomeAventureiro(updatePersonagem.getNomeAventureiro());
            personagem.setLevel(updatePersonagem.getLevel());
            personagem.setForca(updatePersonagem.getForca());
            personagem.setDefesa((updatePersonagem.getDefesa()));

            Personagem updatedPersonagem = personagemRepository.save(personagem);
            return ResponseEntity.ok(updatePersonagem);
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

}
