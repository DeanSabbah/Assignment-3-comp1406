package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ElectronicStore {
    String name;
    private final int MAX_PRODUCTS        = 10;
    private List<Product> products        = new ArrayList<>(MAX_PRODUCTS);
    private List<Product> soldProducts    = new ArrayList<>(MAX_PRODUCTS);    
    private List<Product> popularProducts = new ArrayList<>(3);
    
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
            soldProducts.add(p);
            for (Product product : products) {
                product.setOnShelf(product.getStock());
            }
            if(popularProducts.size() < 3){
                popularProducts.add(p);
            }
        }
    }

    public void addToCart(Product p){
        p.addToCart();
        p.updateAnys();
    }

    public void removeFromCart(Product p){
        p.removeFromCart();
        p.updateAnys();        
    }

    public void sellProduct(Product[] products){
        for(Product p : products){
            double transaction =  p.sellUnits(p.getInCart());
            if(transaction == -1) return;
            revenue += transaction;
            p.updateAnys();
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

    public List<Product> getPopularProducts(){
        Collections.sort(soldProducts);
        for(int i = 0; i < 3;i++){
            popularProducts.set(i, soldProducts.get(i));
        }
        return popularProducts;
    }
}