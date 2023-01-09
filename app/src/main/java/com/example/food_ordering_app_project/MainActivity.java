package com.example.food_ordering_app_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.food_ordering_app_project.Adapters.MainAdapter;
import com.example.food_ordering_app_project.Models.MainModel;
import com.example.food_ordering_app_project.Models.OrderModels;
import com.example.food_ordering_app_project.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list= new ArrayList<>();
        list.add(new MainModel(R.drawable.hamburger,"Burger","100","Burger with Extra cheese"));
        list.add(new MainModel(R.drawable.pizza,"Pizza","150","pizza with garnis of capsicum"));
        list.add(new MainModel(R.drawable.frenchfriesmc,"French Fries","120","delicious fries"));
        list.add(new MainModel(R.drawable.frenchfrieswithcoke,"Burger","150","fries with pepsi coke"));
        list.add(new MainModel(R.drawable.idlisa,"Burger","80","idli with sambar and chatni"));
        list.add(new MainModel(R.drawable.biryani,"Burger","160","Hyderabadi chicken biryani"));
        list.add(new MainModel(R.drawable.butterchicken,"Burger","200","chicken with extra butter"));
        list.add(new MainModel(R.drawable.mangojuice,"Mango juice","100","chill with mango"));
        list.add(new MainModel(R.drawable.coldcoffee,"cold cofee","120","chill with cold coffee"));


        MainAdapter adapter=new MainAdapter(list ,this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, Order_Activity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}