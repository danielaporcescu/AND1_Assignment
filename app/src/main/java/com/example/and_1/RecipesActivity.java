package com.example.and_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecipesActivity extends AppCompatActivity {

    private RecyclerView topics;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        ArrayList<Topic> topics = initTopics();

        this.topics = findViewById(R.id.topics);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        this.topics.setLayoutManager(mLayoutManager);

        adapter = new TopicAdapter(topics);
        this.topics.setAdapter(adapter);
    }

    private ArrayList<Topic> initTopics() {
        ArrayList<Topic> list = new ArrayList<>();

        list.add(new Topic("Tiramisu", "https://images.unsplash.com/photo-1511282964533-7f0c3c1f555a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80" , "eggs\n" +
                "mascarpone\n" +
                "espresso\n" +
                "ladyfingers\n" +
                "a touch of sugar\n" +
                "a touch of alcohol (I like amaretto or spiced rum)\n" +
                "…and a dusting of cocoa powder on top"));
        list.add(new Topic("CheeseCake", "https://images.unsplash.com/photo-1524351199678-941a58a3df50?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1051&q=80", "Crust\n" +
                "1 3/4 cups Graham Cracker Crumbs (about 15 full crackers)\n" +
                "1/3 cup butter, melted\n" +
                "1/4 cup granulated sugar\n" +
                "1/2 teaspoon kosher salt\n" +
                "Cheesecake\n" +
                "4 (8 ounce) packages Cream Cheese, room temperature\n" +
                "1 cup granulated sugar\n" +
                "1/2 cup sour cream, room temperature\n" +
                "2 teaspoons vanilla\n" +
                "3 eggs, room temperature"));
        list.add(new Topic("Ice Cream", "https://images.unsplash.com/photo-1515037028865-0a2a82603f7c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1021&q=80", "3/4 cup white sugar1\n" +
                "1 cup heavy whipping cream\n" +
                "2 1/4 cups milk \n" +
                "2 teaspoons vanilla extract" ));
        list.add(new Topic("Roast Beef", "https://images.unsplash.com/photo-1486172290186-a633e90efd68?ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80", "3 to 3 1/2 lbs (1.3 to 1.6 kg) of Boneless Rump Roast (pick an end cut with a layer of fat if you can)\n" +
                "1 Tbsp olive oil\n" +
                "8-10 slivers of garlic (3 to 4 cloves, sliced in half or into thirds)\n" +
                "Salt and pepper"));
        list.add(new Topic("Olivye Salad", "https://images.unsplash.com/photo-1543339308-43e59d6b73a6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80", "6 potatoes, peeled\n" +
                "1 carrot, or more to taste\n"+
                "4 eggs\n"+
                "6 large pickles, cut into cubes\n"+
                "1 (15 ounce) can peas, drained\n"+
                "1/2 cup cubed fully cooked ham, or to taste\n"+
                "1 tablespoon chopped fresh parsley, or to taste (optional)\n"+
                "1/2 cup mayonnaise, or to taste"));

        return list;
    }


}
