package com.verisence.restaurants.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RestaurantsArrayAdapter extends ArrayAdapter {

    private Context mContext;
    private String[] mRestaurants;
    private String[] mCuisines;

    public RestaurantsArrayAdapter(Context mContext, int resource, String[] mRestaurants, String[] mCuisines) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mRestaurants = mRestaurants;
        this.mCuisines = mCuisines;
    }

    @Override
    public int getCount() {
        return mRestaurants.length;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        String restaurant = mRestaurants[position];
        String cuisine = mCuisines[position];
        return String.format("%s, \nServes great: %s", restaurant, cuisine);
    }
}
