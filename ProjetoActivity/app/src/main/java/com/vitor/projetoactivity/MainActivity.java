package com.vitor.projetoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button financeiroButton = findViewById(R.id.financeiro_button);
        financeiroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FinanceiroActivity.class));
            }
        });

        Button educacaoButton = findViewById(R.id.educacao_button);
        educacaoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EducacaoActivity.class));
            }
        });

        Button saudeButton = findViewById(R.id.saude_button);
        saudeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SaudeActivity.class));
            }
        });

        Button informacoesButton = findViewById(R.id.informacoes_button);
        informacoesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InformacoesActivity.class));
            }
        });
    }
}
