
package model;

import javafx.beans.property.SimpleBooleanProperty;

public abstract class Product implements Comparable<Product>{
    protected double price;
    protected int stock;
    protected int onShelf;
    protected int inCart;
    protected int sold;
    private SimpleBooleanProperty anyInCart;
    private SimpleBooleanProperty anyOnShelf;

    public Product(double price, int stock, int sold){
        this.price = price;
        this.stock = stock;
        this.sold = sold;
        this.anyInCart = new SimpleBooleanProperty(false);
        this.anyOnShelf = new SimpleBooleanProperty(true);
    }

    public int getOnShelf(){
        return onShelf;
    }

    public void addToCart(){
        if(onShelf > 0){
            inCart++;
            onShelf--;
        }
        else throw new IndexOutOfBoundsException("No items in stock");
    }

    public void removeFromCart(){
        if(inCart > 0){
            inCart--;
            onShelf++;
        }
        else throw new IndexOutOfBoundsException("No items in the cart");
    }

    public void setOnShelf(int onShelf){
        this.onShelf = onShelf;
    }

    public int getInCart(){
        return inCart;
    }

    public void setInCart(int inCart){
        this.inCart = inCart;
    }
    
    public int amountSold(){
        return sold;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice(){
        return price;
    }

    public void updateAnys(){
        anyInCart.set(inCart > 0);
        anyOnShelf.set(onShelf > 0);
    }

    public SimpleBooleanProperty anyInCart(){
        return anyInCart;
    }

    public SimpleBooleanProperty anyOnShelf(){
        return anyOnShelf;
    }

    public double sellUnits(int amount){
        if (amount <= stock && amount > 0){
            stock -= amount;
            sold += amount;
            inCart = 0;
            return price*amount;
        }
        else{
            return -1.0;
        }
    }

    public int compareTo(Product o) {
        return o.amountSold() - this.amountSold();
    }
}