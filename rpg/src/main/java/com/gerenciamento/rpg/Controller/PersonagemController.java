package com.gerenciamento.rpg.Controller;

import com.gerenciamento.rpg.Model.Personagem;
import com.gerenciamento.rpg.Service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @PostMapping("/criar-personagem")
    public ResponseEntity<Personagem> criarPersonagem(@RequestBody Personagem personagem){
        return personagemService.criarPersonagem(personagem);
    }
}
