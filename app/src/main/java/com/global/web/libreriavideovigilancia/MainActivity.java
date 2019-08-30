package com.global.web.libreriavideovigilancia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.global.imac2.libreriavideovigilancia.R;
import com.global.web.integracionvideovigilancia.LaunchVideovigilancia;

public class MainActivity extends AppCompatActivity {

    private EditText edtCorreo, edtPass;
    private Button btnIntegracion, btnDescarga;
    private LaunchVideovigilancia launchVideovigilancia;

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        launchVideovigilancia = new LaunchVideovigilancia();

        btnIntegracion = (Button)findViewById(R.id.btnIntegracion);
        //btnDescarga = (Button)findViewById(R.id.btnDescarga);
        edtCorreo = (EditText)findViewById(R.id.edtCorreo);
        edtPass = (EditText)findViewById(R.id.edtPass);
        edtPass.setVisibility(View.GONE);
        edtCorreo.setVisibility(View.GONE);

        AlertDialog alertDialog = AlertaIntegracion();
        alertDialog.show();

        btnIntegracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean statusIntegracion = launchVideovigilancia.StartVigilancia(getApplicationContext());
                Log.e("Integracion",  ""+statusIntegracion);
            }
        });

        /*btnDescarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchVideovigilancia.DescargaVideoVigilancia(getApplicationContext());
            }
        });*/
    }

    private AlertDialog AlertaIntegracion(){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("¿App instalada? ");
        builder.setMessage("Status: " + launchVideovigilancia.ValidacionVideoVigilanciaInstalada(getApplicationContext()));
        return builder.create();
    }
}
