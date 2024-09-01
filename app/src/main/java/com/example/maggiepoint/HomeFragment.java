package com.example.maggiepoint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private FoodItemAdapter adapter;
    private List<FoodItem> foodItemList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2)); // 2 columns

        foodItemList = new ArrayList<>();
        foodItemList.add(new FoodItem(R.drawable.maggie, "Veg Maggie", "₹35"));
        foodItemList.add(new FoodItem(R.drawable.sandwich, "Sandwich", "₹40"));
        foodItemList.add(new FoodItem(R.drawable.bread_omelette, "Bread omelette", "₹50"));
        foodItemList.add(new FoodItem(R.drawable.french_fries, "French Fries", "₹60"));
        foodItemList.add(new FoodItem(R.drawable.iced_tea, "Iced Tea", "₹30"));
        foodItemList.add(new FoodItem(R.drawable.chicken_frankie, "Chicken Frankie", "₹70"));
        foodItemList.add(new FoodItem(R.drawable.oreo_milkshake, "Oreo Milkshake", "₹60"));
        foodItemList.add(new FoodItem(R.drawable.tea, "Tea", "₹20"));
        foodItemList.add(new FoodItem(R.drawable.pineapple_juice, "Pineapple Juice", "₹40"));
        foodItemList.add(new FoodItem(R.drawable.chicken_burger, "Chicken Burger", "₹70"));
        foodItemList.add(new FoodItem(R.drawable.veg_burger, "Veg Burger", "₹50"));
        foodItemList.add(new FoodItem(R.drawable.chicken_maggie, "Chicken Maggie", "₹65"));
        foodItemList.add(new FoodItem(R.drawable.egg_maggie, "Egg Maggie", "₹55"));
        foodItemList.add(new FoodItem(R.drawable.fruit_salad, "Fruit Salad", "₹45"));
        foodItemList.add(new FoodItem(R.drawable.mausambi_juice, "Mausambi Juice", "₹40"));
        foodItemList.add(new FoodItem(R.drawable.muskmelon_juice, "Muskmelon Juice", "₹40"));
        foodItemList.add(new FoodItem(R.drawable.watermelon_juice, "Watermelon Juice", "₹40"));
        // Add more items as needed

        adapter = new FoodItemAdapter(foodItemList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(foodItem -> {
            Bundle bundle = new Bundle();
            bundle.putInt("imageResId", foodItem.getImageResourceId());
            bundle.putString("name", foodItem.getName());
            bundle.putString("price", foodItem.getPrice());

            ItemDetailFragment itemDetailFragment = new ItemDetailFragment();
            itemDetailFragment.setArguments(bundle);

            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, itemDetailFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });

        return view;
    }
}
