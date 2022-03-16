package model;

public class Laptop extends Computers {
    double  screen;

    public Laptop(double price, int stock, double cpu, int ram, boolean drive, int storage, double screen){
        super(price, stock, cpu, ram, drive, storage);
        this.screen = screen;
    }
    
    public String toString(){
        if (drive){
            return screen + " inch Laptop PC with " + cpu + "GHz CPU, " + ram + "GB RAM, " + storage + "GB SSD drive.\n (" + String.format("%,.2f", price) + "$ each)";
        }
        else{
            return screen + " inch Laptop PC with " + cpu + "GHz CPU, " + ram + "GB RAM, " + storage + "GB HDD drive.\n (" + String.format("%,.2f", price) + "$ each)";
        }
    }
}
