/**
 * Author: Vaughn Rowse
 * Assignment 3
 *
 * Code from repository
 */

package com.example.recycle_view;

public class Recipe {
    public Recipe(String name, String description, String image, String ingredients, String directions) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public String name;
    public String description;
    public String image;
    public String ingredients;
    public String directions;
}