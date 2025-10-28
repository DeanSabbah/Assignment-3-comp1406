package model;

public abstract class Appliance extends Product {
    protected int    wattage;
    protected String colour;
    protected String brand;

    public Appliance(double price, int stock, int wattage, String colour, String brand){
        super(price, stock);
        this.wattage = wattage;
        this.colour = colour;
        this.brand = brand;
    }
}
