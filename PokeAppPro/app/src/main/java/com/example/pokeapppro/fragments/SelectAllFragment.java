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
import com.example.pokeapppro.adapters.PokemonAdapter;
import com.example.pokeapppro.listener.OnPokemonListClicked;
import com.example.pokeapppro.models.Pokemon;
import com.example.pokeapppro.viewmodel.PokemonDBViewModel;
import com.example.pokeapppro.viewmodel.PokemonViewModel;

public class SelectAllFragment extends Fragment implements OnPokemonListClicked {

    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter = new PokemonAdapter(this);
    private PokemonViewModel pokemonViewModel;
    private PokemonDBViewModel dbViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pokemonViewModel = new ViewModelProvider(this).get(PokemonViewModel.class);
        dbViewModel = new ViewModelProvider(this).get(PokemonDBViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewAll);
        recyclerView.setAdapter(pokemonAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        pokemonViewModel.getPokemonListServer();
        pokemonViewModel.getPokemonListAll().observe(this.getViewLifecycleOwner(), pokemons -> pokemonAdapter.setPokemonList(pokemons));

    }

    @Override
    public void onClicked(Pokemon pokemon) {
        NavDirections action = TabFragmentDirections.actionTabFragmentToDetailFragment(pokemon.getPokemonId(), pokemon.getPokemonImageURL(), pokemon.getPokemonName());
        NavHostFragment.findNavController(SelectAllFragment.this).navigate(action);
        dbViewModel.InsertPokemon(pokemon.getPokemonName(),pokemon.getPokemonImageURL(),pokemon.getPokemonId(), pokemon.getPokemonURL(), pokemon.getPokemonFavorite(),true);
    }

    @Override
    public void onFavoriteClick(Pokemon pokemon) {
        if (pokemon.getPokemonFavorite().equals(true)){
            pokemon.setPokemonFavorite(false);
        }
        else pokemon.setPokemonFavorite(true);

        dbViewModel.InsertPokemon(pokemon.getPokemonName(),pokemon.getPokemonImageURL(),pokemon.getPokemonId(), pokemon.getPokemonURL(), pokemon.getPokemonFavorite(),pokemon.getPokemonRecent());
    }
}
