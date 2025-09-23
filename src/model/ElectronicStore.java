package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ElectronicStore {
    String name;
    private final int MAX_PRODUCTS = 10;
    double revenue = 0;
    private List<Product> products = new ArrayList<>(MAX_PRODUCTS);
    private List<Product> soldProducts = new ArrayList<>(MAX_PRODUCTS);    
    private List<Product> popularProducts = new ArrayList<>(3);
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
            soldProducts.add(p);
            for (Product product : products) {
                product.onShelf = product.stock;
            }
            if(popularProducts.size() < 3){
                popularProducts.add(p);
            }
        }
    }

    public void addToCart(Product p) throws IndexOutOfBoundsException{
        if(p.getOnShelf() > 0){
            p.inCart++;
            p.onShelf--;
            p.updateAnys();
        }
        else{
            throw new IndexOutOfBoundsException("No items left on shelf");
        }
    }

    public void removeFromCart(Product p) throws IndexOutOfBoundsException{
        if(p.getInCart() > 0){
            p.inCart--;
            p.onShelf++;
            p.updateAnys();
        }
        else{
            throw new IndexOutOfBoundsException("No items left in cart");
        }
    }

    public void sellProduct(Product p){
        double transaction =  p.sellUnits(p.getInCart());
        if(transaction == -1) return;
        sales += p.getInCart();
        revenue += transaction;
    }

    public double getRevenue() {
        return revenue;
    }

    public List<Product> getProducts(){
        return products;
    }

    public List<Product> getPopularProducts(){
        Collections.sort(soldProducts);
        for(int i = 0; i < 3;i++){
            popularProducts.set(i, soldProducts.get(i));
        }
        return popularProducts;
    }
}