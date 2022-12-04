package com.unipar.rosilton.activity;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.unipar.rosilton.ListaActivity;
import com.unipar.rosilton.R;
import com.unipar.rosilton.SobreActivity;


/**
 * Classe Activity propria do projeto. Criada para concentrar atributos e metodos comuns e
 * compartilhados entre as outras activities do projeto
 *
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    //Override do metodo onCreateOptionsMenu para inicializar o menu na tela a partir do xml
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    //Override do metodo onOptionsItemSelected para tratamento de clique nas opcoes de menu
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_sobre:
                irParaTelaSobre();
                return true;

            case R.id.item_sair:
                finishAndRemoveTask();
                return false;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void irParaTelaSobre() {
        Intent intentLista = new Intent(this, SobreActivity.class);
        startActivity(intentLista);
    }

    protected void irParaTelaLista() {
        Intent intentLista = new Intent(this, ListaActivity.class);
        startActivity(intentLista);
    }
}
