package com.example.pokeapppro.listener;

import com.example.pokeapppro.models.Pokemon;

public interface OnPokemonListClicked {
    void onClicked(Pokemon pokemon);

    void onFavoriteClick(Pokemon pokemon);
}
