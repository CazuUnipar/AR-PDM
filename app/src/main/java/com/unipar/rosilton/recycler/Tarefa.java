package com.unipar.rosilton.recycler;

/**
 * Classe model. Representa o modelo de dados utilizado no projeto.
 * Representa uma tarefa no sistema de controle de tarefas.
 */
public class Tarefa {
    private int id;
    private String nome;
    private String descricao;
    private boolean finalizada;

    public Tarefa() {}

    public Tarefa(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Tarefa(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public String isFinalizadaString() {
        return (isFinalizada() ? "Finalizada" : "Não Finalizada");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}