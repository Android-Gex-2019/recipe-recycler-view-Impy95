/**
 * Author: Vaughn Rowse
 * Assignment 3
 *
 * Activity for the main activity screen with recycle view
 */
package com.example.recycle_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecipeList list;
    private LinkedList<Recipe> recipes = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load Recipes
        recipes = DataProvider.getRecipes();

        // Locate the recycle view
        recyclerView = findViewById(R.id.recyclerview);

        // Create the list adapter
        list = new RecipeList(this, recipes);

        // Set up the recycle view
        recyclerView.setAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
