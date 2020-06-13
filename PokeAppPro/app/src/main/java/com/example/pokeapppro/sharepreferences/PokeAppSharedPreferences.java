package com.example.pokeapppro.sharepreferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.pokeapppro.R;

public class PokeAppSharedPreferences {
    SharedPreferences sharedpreferences;

    //GET CONTEXT PREFERENCES
    public PokeAppSharedPreferences(Context context) {
        sharedpreferences = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    }

    //TRAINER
    public void setTrainerName(String trainerName) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("TrainerNameKey", trainerName);
        editor.apply();
    }

    public String getTrainerName() {
        return sharedpreferences.getString("TrainerNameKey", null);
    }

    //GENDER
    public void setGender(String gender) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("TrainerGenderKey", gender);
        editor.apply();
    }

    public String getGender() {
        return sharedpreferences.getString("TrainerGenderKey", null);
    }

}
