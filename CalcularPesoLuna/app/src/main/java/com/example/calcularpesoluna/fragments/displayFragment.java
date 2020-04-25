package com.example.calcularpesoluna.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.calcularpesoluna.R;

public class displayFragment extends Fragment {
    private TextView pesoTextView;
    private double total = 0;
    private double pesoTierra = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pesoTextView = view.findViewById(R.id.displayPeso);
        pesoTierra = Double.valueOf(displayFragmentArgs.fromBundle(getArguments()).getPeso());
        total = (pesoTierra/9.81)*1.622;
        pesoTextView.setText(String.valueOf(total));

    }
}
