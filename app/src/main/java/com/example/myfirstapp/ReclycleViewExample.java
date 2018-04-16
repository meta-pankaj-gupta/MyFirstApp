package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.content.res.Configuration;

import  com.example.myfirstapp.RecyclerViewHorizontalListAdapter;
import com.example.myfirstapp.model.Grocery;

import java.util.ArrayList;
import java.util.List;

public class ReclycleViewExample extends AppCompatActivity {
    private List<Grocery> groceryList = new ArrayList<>();
    private RecyclerView groceryRecyclerView;
    private RecyclerViewHorizontalListAdapter groceryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclycle_view_example);

        groceryRecyclerView = findViewById(R.id.idRecyclerViewHorizontalList);
        // add a divider after each item for more clarity
        groceryRecyclerView.addItemDecoration(new DividerItemDecoration(ReclycleViewExample.this, LinearLayoutManager.VERTICAL));
        groceryAdapter = new RecyclerViewHorizontalListAdapter(groceryList, getApplicationContext());
      //     groceryRecyclerView.setLayoutManager(verticalLayoutManager);


        Configuration orientation = new Configuration();
        if(groceryRecyclerView.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(ReclycleViewExample.this, LinearLayoutManager.VERTICAL, false);
            groceryRecyclerView.setLayoutManager(verticalLayoutManager);
        } else if (groceryRecyclerView.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            groceryRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        }
        groceryRecyclerView.setAdapter(groceryAdapter);
        populategroceryList();
    }

    private void populategroceryList(){
        Grocery potato = new Grocery("Shoes", R.drawable.shoes);
        Grocery onion = new Grocery("Laptop", R.drawable.laptop);
        Grocery cabbage = new Grocery("Watches", R.drawable.watches);
        Grocery cauliflower = new Grocery("Cream", R.drawable.cream);
        Grocery mobile = new Grocery("Mobile", R.drawable.mobile);
        Grocery camera = new Grocery("Camera", R.drawable.camera);
        Grocery speaker = new Grocery("Speaker", R.drawable.speaker);
        Grocery deo = new Grocery("Deo", R.drawable.deo);
        Grocery bolt = new Grocery("Bolt", R.drawable.bolt);
        Grocery alarm = new Grocery("Alarm", R.drawable.alarm);
        groceryList.add(potato);
        groceryList.add(onion);
        groceryList.add(cabbage);
        groceryList.add(cauliflower);
        groceryList.add(mobile);
        groceryList.add(camera);
        groceryList.add(speaker);
        groceryList.add(deo);
        groceryList.add(bolt);
        groceryList.add(alarm);
        groceryAdapter.notifyDataSetChanged();
    }
}
