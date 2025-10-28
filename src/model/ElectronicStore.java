package model;

import java.util.ArrayList;
import java.util.List;


public class ElectronicStore {
    String name;
    private final int MAX_PRODUCTS        = 10;
    private List<Product> products        = new ArrayList<>(MAX_PRODUCTS);
    
    private int sales      = 0;
    private double revenue = 0;
    

    public ElectronicStore(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    void addProduct(Product p){
        if (products.size() < MAX_PRODUCTS){
            products.add(p);
            for (Product product : products) {
                product.setOnShelf(product.getStock());
            }
        }
    }

    public void addToCart(Product p){
        p.addToCart();
    }

    public void removeFromCart(Product p){
        p.removeFromCart();
    }

    public void sellProduct(Product[] products){
        for(Product p : products){
            double transaction =  p.sellUnits(p.getInCart());
            if(transaction == -1) return;
            revenue += transaction;
        }
        sales++;
    }

    public double getRevenue() {
        return revenue;
    }

    public List<Product> getProducts(){
        return products;
    }

    public int getSales() {
        return sales;
    }
}