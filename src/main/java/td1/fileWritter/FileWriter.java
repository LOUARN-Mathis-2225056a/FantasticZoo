package td1.fileWritter;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {
    private static void write(String str, String fileName){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new java.io.FileWriter(fileName, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.newLine();
            writer.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeInFile(String str) {
        write(str, "logs");
    }
    public static void writeInFile(String str, String fileName) {
        write(str, fileName);
    }
}
