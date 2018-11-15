package software.ragp.com.projectotemporal;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;
import android.widget.Toolbar;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import software.ragp.com.projectotemporal.controllers.DatosCliente;
import software.ragp.com.projectotemporal.controllers.TipoDeProducto;
import software.ragp.com.projectotemporal.models.Encargo;
import software.ragp.com.projectotemporal.models.ManagerDB;

public class MainActivity extends AppCompatActivity {

    private final int MY_PERMISSIONS_REQUEST_READ_CONTACTS=100;
    Button btnCambio;
    Button btnExportar;
    File archivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Inicio");
        getSupportActionBar().setIcon(R.drawable.inicio);
        btnCambio= findViewById(R.id.btnBuscar);
        btnExportar = findViewById(R.id.btnExportar);
        btnExportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pedirPermiso();
            }
        });
        btnCambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviar(v);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

        }
        return super.onOptionsItemSelected(item);
    }

    public void enviar(View view) {
        Intent intent = new Intent(MainActivity.this, DatosCliente.class);
        startActivity(intent);
    }

    private void pedirPermiso() {

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISSIONS_REQUEST_READ_CONTACTS);

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {
                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }else {
            exportarEnCSV();
        }

    }

    private void exportarEnCSV() {

        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.item_busqueda);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        final DatePicker datePicker = dialog.findViewById(R.id.calendario);
        final Button btnAceptar =  dialog.findViewById(R.id.btnExportar);
        Button btnCancelar =  dialog.findViewById(R.id.btnCancelar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mes = datePicker.getMonth()+1;
                String fecha1 = datePicker.getDayOfMonth()+"/"+mes+"/"+datePicker.getYear();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                try {
                    date =dateFormat.parse(fecha1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
                String fecha = dateFormat1.format(date);
                ManagerDB managerDB = ManagerDB.getInstance(MainActivity.this);
                List<Encargo> tmpListDatos = managerDB.selectAllEncargo();
                //Log.e("asd",""+tmpListDatos.get(0).getFecTamitaje()+" "+fecha);
                System.out.println(tmpListDatos);
                Iterator<Encargo> it = tmpListDatos.iterator();
                List<Encargo> tmpDatos1 = new ArrayList<>();
                try {
                    while (it.hasNext()) {
                        Encargo current = it.next();
                        if (!current.getFecCreacion().equals(fecha)) {
                            it.remove();
                        }else {
                            tmpDatos1.add(current);
                        }
                    }
                    File exportDir = new File(Environment.getExternalStorageDirectory(), "Entregas");
                    if (!exportDir.exists())
                    {
                        exportDir.mkdirs();
                    }
                    archivo = new File(exportDir, "Entregas "+fecha.substring(0,2)+"-"+fecha.substring(3,5)+"-"+fecha.substring(6,8)+".csv");
                    archivo.createNewFile();
                    CSVWriter csvWrite = new CSVWriter(new FileWriter(archivo));
                    String titulos [] ={
                            "ID","Tipo de Objeto", "Peso","Valor Destinado", "Origen", "Destino", "Largo", "Alto",
                            "Ancho","Tipo de Material","Cantidad","Escala de Riego","Estado","Objetos Extraños", "Descripción","Fecha de Creación"
                    };
                    csvWrite.writeNext(titulos);
                    for (int i=0; i<tmpDatos1.size();i++) {
                        Encargo tmpDatos = tmpDatos1.get(i);
                        String arrStr[] = {String.valueOf(tmpDatos.getId()),tmpDatos.getTipoObj(),tmpDatos.getPeso(),
                                tmpDatos.getValorD(), tmpDatos.getOrigen(),tmpDatos.getDestino(),tmpDatos.getLargo(),
                                tmpDatos.getAlto(),tmpDatos.getAncho(),tmpDatos.getTipoRiesgo(), tmpDatos.getCantidad(),tmpDatos.getEscalaDeRiesgo(),
                                tmpDatos.getEstado(),tmpDatos.getObjetoEx(),tmpDatos.getDescripcion(),tmpDatos.getFecCreacion()
                        };

                        csvWrite.writeNext(arrStr);

                    }
                    csvWrite.close();

                    if (tmpDatos1.size()<1){
                        Toast.makeText(MainActivity.this, "No hay entregas registradas en la fecha seleccionada", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "El archivo está en la carpeta Entregas", Toast.LENGTH_SHORT).show();

                    }

                    dialog.cancel();

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "No hay tamitajes registrados en la fecha seleccionada", Toast.LENGTH_SHORT).show();
                    Log.e("Error",e.getMessage());
                }
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }



}
