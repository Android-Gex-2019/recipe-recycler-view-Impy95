/**
 * Author: Vaughn Rowse
 * Assignment 3
 *
 * Adapter for the recipe list
 */
package com.example.recycle_view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.LinkedList;

public class RecipeList extends RecyclerView.Adapter<RecipeList.RecipeView> {
    private LinkedList<Recipe> recipes;
    private LayoutInflater inflater;
    private Context context;

    /**
     * Constructor
     * @param context the activity being passed through
     * @param recipes the recipes being passed through
     */
    RecipeList(Context context, LinkedList<Recipe> recipes) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public RecipeList.RecipeView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = inflater.inflate(R.layout.recipe_item, viewGroup, false);
        return new RecipeView(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeList.RecipeView recipeViewHolders, int i) {
        Recipe currentRecipe = recipes.get(i);
        recipeViewHolders.itemTitle.setText(currentRecipe.name);
        recipeViewHolders.itemDesc.setText(currentRecipe.description);
    }

    /**
     * Gets the total amount of recipes
     * @return total amount of recipes
     */
    @Override
    public int getItemCount() {
        return recipes.size();
    }

    /**
     * Class for the Recipes view holder
     */
    class RecipeView extends RecyclerView.ViewHolder implements View.OnClickListener {

        final TextView itemTitle;
        final TextView itemDesc;
        final RecipeList list;

        RecipeView(View view, RecipeList list) {
            super(view);
            itemTitle = view.findViewById(R.id.item_title);
            itemDesc = view.findViewById(R.id.item_desc);
            this.list = list;
            view.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {
            Recipe recipe = recipes.get(getLayoutPosition());
            Intent intent = new Intent(context, RecipeActivity.class);

            intent.putExtra("name", recipe.name);
            intent.putExtra("description", recipe.description);
            intent.putExtra("image", recipe.image);
            intent.putExtra("ingredients", recipe.ingredients);
            intent.putExtra("directions", recipe.directions);

            context.startActivity(intent);
        }
    }
}
