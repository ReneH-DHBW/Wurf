package com.example.waagrechterwurf.datenbank;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(User user);

    @Query("SELECT * from User")
    public List<User> getAll();

    @Delete
    public void delete(User user);

}
