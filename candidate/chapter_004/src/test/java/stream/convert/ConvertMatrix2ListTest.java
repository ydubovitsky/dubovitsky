//package stream.convert;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//
//public class ConvertMatrix2ListTest {
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @Test
//    public void toList() {
//        int[] expected = new int[]{1, 2, 2, 6, 3};
//        ConvertMatrix2List convertMatrix2List = new ConvertMatrix2List();
//        int[][] matrixB = {
//                {-9, 1, 0},
//                {4, 1, 1},
//                {-2, 2, -1}
//        };
//        Assert.assertArrayEquals(expected, convertMatrix2List.toList(matrixB));
//    }
//}