/**
 * Author: Vaughn Rowse
 * Assignment 3
 *
 * Shows the full recipe
 */
package com.example.recycle_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = getIntent();

        // Make sure there is an intent
        if (intent != null) {
            Bundle extras = intent.getExtras();

            // Make sure there is an extra present
            if (extras != null) {
                TextView title = findViewById(R.id.title);
                title.setText(extras.getString("name"));

                ImageView image = findViewById(R.id.image);

                // From code snippet in READ.ME
                Picasso.get().load(extras.getString("image"))
                        .fit()
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(image);

                // Sets the text for the ingredients
                TextView ingredients = findViewById(R.id.ingredients);
                ingredients.setText(extras.getString("ingredients"));

                // Sets the text for the directions
                TextView directions = findViewById(R.id.directions);
                directions.setText(extras.getString("directions"));
            }
        }
    }
}
