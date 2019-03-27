package example.ke.recipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

//File: MainActivity.java
//Authr: KwangEun Oh
//Date: Mar. 24, 2019
//Type: Assignment3

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    /**
     * Populate the specific data when opening the activity_main.xml.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the recycler view.
        mRecyclerView = findViewById(R.id.recycler_view);
        // Instantiate the adapter that have the recipes of the list.
        RecipeAdapter adapter = new RecipeAdapter(this, DataProvider.recipes);
        // Connect the adapter with the view.
        mRecyclerView.setAdapter(adapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
