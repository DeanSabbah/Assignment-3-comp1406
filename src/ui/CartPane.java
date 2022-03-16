package ui;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import model.Product;

public class CartPane extends Pane {
    /*------Initialization or whatever------*/
    Label lCart = new Label("Cart");
    ListView<Product> cart = new ListView<Product>();
    ToggleButton remove = new ToggleButton("Remove from\ncart");
    ToggleButton purchase = new ToggleButton("Complete\npurchase");
    Label cartTotal = new Label();
    public CartPane(){

        /*------------Cart label-----------*/
        lCart.setStyle("-fx-font: 16 ariel");
        lCart.relocate(95, -5);

        /*-----------cartTotal label-----------*/
        cartTotal.setStyle("-fx-font: 16 ariel");
        cartTotal.relocate(130, -5);

        /*-----------Cart list-------------*/
        cart.relocate(0, 18);
        cart.setPrefSize(274, 274);

        /*----------Remove button----------*/
        remove.setStyle("-fx-font: 14 ariel");
        remove.relocate(143, 304);
        remove.setPrefSize(120, 46);
        remove.setOn(false);

        /*--------Purchese button----------*/
        purchase.setStyle("-fx-font: 14 ariel");
        purchase.relocate(17, 304);
        purchase.setPrefSize(120, 46);
        purchase.setOn(false);

        getChildren().addAll(lCart, remove, purchase, cart, cartTotal);
    }
}
