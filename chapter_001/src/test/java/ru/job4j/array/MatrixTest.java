package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dubovitsky Y. (y.dubovitsky@gmail.com)
 * @version 1.0
 * @since 0.1
 */

public class MatrixTest {
	@Test
	public void multipleTest() {
		Matrix mtrx = new Matrix();
		int[][] resultArray = mtrx.multiple(2);
		int[][] expectArray = {1,2,2,3};
		assertThat(resultArray, is(expectArray));
	}
}