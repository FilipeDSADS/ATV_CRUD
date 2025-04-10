package com.gerenciamento.rpg.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personagem")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String nomeAventureiro;
    private Classe classe;
    private Integer level;
    private Integer forca;
    private Integer defesa;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItemMagico> itensMagicos = new ArrayList<>();

    public Personagem(){
    }

    public Personagem(Long id, String nome, String nomeAventureiro, Classe classe, Integer level, Integer forca, Integer defesa) {
        this.id = id;
        this.nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.classe = classe;
        this.level = level;
        this.forca = forca;
        this.defesa = defesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeAventureiro() {
        return nomeAventureiro;
    }

    public void setNomeAventureiro(String nomeAventureiro) {
        this.nomeAventureiro = nomeAventureiro;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public List<ItemMagico> getItensMagicos() {
        return itensMagicos;
    }

    public void setItensMagicos(List<ItemMagico> itemMagico) {
        this.itensMagicos = itemMagico;
    }

    @JsonProperty("forcaTotal")
    public int getForcaTotal() {
        int bonus = 0;
        if (itensMagicos != null) {
            bonus = itensMagicos.stream().mapToInt(ItemMagico::getForca).sum();
        }
        return this.forca + bonus;
    }

    @JsonProperty("defesaTotal")
    public int getDefesaTotal() {
        int bonus = 0;
        if (itensMagicos != null) {
            bonus = itensMagicos.stream().mapToInt(ItemMagico::getDefesa).sum();
        }
        return this.defesa + bonus;
    }

}
