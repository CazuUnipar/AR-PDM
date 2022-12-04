package com.unipar.rosilton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.material.textfield.TextInputEditText;
import com.unipar.rosilton.activity.BaseActivity;
import com.unipar.rosilton.recycler.Tarefa;
import com.unipar.rosilton.recycler.TarefaCache;

/**
 * Activity que apresenta os detalhes de uma tarefa no sistema, a partir de um clique na ListaActivity chega-se aqui.
 * A tela apresentara 3 campos pertencentes a tarefa, permite edicao, e duas acoes: Salvar ou Voltar.
 */
public class DetalheActivity extends BaseActivity {
    private Button btnSalvar;
    private Button btnVoltar;
    private int idTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        //Obtendo o id da tarefa que e passado como parametro atraves do Intent
        //Obtem tambem o objeto tarefa no cache com o id
        this.idTarefa = Integer.parseInt(getIntent().getStringExtra("idTarefa"));
        Tarefa a = TarefaCache.getTarefa(idTarefa);

        //Com o objeto tarefa, atualiza os campos na tela para exibicao dos valores
        TextInputEditText inputNome = findViewById(R.id.detalhe_atividade_nome);
        inputNome.setText(a.getNome());
        TextInputEditText inputDescricao = findViewById(R.id.detalhe_atividade_descricao);
        inputDescricao.setText(a.getDescricao());

        //Listener para o botao Salvar
        this.btnSalvar = findViewById(R.id.btnSalvar);
        this.btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        //Listener para o botao Voltar
        this.btnVoltar = findViewById(R.id.btnVoltar);
        this.btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltar();
            }
        });
    }

    //Logica do botao Salvar, obtem os valores dos campos na tela e atualiza no Cache
    private void salvar() {
        TextInputEditText inputNome = findViewById(R.id.detalhe_atividade_nome);
        TextInputEditText inputDescricao = findViewById(R.id.detalhe_atividade_descricao);
        CheckBox checkboxFinalizada = findViewById(R.id.chkFinalizada);
        TarefaCache.updateTarefa(this.idTarefa, inputNome.getText().toString(), inputDescricao.getText().toString(), checkboxFinalizada.isChecked());

        irParaTelaLista();
    }

    private void voltar() {
        irParaTelaLista();
    }
}