package com.example.pokeapppro.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonTypeListResponse {
    @SerializedName("types")
    private List<PokemonTypeDetail> typeList;

    public List<PokemonTypeDetail> getPokemonTypeList() {
        return typeList;
    }

    public void setPokemonTypeList(List<PokemonTypeDetail> pokemonTypeDetailList) {
        this.typeList = pokemonTypeDetailList;
    }
}
