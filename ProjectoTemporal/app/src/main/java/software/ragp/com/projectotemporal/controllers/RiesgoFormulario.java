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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        riesgoFormulario = this;
    }

    private void inizialite() {
        spTipoM = findViewById(R.id.spTipoMa);
        txtCantidad = findViewById(R.id.txtCantidad);
        sbRiesgo = findViewById(R.id.sbRiesgo);
        btnSiguiente = findViewById(R.id.btnSiguiente);
    }

    private void inputList() {
        ArrayAdapter<String> materiales = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,Constans.listaMaterial);
        spTipoM.setAdapter(materiales);
    }

    private void escucharBoton() {
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });
    }

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


    private void inputData() {
        TipoDeProducto.encargo.setCantidad(txtCantidad.getText().toString());

        sbRiesgo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                nRiesgo=progress;
                TipoDeProducto.encargo.setCantidad(Integer.toString(nRiesgo));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        TipoDeProducto.encargo.setTipoRiesgo(spTipoM.getSelectedItem().toString());
        startActivity(new Intent(RiesgoFormulario.this,EncuestaFormulario.class));


    }
}
