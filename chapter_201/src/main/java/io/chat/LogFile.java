package io.chat;

import java.io.*;

/**
 * Конкретный класс, реализующий лог
 */
public class LogFile implements Logs {

    /**
     * Лог-файл
     */
    File log;

    public LogFile(File file) {
        this.log = file;
    }


    @Override
    public void save(String str) {
        // true - перевод на новую строку
        try(FileWriter fr = new FileWriter(log, true)) {
            fr.write("\n" + str);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
