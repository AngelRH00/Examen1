package com.example.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Calculator c;
    private EditText tn1;
    private EditText tn2;
    private TextView answerView;
    private RadioButton even;
    private RadioButton odd;
    private boolean evodd;
    private boolean divZero = false;
    private double memory;
    private double respuesta = 0;
    private double n1, n2 = 0;
    private int operacion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void mc(View view){
        answerView = findViewById(R.id.answer);
        tn1 = findViewById(R.id.nArriba);
        tn2 = findViewById(R.id.nAbajo);
        respuesta =0;
        memory = 0;
        answerView.setText(String.valueOf(0));
        tn1.setText("0");
        tn2.setText("0");
    }
    public void mr(View view){
        tn1 = findViewById(R.id.nArriba);
        tn1.setText(String.valueOf(memory));
    }
    public void mPlus(View view){
        memory = respuesta;
    }

    public void mMinus(View view){
        memory = 0;
    }



    public void suma(View view){
        operacion = 1;
        calculo(operacion);
    }
    public void resta(View view){
        operacion = 2;
        calculo(operacion);
    }
    public void multi(View view){
        operacion = 3;
        calculo(operacion);
    }
    public void div(View view){
        operacion = 4;
        calculo(operacion);
    }

    public void calculo(int operacion){
        c = new Calculator();
        answerView = findViewById(R.id.answer);
        even = findViewById(R.id.par);
        odd = findViewById(R.id.impar);
        tn1 = findViewById(R.id.nArriba);
        tn2 = findViewById(R.id.nAbajo);
        try {
            n1 = Double.parseDouble(tn1.getText().toString());
            n2 = Double.parseDouble(tn2.getText().toString());
            switch (operacion){
                case 1:
                    respuesta = c.suma(n1,n2);
                    divZero = false;
                    break;
                case 2:
                    respuesta = c.resta(n1,n2);
                    divZero = false;
                    break;
                case 3:
                    respuesta = c.multiplicacion(n1,n2);
                    divZero = false;
                    break;
                case 4:
                    try{
                        respuesta = c.division(n1, n2);
                        divZero = false;
                    }catch(IllegalArgumentException e){
                        divZero = true;
                        respuesta = 0;
                    }
                    break;
                default:
                    break;
            }
            if (divZero){
                answerView.setText("You can't divide by zero!");
            }else{
                answerView.setText(String.valueOf(respuesta));
                if(respuesta%2 == 0) {even.setChecked(true); odd.setChecked(false);}
                else {even.setChecked(false); odd.setChecked(true);}

            }

        }catch(NumberFormatException exFormat){
            answerView.setText("Not valid numbers.");
        }

    }


}
