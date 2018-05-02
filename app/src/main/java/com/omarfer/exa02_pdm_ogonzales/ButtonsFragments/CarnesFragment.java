package com.omarfer.exa02_pdm_ogonzales.ButtonsFragments;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omarfer.exa02_pdm_ogonzales.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarnesFragment extends Fragment {


    public CarnesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_carnes, container, false);
    }

}
