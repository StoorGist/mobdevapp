package com.example.pokeapppro.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;

import com.example.pokeapppro.database.Repository.PokemonRepo;
import com.example.pokeapppro.database.entity.PokemonDB;

import java.util.List;

public class PokemonDBViewModel extends AndroidViewModel {
    private static final String QUERY_KEY = "QUERY";
    private PokemonRepo repository;
    public PokemonDBViewModel (@NonNull Application application){
        super(application);
        repository = new PokemonRepo(application.getApplicationContext());
    }

    public void InsertPokemon(String pokemonName, String pokemonImageURL, String pokemonId, String pokemonURL, Boolean pokemonFavorite, Boolean pokemonRecent){
        repository.InsertPokemon(new PokemonDB(pokemonName, pokemonImageURL, pokemonId, pokemonURL, pokemonFavorite, pokemonRecent));
    }

    public LiveData<List<PokemonDB>> GetFavoritePokemonList(){
        return repository.GetFavoritePokemonList();
    }

    public LiveData<List<PokemonDB>> GetRecentPokemonList(){
        return repository.GetRecentPokemonList();
    }

}
