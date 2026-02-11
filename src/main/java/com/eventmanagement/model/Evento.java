package com.eventmanagement.model;

import java.time.LocalDate;

public class Evento {
    private Integer id;
    private String nome;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Boolean ativo;
    private Integer instituicaoId;
    private String nomeInstituicao;

    public Evento() {}
    
    public Evento(Integer id, String nome, LocalDate dataInicial, 
                  LocalDate dataFinal, Boolean ativo, Integer instituicaoId) {
        this.id = id;
        this.nome = nome;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.ativo = ativo;
        this.instituicaoId = instituicaoId;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public LocalDate getDataInicial() {
        return dataInicial;
    }
    
    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }
    
    public LocalDate getDataFinal() {
        return dataFinal;
    }
    
    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }
    
    public Boolean getAtivo() {
        return ativo;
    }
    
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    public Integer getInstituicaoId() {
        return instituicaoId;
    }
    
    public void setInstituicaoId(Integer instituicaoId) {
        this.instituicaoId = instituicaoId;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }
    
    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }
}