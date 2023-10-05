package Practica2;

import javax.swing.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

public class Main {
    public static void main(String[] args) {
        // Crear un nuevo frame (ventana)
        JFrame frame = new JFrame("Solicitud de URL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
        frame.setSize(400, 150); // Tamaño de la ventana

        // Crear un panel
        JPanel panel = new JPanel();

        // Crear un label para indicar al usuario qué ingresar
        JLabel label = new JLabel("Seleccione la fuente de datos que quiera graficar\n");

        JButton covidButton = new JButton("Covid");
        JButton hospitalButton = new JButton("Hospital (it may take a while)");

        hospitalButton.addActionListener(e -> {
            String url = "https://cnecovid.isciii.es/covid19/resources/casos_hosp_uci_def_sexo_edad_provres_60_mas.csv";
            String[] contents = DownloadFile.downloadFromURL(url).split("\n");

            Parser parser = new HospitalParser(contents);

            DefaultCategoryDataset dataset = parser.constructDatabase();
            new BarChart("Gráfico de Barras de Covid", dataset).display();
            new LineChart("Gráfico de Lineas de Covid", dataset).display();
        });

        covidButton.addActionListener(e -> {
            String url = "https://cnecovid.isciii.es/covid19/resources/casos_diagnostico_provincia.csv";
            String[] contents = DownloadFile.downloadFromURL(url).split("\n");
            Parser parser = new HospitalParser(contents);
            DefaultCategoryDataset dataset = parser.constructDatabase();
            new BarChart("Gráfico de Barras de Hospital", dataset).display();
            new LineChart("Gráfico de Lineas de Hospital", dataset).display();
        });

        // Agregar los componentes al panel
        panel.add(label);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        panel.add(separator);

        panel.add(covidButton);
        panel.add(hospitalButton);

        // Agregar el panel al frame
        frame.add(panel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
