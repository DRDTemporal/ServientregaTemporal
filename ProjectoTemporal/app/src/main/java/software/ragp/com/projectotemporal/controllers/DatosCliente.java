package software.ragp.com.projectotemporal.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import software.ragp.com.projectotemporal.R;

public class DatosCliente extends AppCompatActivity {

    Button btnSiguiente;
    TextView txtDocumento, txtNombre, txtApellido, txtTelefono,txtEmail,txtDireccion;
    public static DatosCliente datosCliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_cliente);

        getSupportActionBar().setTitle("Formulario Envio");

        inizialite();


        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });
        datosCliente = this;

    }

    private void inizialite() {
        btnSiguiente = findViewById(R.id.btnSiguiente);
        txtApellido = findViewById(R.id.txtApellidos);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtDocumento = findViewById(R.id.txtDocumento);
        txtEmail = findViewById(R.id.txtCorreo);
        txtNombre = findViewById(R.id.txtNombres);
        txtTelefono = findViewById(R.id.txtTelefono);
    }

    private void validar() {
        int nValidar =0;

        if (txtApellido.getText().toString().length()>0){
            nValidar++;
        }else {
            txtApellido.setError("Por favor ingrese este campo");
        }

        if (txtDireccion.getText().toString().length()>0){
            nValidar++;
        }else {
            txtDireccion.setError("Por favor ingrese este campo");
        }

        if (txtDocumento.getText().toString().length()>0){
            nValidar++;
        }else {
            txtDocumento.setError("Por favor ingrese este campo");
        }

        if (txtEmail.getText().toString().length()>0){
            nValidar++;
        }else {
            txtEmail.setError("Por favor ingrese este campo");
        }

        if (txtNombre.getText().toString().length()>0){
            nValidar++;
        }else {
            txtNombre.setError("Por favor ingrese este campo");
        }

        if (txtTelefono.getText().toString().length()>0){
            nValidar++;
        }else {
            txtTelefono.setError("Por favor ingrese este campo");
        }

        if (nValidar>=6){
            inputData();
        }else {
            Toast.makeText(this, "Faltan campos por completar", Toast.LENGTH_SHORT).show();
        }

    }

    private void inputData() {
        TipoDeProducto.encargo.setNombre(txtNombre.getText().toString());
        TipoDeProducto.encargo.setApellido(txtApellido.getText().toString());
        TipoDeProducto.encargo.setDireccion(txtDireccion.getText().toString());
        TipoDeProducto.encargo.setDocumento(txtDocumento.getText().toString());
        TipoDeProducto.encargo.setCorreo(txtEmail.getText().toString());
        TipoDeProducto.encargo.setTelefono(txtTelefono.getText().toString());
        Intent intent = new Intent(DatosCliente.this, TipoDeProducto.class);
        startActivity(intent);
    }
}
