package com.example.almacen;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText  jetunidades,jetvalor,jetiva;
    TextView jtvventabruta,jtvalorviva,jtvventaneta;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ocultar la barra de titulo por defecto y asociar objetos Java con
        //objetos Xml
        getSupportActionBar().hide();
        //Relacionamos los objetos xml con los objetos java
        jetunidades = findViewById(R.id.etunidades);
        jetvalor = findViewById(R.id.etvalor);
        jetiva = findViewById(R.id.etiva);
        jtvalorviva = findViewById(R.id.tvvaloriva);
        jtvventabruta = findViewById(R.id.tvventabruta);
        jtvventaneta = findViewById(R.id.tvventaneta);



    }//FIN ONCREATE

    public  void Calcular(View view){
        String unidades,valor,iva;
        unidades = jetunidades.getText().toString();
        valor = jetvalor.getText().toString();
        iva = jetiva.getText().toString();
        if (unidades.isEmpty() || valor.isEmpty() || iva.isEmpty()){
            Toast.makeText(this, "Los datos son requeridos ", Toast.LENGTH_SHORT).show();
            jetunidades.requestFocus();
        }else{
            double unidadfloat,valorfloat,valorivafloat,ventabruta,valoriva,netoapagar;
            unidadfloat = Float.parseFloat(unidades);
            valorfloat = Float.parseFloat(valor);
            valorivafloat = Float.parseFloat(iva);
            ventabruta = unidadfloat * valorfloat;
            valoriva =  ventabruta*valorivafloat/100;
            netoapagar = ventabruta + valoriva;
            jtvventabruta.setText((String.valueOf(ventabruta)));
            jtvalorviva.setText((String.valueOf(valoriva)));
            jtvventaneta.setText((String.valueOf(netoapagar)));
        }

    }
    public void Limpiar(View view){
        jetunidades.setText("Cantidad");
        jetiva.setText("Valor del articulo");
        jetvalor.setText("Valor IVA");
        jtvventabruta.setText("0");
        jtvalorviva.setText("0");
        jtvventaneta.setText("0");

    }


}