package software.ragp.com.projectotemporal.fragments;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import software.ragp.com.projectotemporal.R;
import software.ragp.com.projectotemporal.controllers.EncuestaFormulario;
import software.ragp.com.projectotemporal.controllers.RiesgoFormulario;
import software.ragp.com.projectotemporal.controllers.TipoDeProducto;
import software.ragp.com.projectotemporal.models.Constans;
import software.ragp.com.projectotemporal.models.Encargo;

/**
 * A simple {@link Fragment} subclass.
 */
public class MercanciaFragment extends Fragment{

    View view;
    EditText txtPeso, txtLargo, txtAlto, txtAncho, txtValor;
    Spinner spinner1, spinner2;
    Encargo encargo = new Encargo();
    Button btnSiguienteMercancia;
    int nValidar;
    public MercanciaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_mercancia, container, false);
        inizliate();
        inputLists();
        return view;
    }

    private void inizliate() {
        txtPeso = view.findViewById(R.id.txtPeso);
        txtLargo = view.findViewById(R.id.txtLargo);
        txtAlto = view.findViewById(R.id.txtAlto);
        txtAncho = view.findViewById(R.id.txtAncho);
        txtValor = view.findViewById(R.id.txtValorA);
        spinner1 = view.findViewById(R.id.spinner);
        spinner2 = view.findViewById(R.id.spinner1);
        btnSiguienteMercancia = view.findViewById(R.id.btnSiguienteMercancia);

    }

    private void inputLists() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_dropdown_item_1line,Constans.listaDepartamentos);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
    }

    private void inputData(){
        TipoDeProducto.encargo.setPeso(txtPeso.getText().toString());
        TipoDeProducto.encargo.setLargo(txtLargo.getText().toString());
        TipoDeProducto.encargo.setAlto(txtAlto.getText().toString());
        TipoDeProducto.encargo.setAncho(txtAncho.getText().toString());
        TipoDeProducto.encargo.setValorD(txtValor.getText().toString());
        TipoDeProducto.encargo.setOrigen(spinner1.getSelectedItem().toString());
        TipoDeProducto.encargo.setDescripcion(spinner2.getSelectedItem().toString());
        startActivity(new Intent(getContext(),EncuestaFormulario.class));

    }

    private void validar(){
        nValidar=0;
        if (txtAlto.getText().toString().length()>0){
            nValidar++;
        }else {
            txtAlto.setError("Por favor ingrese este campo");
        }

        if (txtAncho.getText().toString().length()>0){
            nValidar++;
        }else {
            txtAncho.setError("Por favor ingrese este campo");
        }


        if (txtLargo.getText().toString().length()>0){
            nValidar++;
        }else {
            txtLargo.setError("Por favor ingrese este campo");
        }


        if (txtPeso.getText().toString().length()>0){
            nValidar++;
        }else {
            txtPeso.setError("Por favor ingrese este campo");
        }

        if (txtValor.getText().toString().length()>0){
            nValidar++;
        }else {
            txtValor.setError("Por favor ingrese este campo");
        }

        if (spinner1.getSelectedItem().toString().equals(spinner2.getSelectedItem().toString())){
            nValidar++;
        }else {
            TextView errorText = (TextView)spinner1.getSelectedView();
            TextView errorText1 = (TextView)spinner2.getSelectedView();
            errorText.setError("");
            errorText.setTextColor(Color.RED);
            errorText.setText("El origen y el destino no pueden ser iguales");
            errorText1.setError("");
            errorText1.setTextColor(Color.RED);
            errorText1.setText("El origen y el destino no pueden ser iguales");
        }

        if (nValidar>=6){
            inputData();


        }else if (!spinner1.getSelectedItem().toString().equals(spinner2.getSelectedItem().toString())){
            Toast.makeText(getContext(), "El origen y el destino no pueden ser iguales", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(getContext(), "Faltan campos por ingresar", Toast.LENGTH_SHORT).show();
        }
        btnSiguienteMercancia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), RiesgoFormulario.class));

            }
        });
    }

}
