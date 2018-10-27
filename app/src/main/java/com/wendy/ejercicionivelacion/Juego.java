package com.wendy.ejercicionivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Juego extends AppCompatActivity {
    Button btncpu,btnpiedra,btnpapel,btntijera,btnfinalizar;
    TextView lblpuntos,lblganados,lblperdido,lblempates;

    private static int NUMEROCPU=1;
    private static  int puntos;
    private  static  int ganados;
    private  static  int empates;
    private  static  int perdidos;

    private String NombreJugador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        puntos=0;
        ganados=0;
        empates=0;
        perdidos=0;
        NombreJugador = MainActivity.Nombre;
        btncpu = findViewById(R.id.btncpu);
        btnpiedra = findViewById(R.id.btnpiedra);
        btnpapel = findViewById(R.id.btnpapel);
        btntijera = findViewById(R.id.btntijera);
        btnfinalizar = findViewById(R.id.btnFinalizar);
        lblpuntos = findViewById(R.id.lblpuntos);
        lblempates = findViewById(R.id.lblempates);
        lblganados = findViewById(R.id.lblganados);
        lblperdido = findViewById(R.id.lblperdidos);
        btnfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalizar();
            }
        });
        btnpiedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Piedra();
            }
        });
        btnpapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Papel();
            }
        });
        btntijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tijera();
            }
        });
        btncpu = findViewById(R.id.btncpu);
    }

    private void finalizar() {
        Intent resultado = new Intent();
        resultado.putExtra("Puntos",puntos);
        resultado.putExtra("Nombre",NombreJugador);
        setResult(MainActivity.CODIGO_INICIO,resultado);
        finish();
    }

    private void tijera() {
        int NUMERO_TIJERA =3;
        Random r2 = new Random();
        NUMEROCPU =  1+r2.nextInt(3);
        btncpu.setText(String.valueOf(NUMEROCPU));
        if(NUMERO_TIJERA==NUMEROCPU){
            Toast.makeText(getApplicationContext(),"Empates Ambos Escogieron Tijera",Toast.LENGTH_SHORT).show();

            lblempates.setText("Empatados  :"+(empates+=1));
        }
        if(NUMEROCPU==2){
            Toast.makeText(getApplicationContext(),"Jugador  Selecciono : Tijera \n"+"CPU Selecciono : Papel \n"+"Gana Jugador",Toast.LENGTH_SHORT).show();

            lblganados.setText("Ganados  :"+(ganados+=1));
            lblpuntos.setText("Puntos   :"+(puntos+=6)+" pts");
        }
        if(NUMEROCPU==1){
            Toast.makeText(getApplicationContext(),"Jugador  Selecciono : Tijera \n"+"CPU Selecciono : Piedra \n"+"Gana CPU",Toast.LENGTH_SHORT).show();

            lblperdido.setText("Perdidos  :"+(perdidos+=1));
            lblpuntos.setText("Puntos   :"+(puntos-=3)+" pts");
        }
    }

    private void Papel() {
        int NUMERO_PAPEL =2;
        Random r1 = new Random();
        NUMEROCPU =  1+r1.nextInt(3);
        btncpu.setText(String.valueOf(NUMEROCPU));
        if(NUMERO_PAPEL==NUMEROCPU){
            Toast.makeText(getApplicationContext(),"Empates Ambos Escogieron Papel",Toast.LENGTH_SHORT).show();

            lblempates.setText("Empatados  :"+(empates+=1));
        }
        if(NUMEROCPU==1){
            Toast.makeText(getApplicationContext(),"Jugador  Selecciono : Papel \n"+"CPU Selecciono : Piedra \n"+"Gana Jugador",Toast.LENGTH_SHORT).show();
            lblganados.setText("Ganados  :"+(ganados+=1));
            lblpuntos.setText("Puntos   :"+(puntos+=6)+" pts");
        }
        if(NUMEROCPU==3){
            Toast.makeText(getApplicationContext(),"Jugador  Selecciono : Papel \n"+"CPU Selecciono : Tijera \n"+"Gana CPU",Toast.LENGTH_SHORT).show();
            lblperdido.setText("Perdidos  :"+(perdidos+=1));
            lblpuntos.setText("Puntos   :"+(puntos-=3)+" pts");
        }
    }

    private void Piedra() {
        int NUMERO_PIEDRA =1;
        Random r = new Random();
        NUMEROCPU = 1+r.nextInt(3);
        btncpu.setText(String.valueOf(NUMEROCPU));
        if(NUMERO_PIEDRA==NUMEROCPU){
            Toast.makeText(getApplicationContext(),"Empates Ambos Escogieron Piedra",Toast.LENGTH_SHORT).show();

            lblempates.setText("Empatados  :"+(empates+=1));
        }
        if(NUMEROCPU==3){
            Toast.makeText(getApplicationContext(),"Jugador  Selecciono : Piedra \n"+"CPU Selecciono : Tijera \n"+"Gana Jugador",Toast.LENGTH_SHORT).show();
            lblganados.setText("Ganados  :"+(ganados+=1));
            lblpuntos.setText("Puntos   :"+(puntos+=6)+" pts");
        }
        if(NUMEROCPU==2){
            Toast.makeText(getApplicationContext(),"Jugador  Selecciono : Piedra \n"+"CPU Selecciono : Papel \n"+"Gana CPU",Toast.LENGTH_SHORT).show();

            lblperdido.setText("Perdidos  :"+(perdidos+=1));
            lblpuntos.setText("Puntos   :"+(puntos-=3)+" pts");
        }
    }
}
