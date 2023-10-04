package Practica2;

import java.util.ArrayList;
import java.util.Arrays;
import org.jfree.data.category.DefaultCategoryDataset;

public class ReaderCSV {
    public static final String SEPARATOR = ",";
    private final ArrayList<String> headers;
    private final ArrayList<ArrayList<String>> records;

    public ReaderCSV(String[] rawContent) {
        headers = new ArrayList<>(Arrays.asList(rawContent[0].split(SEPARATOR)));
        records = new ArrayList<>();
        for (int i = 1; i < rawContent.length; i++) {
            records.add(new ArrayList<>(Arrays.asList(rawContent[i].split(SEPARATOR))));
        }
    }
    public ArrayList<String> getHeaders() {
        return headers;
    }
    public String getValue(int i, int j) {
        return records.get(i).get(j);
    }
    public int getSize() {
        return records.size();
    }
    public ArrayList<String> getValuesNonRepeated(int xAxis) {
        ArrayList<String> values = new ArrayList<>();
        for (ArrayList<String> record : records) {
            if (!values.contains(record.get(xAxis))) {
                values.add(record.get(xAxis));
            }
        }
        return values;
    }

    public DefaultCategoryDataset createDataset(int xAxis, int yAxis) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        ArrayList<String> xValues = getValuesNonRepeated(xAxis);
        ArrayList<String> yValues = getValuesNonRepeated(yAxis);

        for (String yValue : yValues) {
            for (String xValue : xValues) {
                int count = 0;
                for (int i = 0; i < getSize(); i++) {
                    if (getValue(i, xAxis).equals(xValue) && getValue(i, yAxis).equals(yValue)) {
                        count++;
                    }
                }
                dataset.addValue(count, yValue, xValue);
            }
        }

        return dataset;
    }

    public void printDataset(DefaultCategoryDataset dataset) {
        int rowCount = dataset.getRowCount();
        int colCount = dataset.getColumnCount();

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                String rowKey = dataset.getRowKey(row).toString();
                String colKey = dataset.getColumnKey(col).toString();
                double value = dataset.getValue(rowKey, colKey).doubleValue();

                System.out.println("Row: " + rowKey + ", Column: " + colKey + ", Value: " + value);
            }
        }
    }
}
