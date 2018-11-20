package ru.job4j.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс, отвечающий за Удаление дубликатов в массиве.
 */
public class ArrayDuplicate {

    /**
     * Метод убирает все дубликаты строк из массива.
     * @param array
     * @return
     */
    public String[] remove(String[] array) {
        Set set = new HashSet(Arrays.asList(array));
        return (String[]) set.toArray(new String[set.size()]);
    }

    /**
     * Метод должен выполнять то же самое, что и remove(String[] array).
     * @param array
     * @return
     */
    public String[] removeDuplicate(String[] array) {
        for (int i = 0; i != array.length -1; i++) {
            if (array[i] == array[i+1]) {
                System.arraycopy(array, i, array, i + 1, array.length - 1);
            }
        }
        return array;
    }

    /**
     * Метод для тестирования
     * @param args
     */
    public static void main(String[] args) {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        for (String a : arrayDuplicate.removeDuplicate(new String[]{"1", "1", "1", "2", "3", "3", "4", "5"})) {
            System.out.println(a);
        }
    }
}
