package com.example.chefschoice;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//@Database(entities = Meal.class, version = 1)
public abstract class LocalBuilder extends RoomDatabase{

    private static LocalBuilder dbInstance;

    public abstract MealDao mealDao();

    public static LocalBuilder getInstance(Context context) {

        if(dbInstance == null) {
            dbInstance = Room.databaseBuilder(context.getApplicationContext(),
                    LocalBuilder.class, "mealfavDB").build();
        }
        return dbInstance;
    }
}





