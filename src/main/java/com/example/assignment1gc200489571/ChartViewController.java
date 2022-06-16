package com.example.assignment1gc200489571;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChartViewController implements Initializable {

    @FXML
    private BarChart<String, Double> barChart;

    @FXML
    private NumberAxis yAxis;
    @FXML
    private Button button;

    @FXML
    private Label label;

    public void initialize(URL url, ResourceBundle resourceBundle) {

        barChart.getData().addAll(DBUtility.getLaptopsByBrand());

        // To set custom range and midpoints
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(100000);
        yAxis.setTickUnit(5000);
    }

    /**
     * This is to change the scene by clicking on button
     * @param event
     * @throws IOException
     */
    @FXML
    private void tableView(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"table-view.fxml");
    }

}
