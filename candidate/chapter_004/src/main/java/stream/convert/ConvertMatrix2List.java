//package stream.convert;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Stream.Collectors;
//
///**
// * Класс, отвечающий за конвертацию двумерного массива в коллекцию  - list.
// */
//public class ConvertMatrix2List {
//    /**
//     * Метод, конвертирующий двумерный массив в список.
//     * @param array - двумерный массив.
//     * @return
//     */
//    public ArrayList<int[]> toList(int[][] array) {
//        ArrayList<int[]> list = Arrays.Stream(array).collect(Collectors.toCollection(ArrayList::new));
//        ArrayList<Integer> ret = list.Stream().
//    }
//
//    public static void main(String[] args) {
//        ConvertMatrix2List convertMatrix2List = new ConvertMatrix2List();
//        ArrayList<int[]> list= convertMatrix2List.toList(new int[][]{{-9, 1, 0},
//                {4, 1, 1},
//                {-2, 2, -1}});
//        for (int[] a : list) {
//            System.out.println("Новый массив");
//            for(int b : a) {
//                System.out.print(b);
//            }
//        }
//    }
//}