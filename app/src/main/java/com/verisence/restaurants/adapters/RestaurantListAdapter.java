package com.verisence.restaurants.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.verisence.restaurants.R;
import com.verisence.restaurants.models.Business;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder> {

    private List<Business> mRestaurants;
    private Context mContext;

    public RestaurantListAdapter(Context context, List<Business> restaurants) {
        this.mContext = context;
        this.mRestaurants = restaurants;
    }

    @Override
    public RestaurantListAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_card, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        holder.bindRestaurant(mRestaurants.get(position));
    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }

    public class RestaurantViewHolder  extends RecyclerView.ViewHolder{
        @BindView(R.id.restaurantImage)
        ImageView mRestaurantImageView;
        @BindView(R.id.resName) TextView mNameTextView;
        @BindView(R.id.resCat) TextView mCatTextView;
        @BindView(R.id.resClosed) TextView mClosedTextView;
        @BindView(R.id.resRating)
        RatingBar mRatingBar;

        private Context mContext;

        public RestaurantViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindRestaurant(Business restaurant){
            //TODO
            // ADD SHIMMER TO RESTAURANTS
            mNameTextView.setText(restaurant.getName());
            mCatTextView.setText(restaurant.getCategories().get(0).getTitle());
            Boolean closed = restaurant.getIsClosed();
            String isClosed;
            Float rating = restaurant.getRating().floatValue();
            if(closed){
//                mClosedTextView.setTextColor(Color.red(200));
                //TODO
                // set isClosed color.
                isClosed= "Closed";
            }else{
//                mClosedTextView.setTextColor(Color.green(200));
                isClosed = "Open";
            }
            Picasso.get().load(restaurant.getImageUrl()).into(mRestaurantImageView);
            mClosedTextView.setText(isClosed);
            mRatingBar.setMax(5);
            mRatingBar.setStepSize(0.1f);
            mRatingBar.setRating(rating);

//            mRatingTextView.setText("Rating: "+restaurant.getRating()+"/5");
        }
    }
}
