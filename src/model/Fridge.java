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
        return String.format("%.1f cu. ft. %s Fridge%s (%s, %d watts)\n(%.2f$ each)", size, brand, freezer ? " with freezer" : "", colour, wattage, price);
    }
}
