package software.ragp.com.projectotemporal.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import software.ragp.com.projectotemporal.R;
import software.ragp.com.projectotemporal.models.ManagerDB;

public class EncuestaFormulario extends AppCompatActivity {

    ArrayList<String> estado = new ArrayList<>();
    Spinner spinnerEstado;
    EditText txtDescripcion;
    RadioButton btnSi;
    RadioButton btnNo;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_encuesta_formulario);
        inizialite();
        inputList();

    }

    private void inizialite() {
        spinnerEstado=findViewById(R.id.spinnerEstado);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        btnSi = findViewById(R.id.rbtnSi);
        btnNo = findViewById(R.id.rbtnNo);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputData();
            }
        });
    }

    private void inputList() {
        estado.add("Bueno");
        estado.add("Malo");
        estado.add("Regular");
        ArrayAdapter<String> spinnerEstadoAdapter= new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, estado);
        spinnerEstado.setAdapter(spinnerEstadoAdapter);

    }

    private void inputData() {
        TipoDeProducto.encargo.setDescripcion(txtDescripcion.getText().toString());
        TipoDeProducto.encargo.setEstado(spinnerEstado.getSelectedItem().toString());
        if (btnSi.isChecked()){
            TipoDeProducto.encargo.setObjetoEx("Si");
        }else {
            TipoDeProducto.encargo.setObjetoEx("No");
        }
        ManagerDB managerDB = ManagerDB.getInstance(this);
        managerDB.insertEncargo(TipoDeProducto.encargo);
        Toast.makeText(this, "Se ha guardado correctamente", Toast.LENGTH_SHORT).show();
        finalizarTodo();


    }

    private void finalizarTodo() {
        RiesgoFormulario.riesgoFormulario.finish();
        TipoDeProducto.tipoDeProducto.finish();
        finish();
    }


}
