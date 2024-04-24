package com.vitor.projetoactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SaudeActivity extends AppCompatActivity {

    private EditText pesoEditText;
    private EditText alturaEditText;
    private TextView pesoTextView;
    private TextView alturaTextView;
    private TextView imcTextView;
    private TextView classificacaoTextView;
    private Button encerrarButton;
    private Button limparButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saude);

        // Inicializando as Views
        pesoEditText = findViewById(R.id.peso_edit_text);
        alturaEditText = findViewById(R.id.altura_edit_text);
        pesoTextView = findViewById(R.id.peso_text_view);
        alturaTextView = findViewById(R.id.altura_text_view);
        imcTextView = findViewById(R.id.imc_text_view);
        classificacaoTextView = findViewById(R.id.classificacao_text_view);
        encerrarButton = findViewById(R.id.encerrar_button);
        limparButton = findViewById(R.id.limpar_button);

        // Configurando o botão de calcular
        Button calcularButton = findViewById(R.id.calcula_imc_button);
        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });

        // Configurando o botão "Encerrar"
        encerrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adicione aqui o código para encerrar a atividade
                finish();
            }
        });

        // Configurando o botão "Limpar"
        limparButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adicione aqui o código para limpar os EditTexts e os TextViews
                pesoEditText.setText("");
                alturaEditText.setText("");
                pesoTextView.setText("Peso:");
                alturaTextView.setText("Altura:");
                imcTextView.setText("IMC:");
                classificacaoTextView.setText("Classificação:");
            }
        });
    }

    private void calcularIMC() {
        // Obtendo o peso e a altura inseridos pelo usuário
        double peso = Double.parseDouble(pesoEditText.getText().toString());
        double altura = Double.parseDouble(alturaEditText.getText().toString());

        // Calculando o IMC
        double imc = peso / (altura * altura);

        // Exibindo o peso, altura e IMC nos TextViews correspondentes
        pesoTextView.setText("Peso: " + peso + " kg");
        alturaTextView.setText("Altura: " + altura + " m");
        imcTextView.setText("IMC: " + String.format("%.2f", imc));

        // Determinando a classificação do IMC e exibindo-a
        String classificacao;
        if (imc < 18.5) {
            classificacao = "Magreza";
        } else if (imc < 24.9) {
            classificacao = "Normal";
        } else if (imc < 29.9) {
            classificacao = "Sobrepeso";
        } else if (imc < 34.9) {
            classificacao = "Obesidade Grau I";
        } else if (imc < 39.9) {
            classificacao = "Obesidade Grau II";
        } else {
            classificacao = "Obesidade Grau III";
        }
        classificacaoTextView.setText("Classificação: " + classificacao);
    }
}
