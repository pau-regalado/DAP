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
        JLabel label = new JLabel("Introduce la URL del archivo CSV:");

        // Crear un campo de texto para que el usuario ingrese la URL
        JTextField urlField = new JTextField(30); // 30 caracteres de ancho

        // Primera columna
        JLabel labelColumna = new JLabel("Que columnas desea comparar:");
        JTextField fielColumna1 = new JTextField(3);
        JTextField fielColumna2 = new JTextField(3);

        // Crear un botón para enviar la URL
        JButton submitButton = new JButton("Enviar");

        // Agregar un ActionListener al botón para manejar el evento de clic
        submitButton.addActionListener(e -> {
            String url = urlField.getText(); // Obtener la URL ingresada por el usuario
            // url = "https://cnecovid.isciii.es/covid19/resources/casos_hosp_uci_def_sexo_edad_provres_60_mas.csv";
            // String url1 = "https://cnecovid.isciii.es/covid19/resources/hosp_uci_def_sexo_edad_provres_todas_edades.csv";
            url = "https://cnecovid.isciii.es/covid19/resources/casos_diagnostico_provincia.csv";
            System.out.println("URL ingresada: " + url);
            String[] contents = DownloadFile.downloadFromURL(url).split("\n");

            Parser parser = new CovidParser(contents);
            int c1 = Integer.parseInt(fielColumna1.getText());
            int c2 = Integer.parseInt(fielColumna2.getText());
            // DefaultCategoryDataset dataset = readerCSV.createDataset(c1, c2, 5);
            // readerCSV.printDataset(dataset);
            DefaultCategoryDataset dataset = parser.constructDatabase();
            new BarChart("Gráfico de Barras", dataset).display();
            new LineChart("Gráfico de Lineas", dataset).display();
        });

        // Agregar los componentes al panel
        panel.add(label);
        panel.add(urlField);
        panel.add(labelColumna);
        panel.add(fielColumna1);
        panel.add(fielColumna2);
        panel.add(submitButton);

        // Agregar el panel al frame
        frame.add(panel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
