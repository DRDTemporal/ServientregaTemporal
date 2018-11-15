package software.ragp.com.projectotemporal.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import software.ragp.com.projectotemporal.R;

public class RiesgoFormulario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riesgo_formulario);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
