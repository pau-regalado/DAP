package Practica2;

import java.util.ArrayList;
import java.util.List;
import org.jfree.data.category.DefaultCategoryDataset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        for (int i = 0; i < this.records.size(); i++) {
            try {
                double xValue = Double.parseDouble(this.records.get(i).get(2));
                double yValue = Double.parseDouble(this.records.get(i).get(3));
                double zValue = Double.parseDouble(this.records.get(i).get(4));
                String label = this.records.get(i).get(1);

                dataset.addValue(xValue, this.headers.get(2), label);
                dataset.addValue(yValue, this.headers.get(3), label);
                dataset.addValue(zValue, this.headers.get(4), label);
            } catch (NumberFormatException e) {
            }
        }
            return dataset;
        }
}
