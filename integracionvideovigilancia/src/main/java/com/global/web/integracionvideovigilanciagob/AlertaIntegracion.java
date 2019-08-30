package com.global.web.integracionvideovigilanciagob;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.global.imac2.integracionvideovigilancia.R;

public class AlertaIntegracion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerta_integracion);

        AlertDialog alertDialog = AlertaInstalaSOS();
        alertDialog.show();

    }

    private AlertDialog AlertaInstalaSOS(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("Inicie videovigilancia.")
                .setMessage("Puede instalar el modulo de Videovigilancia compatible con Claro360.")
                .setNegativeButton("Instalar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        LanzaDescarga();
                    }
                })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        finish();
                    }
                });

        return builder.create();
    }

    private void LanzaDescarga() {
        String urlDescarga = getResources().getString(R.string.URL_VIDEOPLAY);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlDescarga));
        startActivity(intent);
    }

}
