package com.example.pokeapppro.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.ColumnInfo;

import com.example.pokeapppro.R;
import com.example.pokeapppro.adapters.PokemonAdapter;
import com.example.pokeapppro.database.PokemonRoomDataBase;
import com.example.pokeapppro.database.entity.PokemonDB;
import com.example.pokeapppro.listener.OnPokemonListClicked;
import com.example.pokeapppro.models.Pokemon;
import com.example.pokeapppro.viewmodel.PokemonDBViewModel;
import com.example.pokeapppro.viewmodel.PokemonViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment implements OnPokemonListClicked {

    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter = new PokemonAdapter(this);
    private PokemonDBViewModel dbViewModel;

    private List<Pokemon> ConvertPokemonList(List<PokemonDB> pokemonDbList){
        List<Pokemon> newPokemonList = new ArrayList<>();

        if (pokemonDbList != null && pokemonDbList.size() > 0){
            for (int i = 0; i < pokemonDbList.size(); i++){
                newPokemonList.add(new Pokemon(
                    pokemonDbList.get(i).getPokemonName(),
                    pokemonDbList.get(i).getPokemonImageURL(),
                    pokemonDbList.get(i).getPokemonId(),
                    pokemonDbList.get(i).getPokemonURL(),
                    pokemonDbList.get(i).getPokemonFavorite(),
                    pokemonDbList.get(i).getPokemonRecent()));
            }
        }
        return newPokemonList;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        dbViewModel.GetFavoritePokemonList().observe(getViewLifecycleOwner(), pokemonDB -> pokemonAdapter.setPokemonList(ConvertPokemonList(pokemonDB)));
    }

    @Override
    public void onClicked(Pokemon pokemon) {
        NavDirections action = TabFragmentDirections.actionTabFragmentToDetailFragment(pokemon.getPokemonId(), pokemon.getPokemonImageURL(), pokemon.getPokemonName());
        NavHostFragment.findNavController(this).navigate(action);
        //dbViewModel.InsertPokemon(pokemon.getPokemonName(),pokemon.getPokemonImageURL(),pokemon.getPokemonId(), pokemon.getPokemonURL(), true,true);
    }

    @Override
    public void onFavoriteClick(Pokemon pokemon) {
        dbViewModel.InsertPokemon(pokemon.getPokemonName(),pokemon.getPokemonImageURL(),pokemon.getPokemonId(), pokemon.getPokemonURL(), false,pokemon.getPokemonRecent());
    }
}
