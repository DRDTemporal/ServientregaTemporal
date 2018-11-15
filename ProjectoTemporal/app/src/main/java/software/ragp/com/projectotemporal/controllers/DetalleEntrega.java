package software.ragp.com.projectotemporal.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import software.ragp.com.projectotemporal.R;
import software.ragp.com.projectotemporal.models.Encargo;

public class DetalleEntrega extends AppCompatActivity {
    Encargo encargo;
    TextView txtTexto1, txtTexto2, txtTexto3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_entrega);
        getSupportActionBar().setTitle("Detalle");
        inizialite();
        inputData();
    }

    //Método para inicializar loas vistas
    private void inizialite() {
        txtTexto1 = findViewById(R.id.txtTexto1);
        txtTexto2 = findViewById(R.id.txtTexto2);
        txtTexto3 = findViewById(R.id.txtTexto3);
        encargo = ListaDeEntregas.encargo;
    }

    //Método para ingresar los datos a los tres Texviews
    private void inputData() {
        String texto1= encargo.getDocumento()+" "+ encargo.getNombre()+" "+encargo.getApellido()+"\n"+
                encargo.getDireccion()+"\n"+encargo.getTelefono()+" "+encargo.getCorreo();
        String texto2 = "ID de la entrega: "+encargo.getId()+"\n"+
                "Tipo de Objeto: "+encargo.getTipoObj()+"\n"+
                "Origen: "+encargo.getOrigen()+"\n"+
                "Destino: "+encargo.getDestino()+"\n"+
                "Peso: "+encargo.getPeso()+"\n"+
                "Alto: "+encargo.getAlto()+"\n"+
                "Ancho: "+encargo.getAncho()+"\n"+
                "Largo: "+encargo.getLargo()+"";

        String texto3 = "Tipo de Material: "+encargo.getTipoObj()+"\n"+
                "Cantidad: "+encargo.getCantidad()+"\n"+
                "escalaDeRiesgo : "+encargo.getEscalaDeRiesgo()+"\n"+
                "Estado: "+encargo.getEstado()+"\n"+
                "Objeto extraño: "+encargo.getObjetoEx()+"\n"+
                "Descripción: "+encargo.getDescripcion();

        txtTexto1.setText(texto1);
        txtTexto2.setText(texto2);
        txtTexto3.setText(texto3);
    }
}
