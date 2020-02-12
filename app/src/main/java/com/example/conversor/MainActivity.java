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
                out.setText(String.valueOf(getResult()));
        }
    }
    public double getResult(){
        double result=0;
        try{
            int num;
            switch (convertFrom.getSelectedItemPosition()){
                case 0:

                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
            }
            switch (convertTo.getSelectedItemPosition()){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
            }
            double multiplier = getMultiplier();

        }catch (Exception e){
            Log.e("CONVERSOR","UNHANDLED EXCEPTION CONVERTING");
            e.printStackTrace();
        }
        return result;
    }
    public double getMultiplier(int times){
        boolean toUpOrDown=times>0;

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
