package example.ke.recipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;

//File: DetailActivity.java
//Authr: KwangEun Oh
//Date: Mar. 24, 2019
//Type: Assignment3

public class DetailActivity extends AppCompatActivity {

    private ImageView mImg;
    private TextView mHeading, mIngredient, mDirection;

    private LinkedList<Recipe> mRecipes;

    /**
     * Generate specified information when opening the activity_detail view.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Initialize all TextViews and ImageView.
        mImg = findViewById(R.id.image_view);
        mHeading = findViewById(R.id.article_heading);
        mIngredient = findViewById(R.id.Ingredient);
        mDirection = findViewById(R.id.Direction);

        // Instantiate the intent to receive the call from the Main Activity.
        Intent intent = getIntent();
        // Get the position of the card Item from the Intent Extra.
        int position = intent.getIntExtra(RecipeAdapter.EXTRA_MESSAGE, 0);

        // Initialize the list of recipes.
        mRecipes = DataProvider.recipes;
        // Get the specific recipe sent by the Main Activity.
        Recipe recipe = mRecipes.get(position);

        // Get the image of the recipe by using Picasso Library.
        Picasso.get().load(recipe.image).fit().placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background).into(mImg);

        // Set the heading, ingredients, direction of the recipe to those TextViews.
        mHeading.setText(recipe.name);
        mIngredient.setText(recipe.ingredients);
        mDirection.setText(recipe.directions);
    }
}
