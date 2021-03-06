package com.example.pokeapppro.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.pokeapppro.fragments.PokemonSelectAllFragment;
import com.example.pokeapppro.fragments.PokemonFavoritesFragment;
import com.example.pokeapppro.fragments.PokemonRecentFragment;

public class PokemonTabAdapter extends FragmentStateAdapter {

    public PokemonTabAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new PokemonFavoritesFragment();
            case 1:
                return new PokemonRecentFragment();
            case 2:
                return new PokemonSelectAllFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
