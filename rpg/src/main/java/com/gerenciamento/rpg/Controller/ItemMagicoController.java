package com.gerenciamento.rpg.Controller;

import com.gerenciamento.rpg.Service.ItemMagicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ItemMagico")
public class ItemMagicoController {

    @Autowired
    private ItemMagicoService itemMagicoService;
}
