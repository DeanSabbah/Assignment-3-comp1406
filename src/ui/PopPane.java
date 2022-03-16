package ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import model.Product;

public class PopPane extends Pane {
    /*------Initialization or whatever------*/
    ListView<Product> popular = new ListView<Product>();
    Label l_popular = new Label("Most Popular Items:");
    Button reset = new Button("Reset");

    public PopPane(){
        /*-----------reset button----------*/
        reset.setStyle("-fx-font: 14 ariel");
        reset.relocate(0, 170);
        reset.setPrefSize(120, 46);

        /*--------popular item list--------*/
        popular.setPrefSize(174, 137);
        popular.relocate(0, 22);

        /*------popular item list label----*/
        l_popular.setStyle("-fx-font: 16 ariel");
        l_popular.relocate(0, 0);

        getChildren().addAll(reset, popular, l_popular);
    }
}
