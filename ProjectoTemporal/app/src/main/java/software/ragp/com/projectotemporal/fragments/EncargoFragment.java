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
import android.widget.Spinner;
import android.widget.TextView;

import software.ragp.com.projectotemporal.R;
import software.ragp.com.projectotemporal.controllers.RiesgoFormulario;
import software.ragp.com.projectotemporal.models.Constans;

/**
 * A simple {@link Fragment} subclass.
 */
public class EncargoFragment extends Fragment implements View.OnClickListener {

    Button btnSiguienteEncargo;
    View view;
    Spinner spinnerOrigen;
    Spinner spinnerDestino;
    TextView txtPeso;
    TextView txtValor;
    int validaciones =0;
    public EncargoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_encargo, container, false);

        initialize();

        return view;
    }

    private void initialize() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_dropdown_item_1line,Constans.listaDepartamentos);
        spinnerDestino=view.findViewById(R.id.spinnerDestino);
        spinnerOrigen=view.findViewById(R.id.spinnerOrigen);
        spinnerOrigen.setAdapter(adapter);
        spinnerDestino.setAdapter(adapter);
        btnSiguienteEncargo = view.findViewById(R.id.btnSiguienteEncargo);
        btnSiguienteEncargo.setOnClickListener(this);
        txtPeso=view.findViewById(R.id.txtPeso);
        txtValor=view.findViewById(R.id.txtValor);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnSiguienteEncargo:
               validar();

            break;
        }

    }

    public  void validar() {
        if (!txtPeso.getText().equals(""))
        {
            validaciones++;
        }
        else
        {
            txtPeso.setError("Debe ingresar el peso del objeto");
        }
        if(!txtValor.getText().equals(""))
        {
            validaciones++;
        }
        else
        {
            txtValor.setError("Debe ingresar el valor declarado del objeto      ");
        }
        if(spinnerOrigen.getSelectedItem().toString().equals(spinnerDestino.getSelectedItem().toString()))
        {
            TextView errorText = (TextView)spinnerOrigen.getSelectedView();
            errorText.setError("");
            errorText.setTextColor(Color.RED);//just to highlight that this is an error
            errorText.setText("El origen y el destino no pueden ser el mismo");//

            TextView errorText1 = (TextView)spinnerDestino.getSelectedView();
            errorText1.setError("");
            errorText1.setTextColor(Color.RED);//just to highlight that this is an error
            errorText1.setText("El origen y el destino no pueden ser el mismo");//
        }
        else
        {
            validaciones++;
        }

        if(validaciones==3)
        {
            Intent intent = new Intent(getContext(), RiesgoFormulario.class);
            startActivity(intent);
        }
    }
}
