package com.example.chefschoice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chefschoice.databinding.FragmentDetailsScreenBinding;
import com.example.chefschoice.databinding.FragmentFavoriteScreenBinding;

import java.util.ArrayList;
import java.util.List;


public class FavoriteScreenFragment extends Fragment {
    LocalBuilder database;
FragmentFavoriteScreenBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View favfrag=inflater.inflate(R.layout.fragment_favorite_screen, container, false);
        binding= FragmentFavoriteScreenBinding.bind(favfrag);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Thread(new Runnable() {
            @Override
            public void run() {
                LocalBuilder builder = LocalBuilder.getInstance(getContext());
               List<Meal> list = builder.mealDao().getAll();
               MealsAdapter adapter = new MealsAdapter(getActivity(), (ArrayList<Meal>) list);


                // to access views in main thread from background thread we need to this function

                getActivity().runOnUiThread(new Runnable() {
                   @Override
                    public void run() {

                        binding.mealsRecyclersaved.setLayoutManager(new LinearLayoutManager(getActivity()));
                       binding.mealsRecyclersaved.setAdapter(adapter);
                    }
                });
           }
        }).start();

    }
}