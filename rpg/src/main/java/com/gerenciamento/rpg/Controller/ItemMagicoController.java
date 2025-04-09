package com.gerenciamento.rpg.Controller;

import com.gerenciamento.rpg.Model.ItemMagico;
import com.gerenciamento.rpg.Model.Personagem;
import com.gerenciamento.rpg.Service.ItemMagicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/listar-itemMagico-id/{id}")
    public ResponseEntity<Optional<ItemMagico>> getItemMagicoById(@PathVariable Long id){
        return itemMagicoService.getItemMagicoById(id);
    }

    @DeleteMapping("/delete-ItemMagico-id/{id}")
    public ResponseEntity<?> deleteItemMagicoById(@PathVariable Long id){
        return itemMagicoService.deleteItemMagicoById(id);
    }

    @PutMapping("/update-itemMagico-id/{id}")
    public ResponseEntity<ItemMagico> updateItemMagico(@RequestBody ItemMagico itemMagico, @PathVariable Long id){
        return itemMagicoService.updateItemMagicoById(itemMagico, id);
    }

}
