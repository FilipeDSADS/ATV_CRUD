package com.gerenciamento.rpg.Service;

import com.gerenciamento.rpg.Repository.ItemMagicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemMagicoService {

    @Autowired
    private ItemMagicoRepository itemMagicoRepository;
}
