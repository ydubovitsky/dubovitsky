package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SquareTest {
	
/**
 *
 * @author Dubovitsky
 * @version $Id$
 * @since 0.1
 */

    @Test
    public void calculateTest() {
        Square sq = new Square();
        int[] result = sq.calculate(5);
        int[] expected = {0, 1, 4, 9, 16};
        assertThat(result, is(expected));
    }
}