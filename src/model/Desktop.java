package model;

public class Desktop extends Computers {

    private String  form;

    public Desktop(double price, int stock, double cpu, int ram, boolean drive, int storage, String form){
        super(price, stock, cpu, ram, drive, storage);
        this.form = form;
    }

    public String toString(){
        return String.format("%s Desktop PC with %.2f GHz CPU, %d GB RAM, %d GB %s drive.\n(%.2f$ each)", form, cpu, ram, storage, drive ? "SSD" : "HDD", price);
    }
}