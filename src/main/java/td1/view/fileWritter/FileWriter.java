package td1.view.fileWritter;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {
    private static void write(String str, String fileName){
        // Init the buffer
        BufferedWriter writer = null;
        try {
            // Indicating the file name, true is to append instead of replacing
            writer = new BufferedWriter(new java.io.FileWriter(fileName, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            // Writing the line
            writer.newLine();
            writer.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            // Close the buffer
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Default file is "logs"
    public static void writeInFile(String str) {
        write(str, "logs");
    }
    // Write in file function
    public static void writeInFile(String str, String fileName) {
        write(str, fileName);
    }
}
