package com.example.pokeapppro.models;

import com.google.gson.annotations.SerializedName;

public class Pokemon {

    @SerializedName("name")
    private String pokemonName;
    private String pokemonImageURL;
    private String pokemonId;
    @SerializedName("url")
    private String pokemonURL;
    private Boolean pokemonFavorite;
    private Boolean pokemonRecent;

    public Pokemon(String pokemonName, String pokemonImageURL, String pokemonId, String pokemonURL, Boolean pokemonFavorite, Boolean pokemonRecent) {
        this.pokemonName = pokemonName;
        this.pokemonImageURL = pokemonImageURL;
        this.pokemonId = pokemonId;
        this.pokemonURL = pokemonURL;
        this.pokemonFavorite = pokemonFavorite;
        this.pokemonRecent = pokemonRecent;
    }

    public String getPokemonName() {
        String str = pokemonName;
        str = String.format("%s%s", str.substring(0, 1).toUpperCase(), str.substring(1));
        return str;
    }

    public String getPokemonImageURL() {
        return pokemonImageURL;
    }

    public void setPokemonImageURL(String pokemonImageURL) {
        this.pokemonImageURL = pokemonImageURL;
    }

    public String getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(String pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getPokemonURL() {
        return pokemonURL;
    }

    public Boolean getPokemonFavorite() {
        return pokemonFavorite;
    }
    public void setPokemonFavorite(Boolean favorite) {
        pokemonFavorite = favorite;
    }

    public Boolean getPokemonRecent() {
        return pokemonRecent;
    }
    public void setPokemonRecent(Boolean favorite) {
        pokemonRecent = favorite;
    }

}
