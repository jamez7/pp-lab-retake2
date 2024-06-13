package com.pplabretake2;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AppController {
    @FXML private ListView<DataSet> listView;
    @FXML private TextField inputField;
    @FXML private Label resultLabel;

    private StatisticsManager statisticsManager;

    public void initialize() {
        statisticsManager = new StatisticsManager();

        for (int i = 0; i < 3; i++) {
            DataSet dataSet = new DataSet();
            for (int j = 0; j < 5; j++) {
                dataSet.addData(Math.random() * 100);
            }
            statisticsManager.addDataSet(dataSet);
        }

        listView.setItems(FXCollections.observableArrayList(statisticsManager.getDataSets()));
    }

    @FXML
    public void handleAddDataSet() {
        DataSet newDataSet = new DataSet();
        statisticsManager.addDataSet(newDataSet);
        listView.setItems(FXCollections.observableArrayList(statisticsManager.getDataSets()));
    }

    @FXML
    public void handleRemoveDataSet() {
        DataSet selectedDataSet = listView.getSelectionModel().getSelectedItem();
        if (selectedDataSet != null) {
            statisticsManager.removeDataSet(selectedDataSet);
            listView.setItems(FXCollections.observableArrayList(statisticsManager.getDataSets()));
        }
    }

    @FXML
    public void handleAddData() {
        DataSet selectedDataSet = listView.getSelectionModel().getSelectedItem();
        if (selectedDataSet != null) {
            double value = Double.parseDouble(inputField.getText());
            selectedDataSet.addData(value);
            inputField.clear();
        }
    }

    @FXML
    public void handleCalculateMean() {
        DataSet selectedDataSet = listView.getSelectionModel().getSelectedItem();
        if (selectedDataSet != null) {
            double mean = statisticsManager.calculateMean(selectedDataSet);
            resultLabel.setText("Mean: " + mean);
        }
    }

    @FXML
    public void handleCalculateMedian() {
        DataSet selectedDataSet = listView.getSelectionModel().getSelectedItem();
        if (selectedDataSet != null) {
            double median = statisticsManager.calculateMedian(selectedDataSet);
            resultLabel.setText("Median: " + median);
        }
    }

    @FXML
    public void handleCalculateStdDev() {
        DataSet selectedDataSet = listView.getSelectionModel().getSelectedItem();
        if (selectedDataSet != null) {
            double stdDev = statisticsManager.calculateStandardDeviation(selectedDataSet);
            resultLabel.setText("Standard Deviation: " + stdDev);
        }
    }
}

