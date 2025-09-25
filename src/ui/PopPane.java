package ui;

import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import model.Product;

public class PopPane extends Pane {
    /*------Initialization or whatever------*/
    private Label l_popular             = new Label("Most Popular Items:");
    protected ListView<Product> popular = new ListView<Product>();
    protected Button reset              = new Button("Reset");

    public PopPane(){
        /*-----------reset button----------*/
        reset.setStyle("-fx-font: 14 ariel");
        reset.relocate(0, 170);
        reset.setPrefSize(120, 46);

        /*--------popular item list--------*/
        popular.setPrefSize(174, 137);
        popular.relocate(0, 22);
        popular.setStyle("-overflow-y: hidden;");
        popular.skinProperty().addListener((_) -> {
            for (Node node : popular.lookupAll(".scroll-bar")) {
                if (node instanceof ScrollBar) {
                    ScrollBar scrollBar = (ScrollBar) node;
                    if (scrollBar.getOrientation() == Orientation.VERTICAL) {
                        scrollBar.setDisable(true); 
                        scrollBar.setVisible(false);
                        scrollBar.setPrefWidth(0);
                    }
                }
            }
        });

        popular.addEventFilter(ScrollEvent.SCROLL, event -> {
            if (event.getDeltaY() != 0) {
                event.consume();
            }
        });

        popular.getStylesheets().add(getClass().getResource("../css/hide-scrollbar.css").toExternalForm());

        /*------popular item list label----*/
        l_popular.setStyle("-fx-font: 16 ariel");
        l_popular.relocate(0, 0);

        getChildren().addAll(reset, popular, l_popular);
    }
}
