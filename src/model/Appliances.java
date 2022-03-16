package model;

public abstract class Appliances extends Product {
    int wattage;
    String colour;
    String brand;

    public Appliances(double price, int stock, int wattage, String colour, String brand){
        super(price, stock, 0);
        this.wattage = wattage;
        this.colour = colour;
        this.brand = brand;
    }
}
