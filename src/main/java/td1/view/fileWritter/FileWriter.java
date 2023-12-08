package td1.view.fileWritter;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {

    /**
     * Writes in a file
     *
     * @param fileName the name of the file
     * @param str the text to write in the file
     */
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

    /**
     * Writes in the logs file
     *
     * @param str the text to write
     */
    public static void writeInFile(String str) {
        write(str, "logs");
    }

    /**
     * Writes in a file
     *
     * @param str the text to write
     * @param fileName the file to write in
     */
    public static void writeInFile(String str, String fileName) {
        write(str, fileName);
    }
}
