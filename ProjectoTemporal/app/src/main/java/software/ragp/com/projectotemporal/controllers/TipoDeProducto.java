package software.ragp.com.projectotemporal.controllers;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import software.ragp.com.projectotemporal.R;
import software.ragp.com.projectotemporal.fragments.EncargoFragment;
import software.ragp.com.projectotemporal.fragments.MercanciaFragment;
import software.ragp.com.projectotemporal.models.Encargo;

public class TipoDeProducto extends AppCompatActivity implements View.OnClickListener {
    //Declaración de variables
    public static Encargo encargo = new Encargo();
    Button btnDocumento;
    Button btnPaquete;
    android.support.v4.app.FragmentManager manager;
    TextView txtTitulo;
    public static TipoDeProducto tipoDeProducto;
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tipo_de_producto);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initialize();
        manager.beginTransaction().replace(R.id.fragment, new EncargoFragment()).commit();
        txtTitulo.setText("Documento");
        tipoDeProducto = this;
        encargo.setTipoObj("Documento");
        encargo.setFecCreacion(dateFormat.format(date));

    }

    //Método parar inicializar las vistas
    private void initialize() {
        manager = getSupportFragmentManager();
        btnDocumento=findViewById(R.id.btnDocumento);
        btnDocumento.setOnClickListener(this);
        btnPaquete=findViewById(R.id.btnPaquete);
        btnPaquete.setOnClickListener(this);
        txtTitulo = findViewById(R.id.txtTipoPaquete);
    }

    @Override
    public void onClick(View v) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        switch (v.getId())
        {
            case R.id.btnDocumento:
                manager.beginTransaction().replace(R.id.fragment, new EncargoFragment()).commit();
                txtTitulo.setText("Documento");
                encargo.setTipoObj("Documento");
                encargo.setFecCreacion(dateFormat.format(date));
                break;

            case R.id.btnPaquete:
                manager.beginTransaction().replace(R.id.fragment, new MercanciaFragment()).commit();
                txtTitulo.setText("Mercancía");
                encargo.setTipoObj("Mercancía");
                encargo.setFecCreacion(dateFormat.format(date));
                break;
        }



    }
}
