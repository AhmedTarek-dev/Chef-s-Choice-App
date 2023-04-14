package com.example.chefschoice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.chefschoice.databinding.FragmentDetailsScreenBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public  class DetailsScreenFragment extends Fragment implements MealCallback {

   DetailsScreenFragmentArgs args;
private FragmentDetailsScreenBinding binding;


   // public  MealDetailcallback mealDetailcallback;
   // public ArrayList<Meal> Mealindex;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = DetailsScreenFragmentArgs.fromBundle(getArguments());

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View fragviewdetails=inflater.inflate(R.layout.fragment_details_screen, container, false);

        binding= FragmentDetailsScreenBinding.bind(fragviewdetails);

        //AppController appController = new AppController(DetailsScreenFragment.this);
        //appController.getMeal(args.getMeals().strMeal); //for mealdetail call or mealcall doesnot return array
       // appController.getAllMeal(args.getMeals().idMeal); // return the array





        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//Meal meals=Mealindex.get(Integer.parseInt(args.getMeals().idMeal));

        binding.country.setText(args.getMeals().idMeal);
        binding.category.setText(args.getMeals().strMeal);
        binding.instructions.setText(args.getMeals().strIngredient1);
        binding.ingredient.setText(args.getMeals().strIngredient3);

        Glide.with(binding.mealThumb).load(args.getMeals().strMealThumb)
                .centerCrop().into(binding.mealThumb);




        binding.youtube.setOnClickListener(view1 -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + args.getMeals().strYoutube));
            startActivity(browserIntent);
        });
        binding.source.setOnClickListener(view1 -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + args.getMeals().strSource));
            startActivity(browserIntent);
        });

    }


    @Override
    public void getAllMeals(ArrayList<Meal> meals) {

    }
}