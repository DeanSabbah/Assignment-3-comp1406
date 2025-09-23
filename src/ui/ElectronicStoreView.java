package ui;

import javafx.scene.layout.Pane;

public class ElectronicStoreView {
    protected Pane mainPane       = new Pane();
    protected SumPane summary     = new SumPane();
    protected DisplayPane display = new DisplayPane();
    protected CartPane cart       = new CartPane();
    protected PopPane popular     = new PopPane();

    public Pane getScene(){
        summary.relocate(14, 25);
        popular.relocate(14, 160);
        display.relocate(203, 25);
        cart.relocate(496, 25);

        mainPane.getChildren().addAll(summary, display, cart, popular);
        return mainPane;
    }
}