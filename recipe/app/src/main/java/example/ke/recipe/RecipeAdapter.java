package example.ke.recipe;

//File: RecipeAdapter.java
//Authr: KwangEun Oh
//Date: Mar. 24, 2019
//Type: Assignment3

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    public static final String EXTRA_MESSAGE =
            "com.example.ke.recipe.extra.Message";
    public static int position;

    private Context mContext;
    private LayoutInflater mInflater;
    private LinkedList<Recipe> mRecipes;

    /**
     * Adapter constructor initializes context, and recipes linked list.
     * @param context
     * @param recipes
     */
    public RecipeAdapter(Context context, LinkedList<Recipe> recipes){
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        this.mRecipes = recipes;
    }

    /**
     * Create the recyclerView holders
     * @param parent
     * @param i
     * @return
     */
    @NonNull
    @Override
    public RecipeAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mItemView = mInflater.inflate(R.layout.card_view, parent, false);

        return new RecipeViewHolder(mItemView, this);
    }

    /**
     * Bind the item views inside the card view from the data in DataProvider class.
     * @param recipeViewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int position) {
        Recipe recipe = mRecipes.get(position);

        recipeViewHolder.txtTitle.setText(recipe.name);
        recipeViewHolder.txtMain.setText(recipe.description);
    }

    /**
     * Get the size of recipes list.
     * @return
     */
    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    /**
     * Inner Class RecipeViewHolder holds the Card view and item views inside of the Card View.
     */
    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
           {

        public final TextView txtTitle;
        public final TextView txtMain;
        final RecipeAdapter mAdapter;


        /**
         * Constructor initializing the item views in the Card View.
         * @param itemView
         * @param adapter
         */
        public RecipeViewHolder(View itemView, RecipeAdapter adapter) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtMain = itemView.findViewById(R.id.txt_main);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        /**
         * Called when a view (each word) has been clicked.
         * @param v
         */
        @Override
        public void onClick(View v) {

            // Instantiate the intent to activate the DetailActivity.
            // It takes two arguments, Context and the class of DetailActivity.
            Intent intent = new Intent(mContext, DetailActivity.class);

            // Get the item of the position you clicked.
            position = getLayoutPosition();

            // Add the string to the Intent as an extra with EXTRA_MESSAGE constant as the key
            // and the int as the value
            intent.putExtra(EXTRA_MESSAGE, position);

            // Start to call the DetailActivity.
            mContext.startActivity(intent);
        }
    }
}
