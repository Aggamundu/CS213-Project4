package com.example.cs213project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;


import javax.xml.stream.events.StartElement;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * this class controls the all orders fxml file
 */
public class AllOrdersController implements Initializable {
    @FXML
    private ComboBox<String> orderNumberBox;
    @FXML
    private ListView<String> ordersList;
    @FXML
    private TextField orderTotal;


    private Stage stage;
    private Scene scene;
    private Parent root;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Order> orders = StateManager.getInstance().getAllOrders();
        orderNumberBox.setItems(StateManager.getInstance().numberList);
    }

    /**
     * changes list dynamically based on combobox
     * @param event event
     */
    @FXML
    public void handleComboBoxSelection(ActionEvent event) {
        ObservableList<Order> orders = StateManager.getInstance().getAllOrders();
        String selectedValue = orderNumberBox.getSelectionModel().getSelectedItem();
        for(Order o : orders){
            if(String.valueOf(o.getNumber()).equals(selectedValue)){
                ordersList.setItems(o.getPizzaListString());
                orderTotal.setText(String.valueOf(o.getTotal()));
                return;
            }
        }
    }

    @FXML
    void getText(){
        FileChooser fileChooser = new FileChooser();
        File documentsDir = new File(System.getProperty("user.home"), "Documents");
        if (documentsDir.exists() && documentsDir.isDirectory()) {
            fileChooser.setInitialDirectory(documentsDir);
        } else {
            // Fallback to the user's home directory
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        }
        File file = fileChooser.showSaveDialog(new Stage());
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );
        if (file != null) {
            // Check if the file name ends with ".txt". If not, append ".txt".
            if (!file.getName().endsWith(".txt")) {
                file = new File(file.getAbsolutePath() + ".txt");
            }

            // Write data to the file
            try (PrintWriter writer = new PrintWriter(file)) {
                for(Order o: StateManager.getInstance().getAllOrders()){
                    for(String s : o.getPizzaListString()){
                        writer.println(s);
                    }
                }
                orderTotal.setText("0");
                StateManager.getInstance().resetStateManager();
                orderNumberBox.setItems(StateManager.getInstance().numberList);
                ordersList.setItems(FXCollections.observableArrayList());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void cancelOrder(){
        if(StateManager.getInstance().getAllOrders().isEmpty()){
            return;
        }
        int selectedIndex = orderNumberBox.getSelectionModel().getSelectedIndex();
        StateManager.getInstance().getAllOrders().remove(selectedIndex);
        StateManager.getInstance().numberList.remove(selectedIndex);
        orderNumberBox.setItems(StateManager.getInstance().numberList);

        ObservableList<Order> orders = StateManager.getInstance().getAllOrders();
        String selectedValue = orderNumberBox.getSelectionModel().getSelectedItem();
        if(selectedValue!=null){
            for(Order o : orders){
                if(String.valueOf(o.getNumber()).equals(selectedValue)){
                    ordersList.setItems(o.getPizzaListString());
                    orderTotal.setText(String.valueOf(o.getTotal()));
                    return;
                }
            }
        } else {
            ordersList.setItems(FXCollections.observableArrayList());
            orderTotal.setText("0");
        }
    }

    /**
     * switches stage back to main
     * @param event event
     * @throws IOException exception
     */
    public void AllSwitchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main-menu-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Main Menu");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
