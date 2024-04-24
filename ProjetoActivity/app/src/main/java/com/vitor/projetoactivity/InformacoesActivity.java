package com.vitor.projetoactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InformacoesActivity extends AppCompatActivity {

    private TextView nomeTextView;
    private TextView matriculaTextView;
    private TextView cursoTextView;
    private TextView periodoTextView;
    private Button encerrarButton;
    private Button limparButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);


        nomeTextView = findViewById(R.id.nome_text_view);
        matriculaTextView = findViewById(R.id.matricula_text_view);
        cursoTextView = findViewById(R.id.curso_text_view);
        periodoTextView = findViewById(R.id.periodo_text_view);
        encerrarButton = findViewById(R.id.encerrar_button);
        limparButton = findViewById(R.id.limpar_button);

        String nome = "Vitor Locateli";
        String matricula = "23024638";
        String curso = "Ciência da Computação";
        String periodo = "Noturno";

        nomeTextView.setText("Nome: " + nome);
        matriculaTextView.setText("Matrícula: " + matricula);
        cursoTextView.setText("Curso: " + curso);
        periodoTextView.setText("Período: " + periodo);

        limparButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nomeTextView.setText("Nome:");
                matriculaTextView.setText("Matrícula:");
                cursoTextView.setText("Curso:");
                periodoTextView.setText("Período:");
            }
        });

        encerrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}


