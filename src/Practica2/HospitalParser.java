package Practica2;

import org.jfree.data.category.DefaultCategoryDataset;

enum HospitalTupleAttr {
    NUM_CASOS,
    NUM_CASOS_PCR,
    NUM_CASOS_TEST_AC
}

public class HospitalParser extends Parser{
    public HospitalParser (String[] content) {
        this.parse(content);
    }
    @Override
    public DefaultCategoryDataset constructDatabase() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < this.records.size(); i++) {
            try {
                double xValue = Double.parseDouble(this.records.get(i).get(4));
                double yValue = Double.parseDouble(this.records.get(i).get(5));
                double zValue = Double.parseDouble(this.records.get(i).get(6));
                String label = this.records.get(i).get(3);

                dataset.addValue(xValue, this.headers.get(4), label);
                dataset.addValue(yValue, this.headers.get(5), label);
                dataset.addValue(zValue, this.headers.get(6), label);
            } catch (NumberFormatException e) {
            }
        }
        return dataset;
    }
}