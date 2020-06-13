package com.example.pokeapppro.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pokeapppro.R;
import com.example.pokeapppro.viewmodel.PokemonViewModel;
import com.squareup.picasso.Picasso;


public class PokemonDetailFragment extends Fragment {

    private ImageView imageViewPokemon;
    private TextView textViewDetailName;
    private TextView textViewDetail;
    private PokemonViewModel detailViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailViewModel = new ViewModelProvider(this).get(PokemonViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageViewPokemon = view.findViewById(R.id.imageViewPokemon);
        textViewDetailName = view.findViewById(R.id.textViewDetailName);
        textViewDetail = view.findViewById(R.id.textViewDetail);

        textViewDetailName.setText(PokemonDetailFragmentArgs.fromBundle(getArguments()).getPokemonName());
        Picasso.get().load(PokemonDetailFragmentArgs.fromBundle(getArguments()).getPokemonImageURL()).into(imageViewPokemon);
        String pokemonId = PokemonDetailFragmentArgs.fromBundle(getArguments()).getPokemonId();

        detailViewModel.getPokemonTypeListServer(pokemonId);
        detailViewModel.getTypeList().observe(this.getViewLifecycleOwner(), pokemonTypeDetails -> {
            String pokemonTypeList = pokemonTypeDetails.get(0).getType().getTypeName();
            String pokemonTypes = "";
            textViewDetail.setText(pokemonTypeList);
        });
    }


}
