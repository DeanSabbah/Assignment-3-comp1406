package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElectronicStore {
    String name;
    private final int MAX_PRODUCTS = 10;
    double revenue = 0;
    public List<Product> products = new ArrayList<>(MAX_PRODUCTS);
    public List<Product> sortMe = new ArrayList<>(MAX_PRODUCTS);    
    public List<Product> sortedProducts = new ArrayList<>(3);
    public List<Product> cartList = new ArrayList<>(MAX_PRODUCTS);
    int sales = 0;
    

    public ElectronicStore(String name) {
    this.name = name;
    }

    public String getName(){
        return name;
    }

    void addProduct(Product p){
        if (products.size() < MAX_PRODUCTS){
            products.add(p);
            sortMe.add(p);
            for (Product product : products) {
                product.onShelf = product.stock;
            }
            if(sortedProducts.size() < 3){
                sortedProducts.add(p);
            }
        }
    }

    public void sellProducts(int item, int amount){
        Product cartItem = cartList.get(item);
        double transaction = cartItem.sellUnits(amount);
        if(transaction == -1.0){}
        else{
            revenue += transaction;
            sales += cartItem.sold;
            if(products.contains(cartItem)){
                Product productItem = products.get(products.indexOf(cartList.get(item)));
                productItem.sold = cartItem.sold;
                productItem.onShelf = cartItem.onShelf;
            }
            sortMe = products;
        }
    }

    public double getRevenue() {
        return revenue;
    }

    public List<Product> getPop(){
        Collections.sort(sortMe);
        for(int i = 0; i < sortMe.size();i++){
            if (i<3){
                sortedProducts.set(i, sortMe.get(i));
            }
        }
        return sortedProducts;
    }
}