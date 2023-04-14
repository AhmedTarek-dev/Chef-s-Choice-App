package com.example.chefschoice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chefschoice.databinding.FragmentCategoryScreenBinding;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
private  MealCallback mealCallback;
    private ArrayList<Category> categories;


    public CategoryAdapter(ArrayList<Category> categories, CategoryScreenFragment categoryScreenFragment) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder( LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        Category currentCat = categories.get(position);

        Glide.with(holder.imgCat).load(currentCat.getStrCategoryThumb()).into(holder.imgCat);
        holder.txtNamecat.setText(currentCat.getStrCategory());
/////////////////////////////
        holder.cardView.setOnClickListener(view -> {
            Navigation.findNavController(view)
                    .navigate(CategoryScreenFragmentDirections
                            .actionCategoryScreenFragmentToMealsScreenFragment(currentCat.getStrCategory()));///should send name
        });


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imgCat;
        TextView txtNamecat;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCat = itemView.findViewById(R.id.category_logo);
            txtNamecat = itemView.findViewById(R.id.txtCategoryName);

            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
