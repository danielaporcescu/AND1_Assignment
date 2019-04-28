package com.example.and_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChoicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);
    }

    public void clickGroceryListButton(View view)
    {
        Intent intent=new Intent(this, GroceryListActivity.class);
        startActivity(intent);
    }

    public void clickRecipesButton(View view)
    {
        Intent intent=new Intent(this, RecipesActivity.class);
        startActivity(intent);
    }

    public void clickMapButton(View view)
    {
        Intent intent=new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
