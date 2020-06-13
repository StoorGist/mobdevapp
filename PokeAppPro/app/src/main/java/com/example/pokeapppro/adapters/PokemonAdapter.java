package com.example.pokeapppro.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokeapppro.R;
import com.example.pokeapppro.listener.OnPokemonListClicked;
import com.example.pokeapppro.models.Pokemon;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonListViewHolder> {

    private List<Pokemon> pokemonList = new ArrayList<>();
    private OnPokemonListClicked pokemonListener;

    public PokemonAdapter(OnPokemonListClicked pokemonListener) {
        this.pokemonListener = pokemonListener;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PokemonListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_pokemon_item, parent, false);
        return new PokemonListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonListViewHolder holder, int position) {
        holder.bind(pokemonList.get(position), pokemonListener);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public static class PokemonListViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private ImageView pokemonImage;
        private ImageView favoriteImageView;

        public PokemonListViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.textViewListName);
            pokemonImage = itemView.findViewById(R.id.imageViewListPokemon);
            favoriteImageView = itemView.findViewById(R.id.favoriteImageView);
        }

        public void bind(final Pokemon pokemon, final OnPokemonListClicked listener) {

            String str = pokemon.getPokemonName();
            str = String.format("%s%s", str.substring(0, 1).toUpperCase(), str.substring(1));
            nameTextView.setText(str);

            if (pokemon.getPokemonURL().equals("") || pokemon.getPokemonImageURL() == null) {
                String[] pokemonURL = pokemon.getPokemonURL().split("/");
                int partID = (pokemonURL.length - 1);
                String pokemonId = pokemonURL[partID];
                pokemon.setPokemonId(pokemonId);
            }
            pokemon.setPokemonFavorite(false);

            pokemon.setPokemonRecent(false);

            pokemon.setPokemonImageURL("https://pokeres.bastionbot.org/images/pokemon/" + pokemon.getPokemonId() + ".png");

            Picasso.get().load(pokemon.getPokemonImageURL()).into(pokemonImage);

            itemView.setOnClickListener(v -> listener.onClicked(pokemon));

            favoriteImageView.setOnClickListener(v -> listener.onFavoriteClick(pokemon));
        }
    }
}
