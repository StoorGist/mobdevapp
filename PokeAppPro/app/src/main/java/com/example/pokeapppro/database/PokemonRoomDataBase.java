package com.example.pokeapppro.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pokeapppro.database.dao.PokemonDAO;
import com.example.pokeapppro.database.entity.PokemonDB;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {PokemonDB.class}, version = 1, exportSchema = false)
public abstract class PokemonRoomDataBase extends RoomDatabase {
    public abstract PokemonDAO pokemonDAO();

    private static volatile PokemonRoomDataBase INSTANCE;
    public static final ExecutorService appDatabaseWriteExecutor = Executors.newFixedThreadPool(4);
    public static PokemonRoomDataBase getDatabase(Context context){
        if (INSTANCE == null){
            synchronized (PokemonRoomDataBase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context, PokemonRoomDataBase.class, "pokemonDatabase").build();
                }
            }
        }
        return INSTANCE;
    }



}
