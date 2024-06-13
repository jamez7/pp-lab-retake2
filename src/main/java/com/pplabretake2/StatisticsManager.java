package com.pplabretake2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticsManager implements StatisticsOperations {
    private List<DataSet> dataSets;

    public StatisticsManager() {
        dataSets = new ArrayList<>();
    }

    public void addDataSet(DataSet dataSet) {
        dataSets.add(dataSet);
    }

    public void removeDataSet(DataSet dataSet) {
        dataSets.remove(dataSet);
    }

    public List<DataSet> getDataSets() {
        return new ArrayList<>(dataSets);
    }

    @Override
    public double calculateMean(DataSet dataSet) {
        List<Double> data = dataSet.getData();
        double sum = 0;
        for (double num : data) {
            sum += num;
        }
        return sum / data.size();
    }

    @Override
    public double calculateMedian(DataSet dataSet) {
        List<Double> data = dataSet.getData();
        Collections.sort(data);
        int size = data.size();
        if (size % 2 == 0) {
            return (data.get(size / 2 - 1) + data.get(size / 2)) / 2.0;
        } else {
            return data.get(size / 2);
        }
    }

    @Override
    public double calculateStandardDeviation(DataSet dataSet) {
        double mean = calculateMean(dataSet);
        double sum = 0;
        for (double num : dataSet.getData()) {
            sum += Math.pow(num - mean, 2);
        }
        return Math.sqrt(sum / dataSet.getData().size());
    }
}

