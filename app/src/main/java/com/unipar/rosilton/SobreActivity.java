package com.unipar.rosilton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.unipar.rosilton.activity.BaseActivity;

public class SobreActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        findViewById(R.id.activity_sobre_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaTelaLista();
            }
        });
    }
}