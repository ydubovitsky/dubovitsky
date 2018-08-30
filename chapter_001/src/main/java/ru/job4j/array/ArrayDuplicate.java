package ru.job4j.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayDuplicate {
    /**
     * Метод убирает все дубликаты строк из массива.
     * @param array
     * @return
     */
    public String[] remove(String[] array) {
        Set set = new HashSet(Arrays.asList(array));
        return  (String[]) set.toArray(new String[set.size()]);
    }
}
