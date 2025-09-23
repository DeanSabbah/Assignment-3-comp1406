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

    public void addToCart(Product p) throws IndexOutOfBoundsException{
        if(p.getOnShelf() > 0){
            p.addToCart();
            p.updateAnys();
        }
        else{
            throw new IndexOutOfBoundsException("No items left on shelf");
        }
    }

    public void removeFromCart(Product p) throws IndexOutOfBoundsException{
        if(p.getInCart() > 0){
            p.removeFromCart();
            p.updateAnys();
        }
        else{
            throw new IndexOutOfBoundsException("No items left in cart");
        }
    }

    public void sellProduct(Product p){
        double transaction =  p.sellUnits(p.getInCart());
        if(transaction == -1) return;
        revenue += transaction;
        sales++;
        p.updateAnys();
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