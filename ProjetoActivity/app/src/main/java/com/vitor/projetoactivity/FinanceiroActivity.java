package com.vitor.projetoactivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinanceiroActivity extends AppCompatActivity {

    private EditText salarioEditText;
    private TextView salarioBrutoTextView;
    private TextView descontoINSSTextView;
    private TextView descontoFGTSTextView;
    private TextView salarioLiquidoTextView;
    private Button encerrarButton;
    private Button limparButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financeiro);

        salarioEditText = findViewById(R.id.salario_edit_text);
        salarioBrutoTextView = findViewById(R.id.salario_bruto_text_view);
        descontoINSSTextView = findViewById(R.id.desconto_inss_text_view);
        descontoFGTSTextView = findViewById(R.id.desconto_fgts_text_view);
        salarioLiquidoTextView = findViewById(R.id.salario_liquido_text_view);
        encerrarButton = findViewById(R.id.encerrar_button);
        limparButton = findViewById(R.id.limpar_button);

        Button calcularDescontosButton = findViewById(R.id.calcula_descontos_button);
        calcularDescontosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularDescontos();
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
                salarioEditText.setText("");
                salarioBrutoTextView.setText("Salário Bruto:");
                descontoINSSTextView.setText("Desconto INSS:");
                descontoFGTSTextView.setText("Desconto FGTS:");
                salarioLiquidoTextView.setText("Salário Líquido:");
            }
        });
    }

    private void calcularDescontos() {
        double salario = Double.parseDouble(salarioEditText.getText().toString());

        double descontoINSS = calcularINSS(salario);

        double descontoFGTS = salario * 0.08; // 8% do salário

        double salarioLiquido = salario - descontoINSS - descontoFGTS;

        salarioBrutoTextView.setText("Salário Bruto: R$ " + salario);
        descontoINSSTextView.setText("Desconto INSS: R$ " + descontoINSS);
        descontoFGTSTextView.setText("Desconto FGTS: R$ " + descontoFGTS);
        salarioLiquidoTextView.setText("Salário Líquido: R$ " + salarioLiquido);
    }

    private double calcularINSS(double salario) {
        if (salario <= 1412) {
            return salario * 0.075;
        } else if (salario <= 2666.68) {
            return salario * 0.09;
        } else if (salario <= 4000.03) {
            return salario * 0.12;
        } else if (salario <= 7786.02) {
            return salario * 0.14;
        } else {
            return salario * 0.14;
        }
    }
}
