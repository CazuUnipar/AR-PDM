package com.unipar.rosilton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.unipar.rosilton.activity.BaseActivity;

/**
 * Activity principal do sistema. Essa tela contem apenas um texto introdutorio e um botao para
 * navegar para a proxima tela: ListaActivity.
 */
public class MainActivity extends BaseActivity {
    private Button btnListagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Listener para o botao da tela, o qual troca de tela
        this.btnListagem = findViewById(R.id.activity_main_button);
        this.btnListagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaTelaLista();
            }
        });
    }
}