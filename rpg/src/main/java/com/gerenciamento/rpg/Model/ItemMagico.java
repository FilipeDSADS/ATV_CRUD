package com.gerenciamento.rpg.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "ItensMágicos")
public class ItemMagico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Integer forca;
    private Integer defesa;


}
