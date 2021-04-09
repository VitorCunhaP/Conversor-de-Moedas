package com.example.conversordemoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private viewHolder mviewHolder = new viewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mviewHolder.editText = findViewById(R.id.edit_valor);
        this.mviewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mviewHolder.textEuro = findViewById(R.id.text_euro);
        this.mviewHolder.botaoCalcular = findViewById(R.id.botao_calcular);

        this.mviewHolder.botaoCalcular.setOnClickListener(this);

        this.limpaValores();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.botao_calcular){
            String valor = this.mviewHolder.editText.getText().toString();
            if("".equals(valor)){
                Toast.makeText(this, R.string.informe_um_valor_alert, Toast.LENGTH_SHORT).show();

            }else{
                Double real = Double.valueOf(valor);

                this.mviewHolder.textDolar.setText(String.format("%.2f", (real/5.42)));
                this.mviewHolder.textEuro.setText(String.format("%.2f", (real/6.51)));
            }
        }
    }

    private void limpaValores(){
        this.mviewHolder.textDolar.setText("");
        this.mviewHolder.textEuro.setText("");
    }

    private static class viewHolder{
        EditText editText;
        TextView textDolar;
        TextView textEuro;
        Button botaoCalcular;
    }
}