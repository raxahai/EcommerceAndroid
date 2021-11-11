package com.example.ecommerceairlift.services;

import com.example.ecommerceairlift.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET("/products")
    Call<List<Product>> getProducts();
}
