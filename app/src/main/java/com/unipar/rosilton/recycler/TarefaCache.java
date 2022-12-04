package com.unipar.rosilton.recycler;

import java.util.ArrayList;

/**
 * Classe com metodos static para substituir o uso de um armazenamento de dados permanente.
 * A finalidade dessa classe e permitir o sistema possuir dados para serem apresentados e modificados.
 * Observacao, ao carregar o sistema os dados sao sempre os mesmos e as modificacoes serao perdidas.
 */
public class TarefaCache {
    private static ArrayList<Tarefa> tarefas;

    //Obtem todas as tarefas disponiveis
    public static ArrayList<Tarefa> getTarefas() {
        if (tarefas == null) {
            tarefas = new ArrayList<>();
            //Tarefas sendo adicionadas no ArrayList, utilizando id sequencial para fins de controle interno
            tarefas.add(new Tarefa(1, "Supermercado", "Comprar: legumes, frutas, leite e pão."));
            tarefas.add(new Tarefa(2, "Higiene geral", "Limpar cozinha, banheiro e lavanderia."));
            tarefas.add(new Tarefa(3, "Estudo unipar", "Fazer a as AR de PDM e DIHC."));
            tarefas.add(new Tarefa(4, "Inverno", "Cortar Lenha e acender o fogão."));
            tarefas.add(new Tarefa(5, "Jardim", "Cortar a grama."));
            tarefas.add(new Tarefa(6, "Pet Shop", "Levar o cachorro ao banho e tosa."));
            tarefas.add(new Tarefa(7, "Saúde", "Fazer mais exercícios e tomar água"));
            tarefas.add(new Tarefa(8, "Mecânica do Uno", "Troca de óleo e fluídos e pastilhas."));
        }

        return tarefas;
    }

    //Obtem uma tarefa a partir do seu id
    public static Tarefa getTarefa(int id) {
        return tarefas.get(id - 1);
    }

    //Altera uma tarefa a partir do seu id
    public static void updateTarefa(int id, String nome, String descricao, boolean finalizada) {
        Tarefa a = getTarefa(id);
        a.setNome(nome);
        a.setDescricao(descricao);
        a.setFinalizada(finalizada);
    }
}
