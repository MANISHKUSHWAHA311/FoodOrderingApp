package com.example.food_ordering_app_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.food_ordering_app_project.databinding.ActivityDetailedBinding;

public class Detailed_Activity extends AppCompatActivity {
    ActivityDetailedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailedBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_detailed);
         final DbHelper dbHelper = new DbHelper(this);

        if(getIntent().getIntExtra("type",0)==1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            String name = getIntent().getStringExtra("name");
            String description = getIntent().getStringExtra("desc");

            binding.detailedImage.setImageResource(image);
            binding.pricelbl.setText(String.format("%d", price));
            binding.nameBox.setText(name);
            binding.detailedDescription.setText(description);


            binding.insertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isInserted = dbHelper.insertOrder(binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            image,
                            description,
                            name,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );
                    if (isInserted) {
                        Toast.makeText(Detailed_Activity.this, "Data Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Detailed_Activity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else{
            int id=getIntent().getIntExtra("id",0);
            Cursor cursor=dbHelper.getOrderById(id);
            int image =cursor.getInt(4);
            binding.detailedImage.setImageResource(image);
            binding.pricelbl.setText(String.format("%d", cursor.getInt(3)));
            binding.nameBox.setText(cursor.getString(6));
            binding.detailedDescription.setText(cursor.getString(5));

            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.insertButton.setText("Update now");
            binding.insertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public  void onClick(View view) {

                    boolean isUpdate= DbHelper.updateOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            Integer.parseInt(binding.pricelbl.getText().toString()),
                            image,
                            binding.detailedDescription.getText().toString(),
                            binding.nameLbl.getText().toString(),
                            1,
                            id
                            );
                    if(isUpdate){
                        Toast.makeText(Detailed_Activity.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Detailed_Activity.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}