package software.ragp.com.projectotemporal.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import software.ragp.com.projectotemporal.R;
import software.ragp.com.projectotemporal.models.Encargo;

public class TipoDeProducto extends AppCompatActivity {
    public static Encargo encargo = new Encargo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_de_producto);


    }

}
