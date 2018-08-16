package convert.list.to.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс для конвертации Листа в Массив.
 */
public class ConvertList2Array {
    /**
     * Метод конвертирует лист в двумерный массив.
     * @param list - лист, содержащий целочисленные значение.
     * @param rows - количество строк, на которыое нужно разбить лист.
     * @return
     */
    public int[][] toArray(List<Integer> list, int rows) {
        System.out.println(list.size());
        while (list.size() % rows != 0) {
            list.add(0);
            System.out.println("Добавил 0");
        }
        System.out.println(list.size());
        int collumns = list.size() / rows;
        int[][] array = new int[rows][collumns];
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < collumns; j++) {
                if (iterator.hasNext()) {
                    array[i][j] = iterator.next();
                }
            }
        }
        return array;
    }

    /**
     * Главный метод
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            list.add(i);
        }
        ConvertList2Array convertList2Array = new ConvertList2Array();
        int[][] arr = convertList2Array.toArray(list, 3);
        for (int[] a : arr) {
            System.out.println();
            for (int b : a) {
                System.out.print(b);
            }
        }
    }
}