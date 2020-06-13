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
        String str = typeName;
        str = String.format("%s%s", str.substring(0, 1).toUpperCase(), str.substring(1));
        return str;
    }

    public String getTypeUrl() {
        return typeUrl;
    }
}
