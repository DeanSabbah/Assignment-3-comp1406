package ui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.ElectronicStore;
import model.ElectronicStoreCreator;
import model.Product;

public class ElectronicStoreApp extends Application{
    private final ElectronicStoreView storeUI = new ElectronicStoreView();
    private ElectronicStore store = ElectronicStoreCreator.createStore();
    private final ListView<Product> cartView = storeUI.cart.cart;
    private final ListView<Product> stockView = storeUI.display.stock;
    private final ListView<Product> popView = storeUI.popular.popular;
    private ObservableList<Product> products = FXCollections.observableArrayList(store.products);
    private ObservableList<Product> popProducts = FXCollections.observableArrayList(store.sortedProducts);
    private static ObservableList<Product> cartList = FXCollections.observableArrayList(ElectronicStoreCreator.createStore().cartList);
    private int saleNum;
    private double cartTotal;
    private double total;

    private void initialization(){
        saleNum = 0;
        cartTotal = 0;
        total = 0;
        store = ElectronicStoreCreator.createStore();
        cartList.clear();
        products = FXCollections.observableArrayList(store.products);
        popProducts = FXCollections.observableArrayList(store.sortedProducts);
        storeUI.summary.sales.setText(Integer.toString(saleNum));
        storeUI.summary.revenue.setText(String.format("%.2f",total));
        storeUI.summary.persale.setText(String.format("%.2f",total/saleNum*1.0));
        storeUI.cart.cartTotal.setText(String.format("%.2f", cartTotal));
        stockView.setItems(products);
        popView.setItems(popProducts);
        cartView.setItems(cartList);
        storeUI.display.addCart.setOn(false);
        storeUI.cart.purchase.setOn(false);
        storeUI.cart.remove.setOn(false);
        cartView.setCellFactory(new Callback<ListView<Product>,ListCell<Product>>() {
            @Override
            public ListCell<Product> call(ListView<Product> arg0) {
                return new CartListCell();
            }
        });
        stockView.setCellFactory(new Callback<ListView<Product>,ListCell<Product>>() {
            @Override
            public ListCell<Product> call(ListView<Product> arg0) {
                return new StockListCell();
            }
        });
    }

    public void start(Stage primaryStage) {
        /*---------Reset button functionality--------*/
        storeUI.popular.reset.setOnAction(actionEvent -> initialization());

        /*If item in display is selected, add to cart becomes button becomes usable*/
        stockView.getSelectionModel().selectedItemProperty().addListener(observable -> storeUI.display.addCart.setOn(true));

        /*If item in cart is selected, remove from cart becomes button becomes usable*/
        cartView.getSelectionModel().selectedItemProperty().addListener(observable -> {
            storeUI.cart.remove.setOn(true);
            if (cartList.isEmpty()){
                storeUI.cart.purchase.setOn(false);
                storeUI.cart.remove.setOn(false);
            }
        });

        /*If display is empty, make add to cart button unusable*/
        stockView.getSelectionModel().selectedItemProperty().addListener(observable -> {
            if (products.isEmpty()){
                storeUI.display.addCart.setOn(false);
            }
        });
        
        /*--------Remove button functionality--------*/
        storeUI.cart.remove.setOnAction(actionEvent -> {
            Product selectedProd = cartView.getSelectionModel().getSelectedItem();
            storeUI.cart.cartTotal.setText(String.format("%.2f", cartTotal -= selectedProd.price));
            if (products.contains(selectedProd)){
                products.get(products.indexOf(selectedProd)).onShelf++;
            }
            else{
                selectedProd.onShelf = 1;
                products.add(selectedProd);
            }
            selectedProd.inCart --;
            if (selectedProd.inCart <= 0){
                cartList.remove(selectedProd);
            }
            cartView.refresh();
            stockView.refresh();
        });

        /*--------Add to cart button functionality-------*/
        storeUI.display.addCart.setOnAction(actionEvent -> {
            Product selectedProd = stockView.getSelectionModel().getSelectedItem();
            storeUI.cart.purchase.setOn(true);
            if(cartList.contains(selectedProd)){
                cartList.get(cartList.indexOf(selectedProd)).inCart ++;
            }
            else{
                selectedProd.inCart = 1;
                cartList.add(selectedProd);
            }
            selectedProd.onShelf --;
            cartTotal += products.get(stockView.getSelectionModel().getSelectedIndex()).price;
            storeUI.cart.cartTotal.setText(String.format("%.2f", cartTotal));
            if (selectedProd.onShelf <= 0){
                products.remove(selectedProd);
           }
            if(stockView.getSelectionModel().getSelectedIndex() == -1){
                storeUI.display.addCart.setOn(false);
            }
            cartView.refresh();
            stockView.refresh();
        });
        
        /*---------Purchese button functinality---------*/
        storeUI.cart.purchase.setOnAction(actionEvent -> {
            store.cartList = cartList;
            for (int i = 0; i < cartList.size(); i++) {
                store.sellProducts(i, cartList.get(i).inCart);
            }
            popView.setItems(popProducts = FXCollections.observableArrayList(store.getPop()));
            storeUI.cart.purchase.setOn(false);
            storeUI.summary.sales.setText(Integer.toString(saleNum += 1));
            storeUI.summary.revenue.setText(String.format("%.2f",total += cartTotal));
            storeUI.summary.persale.setText(String.format("%.2f",total/saleNum*1.0));
            storeUI.cart.cartTotal.setText(String.format("%.2f", cartTotal = 0));
            cartList.clear();
        });

    initialization();
    Scene scene = new Scene(storeUI.getScene(), 800, 400);
    primaryStage.setResizable(false);
    primaryStage.setTitle(store.getName());
    primaryStage.setScene(scene);
    primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}