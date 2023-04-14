package com.example.chefschoice;

public class MealDetailRoot {  //id
    public Meal mealName;

    public MealDetailRoot(Meal mealName) {
        this.mealName = mealName;
    }

    public Meal getMealName() {
        return mealName;
    }

    public void setMealName(Meal mealName) {
        this.mealName = mealName;
    }
}
