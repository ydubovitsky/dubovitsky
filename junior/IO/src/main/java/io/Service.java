package io;

import java.io.*;

/**
 * Сервис проверяет вводимые пользователем данные.
 */
public class Service {
    /**
     * метод должен проверить. что в байтовом потоке записано четное число.
     * @param in - входной поток байтов.
     * @return
     */
    boolean isNumber(InputStream in) {
        boolean result = false;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(in))) { // try с ресурсом
            do {
                int value = Integer.parseInt(br.readLine());
                result = (value % 2) == 0;
            } while (br.ready()); // Пока есть что считывать
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Удаление запрещенных слов
     * @param in
     * @param out
     * @param abuse - массив запрещенных слов
     */
    void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        String str;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in)); // Входной поток
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out)); // Выходной поток
        try {
            do {
                str = bufferedReader.readLine();
                for (int i = 0; i < abuse.length; i++) {
                    if (str.contains(abuse[i])) { // Пропускаем слово
                        continue;
                    }
                }
                bufferedWriter.write(str);
            } while (bufferedReader.ready());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
