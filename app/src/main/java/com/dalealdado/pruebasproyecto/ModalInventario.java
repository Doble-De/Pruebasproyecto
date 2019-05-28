package com.dalealdado.pruebasproyecto;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class ModalInventario {

    int[] item= new int[9];
    ImageView ivitem1, ivitem2, ivitem3, ivitem4, ivitem5, ivitem6, ivitem7, ivitem8, ivitem9;
    Button salir;


    public interface ObjetoUsado{
        void IdObjeto(int id);
    }

    private ObjetoUsado interfaz;

    public ModalInventario (Context context, ObjetoUsado actividad){

        interfaz = actividad;
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.activity_modal_inventario);
        salir = dialog.findViewById(R.id.exit);
        item[0] = 1;
        item[1] = 3;


        ivitem1 = (ImageView) dialog.findViewById(R.id.item1);
        ivitem2 = (ImageView) dialog.findViewById(R.id.item2);
        ivitem3 = (ImageView) dialog.findViewById(R.id.item3);
        ivitem4 = (ImageView) dialog.findViewById(R.id.item4);
        ivitem5 = (ImageView) dialog.findViewById(R.id.item5);
        ivitem6 = (ImageView) dialog.findViewById(R.id.item6);
        ivitem7 = (ImageView) dialog.findViewById(R.id.item7);
        ivitem8 = (ImageView) dialog.findViewById(R.id.item8);
        ivitem9 = (ImageView) dialog.findViewById(R.id.item9);


        PonerImagen();

        ivitem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.IdObjeto(item[0]);
                dialog.dismiss();
            }
        });

        ivitem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.IdObjeto(item[1]);
                dialog.dismiss();
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    public void AñadirOobjeto(int objeto){

        for (int i = 0; i < item.length; i++) {
            if (item[i] == 0){
                item[i] = objeto;
            }
        }
    }

    private void PonerImagen(){
        ImagenObjeto(item[0], ivitem1);
        ImagenObjeto(item[1], ivitem2);
        ImagenObjeto(item[2], ivitem3);
        ImagenObjeto(item[3], ivitem4);
        ImagenObjeto(item[4], ivitem5);
        ImagenObjeto(item[5], ivitem6);
        ImagenObjeto(item[6], ivitem7);
        ImagenObjeto(item[7], ivitem8);
        ImagenObjeto(item[8], ivitem9);
    }

    public void ImagenObjeto(int tipo, ImageView imageView){

        switch (tipo){
            case 0:
                imageView.setImageResource(R.drawable.empty);
                break;
            case 1:
                imageView.setImageResource(R.drawable.potion);
                break;
            case 2:
                break;
            case 3:
                imageView.setImageResource(R.drawable.librog);
                break;
        }

    }


}
