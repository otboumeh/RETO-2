package main.java.app.com.textFile;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextFileManager {
    
    private static final String RUTA_RELATIVE_FICHERO = "src/main/resources/textFiles/"; 
    private static final String NOMBRE_FICHERO = "ofertaCliente.txt";  

	
	/**
     * Escribe un texto pasado por parametro en el fichero.
     * Crea el fichero si no existe.
     * 
     * @param texto El texto a escribir en el fichero.
     */
    public void sobreescribirFichero(String texto) {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        File file = new File(RUTA_RELATIVE_FICHERO + NOMBRE_FICHERO);
        
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            fileWriter = new FileWriter(file, false); 
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(texto);
        } catch (IOException e) {
            System.out.println("Error de escritura en el fichero " + RUTA_RELATIVE_FICHERO + NOMBRE_FICHERO);
        } catch (Exception e) {
            System.out.println("Error de escritura en el fichero " + RUTA_RELATIVE_FICHERO + NOMBRE_FICHERO);
        } finally {
            if (null != printWriter)
                printWriter.close();
            try {
                if (null != fileWriter)
                    fileWriter.close();
            } catch (IOException e) {
            }
        }
    }
    
    public void openFile() {
        File file = new File(RUTA_RELATIVE_FICHERO + NOMBRE_FICHERO);

        if (file.exists()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("No se pudo abrir el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }
}
