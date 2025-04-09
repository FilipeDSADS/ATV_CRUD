package com.gerenciamento.rpg.Controller;

import com.gerenciamento.rpg.Model.Personagem;
import com.gerenciamento.rpg.Service.PersonagemService;
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

    @DeleteMapping("/delete-personagem-id/{id}")
    public ResponseEntity<?> deletePersonagemById(@PathVariable Long id){
        return personagemService.deletePersonagemById(id);
    }

    @PutMapping("/update-personagem-id/{id}")
    public ResponseEntity<Personagem> updatePersonagem(@RequestBody Personagem personagem, @PathVariable Long id){
        return personagemService.updatePersonagemById(personagem, id);
    }

}
