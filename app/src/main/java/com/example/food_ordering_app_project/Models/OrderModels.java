package com.example.food_ordering_app_project.Models;

public class OrderModels {
    int orderImage;
    String soldItemName,price,orderName;

    public OrderModels(int orderImage, String soldItemName, String price, String orderName) {
        this.orderImage = orderImage;
        this.soldItemName = soldItemName;
        this.price = price;
        this.orderName = orderName;


    }

    public OrderModels() {

    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSoldItemName() {
        return soldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

   

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }



    public String getPrices() {
        return null;
    }
}
