package com.example.ali.a7cook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.android.volley.Response;
import com.example.ali.a7cook.adapters.BannerAdapter;
import com.example.ali.a7cook.adapters.CategoryAdapter;
import com.example.ali.a7cook.adapters.RecipeAdapter;
import com.example.ali.a7cook.data.Banner;
import com.example.ali.a7cook.data.Category;
import com.example.ali.a7cook.data.Recipe;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiService = new ApiService(this);
        setupViews();
    }

    private void setupViews() {
        getBanners();
      // getCategories();
      // getRecipes();
    }

    private void getBanners()
    {
        apiService.getBanners(new Response.Listener<List<Banner>>() {
            @Override
            public void onResponse(List<Banner> banners) {
                RecyclerView bannerRv = findViewById(R.id.rv_main_slider);
                bannerRv.setNestedScrollingEnabled(false);
                bannerRv.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                bannerRv.setAdapter(new BannerAdapter(banners));
                SnapHelper snapHelper = new PagerSnapHelper();
                snapHelper.attachToRecyclerView(bannerRv);
                //issue is fixed
            }
        });
    }
    private void getCategories()
    {
        apiService.getCategories(new Response.Listener<List<Category>>() {
            @Override
            public void onResponse(List<Category> categories) {
                RecyclerView categoryRv = findViewById(R.id.rv_main_category);
                categoryRv.setNestedScrollingEnabled(false);
                categoryRv.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                categoryRv.setAdapter(new CategoryAdapter(categories));
            }
        });
    }
    private void getRecipes()
    {
        apiService.getRecipes(new Response.Listener<List<Recipe>>() {
            @Override
            public void onResponse(List<Recipe> recipes) {
                RecyclerView recipeRv = findViewById(R.id.rv_main_recipe);
                recipeRv.setNestedScrollingEnabled(false);
                recipeRv.setLayoutManager(new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL));
                recipeRv.setAdapter(new RecipeAdapter(recipes));
                //
            }
        });
    }

}
