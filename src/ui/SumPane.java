package ui;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class SumPane extends Pane {
    Label summary = new Label("Store Summary");
    Label l_sales = new Label("Sales:");
    Label l_revenue = new Label("Revenue:");
    Label l_persale = new Label("$/Sale:");
    TextField sales = new TextField();
    TextField revenue = new TextField();
    TextField persale = new TextField();

    public SumPane(){
        summary.relocate(0, 5);
        summary.setStyle("-fx-font: 16 ariel");

        l_sales.relocate(0, 41);
        l_sales.setStyle("-fx-font: 14 ariel");

        l_revenue.relocate(0, 76);
        l_revenue.setStyle("-fx-font: 14 ariel");

        l_persale.relocate(0, 110);
        l_persale.setStyle("-fx-font: 14 ariel");

        sales.relocate(65, 36);
        sales.setPrefSize(114, 25);
        sales.setEditable(false);

        revenue.relocate(65, 71);
        revenue.setPrefSize(114, 25);
        revenue.setEditable(false);

        persale.relocate(65, 106);
        persale.setPrefSize(114, 25);
        persale.setEditable(false);

        getChildren().addAll(summary, l_sales, l_revenue, l_persale, sales, revenue, persale);
    }
}