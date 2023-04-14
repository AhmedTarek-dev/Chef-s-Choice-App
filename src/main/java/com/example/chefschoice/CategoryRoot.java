package com.example.chefschoice;

import java.util.ArrayList;

public class CategoryRoot {
    public ArrayList<Category> categories;

    public CategoryRoot(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
}
