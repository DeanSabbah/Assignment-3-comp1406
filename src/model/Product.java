
package model;

public abstract class Product implements Comparable<Product>{
    public double price;
    public int stock;
    public int onShelf;
    public int inCart;
    public int sold;

    public Product(double price, int stock, int sold){
        this.price = price;
        this.stock = stock;
        this.sold = sold;
    }

    public int getOnShelf(){
        return onShelf;
    }

    public int getInCart(){
        return inCart;
    }

    public int getSales(){
        return sold;
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
        return o.getSales() - this.getSales();
    }

    public int getStock() {
        return stock;
    }
}