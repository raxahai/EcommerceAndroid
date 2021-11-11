package com.example.ecommerceairlift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.ecommerceairlift.models.Product;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class DetailedProductActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView productTitle;
    private TextView productPrice;
    private RatingBar ratingBar;
    private TextView productsRemaining;
    private TextView productDescription;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detailed);

        product = fetchData();
        initializeViews();

        setDataIntoViews();
    }
    private void initializeViews(){
        imageView = findViewById(R.id.productImage);
        productTitle = findViewById(R.id.productTitle);
        productPrice = findViewById(R.id.productPrice);
        ratingBar = findViewById(R.id.ratingBarDetailedActivity);
        productsRemaining = findViewById(R.id.productsRemaining);
        productDescription = findViewById(R.id.productDescription);
        setScrolling();
    }
    private void setDataIntoViews(){
        Picasso.get().load(product.getImage()).into(imageView);
        productTitle.setText(product.getTitle());
        productPrice.setText("$"+Float.toString(product.getPrice()));
        ratingBar.setRating(product.getRating().getRate());
        productsRemaining.setText("Products remaining: "+Math.round(product.getRating().getCount()));
        productDescription.setText(product.getDescription());
    }
    private void setScrolling(){
        productDescription.setMovementMethod(new ScrollingMovementMethod());
    }
    private Product fetchData(){
        return (Product) getIntent().getSerializableExtra("Product");
    }
}