package software.ragp.com.projectotemporal.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import software.ragp.com.projectotemporal.R;
import software.ragp.com.projectotemporal.models.Constans;

public class RiesgoFormulario extends AppCompatActivity {
    //Declaración de variables
    Spinner spTipoM;
    EditText txtCantidad;
    SeekBar sbRiesgo;
    Button btnSiguiente;
    int nValidar=0;
    int nRiesgo=0;
    public static RiesgoFormulario riesgoFormulario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riesgo_formulario);
        inizialite();
        inputList();
        escucharBoton();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Riesgos");
        riesgoFormulario = this;
    }

    //Método parar inicializar las vistas
    private void inizialite() {
        spTipoM = findViewById(R.id.spTipoMa);
        txtCantidad = findViewById(R.id.txtCantidad);
        sbRiesgo = findViewById(R.id.sbRiesgo);
        btnSiguiente = findViewById(R.id.btnSiguiente);
    }

    //Método para ingresar las opciones al spinner
    private void inputList() {
        ArrayAdapter<String> materiales = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,Constans.listaMaterial);
        spTipoM.setAdapter(materiales);
    }

    //Método para agregar el OnClickListener
    private void escucharBoton() {
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });
    }

    //Método para comprobar que todos lks campos esten correctamente ingresasdos
    private void validar() {
        nValidar = 0;
        if (txtCantidad.getText().toString().length()>0){
            nValidar++;
        }else {
            txtCantidad.setError("Falta este caompor por ingresar");
        }

        if (nValidar>0){
            inputData();
        }else {
            Toast.makeText(this, "Fata el campo por ingresar", Toast.LENGTH_SHORT).show();
        }

    }

    //Método para guardar temporalmete los datos de está Activity
     private void inputData() {
        TipoDeProducto.encargo.setCantidad(txtCantidad.getText().toString());
        TipoDeProducto.encargo.setEscalaDeRiesgo(String.valueOf(sbRiesgo.getProgress()));
        TipoDeProducto.encargo.setTipoRiesgo(spTipoM.getSelectedItem().toString());
        try {


        }catch (Exception e){

        }
        startActivity(new Intent(RiesgoFormulario.this,Escaner.class));


    }
}
