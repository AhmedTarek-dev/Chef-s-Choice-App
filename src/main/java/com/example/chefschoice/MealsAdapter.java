package com.example.chefschoice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.ViewHolder> {

    private ArrayList<Meal> meals;
    private ClickOnFavInterface clickOnFavInterface;

    public MealsAdapter(ArrayList<Meal> meals, ClickOnFavInterface clickOnFavInterface) {
        this.meals = meals;
        this.clickOnFavInterface = clickOnFavInterface;
    }

    public MealsAdapter(ClickOnFavInterface clickOnFavInterface) {
        this.clickOnFavInterface = clickOnFavInterface;
    }

    public MealsAdapter(FragmentActivity activity, ArrayList<Meal> meals) {
        this.meals = meals;
    }

    @NonNull
    @Override
    public MealsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MealsAdapter.ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.meals_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MealsAdapter.ViewHolder holder, int position) {
Meal currentmeal= meals.get(position);

        holder.txtmealName.setText(currentmeal.strMeal);
        Glide.with(holder.imgMeal).load(currentmeal.strMealThumb).into(holder.imgMeal);

        holder.cardViewMeal.setOnClickListener(view ->  {///////////////////////

           Navigation.findNavController(view)
                   .navigate(MealsScreenFragmentDirections.actionMealsScreenFragmentToDetailsScreenFragment(currentmeal));

        });

    /*    holder.imgFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.imgFav.setImageResource(R.drawable.favoritecolor);
                clickOnFavInterface.addToFavorite(currentmeal);
            }
        });

    */



    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFav;
        CircleImageView imgMeal;
        TextView txtmealName;
        CardView cardViewMeal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMeal = itemView.findViewById(R.id.meal_logo);
            txtmealName = itemView.findViewById(R.id.txtMealName);
            imgFav = itemView.findViewById(R.id.imgFav);
            cardViewMeal = itemView.findViewById(R.id.cardView);
        }
    }
}
