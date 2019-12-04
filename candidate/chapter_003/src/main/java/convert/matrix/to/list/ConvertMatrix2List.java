package convert.matrix.to.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, отвечающий за конвертацию двумерного массива в коллекцию  - list.
 */
public class ConvertMatrix2List {
    /**
     * Метод, конвертирующий двумерный массив в список.
     * @param array - двумерный массив.
     * @return
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for(int[] a : array) {
            for (int b : a) {
                list.add(b);
            }
        }
        return list;
    }
}
