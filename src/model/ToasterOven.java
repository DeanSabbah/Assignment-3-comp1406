package model;

public class ToasterOven extends Appliance {
    private int     width;
    private boolean convection;

    public ToasterOven(double price, int stock, int wattage, String colour, String brand, int width, boolean convection){
        super(price, stock, wattage, colour, brand);
        this.width = width;
        this.convection = convection;
    }

    public String toString(){
        return String.format("%d inch %s Toaster%s (%s, %d watts)\n(%.2f$ each)", width, brand, convection ? " with convection" : "", colour, wattage, price);
    }    
}