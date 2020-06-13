package com.example.pokeapppro.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.pokeapppro.database.entity.PokemonDB;
import java.util.List;

@Dao
public interface PokemonDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void Insert(PokemonDB pokemon);

    @Query("Select * From pokemon Where pokemonFavorite = 1")
    LiveData<List<PokemonDB>> getFavoritePokemonList();

    @Query("Select * From pokemon Where pokemonRecent = 1")
    LiveData<List<PokemonDB>> getRecentPokemonList();

}
