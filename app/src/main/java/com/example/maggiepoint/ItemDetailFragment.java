package com.example.maggiepoint;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ItemDetailFragment extends Fragment {

    private ImageView itemImage;
    private TextView itemName;
    private TextView itemPrice;
    private Button placeOrderButton;

    private static final String TAG = "ItemDetailFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);

        itemImage = view.findViewById(R.id.itemImage);
        itemName = view.findViewById(R.id.itemName);
        itemPrice = view.findViewById(R.id.itemPrice);
        placeOrderButton = view.findViewById(R.id.placeOrderButton);

        // Get arguments passed to the fragment
        if (getArguments() != null) {
            int imageResId = getArguments().getInt("imageResId");
            String name = getArguments().getString("name");
            String price = getArguments().getString("price");

            // Set data to views
            itemImage.setImageResource(imageResId);
            itemName.setText(name);
            itemPrice.setText(price);
        }

        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String phoneNumberWithCountryCode = "+919065682814";  // Indian number with country code
                String name = itemName.getText().toString();
                String price = itemPrice.getText().toString();
                String message = "I would like to place an order for " + name + " priced at " + price;
                Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumberWithCountryCode + "&text=" + Uri.encode(message));
                Intent sendIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(sendIntent);
            }
        });

        return view;
    }
}
