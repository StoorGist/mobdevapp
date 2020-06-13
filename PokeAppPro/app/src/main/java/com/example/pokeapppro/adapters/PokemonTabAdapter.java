package com.example.pokeapppro.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.pokeapppro.fragments.SelectAllFragment;
import com.example.pokeapppro.fragments.fragmento1;
import com.example.pokeapppro.fragments.fragmento2;

public class PokemonTabAdapter extends FragmentStateAdapter {

    public PokemonTabAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new fragmento1();
            case 1: return new fragmento2();
            case 2: return new SelectAllFragment();
            default: return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
