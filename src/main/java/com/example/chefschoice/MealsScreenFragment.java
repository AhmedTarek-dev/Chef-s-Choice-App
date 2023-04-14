package com.example.chefschoice;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgs;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chefschoice.databinding.FragmentMealsScreenBinding;

import java.util.ArrayList;


public class MealsScreenFragment extends Fragment implements MealCallback, NavArgs/*, ClickOnFavInterface */{

Category category;
MealsScreenFragmentArgs args;
private FragmentMealsScreenBinding binding;

@Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    args = MealsScreenFragmentArgs.fromBundle(getArguments());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragviewMeals=inflater.inflate(R.layout.fragment_meals_screen, container, false);
        binding=FragmentMealsScreenBinding.bind(fragviewMeals);

        AppController appController = new AppController(MealsScreenFragment.this);
        appController.getAllMeal(args.getMealname());/////////here

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void getAllMeals(ArrayList<Meal> meals) {
        MealsAdapter adapter = new MealsAdapter(getActivity(), meals);
        binding.mealsRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        binding.mealsRecycler.setAdapter(adapter);


    }

   /* @Override
    public void addToFavorite(Meal mealfav) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                LocalBuilder localBuilder = LocalBuilder.getInstance(getActivity());
                localBuilder.mealDao().insertLeague(mealfav);
            }
        }).start();
    }*/
}

