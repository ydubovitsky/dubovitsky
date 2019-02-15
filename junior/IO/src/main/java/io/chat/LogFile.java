package io.chat;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

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
        //System.out.println(logFile.read());
        for (int i = 0; i < 10; i++) {
            System.out.println(logFile.returnRandomString());
        }
    }

    @Override
    public void save(Reader reader) {
        int i;
        try(FileWriter fr = new FileWriter(log)) {

            // Пока во входном потоке есть данные
            while ((i = reader.read()) != -1) {

                // Записываем их в файл
                fr.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String returnRandomString() {
        String result = new String();
        try {
            // Получаем список всех строк
            List<String> list = Files.readAllLines(this.log.toPath());

            // Получить случайное значение строки
            Random random = new Random();
            int value = random.nextInt(list.size());

            // Вернуть случайную строку из файла
            result = list.get(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Метод возвращает случайную строку из файла this.log
     */
    public String randStringStream() {
        String result = new String();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(this.log)))) {

            // По идее должен вернуть случайную строку
            result = br.lines().parallel().findAny().get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
