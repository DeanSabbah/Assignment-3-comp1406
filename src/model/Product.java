
package model;

import javafx.beans.property.SimpleIntegerProperty;

public abstract class Product implements Comparable<Product> {
    protected double price;
    protected int    stock;

    private SimpleIntegerProperty onShelf;
    private SimpleIntegerProperty inCart;
    private SimpleIntegerProperty sold;

    public Product(double price, int stock, int sold){
        this.price      = price;
        this.stock      = stock;

        this.inCart     = new SimpleIntegerProperty(0);
        this.onShelf    = new SimpleIntegerProperty(stock);
        this.sold       = new SimpleIntegerProperty(0);
    }

    public void addToCart() throws IndexOutOfBoundsException{
        if(onShelf.get() > 0){
            inCart.set(inCart.get() + 1);
            onShelf.set(onShelf.get() - 1);
        }
        else throw new IndexOutOfBoundsException("No items in stock");
    }

    public void removeFromCart() throws IndexOutOfBoundsException{
        if(inCart.get() > 0){
            inCart.set(inCart.get() - 1);
            onShelf.set(onShelf.get() + 1);
        }
        else throw new IndexOutOfBoundsException("No items in the cart");
    }

    public int getOnShelf(){
        return onShelf.get();
    }

    public SimpleIntegerProperty getOnShelfObservable(){
        return onShelf;
    }

    public void setOnShelf(int onShelf){
        this.onShelf.set(onShelf);;
    }

    public int getInCart(){
        return inCart.get();
    }

    public SimpleIntegerProperty getInCartObservable(){
        return inCart;
    }

    public void setInCart(int inCart){
        this.inCart.set(inCart);;
    }
    
    public int getSold(){
        return sold.get();
    }

    public SimpleIntegerProperty getSoldObservable(){
        return sold;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice(){
        return price;
    }

    public double sellUnits(int amount){
        if (amount <= stock && amount > 0){
            stock -= amount;
            sold.set(sold.get() + amount);
            inCart.set(0);
            return price*amount;
        }
        else{
            return -1.0;
        }
    }

    public int compareTo(Product o) {
        return o.getSold() - this.getSold();
    }
}