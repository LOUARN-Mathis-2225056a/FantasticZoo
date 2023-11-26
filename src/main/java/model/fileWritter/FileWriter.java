package model.fileWritter;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {
    public static void writeInFile(String str, String fileName) {

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new java.io.FileWriter(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
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
}
