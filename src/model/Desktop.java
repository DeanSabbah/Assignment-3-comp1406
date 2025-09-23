package model;

public class Desktop extends Computers {

    private String  form;

    public Desktop(double price, int stock, double cpu, int ram, boolean drive, int storage, String form){
        super(price, stock, cpu, ram, drive, storage);
        this.form = form;
    }

    public String toString(){
        if (drive){
            return form + " Desktop PC with " + cpu + "GHz CPU, " + ram + "GB RAM, " + storage + "GB SSD drive. \n(" + String.format("%,.2f", price) + "$ each)";
        }
        else{
            return form + " Desktop PC with " + cpu + "GHz CPU, " + ram + "GB RAM, " + storage + "GB HDD drive. \n(" + String.format("%,.2f", price) + "$ each)";
        }
    }
}