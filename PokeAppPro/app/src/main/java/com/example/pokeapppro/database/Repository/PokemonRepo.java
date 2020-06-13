package com.example.pokeapppro.database.Repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.pokeapppro.database.PokemonRoomDataBase;
import com.example.pokeapppro.database.dao.PokemonDAO;
import com.example.pokeapppro.database.entity.PokemonDB;

import java.util.List;

public class PokemonRepo {
    private PokemonDAO pokemonDAO;

    public PokemonRepo(Context context){
        PokemonRoomDataBase db = PokemonRoomDataBase.getDatabase(context);
        pokemonDAO = db.pokemonDAO();
    }

    public void InsertPokemon(PokemonDB pokemon){
        if (pokemon != null && pokemonDAO != null){
            PokemonRoomDataBase.appDatabaseWriteExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    //Boolean favorite = true;
                    //PokemonDB pokemonDb = pokemonDAO.FindById(pokemon.getPokemonId());
                    //if (pokemonDb != null){
                    //    favorite = pokemonDAO.FindById(pokemon.getPokemonId()).getPokemonFavorite();
                    //}

                    if (pokemon.getPokemonFavorite().equals(false)){
                        pokemon.setPokemonFavorite(true);}

                    pokemonDAO.Insert(pokemon);
                }
            });
        }
    }

    public LiveData<List<PokemonDB>> GetFavoritePokemonList(){
        return pokemonDAO.getFavoritePokemonList();
    }

    public LiveData<List<PokemonDB>> GetRecentPokemonList(){
        return pokemonDAO.getRecentPokemonList();
    }

}