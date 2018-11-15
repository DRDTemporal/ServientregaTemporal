package software.ragp.com.projectotemporal.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import software.ragp.com.projectotemporal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MercanciaFragment extends Fragment {

    View view;
    EditText txtPeso, txtLargo, txtAlto, txtAncho, txtValor;
    Spinner spinner1, spinner2;
    public MercanciaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_mercancia, container, false);
        inizliate();
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
    }

}
