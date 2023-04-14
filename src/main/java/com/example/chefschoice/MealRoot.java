package com.example.chefschoice;

import java.util.ArrayList;

public class MealRoot {
    public ArrayList<Meal> meals;

    public MealRoot(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }
}
