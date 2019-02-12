package io.filter;

import java.io.*;

/**
 * Конкретный класс, реализующий фабричные методы.
 */
public class FileFilterWords extends FilterWords {

    /**
     * Входные и выходные файлы.
     */
    private File in;
    private File out;

    public FileFilterWords(File in, File out) {
        this.in = in;
        this.out = out;
    }

    @Override
    InputStream factoryInputStream() {
        try {
            return new FileInputStream(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    OutputStream factoryOutputStream() {
        try {
            return new FileOutputStream(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
