package com.example.waagrechterwurf.datenbank;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
// Version nachfragen, muss man da auf was achten
@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserRoomDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();

    private static UserRoomDatabase INSTANCE;

    static UserRoomDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    UserRoomDatabase.class, "user_database")
                    .build();
        }
        return INSTANCE;
    }
}
