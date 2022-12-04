package com.unipar.rosilton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.unipar.rosilton.activity.BaseActivity;
import com.unipar.rosilton.recycler.Tarefa;
import com.unipar.rosilton.recycler.TarefaAdapter;
import com.unipar.rosilton.recycler.TarefaCache;

import java.util.ArrayList;

/**
 * Activity de listagem das tarefas do sistema.
 * Essa activity utiliza o RecyclerView na tela com o apoio de um Linear layout.
 * A partir dessa tela existe a possibilidade de navegacao para uma outra: DetalheActivity.
 */
public class ListaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        //Obtendo do Cache a lista de tarefas que sera exibida na tela no recycler view
        ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
        tarefas.addAll(TarefaCache.getTarefas());

        //Inicializando o recycler view com o linear layout de apoio
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recycler = findViewById(R.id.lista_recycler_view);
        recycler.setLayoutManager(linearLayoutManager);

        //Inicializando o adapter do recycler view
        TarefaAdapter tarefaAdapter = new TarefaAdapter(this, tarefas);
        recycler.setAdapter(tarefaAdapter);
    }
}