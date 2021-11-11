package com.example.ecommerceairlift.Adapters;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceairlift.DetailedProductActivity;
import com.example.ecommerceairlift.R;
import com.example.ecommerceairlift.models.Product;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomProductAdapter extends RecyclerView.Adapter<CustomProductAdapter.ViewHolder> {
    private List<Product> dataSet;

    public CustomProductAdapter(List<Product> dataset) {
        this.dataSet = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(dataSet.get(position).getTitle());
        Picasso.get().load(dataSet.get(position).getImage()).into(holder.getImageView());
        holder.getProductAmountView().setText("$"+Float.toString(dataSet.get(position).getPrice()));
        holder.getRatingBarView().setRating(dataSet.get(position).getRating().getRate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailedProductActivity.class);
                intent.putExtra("Product",dataSet.get(holder.getAdapterPosition()));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final Context context;
        private final TextView textView;
        private final ImageView imageView;
        private final TextView productAmount;
        private final RatingBar productRatingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            textView = itemView.findViewById(R.id.productName);
            imageView = itemView.findViewById(R.id.imageView);
            productAmount = itemView.findViewById(R.id.productAmount);
            productRatingBar = itemView.findViewById(R.id.ratingBar);
        }
        public TextView getTextView(){
            return textView;
        }
        public ImageView getImageView(){
            return imageView;
        }
        public TextView getProductAmountView(){
            return productAmount;
        }
        public RatingBar getRatingBarView(){
            return productRatingBar;
        }

    }
}
