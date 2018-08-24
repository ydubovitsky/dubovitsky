package ru.job4j.array;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dubovitsky Y. (y.dubovitsky@gmail.com)
 * @version 1.0
 * @since 0.1
 */

public class BubbleSortTest {

    BubbleSort bs;

    @Before
    public void initVariable() {
        bs = new BubbleSort();
    }

    @Test
    public void sortTestLuck() {
        int[] qwe = {9, 8, -3, 0, 7, 6, 5, 0, 4, 3, 2, 1};
        int[] resultArray = bs.sort(qwe);
        int[] expectArray = {-3, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(resultArray, is(expectArray));
    }

    @Test
    public void sortTestFail() {
        int[] qwe = {9, 8, -3, 0, 7, 6, 5, 0, 4, 3, 2, 1};
        int[] resultArray = bs.sort(qwe);
        int[] expectArray = {0, -3, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(resultArray, is(expectArray));
    }
}