package com.mszgajewski.mojezadania.database;

import android.content.Context;
import android.graphics.Color;

import androidx.room.Room;

import com.mszgajewski.mojezadania.activity.MainActivity;

public class DatabaseClient {

    private Context mCtx;
    private static DatabaseClient mInstance;
    private AppDatabase appDatabase;

    private DatabaseClient(Context mCtx){
        this.mCtx = mCtx;
        appDatabase = Room.databaseBuilder(mCtx,AppDatabase.class, "Task.db")
                .fallbackToDestructiveMigration()
                .build();
    }
    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(mCtx);
        }
        return  mInstance;
    }

    public AppDatabase getAppDatabase(){
        return appDatabase;
    }
}
