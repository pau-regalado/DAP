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

    public DefaultCategoryDataset createDataset(int xAxis, int yAxis, int zAxis) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        ArrayList<String> xValues = getValuesNonRepeated(xAxis);
        ArrayList<String> yValues = getValuesNonRepeated(yAxis);
        ArrayList<String> zValues = getValuesNonRepeated(zAxis);

        // Assuming xValues, yValues, and zValues have the same size.
        int size = Math.min(Math.min(xValues.size(), yValues.size()), zValues.size());

        for (int i = 0; i < size; i++) {
            String xValue = xValues.get(i);
            String yValue = yValues.get(i);
            String zValue = zValues.get(i);

            // Assuming you want to use xValue as the data point.
            dataset.addValue(Double.parseDouble(xValue), yValue, zValue);
        }

        return dataset;
    }
}
