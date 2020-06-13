package com.example.pokeapppro.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.pokeapppro.fragments.SelectAllFragment;
import com.example.pokeapppro.fragments.FavoritesFragment;
import com.example.pokeapppro.fragments.RecentFragment;

public class PokemonTabAdapter extends FragmentStateAdapter {

    public PokemonTabAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new FavoritesFragment();
            case 1: return new RecentFragment();
            case 2: return new SelectAllFragment();
            default: return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
