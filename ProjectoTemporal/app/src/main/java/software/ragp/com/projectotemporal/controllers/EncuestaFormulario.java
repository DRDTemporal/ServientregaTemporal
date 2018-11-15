package software.ragp.com.projectotemporal.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import software.ragp.com.projectotemporal.R;

public class EncuestaFormulario extends AppCompatActivity {

    ArrayList<String> estado = new ArrayList<>();
    Spinner spinnerEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_encuesta_formulario);

        estado.add("Bueno");
        estado.add("Malo");
        estado.add("Regular");

        spinnerEstado=findViewById(R.id.spinnerEstado);

        ArrayAdapter<String> spinnerEstadoAdapter= new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, estado);
        spinnerEstado.setAdapter(spinnerEstadoAdapter);


    }
}
