package com.example.pokeapppro.models;

import com.google.gson.annotations.SerializedName;

public class PokemonType {

    @SerializedName("name")
    private String typeName;
    @SerializedName("url")
    private String typeUrl;

    public PokemonType(String typeName, String typeUrl) {
        this.typeName = typeName;
        this.typeUrl = typeUrl;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getTypeUrl() {
        return typeUrl;
    }
}
