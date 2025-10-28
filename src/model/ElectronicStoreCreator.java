package model;

public class ElectronicStoreCreator{
  public static ElectronicStore createStore(){
    ElectronicStore store = new ElectronicStore("Ohm-y Goodness Electronics");
    Desktop d1 = new Desktop(175.0, 10, 3.0, 16, true, 250, "Low-Profile");
    Desktop d2 = new Desktop(150.0, 15, 3.5, 32, false, 1000, "Standard");
    Laptop l1 = new Laptop(350.0, 5, 3.5, 16, true, 500, 16);
    Laptop l2 = new Laptop(500.0, 5, 2.5, 8, true, 125, 13);
    Fridge f1 = new Fridge(250.0, 5, 250, "Black", "Sub Zero", 12, false);
    Fridge f2 = new Fridge(275.0, 5, 125, "White", "Sub Zero", 15, true);
    ToasterOven t1 = new ToasterOven(30, 10, 50, "Graphite", "Danby", 8, false);
    ToasterOven t2 = new ToasterOven(80, 10, 50, "Red", "Toasty", 12, true);
    Desktop d3 = new Desktop(1200, 5, 4.2, 16, true, 500, "Standard");
    Laptop l3 = new Laptop(450, 7, 3.5, 8, true, 128, 16.7);

    store.addProduct(d1);
    store.addProduct(d2);
    store.addProduct(l1);
    store.addProduct(l2);
    store.addProduct(f1);
    store.addProduct(f2);
    store.addProduct(t1);
    store.addProduct(t2);
    store.addProduct(d3);
    store.addProduct(l3);
    return store;
  }
}