package com.example.ali.a7cook.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.ali.a7cook.R;
import com.example.ali.a7cook.data.Recipe;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {
    private List<Recipe> recipes;

    public RecipeAdapter(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe,parent,false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        holder.bindRecipe(recipes.get(position));
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        private ImageView recipeIv;
        private TextView titleTv;
        private TextView authorTv;
        private TextView descTv;
        private RatingBar recipeRb;
        public RecipeViewHolder(View itemView) {
            super(itemView);
            recipeIv = itemView.findViewById(R.id.iv_recipe);
            titleTv = itemView.findViewById(R.id.tv_recipe_title);
            authorTv = itemView.findViewById(R.id.tv_recipe_author);
            descTv = itemView.findViewById(R.id.tv_recipe_desc);
            recipeRb = itemView.findViewById(R.id.rb_recipe);
        }
        public void bindRecipe(Recipe recipe)
        {
            Picasso.get().load(recipe.getImg()).into(recipeIv);
            descTv.setText(recipe.getDesc());
            titleTv.setText(recipe.getTitle());
            authorTv.setText("By " + recipe.getBy());
            recipeRb.setRating(recipe.getRate());

        }
    }
}
