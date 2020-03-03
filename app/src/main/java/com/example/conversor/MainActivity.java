package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button convert;
    public EditText out;
    public TextInputEditText input;
    public Spinner convertFrom,convertTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        input=findViewById(R.id.input);
        convertFrom=findViewById(R.id.spinner1);
        convertTo=findViewById(R.id.spinner2);
        convert=findViewById(R.id.convertButton);
        out=findViewById(R.id.outText);
        convert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.convertButton:
                if(input.getText().toString().isEmpty()){
                    input.setText("0");
                }
                out.setText(getResult() + convertTo.getSelectedItem().toString());
                break;
        }
    }
    public double getResult(){
        double result=Integer.valueOf(input.getText().toString());
        double numOne=getMultiply(convertFrom.getSelectedItemPosition());
        double numTwo=getDivide(convertTo.getSelectedItemPosition());
        return result*numOne*numTwo;
    }
    public double getDivide(int option){
        return 1/getMultiply(option);
    }
    public double getMultiply(int option){
        switch (option){
            case 0:
                return 1000;
            case 1:
                return 1;
            case 2:
                return 0.1;
            case 3:
                return 0.01;
            case 4:
                return 0.001;
            case 5://LEGUAS
                return 4828.03;
            case 6://MILLAS
                return 1609.34;
            case 7://ESTADIOS
                return 201.168;
            case 8://CADENAS
                return 20.116676725;
            case 9://BARRAS
                return  5.029;
            case 10://YARDAS
                return 0.9144;
            case 11://PIE
                return 0.3048;
            case 12://MANO
                return 0.1016;
            case 13://PULGADA
                return 0.0254;
            case 14://MILLAS NAUTICAS
                return 1852;
            case 15://BRAZAS
                return 1.8288;
            default:
                return 0;
        }
    }
    public double getMeterMultiplier(int times){
        boolean toUpOrDown=times>0;
        int num=1;
        for(int a=0;a!=Math.abs(times);){
         if(toUpOrDown){
             num*=0.1;
         }else{
             num*=10;
         }
     }
     return num;
    }
}
