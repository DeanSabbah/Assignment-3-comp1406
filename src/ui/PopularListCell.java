package ui;

import javafx.scene.control.ListCell;
import model.Product;

public class PopularListCell extends ListCell<Product> {
    @Override
    protected void updateItem(Product item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || getIndex() >= 3 || item == null) {
            setText("");
        } else {
            setText(item.getSold() + "x " + item.toString());
        }
    }
}
