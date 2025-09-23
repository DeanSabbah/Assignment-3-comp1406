package ui;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import model.Product;

public class DisplayPane extends Pane {
    /*------Initialization or whatever------*/
    private Label l_stock               = new Label("Store stock");
    protected ListView<Product> stock   = new ListView<Product>();
    protected ToggleButton addCart      = new ToggleButton("Add to Cart");

        public DisplayPane(){
        l_stock.setStyle("-fx-font: 16 ariel");
        l_stock.relocate(97, -5);

        stock.relocate(0, 18);
        stock.setPrefSize(274, 274);

        addCart.setStyle("-fx-font: 14 ariel");
        addCart.relocate(77, 304);
        addCart.setPrefSize(120, 46);
        addCart.setOn(false);

        getChildren().addAll(l_stock, stock, addCart);
    }
}
