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
    InputStream factoryInputStream() throws FileNotFoundException {
        return new FileInputStream(in);
    }

    @Override
    OutputStream factoryOutputStream() throws FileNotFoundException {
        return new FileOutputStream(out);
    }
}
