package software.ragp.com.projectotemporal.controllers;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import software.ragp.com.projectotemporal.R;

public class Escaner extends AppCompatActivity {
    VideoView videoView;
    Button btnEscaner;
    public  static Escaner escaner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escaner);
        inizialite();
        escucharBoton();
        escaner=this;
    }

    //Método para inicializar las vistas
    private void inizialite() {
        videoView = findViewById(R.id.videoView);
        btnEscaner = findViewById(R.id.btnEscaner);
    }

    //Método para ingresar el OnClickListerner al botón btnEscaner
    private void escucharBoton(){
        btnEscaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarEscaneo();
                btnEscaner.setEnabled(false);
            }
        });
    }

    //Método para simular el escaneo
    private void iniciarEscaneo() {

        String uripath = "android.resource://"+getPackageName()+"/"+R.raw.prueba;
        //String uripath = "https://www.youtube.com/watch?v=owI8-X_n9bQ";
        Uri uri = Uri.parse(uripath);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        try{
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();

        }catch (Exception e){
            Log.e("Error", e.getMessage());
            Toast.makeText(this, "El video no está disponible", Toast.LENGTH_SHORT).show();
        }

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                startActivity(new Intent(Escaner.this,EncuestaFormulario.class));
            }
        });


    }

}
