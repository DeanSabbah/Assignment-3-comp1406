package model;

public abstract class Computers extends Product {
    protected double    cpu;
    protected int       ram;
    protected boolean   drive;
    protected int       storage;

    public Computers(double price, int stock, double cpu, int ram, boolean drive, int storage){
        super(price, stock, 0);
        this.cpu = cpu;
        this.ram = ram;
        this.drive = drive;
        this.storage = storage;
    }
}