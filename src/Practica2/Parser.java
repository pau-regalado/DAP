package Practica2;

import org.jfree.data.category.DefaultCategoryDataset;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Parser {
    public static final String SEPARATOR = ",";
    protected ArrayList<String> headers;
    protected ArrayList<ArrayList<String>> records;


    public void parse(String[] incomingData) {
        headers = new ArrayList<>(Arrays.asList(incomingData[0].split(SEPARATOR)));
        records = new ArrayList<>();
        for (int i = 1; i < incomingData.length; i++) {
            records.add(new ArrayList<>(Arrays.asList(incomingData[i].split(SEPARATOR))));
        }
    }

    public abstract DefaultCategoryDataset constructDatabase();

    public ArrayList<String> getValuesNonRepeated(int xAxis) {
        ArrayList<String> values = new ArrayList<>();
        for (ArrayList<String> record : records) {
            if (!values.contains(record.get(xAxis))) {
                values.add(record.get(xAxis));
            }
        }
        return values;
    }
}
