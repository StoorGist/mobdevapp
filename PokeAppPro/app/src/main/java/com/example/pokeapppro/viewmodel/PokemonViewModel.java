package com.example.pokeapppro.viewmodel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pokeapppro.api.RetrofitProvider;
import com.example.pokeapppro.models.Pokemon;
import com.example.pokeapppro.models.PokemonListResponse;
import com.example.pokeapppro.models.PokemonTypeDetail;
import com.example.pokeapppro.models.PokemonTypeListResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonViewModel extends ViewModel {

    //PokemonDetails
    private MutableLiveData<List<Pokemon>> pokemonListAll = new MutableLiveData<>();
    public LiveData<List<Pokemon>> getPokemonListAll() {
        return pokemonListAll;
    }

    public void getPokemonListServer() {
        RetrofitProvider retrofitProvider = new RetrofitProvider();
        retrofitProvider.getPokemonApi().getPokemonList(20, 500).enqueue(new Callback<PokemonListResponse>() {
            @Override
            public void onResponse(Call<PokemonListResponse> call, Response<PokemonListResponse> response) {
                pokemonListAll.postValue(response.body().getPokemonList());
            }

            @Override
            public void onFailure(Call<PokemonListResponse> call, Throwable t) {
            }
        });
    }

    //TypesDetails
    private MutableLiveData<List<PokemonTypeDetail>> typeList = new MutableLiveData<>();
    public LiveData<List<PokemonTypeDetail>> getTypeList() {
        return typeList;
    }

    public void getPokemonTypeListServer(String id) {
        RetrofitProvider retrofitProvider = new RetrofitProvider();
        retrofitProvider.getPokemonApi().getPokemonTypeList(id).enqueue(new Callback<PokemonTypeListResponse>() {
            @Override
            public void onResponse(Call<PokemonTypeListResponse> call, Response<PokemonTypeListResponse> response) {
                typeList.postValue(response.body().getPokemonTypeList());
            }

            @Override
            public void onFailure(Call<PokemonTypeListResponse> call, Throwable t) {
            }
        });
    }

}
