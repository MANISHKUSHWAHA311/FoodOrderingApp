package com.example.food_ordering_app_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.food_ordering_app_project.Models.OrderModels;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    final static String DBName="myDatabase.db";
    final static int DBVersion = 2 ;
    private static Object SQLiteDatabase;


    public DbHelper(@Nullable Context context ) {
        super(context, DBName, null, DBVersion);
    }

    public static boolean updateOrder(String toString, String toString1, int parseInt, int image, String toString2, String toString3, int i, int id) {
        return false;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table orders"+"(id integer primary key autoincrement,"+"name text,"+"phone text,"+"price int,"+"quantity int,"
        +"image int,"+"description text,"+"foodname text)"
    );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists orders");
        onCreate(sqLiteDatabase);

    }
    public  boolean insertOrder(String name,String phone ,int price,int image,String desc ,String foodName,int quantity){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        contentValues.put("price",price);
        contentValues.put("image",image);
        contentValues.put("desc",desc);
        contentValues.put("foodName",foodName);
        contentValues.put("quantity",quantity);
        int id= (int) sqLiteDatabase.insert("orders",null,contentValues);

        if (id<=0){
            return false;
        }
        else{
            return true;
        }
    }
    public ArrayList<OrderModels>getOrders(){
        ArrayList<OrderModels>orderModels=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select id ,foodname,image ,price from orders",null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                OrderModels models=new OrderModels();
                models.setOrderName(cursor.getInt(0)+"");
                models.setSoldItemName(cursor.getString(1));
                models.setOrderImage(cursor.getInt(2));
                models.setPrice(cursor.getInt(3)+"");
                orderModels.add(models);
            }
        }
        cursor.close();
        sqLiteDatabase.close();
        return orderModels;
    }
    public Cursor getOrderById(int id){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from orders where id="+id,null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }
    public  boolean updateOrder(String name,String phone ,int price,int image,String desc ,String foodName,int quantity){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        contentValues.put("price",price);
        contentValues.put("image",image);
        contentValues.put("desc",desc);
        contentValues.put("foodName",foodName);
        contentValues.put("quantity",quantity);
        int row= (int) sqLiteDatabase.insert("orders",null,contentValues);

        if (row<=0){
            return false;
        }
        else{
            return true;
        }
    }
    public int deleteOrder(String id){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        return sqLiteDatabase.delete("orders","id="+id,null);
    }
}
