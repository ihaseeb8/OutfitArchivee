package com.example.outfitarchivee.Classes;

public class OrderLine {
    int orderId;
    String productId;
    int quantity;
    double price;
    double total;

    public OrderLine() {
        this.orderId = 0;
        this.productId = "";
        this.quantity = 0;
        this.price = 0;
        this.total = 0;
    }

    public OrderLine(int orderId, String productId, int quantity, double bill , double total) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = bill;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
