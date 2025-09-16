package ui;

import javafx.scene.control.ListCell;
import model.Product;

public class CartListCell extends ListCell<Product> {
    @Override
    public void updateItem(Product item, boolean empty){
        super.updateItem(item, empty);
        if(empty || item == null){
            setText("");
        }
        else{
            setText(item.getInCart() + "x " + item.toString());
        }
    }
}
