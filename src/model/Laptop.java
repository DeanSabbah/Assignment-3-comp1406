package model;

public class Laptop extends Computer {
    private double  screen;

    public Laptop(double price, int stock, double cpu, int ram, boolean drive, int storage, double screen){
        super(price, stock, cpu, ram, drive, storage);
        this.screen = screen;
    }
    
    public String toString(){
        return String.format("%.1f inch Laptop PC with %.2f GHz CPU, %d GB RAM, %d GB %s drive.\n(%.2f$ each)", screen, cpu, ram, storage, drive ? "SSD" : "HDD", price);
    }
}
