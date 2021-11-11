package com.example.ecommerceairlift;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ecommerceairlift.models.Product;
import com.example.ecommerceairlift.services.ProductService;
import com.example.ecommerceairlift.utils.RetrofitInstance;
import com.example.ecommerceairlift.Adapters.CustomProductAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    ProductService service;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    CustomProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = RetrofitInstance.getRetrofit().create(ProductService.class);
        progressDialog = new ProgressDialog(MainActivity.this);
        callPost();
    }
    public void callPost(){
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        Call<List<Product>> call = service.getProducts();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<Product> products) {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new CustomProductAdapter(products);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}