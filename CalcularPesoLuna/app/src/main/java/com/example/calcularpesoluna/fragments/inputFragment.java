package com.example.calcularpesoluna.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.example.calcularpesoluna.R;
import com.google.android.material.textfield.TextInputEditText;


public class inputFragment extends Fragment {
    private Button pesoButton;
    private TextInputEditText Peso;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.input_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pesoButton = view.findViewById(R.id.calcularButton);
        Peso = view.findViewById(R.id.pesoInputText);
        pesoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = inputFragmentDirections.actionInputFragmentToDisplayFragment(Peso.getText().toString());
                NavHostFragment.findNavController(inputFragment.this).navigate(action);
            }
        });
    }
}
