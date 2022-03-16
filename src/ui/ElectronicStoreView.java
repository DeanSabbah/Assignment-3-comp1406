package ui;

import javafx.scene.layout.Pane;

public class ElectronicStoreView {
    Pane mainPane = new Pane();
    SumPane summary = new SumPane();
    DisplayPane display = new DisplayPane();
    CartPane cart = new CartPane();
    PopPane popular = new PopPane();

    public Pane getScene(){
        summary.relocate(14, 25);
        popular.relocate(14, 160);
        display.relocate(203, 25);
        cart.relocate(496, 25);

        mainPane.getChildren().addAll(summary, display, cart, popular);
        return mainPane;
    }
}