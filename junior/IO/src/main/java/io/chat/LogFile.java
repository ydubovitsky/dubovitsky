package io.chat;

import java.io.*;

public class LogFile implements Logs {

    File log;

    public LogFile(File file) {
        this.log = file;
    }

    /**
     * Тестовый метод
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("C:\\Users\\user\\IdeaProjects\\dubovitsky\\junior\\IO\\src\\main\\java\\io\\chat\\text.txt");
        LogFile logFile = new LogFile(file);
        ByteArrayInputStream b = new ByteArrayInputStream("Hello".getBytes());
        //logFile.save(b);
        System.out.println(logFile.read());
    }

    @Override
    public void save(InputStream inputStream) {
        int i;
        try(FileOutputStream fileOutputStream = new FileOutputStream(log)) {

            // Пока во входном потоке есть данные
            while ((i = inputStream.read()) != -1) {

                // Записываем их в файл
                fileOutputStream.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String read() {
        String result = new String();
        try(BufferedReader br = new BufferedReader(new FileReader(log))) {

            // По идее стрим должен вернуть любую строку из файла
            result  = br.lines().findAny().get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
