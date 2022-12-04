package com.unipar.rosilton.recycler;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.unipar.rosilton.DetalheActivity;
import com.unipar.rosilton.R;

import java.util.ArrayList;

/**
 * Classe Adapter para a model Tarefa, necessaria para fazer funcionar corretamente o RecyclerView
 */
public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder> {
    private Context context;
    private ArrayList<Tarefa> tarefas;

    //Construtor do Adapter, recebe o Context para armazenar como Parent para utilizar recursos de tela, como Intent por exemplo
    //Recebe o ArrayList de tarefas o qual sera apresentado na tela
    public TarefaAdapter(Context ctx, ArrayList<Tarefa> tarefas){
        this.context = ctx;
        this.tarefas = tarefas;
    }

    @NonNull
    @Override
    /**
     * Override obrigatorio do metodo onCreateViewHolder, inicializa a partir do elemento de tela (XML)
     */
    public TarefaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout, parent, false);
        TarefaViewHolder pvh = new TarefaViewHolder(v);

        return pvh;
    }

    @Override
    /**
     * Override obrigatorio do metodo onBindViewHolder, para cada elemento da listagem executa a logica abaixo
     */
    public void onBindViewHolder(@NonNull TarefaViewHolder holder, int position) {
        Tarefa tarefa = this.tarefas.get(position);
        holder.txtNome.setText(tarefa.getNome());
        holder.txtDescricao.setText(tarefa.getDescricao());
        holder.txtFinalizado.setText(tarefa.isFinalizadaString());

        if (tarefa.isFinalizada()) {
            holder.txtFinalizado.setTextColor(Color.parseColor("#00A300"));
        }
        else {
            holder.txtFinalizado.setTextColor(Color.parseColor("#FF0000"));
        }

        //Listener para click em cada elemento da listagem
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Trocando de tela, para a tela de detalhe, e passando o id como parametro
                Intent intentDetalhe = new Intent(context, DetalheActivity.class);
                intentDetalhe.putExtra("idTarefa", String.valueOf(tarefa.getId()));
                context.startActivity(intentDetalhe);
            }
        });
    }

    @Override
    //Overide obrigatorio do metodo getItemCount, retorna o total de elementos a partir do ArrayList de tarefas
    public int getItemCount() {
        return tarefas.size();
    }

    //Classe Holder, classe de apoio, para representar cada elemento na listagem, utiliza o layout (XML) cards_layout
    public static class TarefaViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView txtNome;
        TextView txtDescricao;
        TextView txtFinalizado;

        TarefaViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view_item);
            txtNome = (TextView)itemView.findViewById(R.id.item_nome);
            txtDescricao = (TextView)itemView.findViewById(R.id.item_descricao);
            txtFinalizado = (TextView)itemView.findViewById(R.id.item_finalizado);
        }
    }
}
