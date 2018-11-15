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

import software.ragp.com.projectotemporal.R;
import software.ragp.com.projectotemporal.fragments.EncargoFragment;
import software.ragp.com.projectotemporal.fragments.MercanciaFragment;
import software.ragp.com.projectotemporal.models.Encargo;

public class TipoDeProducto extends AppCompatActivity implements View.OnClickListener {
    public static Encargo encargo = new Encargo();
    Button btnDocumento;
    Button btnPaquete;
    android.support.v4.app.FragmentManager manager;
    TextView txtTitulo;
    public static TipoDeProducto tipoDeProducto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tipo_de_producto);
        initialize();
        manager.beginTransaction().replace(R.id.fragment, new EncargoFragment()).commit();
        txtTitulo.setText("Documento");
        tipoDeProducto = this;

    }

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

        switch (v.getId())
        {
            case R.id.btnDocumento:
                manager.beginTransaction().replace(R.id.fragment, new EncargoFragment()).commit();
                txtTitulo.setText("Documento");
                break;

            case R.id.btnPaquete:
                manager.beginTransaction().replace(R.id.fragment, new MercanciaFragment()).commit();
                txtTitulo.setText("Mercancía");
                break;
        }



    }
}
