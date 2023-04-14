package com.example.chefschoice;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLeague(Meal meala);
    @Query("SELECT strMeal,strMealThumb FROM mealtable")
    List<Meal> getAll();

}
