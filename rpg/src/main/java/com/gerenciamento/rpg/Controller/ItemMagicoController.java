package com.gerenciamento.rpg.Controller;

import com.gerenciamento.rpg.Model.ItemMagico;
import com.gerenciamento.rpg.Model.Personagem;
import com.gerenciamento.rpg.Service.ItemMagicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ItemMagico")
public class ItemMagicoController {

    @Autowired
    private ItemMagicoService itemMagicoService;

    @PostMapping("/criar-itemMagico")
    public ResponseEntity<ItemMagico> criarItemMagico(@RequestBody ItemMagico itemMagico){
        return itemMagicoService.criarItemMagico(itemMagico);
    }

    @GetMapping("/lista-todos-itemMagico")
    public ResponseEntity<List<ItemMagico>> getAllItemMagico(){
        return itemMagicoService.getAllItemMagico();
    }


}
