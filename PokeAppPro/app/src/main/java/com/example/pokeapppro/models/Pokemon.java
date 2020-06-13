package com.example.pokeapppro.models;

import com.google.gson.annotations.SerializedName;

public class Pokemon {

    @SerializedName("name")
    private String pokemonName;
    private String imageURL;
    private String pokemonId;
    @SerializedName("url")
    private String pokemonURL;
    private Boolean pokemonFavorite;

    public Pokemon(String pokemonName, String imageURL, String pokemonId, String pokemonURL, Boolean pokemonFavorite) {
        this.pokemonName = pokemonName;
        this.imageURL = imageURL;
        this.pokemonId = pokemonId;
        this.pokemonURL = pokemonURL;
        this.pokemonFavorite = pokemonFavorite;
    }

    public String getPokemonName() {
        return pokemonName.substring(0, 1).toUpperCase() + pokemonName.substring(1);
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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

    public Boolean getFavorite() {
        return pokemonFavorite;
    }

    public void setFavorite(Boolean favorite) {
        pokemonFavorite = favorite;
    }

}
