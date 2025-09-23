package ui;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.ElectronicStore;
import model.ElectronicStoreCreator;
import model.Product;

public class ElectronicStoreApp extends Application {
    private final ElectronicStoreView storeUI   = new ElectronicStoreView();
    private final ListView<Product>   cartView  = storeUI.cart.cart;
    private final ListView<Product>   stockView = storeUI.display.stock;
    private final ListView<Product>   popView   = storeUI.popular.popular;

    private ElectronicStore           store;
    private ObservableList<Product>   allProducts;
    private FilteredList<Product>     products;
    private FilteredList<Product>     cartList;
    private ObservableList<Product>   popularProducts;

    private int saleNum;
    private double cartTotal;

    private void initialization(){
        store           = ElectronicStoreCreator.createStore();
        cartTotal       = 0;

        allProducts     = FXCollections.observableArrayList(product -> new Observable[] {product.anyInCart(), product.anyOnShelf()});
        popularProducts = FXCollections.observableArrayList(store.getPopularProducts());
        
        allProducts.addAll(store.getProducts());

        products        = new FilteredList<>(allProducts, product -> product.anyOnShelf().get());
        cartList        = new FilteredList<>(allProducts, product -> product.anyInCart().get());

        storeUI.summary.sales.setText(Integer.toString(store.getSales()));
        storeUI.summary.revenue.setText(String.format("%.2f", store.getRevenue()));
        storeUI.summary.persale.setText(String.format("%.2f",store.getRevenue()/saleNum));
        storeUI.cart.cartTotal.setText(String.format("%.2f", cartTotal));

        stockView.setItems(products);
        cartView.setItems(cartList);
        popView.setItems(popularProducts);

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
        storeUI.popular.reset.setOnAction((_) -> initialization());

        /*If item in display is selected, enable add to cart button*/
        stockView.getSelectionModel().selectedItemProperty().addListener((_) -> storeUI.display.addCart.setOn(true));

        /*If item in cart is selected, enable remove from cart button*/
        cartView.getSelectionModel().selectedItemProperty().addListener((_) -> {
            storeUI.cart.remove.setOn(true);
            if (cartList.isEmpty()){
                storeUI.cart.purchase.setOn(false);
                storeUI.cart.remove.setOn(false);
            }
        });

        /*If display is empty, disables add to cart button*/
        stockView.getSelectionModel().selectedItemProperty().addListener((_) -> {
            if (products.isEmpty()){
                storeUI.display.addCart.setOn(false);
            }
        });
        
        /*--------Remove button functionality--------*/
        storeUI.cart.remove.setOnAction((_) -> {
            Product selectedProd = cartView.getSelectionModel().getSelectedItem();
            store.removeFromCart(selectedProd);

            storeUI.cart.cartTotal.setText(String.format("%.2f", cartTotal -= selectedProd.getPrice()));

            cartView.refresh();
            stockView.refresh();
        });

        /*--------Add to cart button functionality-------*/
        storeUI.display.addCart.setOnAction((_) -> {
            storeUI.cart.purchase.setOn(true);
            Product selectedProd = stockView.getSelectionModel().getSelectedItem();
            
            store.addToCart(selectedProd);
            storeUI.cart.cartTotal.setText(String.format("%.2f", cartTotal += selectedProd.getPrice()));

            cartView.refresh();
            stockView.refresh();
        });
        
        /*---------Purchase button functinality---------*/
        storeUI.cart.purchase.setOnAction((_) -> {
            store.sellProduct(cartList.toArray(new Product[cartList.size()]));

            popularProducts.setAll(store.getPopularProducts());
            popView.refresh();

            storeUI.cart.purchase.setOn(false);
            storeUI.summary.sales.setText(Integer.toString(store.getSales()));
            storeUI.summary.revenue.setText(String.format("%.2f", store.getRevenue()));
            storeUI.summary.persale.setText(String.format("%.2f", store.getRevenue()/store.getSales()));
            storeUI.cart.cartTotal.setText(String.format("%.2f", cartTotal = 0));
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