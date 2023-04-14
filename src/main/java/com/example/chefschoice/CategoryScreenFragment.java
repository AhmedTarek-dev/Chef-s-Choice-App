package com.example.chefschoice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chefschoice.databinding.FragmentCategoryScreenBinding;
import com.example.chefschoice.databinding.FragmentProfileScreenBinding;

import java.util.ArrayList;


public class CategoryScreenFragment extends Fragment implements CategoryCallback {

private FragmentCategoryScreenBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragviewCategory=inflater.inflate(R.layout.fragment_category_screen, container, false);
        binding=FragmentCategoryScreenBinding.bind(fragviewCategory);
        AppController appController = new AppController(CategoryScreenFragment.this);
        appController.getAllCategory();
        // Inflate the layout for this fragment
        return binding.getRoot();

    }
    public  void getAllCategories(ArrayList<Category> categories){
        CategoryAdapter adaptercat = new CategoryAdapter(categories, CategoryScreenFragment.this);
        binding.recyclerCategory.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        binding.recyclerCategory.setAdapter(adaptercat);


    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }
}