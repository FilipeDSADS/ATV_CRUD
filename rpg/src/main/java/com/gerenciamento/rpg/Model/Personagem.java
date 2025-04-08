package com.gerenciamento.rpg.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "personagem")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String nomeAventureiro;
    private Integer level;
    private Integer forca;
    private Integer defesa;

    public Personagem(){
    }




}
