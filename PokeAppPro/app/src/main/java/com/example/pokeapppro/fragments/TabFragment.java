package com.example.pokeapppro.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.pokeapppro.R;
import com.example.pokeapppro.adapters.PokemonListAdapter;
import com.example.pokeapppro.adapters.PokemonTabAdapter;
import com.example.pokeapppro.models.PokemonList;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class TabFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager2 viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab ,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tab);
        viewPager = view.findViewById(R.id.viewPagerTab);
        viewPager.setAdapter(new PokemonTabAdapter(this));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout,
                viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position) {
                            case 0:
                                tab.setText(R.string.favoritesResource);
                                break;
                            case 1:
                                tab.setText(R.string.RecentsResource);
                                break;
                            case 2:
                                tab.setText(R.string.selectAllResource);
                                break;
                        }

                    }
                });


    }
}
