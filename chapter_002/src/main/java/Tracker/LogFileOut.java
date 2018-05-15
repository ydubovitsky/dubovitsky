package Tracker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

class LogFileOut {

    static Path currentRelativePath = Paths.get("");
    static String strPath = currentRelativePath.toAbsolutePath().toString() + "/log.txt";

    public static void createFile() {
        try {
            File file = new File(LogFileOut.strPath);
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Не удалось создать файл! Держи стэк-трейс:");
            System.out.println(e.getStackTrace());
        }
    }

    public static void logged(String a) {
        try {
            FileOutputStream file = new FileOutputStream(LogFileOut.strPath);
            if (a.length() > 0) {
                byte[] buffer = a.getBytes();
                file.write(buffer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
