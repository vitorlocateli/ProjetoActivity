package com.vitor.projetoactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EducacaoActivity extends AppCompatActivity {

    private EditText ni1EditText;
    private EditText ni2EditText;
    private EditText poEditText;
    private TextView ni1TextView;
    private TextView ni2TextView;
    private TextView poTextView;
    private TextView mediaTextView;
    private TextView statusAprovacaoTextView;
    private Button encerrarButton;
    private Button limparButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educacao);

        ni1EditText = findViewById(R.id.ni1_edit_text);
        ni2EditText = findViewById(R.id.ni2_edit_text);
        poEditText = findViewById(R.id.po_edit_text);
        ni1TextView = findViewById(R.id.ni1_text_view);
        ni2TextView = findViewById(R.id.ni2_text_view);
        poTextView = findViewById(R.id.po_text_view);
        mediaTextView = findViewById(R.id.media_text_view);
        statusAprovacaoTextView = findViewById(R.id.status_aprovacao_text_view);
        encerrarButton = findViewById(R.id.encerrar_button);
        limparButton = findViewById(R.id.limpar_button);

        Button calcularAprovacaoButton = findViewById(R.id.calcula_aprovacao_button);
        calcularAprovacaoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularAprovacao();
            }
        });

        encerrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        limparButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adicione aqui o código para limpar os EditTexts e os TextViews
                ni1EditText.setText("");
                ni2EditText.setText("");
                poEditText.setText("");
                ni1TextView.setText("NI1:");
                ni2TextView.setText("NI2:");
                poTextView.setText("PO:");
                mediaTextView.setText("Média:");
                statusAprovacaoTextView.setText("Status de Aprovação:");
            }
        });
    }

    private void calcularAprovacao() {
        double ni1 = Double.parseDouble(ni1EditText.getText().toString());
        double ni2 = Double.parseDouble(ni2EditText.getText().toString());
        double po = Double.parseDouble(poEditText.getText().toString());

        double media = (ni1 * 0.2) + (ni2 * 0.3) + (po * 0.5);

        mediaTextView.setText("Média: " + media);

        String statusAprovacao;
        if (media >= 6.0) {
            statusAprovacao = "Aprovado";
        } else {
            statusAprovacao = "Reprovado";
        }

        statusAprovacaoTextView.setText("Status de Aprovação: " + statusAprovacao);
    }
}
