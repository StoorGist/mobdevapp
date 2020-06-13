package com.example.pokeapppro.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokeapppro.R;
import com.example.pokeapppro.adapters.PokemonListAdapter;
import com.example.pokeapppro.listener.OnPokemonListClicked;
import com.example.pokeapppro.models.Pokemon;
import com.example.pokeapppro.viewmodel.PokemonViewModel;

public class SelectAllFragment extends Fragment implements OnPokemonListClicked {

    private RecyclerView recyclerView;
    private PokemonListAdapter pokemonAdapter = new PokemonListAdapter(this);
    private PokemonViewModel pokemonViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pokemonViewModel = new ViewModelProvider(this).get(PokemonViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_select_all, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewAll);
        recyclerView.setAdapter(pokemonAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        pokemonViewModel.getPokemonListServer();
        pokemonViewModel.getPokemonList().observe(this.getViewLifecycleOwner(), pokemons -> pokemonAdapter.setPokemonList(pokemons));

    }

    @Override
    public void onClicked(Pokemon pokemon) {
        NavDirections action = TabFragmentDirections.actionTabFragmentToDetailFragment(pokemon.getPokemonId(), pokemon.getImageURL(), pokemon.getPokemonName());
        NavHostFragment.findNavController(SelectAllFragment.this).navigate(action);
    }

    @Override
    public void onFavoriteClick(Pokemon pokemon) {

    }
}
