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
            StringBuilder stringBuilder = new StringBuilder(); // Собираем строку из символов
            while ((c = is.read()) != -1) { // Считываем посимвольно из потока ввода
                switch (c) {
                    case ' ' : // если встретили символ пробела, значит слово закончилось
                        for (int i = 0; i < abuse.length; i++) {
                            if (stringBuilder.toString().contains(abuse[i])) {
                                os.write("Замена".getBytes()); // заменяем плохое слово на "Замена"
                                stringBuilder.delete(0, stringBuilder.length()); // Очищаем
                                break; // выходим из цикла.
                            } else{
                                os.write(' ');
                            }
                        }
                        os.write(stringBuilder.toString().getBytes()); // выводим в поток вывода массив байтов
                        stringBuilder.delete(0, stringBuilder.length()); // Очищаем
                        break;
                    default: // если символ не пробел, собирвем его из char
                        stringBuilder.append((char)c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Фабричные методы для получения объектов реализующие интерфейсы InputStream и OutputStream.
     */
    abstract InputStream factoryInputStream() throws FileNotFoundException;
    abstract OutputStream factoryOutputStream() throws FileNotFoundException;
}
