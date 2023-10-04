package Practica2;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;

public abstract class Chart extends ApplicationFrame {
    DefaultCategoryDataset dataset;
    public Chart(String applicationTitle, DefaultCategoryDataset dataset) {
        super(applicationTitle);
        this.dataset = dataset;

        JFreeChart barChart = createDataset();

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public abstract JFreeChart createDataset();

    public void display() {
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
    }
}
