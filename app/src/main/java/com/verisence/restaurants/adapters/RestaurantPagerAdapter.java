package com.verisence.restaurants.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.verisence.restaurants.models.Business;
import com.verisence.restaurants.ui.RestaurantDetailFragment;

import java.util.List;

public class RestaurantPagerAdapter extends FragmentPagerAdapter {
    private List<Business> mRestaurants;

    public RestaurantPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Business> restaurants) {
        super(fm, behavior);
        mRestaurants = restaurants;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return RestaurantDetailFragment.newInstance(mRestaurants.get(position));
    }

    @Override
    public int getCount() {
        return mRestaurants.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mRestaurants.get(position).getName();
    }
}
