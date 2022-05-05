package com.example.anagui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anagui.model.Imc;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double imcText;
    Button enviar;
    EditText alturaEdit;
    EditText pesoEdit;
    TextView texto;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alturaEdit = findViewById(R.id.editAltura);
        pesoEdit = findViewById(R.id.editPeso);
        texto = findViewById(R.id.textView4);
        enviar = findViewById(R.id.button2);
        img = findViewById(R.id.imageView);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Imc pessoa = new Imc();
                pessoa.setAltura(Double.parseDouble(alturaEdit.getText().toString()));
                pessoa.setPeso(Double.parseDouble(pesoEdit.getText().toString()));
                imcText = pessoa.calcularImc();
                DecimalFormat formato = new DecimalFormat("#.#");

                if (imcText <= 18.5) {
                    texto.setText("Abaixo do Peso\nSeu IMC é " +formato.format(imcText));
                    img.setImageResource(R.drawable.magrinho);
                }else if (imcText <= 24.9) {
                    texto.setText("Normal\nSeu IMC é " +formato.format(imcText));
                    img.setImageResource(R.drawable.normal);
                }
                else if (imcText <= 30){
                    texto.setText("Sobrepeso\nSeu IMC é " +formato.format(imcText));
                    img.setImageResource(R.drawable.gordinho);
                }
                else if (imcText <= 40) {
                    texto.setText("Obesidade\nSeu IMC é " +formato.format(imcText));
                    img.setImageResource(R.drawable.gordo);
                }
                else{
                    texto.setText("Obesidade grave\nSeu IMC é " +formato.format(imcText));
                    img.setImageResource(R.drawable.gordao);
                }

            }
        });
    }
}