package model;

public class ToasterOven extends Appliances {
    private int     width;
    private boolean convection;

    public ToasterOven(double price, int stock, int wattage, String colour, String brand, int width, boolean convection){
        super(price, stock, wattage, colour, brand);
        this.width = width;
        this.convection = convection;
    }

    public String toString(){
        if (convection){
            return width + " inch " + brand + " Toaster with convection (" + colour + ", " + wattage + " watts) \n(" + String.format("%,.2f", price) + "$ each)";
        }
        else{
            return width + " inch " + brand + " Toaster (" + colour + ", " + wattage + " watts) \n(" + String.format("%,.2f", price) + "$ each)";
        }
    }    
}