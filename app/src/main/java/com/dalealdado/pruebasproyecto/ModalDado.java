package com.dalealdado.pruebasproyecto;

import android.app.Dialog;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.dalealdado.pruebasproyecto.Shake.ShakeDetector;

import java.util.Random;

public class ModalDado {

    MutableLiveData<Integer> valor20 = new MutableLiveData<>();
    final int delay = 150;
    Random r = new Random();

    private ShakeDetector mShakeDetector;

    int salir =0;
    int resultado;
    boolean lanzado = false;


    public interface MostrarResultado{
        void ResultadoDado(String valor);
    }

    private MostrarResultado interfaz;


    public ModalDado(final Context context, ShakeDetector mShakeDetector, final String tipo, MostrarResultado actividad){

            interfaz = actividad;
            this.mShakeDetector = mShakeDetector;
            final Dialog dado = new Dialog(context);
            dado.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dado.setCancelable(false);
            dado.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dado.setContentView(R.layout.dado_modal);

            final TextView dado20tv = (TextView) dado.findViewById(R.id.dado20tv);
            ImageView dado20 = (ImageView) dado.findViewById(R.id.dado20);


            switch (tipo){
                case "ataque":
                    dado20.setImageResource(R.drawable.dado20ataque);
                    break;
                case "defensa":
                    dado20.setImageResource(R.drawable.dado20defensa);
                    break;
                case "huida":
                    dado20.setImageResource(R.drawable.dado20huida);
                    break;
            }



            this.mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {
                @Override
                public void onShake(int count) {
//                    @SuppressLint("ServiceCast") Vibrator vibrator = (Vibrator) context.getApplicationContext().getSystemService(Context.SENSOR_SERVICE);
//                    vibrator.vibrate(500);

                    //Toast.makeText(ModalDado.this, "Tirando dados", Toast.LENGTH_SHORT).show();
                    if (!lanzado) {
                        lanzado = true;
                        salir = 0;
                        final Handler handler = new android.os.Handler();
                        final Runnable runnable = new Runnable() {
                            int count = 0;

                            public void run() {
                                valor20.postValue(r.nextInt(20) + 1);
                                if (count < 6) {
                                    handler.postDelayed(this, delay);
                                    count++;
                                    salir++;
                                }
                            }
                        };
                        handler.postDelayed(runnable, delay);

                        valor20.observeForever(new Observer<Integer>() {
                            @Override
                            public void onChanged(@Nullable Integer integer) {
                                dado20tv.setText(String.valueOf(integer));
                                resultado = integer;
                            }
                        });
//                    }else {
//                        if (salir == 6) {
//                            interfaz.ResultadoDado(String.valueOf(resultado));
//                            dado.dismiss();
//                        }
                   }
                }

            });


            dado20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!lanzado) {
                        lanzado = true;
                        salir = 0;
                        final Handler handler = new android.os.Handler();
                        final Runnable runnable = new Runnable() {
                            int count = 0;

                            public void run() {
                                valor20.postValue(r.nextInt(20) + 1);
                                if (count < 6) {
                                    handler.postDelayed(this, delay);
                                    count++;
                                    salir++;
                                }
                            }
                        };
                        handler.postDelayed(runnable, delay);

                        valor20.observeForever(new Observer<Integer>() {
                            @Override
                            public void onChanged(@Nullable Integer integer) {
                                dado20tv.setText(String.valueOf(integer));
                                resultado = integer;
                            }
                        });
                    }else {
                        if (salir == 6) {
                            interfaz.ResultadoDado(String.valueOf(resultado));
                            dado.dismiss();
                        }
                    }
                }
            });

        dado.show();

    }


}

