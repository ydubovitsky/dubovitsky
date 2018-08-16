package convert.list.to.array;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования.
 */
public class ConvertList2ArrayTest {
    /**
     * Создание объекта тестируемого класса.
     */
    ConvertList2Array list = new ConvertList2Array();

    /**
     * 
     */
    @Test
    public void when7ElementsThen9() {
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0 ,0}
        };
        assertThat(result, is(expect));
    }

    /**
     * Тест, проверяющий конвертацию Листа массивов в Лист.
     */
    @Test
    public void convertListOfArraysToOneList() {
        List<int[]> listR = Arrays.asList(new int[]{1, 2}, new int[]{3, 4, 5, 6});
        List<Integer> result = list.convert(listR);
        List<Integer> expect = Arrays.asList(1,2,3,4,5,6);
        assertThat(result, is(expect));
    }
}