package software.ragp.com.projectotemporal.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import software.ragp.com.projectotemporal.R;
import software.ragp.com.projectotemporal.models.AdapterE;
import software.ragp.com.projectotemporal.models.Encargo;
import software.ragp.com.projectotemporal.models.ManagerDB;

public class ListaDeEntregas extends AppCompatActivity {
    RecyclerView recyclerView;
    public static Encargo encargo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_entregas);
        recyclerView = findViewById(R.id.recyclerView);
        inputAdapter();
    }

    private void inputAdapter() {
        ManagerDB managerDB = ManagerDB.getInstance(this);
        final List<Encargo> encargos = managerDB.selectAllEncargo();
        AdapterE adapterE = new AdapterE(encargos);
        recyclerView.setAdapter(adapterE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        adapterE.setMlistener(new AdapterE.OnClickListener() {
            @Override
            public void itemClick(int position) {
                encargo = encargos.get(position);
                startActivity(new Intent(ListaDeEntregas.this,DetalleEntrega.class));

            }
        });
    }
}
