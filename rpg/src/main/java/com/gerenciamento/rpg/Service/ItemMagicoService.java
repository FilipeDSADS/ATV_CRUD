package com.gerenciamento.rpg.Service;

import com.gerenciamento.rpg.Model.ItemMagico;
import com.gerenciamento.rpg.Repository.ItemMagicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ItemMagicoService {

    @Autowired
    private ItemMagicoRepository itemMagicoRepository;

    public ResponseEntity<ItemMagico> criarItemMagico(@RequestBody ItemMagico itemMagico){
        ItemMagico novoItemMagico = itemMagicoRepository.save(itemMagico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoItemMagico);
    }

    public ResponseEntity<List<ItemMagico>> getAllItemMagico(){
        List<ItemMagico> todosItensMagicos = itemMagicoRepository.findAll();
        return ResponseEntity.ok(todosItensMagicos);
    }

}
