package Practica2;


import java.util.ArrayList;
import java.util.List;
import org.jfree.data.category.DefaultCategoryDataset;

enum CovidTupleAttr {
    NUM_CASOS,
    NUM_CASOS_PCR,
    NUM_CASOS_TEST_AC
}

public class CovidParser extends Parser{
        public CovidParser (String[] content) {
            this.parse(content);
        }
        @Override
        public DefaultCategoryDataset constructDatabase() {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for (ArrayList<String> record : this.records) {
                // Make sure the record has the same number of values as headers
                if (record.size() == this.headers.size()) {
                    for (int i = 0; i < this.headers.size(); i++) {
                        String value = record.get(i);
                        String header = this.headers.get(i);

                        try {
                            System.out.println("v: " + value + " " + i + " : " + Integer.parseInt(value));
                            int doubleValue = Integer.parseInt(value);
                            dataset.addValue(doubleValue, header, "");
                        } catch (NumberFormatException e) {
                            // Handle the case where the value cannot be parsed as a double
                            // You can print an error message or take appropriate action here
                            dataset.addValue(1, header, "");
                        }
                    }
                }
            }

            return dataset;
        }

}
