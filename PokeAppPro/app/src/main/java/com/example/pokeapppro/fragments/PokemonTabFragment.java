package com.example.pokeapppro.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.pokeapppro.R;
import com.example.pokeapppro.adapters.PokemonTabAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class PokemonTabFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager2 viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayout = view.findViewById(R.id.tab);

        viewPager = view.findViewById(R.id.viewPagerTab);
        viewPager.setAdapter(new PokemonTabAdapter(this));

        new TabLayoutMediator(tabLayout,
                viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText(R.string.favoritesResource);
                            break;
                        case 1:
                            tab.setText(R.string.RecentResource);
                            break;
                        case 2:
                            tab.setText(R.string.selectAllResource);
                            break;
                    }
                }).attach();
    }
}
