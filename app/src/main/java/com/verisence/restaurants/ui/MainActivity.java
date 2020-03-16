package com.verisence.restaurants.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.verisence.restaurants.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.searchBtn) Button searchBtn;
    @BindView(R.id.searchTxt)
    EditText searchTxt;
    String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        searchBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==searchBtn){
            Intent intent = new Intent(this, RestaurantsActivity.class);
            location = searchTxt.getText().toString();
            intent.putExtra("LOCATION_EXTRA", location);
            startActivity(intent);
        }
    }
}
