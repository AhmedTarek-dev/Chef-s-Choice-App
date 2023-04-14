package com.example.chefschoice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("categories.php")
    Call<CategoryRoot> getAllCategory();

    @GET("filter.php?c=")
    Call<MealRoot> getAllMeal(@Query("c") String strCategory);

@GET("lookup.php?i=")
    Call<MealDetailRoot> getmeal(@Query("i") String idMeal);
}
