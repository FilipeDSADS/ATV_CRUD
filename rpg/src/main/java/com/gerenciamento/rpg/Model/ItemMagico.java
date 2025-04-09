package com.gerenciamento.rpg.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "ItensMágicos")
public class ItemMagico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private TipoItem tipoItem;
    private Integer forca;
    private Integer defesa;

    public ItemMagico(){}

    public ItemMagico(Long id, String nome, TipoItem tipoItem, Integer forca, Integer defesa) {
        this.id = id;
        this.nome = nome;
        this.tipoItem = tipoItem;
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

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
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
}
