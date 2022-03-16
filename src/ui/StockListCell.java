package ui;

import javafx.scene.control.ListCell;
import model.Product;

public class StockListCell extends ListCell<Product> {
    @Override
    protected void updateItem(Product item, boolean empty) {
        super.updateItem(item, empty);
        if(empty || item == null){
            setText("");
        }
        else{
            setText(item.onShelf + "x " + item.toString());
        }
    }
}