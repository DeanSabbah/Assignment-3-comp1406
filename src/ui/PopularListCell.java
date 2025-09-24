package ui;

import javafx.scene.control.ListCell;
import model.Product;

public class PopularListCell extends ListCell<Product> {
    @Override
    protected void updateItem(Product item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || getIndex() >= 3 || item == null) {
            setText("");
            setPrefHeight(0);
        } else {
            setPrefHeight(USE_COMPUTED_SIZE);
            setText(item.getSold() + "x " + item.toString());
        }
    }
}
