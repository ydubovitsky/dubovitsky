package io.filter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Абстрактный класс, отвечающий за фильтрацию слов.
 */
abstract public class FilterWords {
    /**
     * Метод удаляет из входного потока все запрещенные слова и направляет их в выходной поток.
     * @param abuse - массив запрещенных слов.
     */
    void dropAbuses(String[] abuse) {
        try(InputStream is = this.factoryInputStream(); OutputStream os =  this.factoryOutputStream()) {
            int c;

            // Собираем строку из символов
            StringBuilder stringBuilder = new StringBuilder();

            // Считываем посимвольно из потока ввода
            while ((c = is.read()) != -1) {
                stringBuilder.append((char)c);
                switch (c) {
                    case ' ' : // если встретили символ пробела, значит слово закончилось

                        // Производим замену
                        String result = replace(stringBuilder.toString(), abuse);
                        os.write(result.getBytes());
                        stringBuilder.delete(0, stringBuilder.length());
                        break;
                    default:
                        os.write(stringBuilder.toString().getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод производит замену подстроки из str входящей в массив String[] на другое слово.
     * @return
     */
    public String replace(String str, String[] strings) {
        String result = new String();
        for (int i = 0; i < strings.length; i++) {
            if (str.contains(strings[i])) {
                result = str.replace( strings[i], "%oops");
            }
        }
        return result;
    }

    public void writeInOutputStream() {}



    /**
     * Фабричные методы для получения объектов реализующие интерфейсы InputStream и OutputStream.
     */
    abstract InputStream factoryInputStream() throws FileNotFoundException;
    abstract OutputStream factoryOutputStream() throws FileNotFoundException;
}
