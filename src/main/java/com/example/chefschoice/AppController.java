package com.example.chefschoice;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppController {
private CategoryCallback categoryCallback;
private MealCallback mealCallback;
private  MealDetailcallback mealDetailcallback;

    public AppController(MealDetailcallback mealDetailcallback) {
        this.mealDetailcallback = mealDetailcallback;
    }

    public AppController(CategoryCallback categoryCallback) {
        this.categoryCallback = categoryCallback;
    }

    public AppController(MealCallback mealCallback) {
        this.mealCallback = mealCallback;
    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void getAllCategory() {
        ApiInterface apiInterface = getRetrofit().create(ApiInterface.class);
        Call<CategoryRoot> call = apiInterface.getAllCategory();
call.enqueue(new Callback<CategoryRoot>() {
    @Override
    public void onResponse(Call<CategoryRoot> call, Response<CategoryRoot> response) {
categoryCallback.getAllCategories(response.body().categories);
    }

    @Override
    public void onFailure(Call<CategoryRoot> call, Throwable t) {

    }
});

    }
    /////////////////////////Meals
public void getAllMeal(String mealname){
    ApiInterface apiInterface = getRetrofit().create(ApiInterface.class);
    Call<MealRoot> call = apiInterface.getAllMeal(mealname);
    call.enqueue(new Callback<MealRoot>() {
        @Override
        public void onResponse(Call<MealRoot> call, Response<MealRoot> response) {
            mealCallback.getAllMeals(response.body().meals);
        }

        @Override
        public void onFailure(Call<MealRoot> call, Throwable t) {

        }
    });

}
//mealdetail
    public void getMeal(String mealname){
       ApiInterface apiInterface = getRetrofit().create(ApiInterface.class);
        Call<MealDetailRoot> call = apiInterface.getmeal(mealname);
        call.enqueue(new Callback<MealDetailRoot>() {
            @Override
            public void onResponse(Call<MealDetailRoot> call, Response<MealDetailRoot> response) {

                mealDetailcallback.getMeals(response.body().getMealName());
            }

            @Override
            public void onFailure(Call<MealDetailRoot> call, Throwable t) {

}
       });

    }





}
