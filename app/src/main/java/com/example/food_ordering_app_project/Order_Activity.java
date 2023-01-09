package com.example.food_ordering_app_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.food_ordering_app_project.Adapters.OrderAdapter;
import com.example.food_ordering_app_project.Models.OrderModels;
import com.example.food_ordering_app_project.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class Order_Activity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DbHelper dbHelper=new DbHelper(this);
        ArrayList<OrderModels>list= dbHelper.getOrders();


        OrderAdapter orderAdapter=new OrderAdapter(list,this);
        binding.orderRecyclerView.setAdapter(orderAdapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(linearLayoutManager);

    }
}