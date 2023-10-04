package Practica2;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadFile {
    static private final int BUFFER_SIZE = 1024;
    private DownloadFile() {}

    public static String downloadFromURL(String link) {
        StringBuilder myURLContent = new StringBuilder();
        try {
            // Abridge enlace URL como stream de dates
            BufferedInputStream in = new BufferedInputStream(new URL(link).openStream());
            int bytesRead;
            byte[] byteContents = new byte[BUFFER_SIZE];
            // Lecture de content
            while((bytesRead = in.read(byteContents)) != -1) {
                // Transformation de content a String
                myURLContent.append(new String(byteContents, 0, bytesRead));
            }

            return myURLContent.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.err.println("There is a malformed URL in " + DownloadFile.class);
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("There is an IO error for the Stream opened in " + DownloadFile.class);
            System.exit(1);
        }
        return myURLContent.toString();
    }
}

