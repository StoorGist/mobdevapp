package com.example.pokeapppro.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pokeapppro.R;
import com.example.pokeapppro.sharepreferences.InitialSharedPreferences;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class LoginFragment extends Fragment {

    private Button loginButton;
    private TextInputLayout trainerTextInputLayout;
    private TextInputEditText trainerTextInputEditText;
    private RadioButton rbMale;
    private RadioButton rbFemale;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loginButton = view.findViewById(R.id.loginButton);
        trainerTextInputLayout = view.findViewById(R.id.trainerTextInputLayout);
        trainerTextInputEditText = view.findViewById(R.id.trainerTextInputEditText);
        rbMale = view.findViewById(R.id.radioButtonMale);
        rbFemale = view.findViewById(R.id.radioButtonFemale);

        InitialSharedPreferences initialSharedPreferences = new InitialSharedPreferences(requireContext());
        String trainerName;
        String gender = initialSharedPreferences.getGender();

        trainerName = initialSharedPreferences.getTrainerName();

        if (trainerName != null) {
            trainerTextInputEditText.setText(trainerName);
        } else {
            trainerTextInputEditText.setText("");
        }

        if (gender != null) {
            if ("Female".equals(gender)) {
                rbFemale.setChecked(true);
            } else {
                rbMale.setChecked(true);
            }
        }

            loginButton.setOnClickListener(v -> {

            if (Objects.requireNonNull(trainerTextInputLayout.getEditText()).getText() != null)
                initialSharedPreferences.setTrainerName(trainerTextInputLayout.getEditText().getText().toString());

            if (rbMale.isChecked()) {
                initialSharedPreferences.setGender("Male");
            } else {
                initialSharedPreferences.setGender("Female");
            }

            NavDirections action = LoginFragmentDirections.actionLoginFragmentToTabFragment();
            NavHostFragment.findNavController(LoginFragment.this).navigate(action);
        });


    }
}
