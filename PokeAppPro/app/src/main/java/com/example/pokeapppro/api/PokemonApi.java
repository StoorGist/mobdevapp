package com.example.pokeapppro.api;

import com.example.pokeapppro.models.PokemonListResponse;
import com.example.pokeapppro.models.PokemonTypeListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokemonApi {
    @GET("pokemon")
    Call<PokemonListResponse> getPokemonList(@Query("offset") int offset, @Query("limit") int limit);

    @GET("pokemon/{id}")
    Call<PokemonTypeListResponse> getPokemonTypeList(@Path("id") String id);
}
