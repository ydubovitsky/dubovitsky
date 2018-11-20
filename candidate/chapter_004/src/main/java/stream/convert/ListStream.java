//package stream.listToArrayStream;
//
//import java.util.List;
//import java.util.Stream.Collectors;
//import java.util.Stream.Stream;
//
//public class ListStream {
//    public int[][] listToArray(List<Integer> list, int rows) {
//        while (list.size() % rows != 0) {
//            list.add(0);
//        }
//        int collumns = list.size() % rows  == 0 ? list.size() / rows : list.size() / rows + 1;
//        int[][] array = new int[rows][collumns];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < collumns; j++) {
//                array[i][j] = list.Stream().limit()
//            }
//        }
//    }
//}