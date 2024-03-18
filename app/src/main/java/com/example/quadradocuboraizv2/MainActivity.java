package com.example.quadradocuboraizv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Forma 3 de atender eventos. Passo 1: implements View.OnClickListener
//ou outra interface, dependendo do tipo de evento.
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private float dado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Forma 2 de atender eventos. Utilizando uma classe interna anônima,
        //para o tipo de evento que queremos atender e o botão para o qual
        //desejamos atender esse evento.
        Button cubo = findViewById(R.id.idbtcubo);
        cubo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lerDado();
                mostraResultado("Cubo", (dado*dado*dado));
            }
        });

        //Forma 3 de atender eventos. Passo 2: definir para quais objetos iremos atender
        //este tipo de evento no método comum onClick que colocamos no final desta classe.
        Button raiz = findViewById(R.id.idbtnraiz);
        raiz.setOnClickListener(this); //this: o método onClick se encontra dentro desta classe
    }

    public void lerDado() {
        //ler o dado digitado pelo usuário:
        EditText txt = findViewById(R.id.idado);
        dado = Float.parseFloat(txt.getText().toString());
    }

    public void mostraResultado(String rotulo, float resultado) {
        //pegar a referência do TextView, calcular e mostrar
        //o resultado (formatado com duas casas decimais):
        TextView txt = findViewById(R.id.idresultado);
        txt.setText(rotulo + ": " + String.format("%.2f", resultado));
    }

    //Forma 1 de atender evento. Observe o atributo android:onClick="quadrado"
    //no código xml do botão Quadrado.
    public void quadrado (View v) {
        lerDado();
        mostraResultado("Quadrado", (dado*dado));
    }

    //Forma 3 de atender eventos. Passo 3: definir o método comum onClick, para
    //atender eventos de click para vários objetos da interface.
    @Override
    public void onClick(View v) { //para tratar o click de Raiz quadrada etc.
        if(v.getId() == R.id.idbtnraiz) {
            lerDado();
            mostraResultado("Raiz quadrada", (float) Math.sqrt(dado));
        }
        //se este método atende o click em outros objetos, então acrescentar
        //outros comandos if para identificar cada objeto, por exemplo:
        //if(v.getId() == R.id.idbtntangente) {
        //
        //}
        //if(v.getId() == R.id.idumaimageview) {
        //
        //}
    }
}