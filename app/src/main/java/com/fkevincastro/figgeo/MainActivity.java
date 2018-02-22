package com.fkevincastro.figgeo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tPerimetro,tArea,tVolumen;
    EditText eLado,eArista,eRadio,eAlto,eAncho;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tPerimetro=findViewById(R.id.tPerimetro);
        tArea=findViewById(R.id.tArea);
        tVolumen=findViewById(R.id.tVolumen);
        eArista=findViewById(R.id.eArista);
        eRadio=findViewById(R.id.eRadio);
        eLado=findViewById(R.id.eLado);
        eAlto=findViewById(R.id.eAlto);
        eAncho=findViewById(R.id.eAncho);
    }

    public void OnclickRadioButton(View view) {
        int id=view.getId();
        switch(id){
            case R.id.rCubo:
                tPerimetro.setText(CalcularPerimetroCubo(eArista.getText().toString()));
                tArea.setText(CalcularAreaCubo(eArista.getText().toString()));
                tVolumen.setText(CalcularVolumen(eArista.getText().toString()));
                break;
            case R.id.rCirculo:
                tPerimetro.setText( CalcularPerimetroCirculo(eRadio.getText().toString()));
                tArea.setText(CalcularAreaCirculo(eRadio.getText().toString()));
                tVolumen.setText("0");
                break;
            case R.id.rCuadrado:
                tPerimetro.setText(CalcularPerimetrocuadrado(eLado.getText().toString()));
                tArea.setText(CalcularAreacuadrado(eLado.getText().toString()));
                tVolumen.setText("0");
                break;
            case R.id.rTriangulo:
                tPerimetro.setText(CalcularPerimetroTriangulo(eAlto.getText().toString(),eAncho.getText().toString()));
                tArea.setText(CalcularAreaTriangulo(eAlto.getText().toString(),eAncho.getText().toString()));
                tVolumen.setText("0");
                break;

        }
    }

    public String CalcularVolumen(String arista) {
        int ans,temp;

        if (!arista.toString().isEmpty()) {
            temp = Integer.parseInt(arista);
            ans = (temp * temp) * temp;
            return String.valueOf(ans);
        }
        else return"0";
       }

    public String CalcularPerimetroCubo(String arista){
        int ans,temp;
        if (!arista.toString().isEmpty()) {
            temp = Integer.parseInt(arista);
            ans = temp * 12;
            return String.valueOf(ans);
        }
        else return "0";
    }
    public String CalcularAreaCubo(String arista){
        int ans,temp;
        if (!arista.toString().isEmpty()) {
            temp = Integer.parseInt(arista);
            ans = (temp * temp) * 6;
            return String.valueOf(ans);
        }
        else return "0";
    }
    public String CalcularPerimetroCirculo(String radio){
        int temp;
        double ans;
        if (!radio.toString().isEmpty()) {
            temp = Integer.parseInt(radio);
            ans =2*Math.PI*temp ;
            return String.valueOf(ans);
        }
        else return "0";
    }

    public String CalcularAreaCirculo(String radio){
        int temp;
        double ans;
        if (!radio.toString().isEmpty()) {
            temp = Integer.parseInt(radio);
            ans =Math.PI*temp*temp;
            return String.valueOf(ans);
        }
        else return "0";
    }
    public String CalcularAreacuadrado(String lado){
        int temp,ans;
        if (!lado.toString().isEmpty()) {
            temp = Integer.parseInt(lado);
            ans =temp*temp;
            return String.valueOf(ans);
        }
        else return "0";
    }
    public String CalcularPerimetrocuadrado(String lado){
        int temp,ans;
        if (!lado.toString().isEmpty()) {
            temp = Integer.parseInt(lado);
            ans =temp*4;
            return String.valueOf(ans);
        }
        else return "0";
    }
    public String CalcularAreaTriangulo(String alto,String ancho){
        int temp1,temp2;
        double ans;
        if (!alto.toString().isEmpty()&&!ancho.toString().isEmpty()) {
            temp1 = Integer.parseInt(alto);
            temp2=Integer.parseInt(ancho);
            ans =(temp1*temp2)*0.5;

            return String.valueOf(ans);
        }
        else return "0";
    }
    public String CalcularPerimetroTriangulo(String alto,String ancho){
        int temp1,temp2;
        double ans;
        if (!alto.toString().isEmpty()&&!ancho.toString().isEmpty()) {
            temp1 = Integer.parseInt(alto);
            temp2=Integer.parseInt(ancho);

            ans=Math.hypot(temp1,temp2)*2+temp2;

            return String.valueOf(ans);

        }
        else return "0";
    }
}
