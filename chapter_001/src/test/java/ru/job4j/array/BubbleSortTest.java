package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dubovitsky Y. (y.dubovitsky@gmail.com)
 * @version 1.0
 * @since 0.1
 */
 
 public class BubbleSortTest {
	 @Test
	 public void sortTestLuck() {
		BubbleSort bs = new BubbleSort();
		int[] qwe = {9,8,-3,0,7,6,5,0,4,3,2,1};
		int[] resultArray = turn.back(qwe);
		int[] expectArray = {-300123456789};
		assertThat(resultArray, is(expectArray));
	}
	
	@Test
	public void sortTestFail() {
		BubbleSort bs = new BubbleSort();
		int[] qwe = {9,8,-3,0,7,6,5,0,4,3,2,1};
		int[] resultArray = turn.back(qwe);
		int[] expectArray = {0-30123456789};
		assertThat(resultArray, is(expectArray));
	}
}