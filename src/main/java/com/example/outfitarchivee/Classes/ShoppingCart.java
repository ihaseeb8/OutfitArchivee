package com.example.outfitarchivee.Classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;

public class ShoppingCart {
    ObservableList<Product> items;

    private static ShoppingCart cart = new ShoppingCart();

    private ShoppingCart(){
        items = FXCollections.observableArrayList();
    }

    public static ShoppingCart getCart(){
        return cart;
    }

    public ShoppingCart(ObservableList<Product> items) {
        this.items = items;
    }

    public ObservableList<Product> getItems() {
        return items;
    }

    public void setItems(ObservableList<Product> items) {
        this.items = items;
    }

    public void addItem(Product item){
        this.items.add(item);
    }

    public void removeItem(Product item){
        this.items.remove(item);
    }

    public double getTotalBill(){
        double Sum = 0;

        for (Product tabPane : this.items){
            Sum += tabPane.price;
        }

        return Sum;
    }

    public void placeOrder(){

    }
}
