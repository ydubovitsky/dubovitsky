package convert.list.to.array;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells;
        if (list.size() % rows == 0) {
            cells = list.size() / rows;
            System.out.println("Делится без остатка " + cells);
        } else {
            cells = list.size() / rows;
            int result = rows - (list.size() - cells * rows);
            System.out.println("Дополним на " + result);
            for (int i = 0; i < result; i++) {
                list.add(0);
            }
            System.out.println("Делится с остатком " + cells);
        }
        int[][] result = new int[cells][rows];
        int end = 0;
        do {
            for (int i = 0; i < cells; i++) {
                System.out.println();
                for (int j = 0; j < rows; j++) {
                    result[i][j] = list.get(end);
                    System.out.print(list.get(end));
                    end++;
                }
            }
        } while (end < list.size() - 1);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < 53; i++) {
            list.add(i);
        }
        ConvertList2Array convertList2Array = new ConvertList2Array();
        convertList2Array.toArray(list,5);
    }
}