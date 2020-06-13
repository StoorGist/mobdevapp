package com.example.pokeapppro.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitProvider {

    PokemonApi pokemonApi;

    public RetrofitProvider() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        pokemonApi = retrofit.create(PokemonApi.class);
    }

    public PokemonApi getPokemonApi() {
        return pokemonApi;
    }
}
