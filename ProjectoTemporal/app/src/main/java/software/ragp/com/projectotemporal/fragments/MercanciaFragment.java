package software.ragp.com.projectotemporal.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import software.ragp.com.projectotemporal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MercanciaFragment extends Fragment {


    public MercanciaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mercancia, container, false);
    }

}
