package software.ragp.com.projectotemporal.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

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
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnSiguienteEncargo:
               Intent intent = new Intent(getContext(), RiesgoFormulario.class);
               startActivity(intent);

            break;
        }

    }
}
