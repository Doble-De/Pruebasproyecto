package com.dalealdado.pruebasproyecto;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class SelectPj {

    ImageView pjm1,pjm2,pjm3,pjm4,pjf1,pjf2,pjf3,pjf4;

    public interface seleccion{
        void pjseleccionado(int id);
    }

    private seleccion interfaz;

    public SelectPj(Context context, seleccion actividad){

        interfaz = actividad;

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.activity_select_pj);

        pjm1= dialog.findViewById(R.id.pjm1);
        pjm2= dialog.findViewById(R.id.pjm2);
        pjm3= dialog.findViewById(R.id.pjm3);
        pjm4= dialog.findViewById(R.id.pjm4);
        pjf1= dialog.findViewById(R.id.pjf1);
        pjf2= dialog.findViewById(R.id.pjf2);
        pjf3= dialog.findViewById(R.id.pjf3);
        pjf4= dialog.findViewById(R.id.pjf4);

        pjm1.setImageResource(R.drawable.pm1);
        pjm2.setImageResource(R.drawable.pm2);
        pjm3.setImageResource(R.drawable.pm3);
        pjm4.setImageResource(R.drawable.pm4);
        pjf1.setImageResource(R.drawable.pf1);
        pjf2.setImageResource(R.drawable.pf2);
        pjf3.setImageResource(R.drawable.pf3);
        pjf4.setImageResource(R.drawable.pf4);

        pjm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.pjseleccionado(1);
                dialog.dismiss();
            }
        });

        pjm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.pjseleccionado(2);
                dialog.dismiss();
            }
        });

        pjm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.pjseleccionado(3);
                dialog.dismiss();
            }
        });

        pjm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.pjseleccionado(4);
                dialog.dismiss();
            }
        });

        pjf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.pjseleccionado(5);
                dialog.dismiss();
            }
        });
        pjf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.pjseleccionado(6);
                dialog.dismiss();
            }
        });
        pjf3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.pjseleccionado(7);
                dialog.dismiss();
            }
        });
        pjf4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.pjseleccionado(8);
                dialog.dismiss();
            }
        });

        dialog.show();
    }




}
