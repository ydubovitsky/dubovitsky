package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;

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
        int[] result = sq.calculate(3);
        int[] expected = {1, 4, 9}
        assertThat(result, is(expected));
    }
}