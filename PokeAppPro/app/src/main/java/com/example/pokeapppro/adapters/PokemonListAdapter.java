package com.example.pokeapppro.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokeapppro.R;
import com.example.pokeapppro.fragments.TabFragment;
import com.example.pokeapppro.listener.OnPokemonListClicked;
import com.example.pokeapppro.models.PokemonList;

import java.util.ArrayList;
import java.util.List;

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.PokemonListViewHolder> {

    private List<PokemonList> pokemonList = new ArrayList<>();

    private OnPokemonListClicked pokemonListener;

    public PokemonListAdapter(TabFragment tabFragment) {
    }

    @NonNull
    @Override
    public PokemonListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_pokemon_item,parent,false);
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

    public static class PokemonListViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTextView;


        public PokemonListViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.textViewListName);

        }

        public void bind(final PokemonList pokemonList,final OnPokemonListClicked listener) {
            nameTextView.setText(pokemonList.getPokemonName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClicked(pokemonList);
                }
            });
        }
    }
}
