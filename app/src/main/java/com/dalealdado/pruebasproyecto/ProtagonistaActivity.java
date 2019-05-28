package com.dalealdado.pruebasproyecto;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProtagonistaActivity extends AppCompatActivity implements SelectPj.seleccion{

    Context context;
    TextView tvvida, tvfuerza, tvagilidad, tvdefensa, tvmagia, puntosrestantes;
    ImageView personaje;
    Button selectpj;
    public int puntos = 30;
    public int vida = 100;
    public int fuerza = 10;
    public int agilidad = 10;
    public int defensa = 10;
    public int magia = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protagonista);

        tvvida = findViewById(R.id.tvvida);
        tvfuerza = findViewById(R.id.tvfuerza);
        tvagilidad = findViewById(R.id.tvagilidad);
        tvdefensa = findViewById(R.id.tvdefensa);
        tvmagia = findViewById(R.id.tvmagia);
        puntosrestantes = findViewById(R.id.puntosrestantes);
        personaje = findViewById(R.id.imagenpj);
        selectpj = findViewById(R.id.selectpj);
        context = this;

        findViewById(R.id.selectpj).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SelectPj(context, ProtagonistaActivity.this);
            }
        });

        findViewById(R.id.mvida).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vida > 100 && puntos != 30){
                    vida = vida -1;
                    puntos = puntos +1;
                    puntosrestantes.setText(String.valueOf(puntos));
                    tvvida.setText(String.valueOf(vida));
                }
            }
        });

        findViewById(R.id.mfuerza).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fuerza > 10 && puntos != 30){
                    fuerza = fuerza -1;
                    puntos = puntos +1;
                    puntosrestantes.setText(String.valueOf(puntos));
                    tvfuerza.setText(String.valueOf(fuerza));
                }
            }
        });

        findViewById(R.id.magilidad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (agilidad > 10 && puntos != 30){
                    agilidad = agilidad -1;
                    puntos = puntos +1;
                    puntosrestantes.setText(String.valueOf(puntos));
                    tvagilidad.setText(String.valueOf(agilidad));
                }
            }
        });

        findViewById(R.id.mdefensa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (defensa > 10 && puntos != 30){
                    defensa = defensa -1;
                    puntos = puntos +1;
                    puntosrestantes.setText(String.valueOf(puntos));
                    tvdefensa.setText(String.valueOf(defensa));
                }
            }
        });

        findViewById(R.id.mmagia).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (magia > 10 && puntos != 30){
                    magia = magia -1;
                    puntos = puntos +1;
                    puntosrestantes.setText(String.valueOf(puntos));
                    tvmagia.setText(String.valueOf(magia));
                }
            }
        });

        findViewById(R.id.pvida).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (puntos > 0){
                    vida = vida +1;
                    puntos = puntos -1;
                    puntosrestantes.setText(String.valueOf(puntos));
                    tvvida.setText(String.valueOf(vida));
                }
            }
        });

        findViewById(R.id.pfuerza).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (puntos > 0){
                    fuerza = fuerza +1;
                    puntos = puntos -1;
                    puntosrestantes.setText(String.valueOf(puntos));
                    tvfuerza.setText(String.valueOf(fuerza));
                }
            }
        });

        findViewById(R.id.pagilidad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (puntos > 0){
                    agilidad = agilidad +1;
                    puntos = puntos -1;
                    puntosrestantes.setText(String.valueOf(puntos));
                    tvagilidad.setText(String.valueOf(agilidad));
                }
            }
        });

        findViewById(R.id.pdefensa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (puntos > 0){
                    defensa = defensa +1;
                    puntos = puntos -1;
                    puntosrestantes.setText(String.valueOf(puntos));
                    tvdefensa.setText(String.valueOf(defensa));
                }
            }
        });

        findViewById(R.id.pmagia).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (puntos > 0){
                    magia = magia +1;
                    puntos = puntos -1;
                    puntosrestantes.setText(String.valueOf(puntos));
                    tvmagia.setText(String.valueOf(magia));
                }
            }
        });
    }

    @Override
    public void pjseleccionado(int id) {

        switch (id){
            case 1:
                personaje.setImageResource(R.drawable.pm1);
                break;
            case 2:
                personaje.setImageResource(R.drawable.pm2);
                break;
            case 3:
                personaje.setImageResource(R.drawable.pm3);
                break;
            case 4:
                personaje.setImageResource(R.drawable.pm4);
                break;
            case 5:
                personaje.setImageResource(R.drawable.pf1);
                break;
            case 6:
                personaje.setImageResource(R.drawable.pf2);
                break;
            case 7:
                personaje.setImageResource(R.drawable.pf3);
                break;
            case 8:
                personaje.setImageResource(R.drawable.pf4);
                break;
        }
    }
}
