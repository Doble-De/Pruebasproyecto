package com.dalealdado.pruebasproyecto;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.pruebasproyecto.Shake.ShakeDetector;

public class BatallasActivity extends AppCompatActivity implements ModalDado.MostrarResultado, ModalInventario.ObjetoUsado{

    private Handler mHandler = new Handler();
    Context context;
    TextView resultado;
    int num = 0;
    ImageView corte;
    ImageView escudo;
    ImageView defensa;
    ImageView enemigo;
    ImageView personaje;
    ImageView estados;
    String accion;
    MediaPlayer mp, mp2, mp3, mp4, heal, fire, firehit;
    int contador=1;
    private SensorManager mSensorManager;
    private Sensor mAccelerometrer;
    private ShakeDetector mShakeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batallas);
        mp = MediaPlayer.create(this, R.raw.slash8);
        mp2 = MediaPlayer.create(this, R.raw.escudo2);
        mp3 = MediaPlayer.create(this, R.raw.escudo);
        mp4 = MediaPlayer.create(this, R.raw.gallina);
        heal = MediaPlayer.create(this,R.raw.heal);
        fire = MediaPlayer.create(this, R.raw.fuego);
        firehit = MediaPlayer.create(this, R.raw.firehit);
        context = this;

        Button ataque = (Button) findViewById(R.id.ataque);
        Button defensa = (Button) findViewById(R.id.defensa);
        Button huida = (Button) findViewById(R.id.huir);
        Button objetos = (Button) findViewById(R.id.objeto);
        resultado = (TextView) findViewById(R.id.valor);

        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mAccelerometrer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();


        defensa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accion = "defensa";
                new ModalDado(context, mShakeDetector, "defensa", BatallasActivity.this);
            }
        });

        ataque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accion = "ataque";
                new ModalDado(context, mShakeDetector, "ataque", BatallasActivity.this);
            }
        });

        huida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accion = "huida";
                new ModalDado(context, mShakeDetector, "huida", BatallasActivity.this);
            }
        });

        objetos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ModalInventario(context, BatallasActivity.this);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector, mAccelerometrer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(mShakeDetector);
    }

    @Override
    public void ResultadoDado(String valor) {
        resultado.setText(valor);
        num = Integer.parseInt(valor);
        YoYo.with(Techniques.ZoomInUp)
                .duration(400)
                .playOn(resultado);
        AnimaciónPegar();
        AnimaciónDefender();
        AnimacionHuida();
    }


    private Runnable AnimacionCura = new Runnable() {
        @Override
        public void run() {
            estados = (ImageView) findViewById(R.id.estados);

            switch (contador){
                case 1: estados.setImageResource(R.drawable.heal1);
                    contador++;
                    YoYo.with(Techniques.FadeInUp)
                            .duration(600)
                            .playOn(estados);
                    break;
                case 2: estados.setImageResource(R.drawable.heal2);
                    heal.start();
                    YoYo.with(Techniques.Pulse)
                            .duration(600)
                            .playOn(estados);
                    contador++;
                    break;
                case 3: estados.setImageResource(R.drawable.heal3);
                    YoYo.with(Techniques.Pulse)
                            .duration(400)
                            .playOn(estados);
                    contador ++;
                    break;
                case 4:  estados.setImageResource(R.drawable.heal3);
                    YoYo.with(Techniques.FadeOutDown)
                            .duration(800)
                            .playOn(estados);
                    contador = 1;
                    break;
            }
        }
    };


    public void AnimaciónPegar(){
        corte = (ImageView) findViewById(R.id.animataque);
        if (num > 5 && accion.equals("ataque")){
            corte.setImageResource(R.drawable.tajo);
            YoYo.with(Techniques.ZoomInLeft)
                    .duration(1000)
                    .playOn(corte);
            mHandler.postDelayed(sonidotajo, 460);
            YoYo.with(Techniques.ZoomOut)
                    .duration(3000)
                    .playOn(corte);

        }
    }

    public void AnimaciónDefender(){
        escudo = (ImageView) findViewById(R.id.escudo);
        defensa = (ImageView) findViewById(R.id.animdefensa);
        if (num > 5 && accion.equals("defensa")){
            escudo.setImageResource(R.drawable.escudo);
            YoYo.with(Techniques.StandUp)
                    .duration(500)
                    .playOn(escudo);
            mp2.start();
            mHandler.postDelayed(golpesDefensa, 450);
            mHandler.postDelayed(golpesDefensa, 600);
            mHandler.postDelayed(golpesDefensa, 850);
            mHandler.postDelayed(golpesDefensa, 1000);


        }
    }

    public void AnimacionHuida(){

        if (num > 5 && accion.equals("huida")) {
            personaje = (ImageView) findViewById(R.id.personaje);
            personaje.animate().rotationY(180).start();
            mp4.start();
            YoYo.with(Techniques.Bounce)
                    .duration(200)
                    .playOn(personaje);
            YoYo.with(Techniques.FadeOutLeft)
                    .duration(1000)
                    .playOn(personaje);
        }
    }


    private Runnable sonidotajo = new Runnable() {
        @Override
        public void run() {
            enemigo = (ImageView) findViewById(R.id.enemigo);
            mp.start();
            YoYo.with(Techniques.Wobble)
                    .duration(200)
                    .playOn(enemigo);
        }
    };

    private Runnable sonidofirehit = new Runnable() {
        @Override
        public void run() {
            enemigo = (ImageView) findViewById(R.id.enemigo);
            firehit.start();
            YoYo.with(Techniques.Wobble)
                    .duration(200)
                    .playOn(enemigo);
        }
    };

    private Runnable golpesDefensa = new Runnable() {
        @Override
        public void run() {
            defensa = (ImageView) findViewById(R.id.animdefensa);
            switch (contador){
                case 1: defensa.setImageResource(R.drawable.defensehit1);
                        contador++;
                        YoYo.with(Techniques.Flash)
                                .duration(300)
                                .playOn(defensa);
                        break;
                case 2: defensa.setImageResource(R.drawable.defensehit2);
                        YoYo.with(Techniques.Flash)
                                .duration(300)
                                .playOn(defensa);
                        contador++;
                        mp3.start();
                        break;
                case 3: defensa.setImageResource(R.drawable.defensehit3);
                        YoYo.with(Techniques.Flash)
                                .duration(300)
                                .playOn(defensa);
                        contador ++;
                        break;
                case 4: defensa.setImageResource(R.color.transparent);
                        YoYo.with(Techniques.FadeOutLeft)
                                .duration(1000)
                                .playOn(escudo);
                        contador = 1;
                        break;
            }


        }
    };


    @Override
    public void IdObjeto(int id) {
        if (id == 1){

            mHandler.postDelayed(AnimacionCura, 100);
            mHandler.postDelayed(AnimacionCura, 400);
            mHandler.postDelayed(AnimacionCura, 1000);
            mHandler.postDelayed(AnimacionCura, 1300);
        }else if (id == 2){
            corte = (ImageView) findViewById(R.id.animataque);
            if (num > 5 && accion.equals("ataque")){
                fire.start();
                corte.setImageResource(R.drawable.tajo);
                YoYo.with(Techniques.ZoomInLeft)
                        .duration(1000)
                        .playOn(corte);
                mHandler.postDelayed(sonidofirehit, 460);
                YoYo.with(Techniques.ZoomOut)
                        .duration(3000)
                        .playOn(corte);

            }
        }
    }
}
