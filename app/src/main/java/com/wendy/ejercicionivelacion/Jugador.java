package com.wendy.ejercicionivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Jugador extends AppCompatActivity {
    Button btnguardar;
    EditText txtnombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugador);
        txtnombre = findViewById(R.id.txtnombre);
        btnguardar = findViewById(R.id.btnguardar);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtnombre.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"No Deje el Campo el Blanco",Toast.LENGTH_SHORT).show();
                }else {
                    Intent resultado = new Intent();
                    resultado.putExtra("Nombre", txtnombre.getText().toString());
                    setResult(MainActivity.CODIGO_NUEVO, resultado);
                    finish();
                }
            }
        });
    }
}
