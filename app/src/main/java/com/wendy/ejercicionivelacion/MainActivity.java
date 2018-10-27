package com.wendy.ejercicionivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnnuevo,btnjuego,btnpuntos;
    public  static final  int CODIGO_NUEVO =1;
    public  static final  int CODIGO_INICIO =2;
    public  static ArrayList<Jugadores> lstjugadores;
    public  static String Nombre="";
    Integer Puntaje =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnnuevo = findViewById(R.id.btnNuevo);
        btnjuego = findViewById(R.id.btniniciar);
        btnpuntos = findViewById(R.id.btnpuntajes);
        lstjugadores = new ArrayList<>();
        btnnuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuevo = new Intent(getApplicationContext(),Jugador.class);
                startActivityForResult(nuevo,CODIGO_NUEVO);
            }
        });
        btnjuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iniciar = new Intent(getApplicationContext(),Juego.class);
                startActivityForResult(iniciar,CODIGO_INICIO);
            }
        });
        btnpuntos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lstjugadores.size()<3){
                    Toast.makeText(getApplicationContext(),"Agregue "+(3-lstjugadores.size())+" Jugadores Mas",Toast.LENGTH_SHORT).show();
                }else {
                    Intent puntos = new Intent(getApplicationContext(), Puntos.class);
                    startActivity(puntos);
                }
            }
        });

        if(Nombre.isEmpty()){
            btnjuego.setEnabled(false);
        }
        //btnpuntos.setEnabled(false);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case CODIGO_NUEVO:
                if(data==null) return;
                Nombre = data.getExtras().getString("Nombre");
                btnjuego.setEnabled(true);
                Toast.makeText(this, "Jugador : "+Nombre+"\n"+"Registrado con Exito", Toast.LENGTH_SHORT).show();
                break;
            case  CODIGO_INICIO:
                if(data==null) return;
                Puntaje = data.getExtras().getInt("Puntos");
                String nombre = data.getExtras().getString("Nombre");
                Jugadores ju = new Jugadores(nombre,Puntaje);
                lstjugadores.add(ju);
                btnjuego.setEnabled(false);
                if(lstjugadores.size()>=3){
                    btnpuntos.setEnabled(true);
                }
                Toast.makeText(this, "Jugador :"+ nombre +"\n"+"Puntajes " +Puntaje+"\n"+" Insertado con Exito", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
