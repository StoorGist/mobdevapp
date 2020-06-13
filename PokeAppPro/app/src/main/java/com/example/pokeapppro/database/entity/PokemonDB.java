package com.example.pokeapppro.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pokemon")
public class PokemonDB {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "pokemonName")
    private String pokemonName;
    @ColumnInfo(name = "pokemonImageURL")
    private String pokemonImageURL;
    @ColumnInfo(name = "pokemonId")
    private String pokemonId;
    @ColumnInfo(name = "pokemonURL")
    private String pokemonURL;
    @ColumnInfo(name = "pokemonFavorite")
    private Boolean pokemonFavorite;
    @ColumnInfo(name = "pokemonRecent")
    private Boolean pokemonRecent;

    public PokemonDB(@NonNull String pokemonName, String pokemonImageURL, String pokemonId, String pokemonURL, Boolean pokemonFavorite, Boolean pokemonRecent) {
        this.pokemonName = pokemonName;
        this.pokemonImageURL = pokemonImageURL;
        this.pokemonId = pokemonId;
        this.pokemonURL = pokemonURL;
        this.pokemonFavorite = pokemonFavorite;
        this.pokemonRecent = pokemonRecent;
    }

    @NonNull
    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(@NonNull String pokemonName) {
        this.pokemonName = pokemonName;
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

    public void setPokemonURL(String pokemonURL) {
        this.pokemonURL = pokemonURL;
    }

    public Boolean getPokemonFavorite() {
        return pokemonFavorite;
    }

    public void setPokemonFavorite(Boolean pokemonFavorite) {
        this.pokemonFavorite = pokemonFavorite;
    }

    public Boolean getPokemonRecent() {
        return pokemonRecent;
    }

    public void setPokemonRecent(Boolean pokemonRecent) {
        this.pokemonRecent = pokemonRecent;
    }
}
