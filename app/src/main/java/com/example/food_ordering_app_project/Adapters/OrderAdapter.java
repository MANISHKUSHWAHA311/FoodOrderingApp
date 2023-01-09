package com.example.food_ordering_app_project.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_ordering_app_project.DbHelper;
import com.example.food_ordering_app_project.Detailed_Activity;
import com.example.food_ordering_app_project.Models.OrderModels;
import com.example.food_ordering_app_project.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder> {

    ArrayList<OrderModels>list;
    Context context;

    public OrderAdapter(ArrayList<OrderModels> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final OrderModels orderModels=list.get(position);
        holder.orderImage.setImageResource(orderModels.getOrderImage());
        holder.soldItemName.setText(orderModels.getSoldItemName());
        holder.price.setText(orderModels.getPrices());
        holder.orderName.setText(orderModels.getOrderName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Detailed_Activity.class);
                intent.putExtra("id",Integer.parseInt(orderModels.getOrderName()));
                intent.putExtra("type",2);
                context.startActivity(intent);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                DbHelper dbHelper=new DbHelper(context);
                if(dbHelper.deleteOrder(orderModels.getOrderName())>0){
                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView orderImage;
        TextView soldItemName,price,orderName;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderImage=itemView.findViewById(R.id.orderimage);
            soldItemName=itemView.findViewById(R.id.orderitemname);
            price=itemView.findViewById(R.id.order);
            orderName=itemView.findViewById(R.id.orderNumber);
        }
    }
}
