package com.example.pokeapppro.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PokemonListResponse {
    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    @SerializedName("results")
    List<Pokemon> pokemonList;
}
