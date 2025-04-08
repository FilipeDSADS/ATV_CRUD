package com.gerenciamento.rpg.Service;

import com.gerenciamento.rpg.Model.Personagem;
import com.gerenciamento.rpg.Repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
}
