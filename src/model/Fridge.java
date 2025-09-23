package model;

public class Fridge extends Appliances {
    private double  size;
    private boolean freezer;

    public Fridge(Double price, int stock, int wattage, String colour, String brand, double size, boolean freezer){
        super(price, stock, wattage, colour, brand);
        this.size = size;
        this.freezer = freezer;
    }

    public String toString(){
        if (freezer){
            return size + "cu. ft. " + brand + " Fridge with freezer (" + colour + ", " + wattage + " watts) \n(" + String.format("%,.2f", price) + "$ each)";
        }
        else{
            return size + "cu. ft. " + brand + " Fridge (" + colour + ", " + wattage + " watts) \n(" + String.format("%,.2f", price) + "$ each)";
        }
    }
}
