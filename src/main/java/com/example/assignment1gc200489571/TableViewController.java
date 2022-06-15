package com.example.assignment1gc200489571;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {

    @FXML
    private TableColumn<Laptop, String> brandColumn;

    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    private TableColumn<Laptop, String> modelColumn;

    @FXML
    private TableColumn<Laptop, Double> priceColumn;

    @FXML
    private TableColumn<Laptop, String> processorNameColumn;

    @FXML
    private TableColumn<Laptop, Integer> ramColumn;
    @FXML
    private TableView<Laptop> tableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Configure the column of the tables to know where to get the data from the laptop object
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        processorNameColumn.setCellValueFactory(new PropertyValueFactory<>("processorName"));
        ramColumn.setCellValueFactory(new PropertyValueFactory<>("ram"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("priceString"));
        tableView.getItems().addAll(DBUtility.getLaptopsFromDB());
    }

    /**
     *This is to change the scene by clicking on button
     * @param event
     * @throws IOException
     */
    @FXML
    private void chartView(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"chart-view.fxml");
    }
}
