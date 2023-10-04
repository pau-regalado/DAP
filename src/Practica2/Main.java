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

        // Crear un botón para enviar la URL
        JButton submitButton = new JButton("Enviar");

        // Agregar un ActionListener al botón para manejar el evento de clic
        submitButton.addActionListener(e -> {
            String url = urlField.getText(); // Obtener la URL ingresada por el usuario
            // Aquí puedes hacer lo que desees con la URL, como descargar el archivo CSV
            url = "https://cnecovid.isciii.es/covid19/resources/casos_hosp_uci_def_sexo_edad_provres_60_mas.csv";
            String url1 = "https://cnecovid.isciii.es/covid19/resources/hosp_uci_def_sexo_edad_provres_todas_edades.csv";
            System.out.println("URL ingresada: " + url1);
            String[] contents = DownloadFile.downloadFromURL(url1).split("\n");
            System.out.println("Result:" + contents[0]);
            System.out.println("Result:" + contents[1]);
            System.out.println("Result:" + contents[2]);
            System.out.println("Result:" + contents.length);
            ReaderCSV readerCSV = new ReaderCSV(contents);
            DefaultCategoryDataset dataset = readerCSV.createDataset(2, 4);
            // readerCSV.printDataset(dataset);

            SwingUtilities.invokeLater(() -> {
                BarChart demo = new BarChart("Gráfico de Barras Demo", dataset);
                demo.pack();
                RefineryUtilities.centerFrameOnScreen(demo);
                demo.setVisible(true);
            });
        });

        // Agregar los componentes al panel
        panel.add(label);
        panel.add(urlField);
        panel.add(submitButton);

        // Agregar el panel al frame
        frame.add(panel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
