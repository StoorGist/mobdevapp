package com.example.pokeapppro.models;

import com.google.gson.annotations.SerializedName;

public class PokemonTypeDetail {

    @SerializedName("type")
    private PokemonType type;
    @SerializedName("slot")
    private int slot;

    public PokemonTypeDetail(PokemonType type, Boolean isHidden, int slot) {
        this.setType(type);
        this.setSlot(slot);
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
