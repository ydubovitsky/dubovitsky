package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dubovitsky Y. (y.dubovitsky@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TurnTest {
	@Test
	public void backTurnTrue() {
		Turn turn = new Turn();
		int[] qwe = {1,2,3,4,5,6,7};
		int[] resultArray = turn.back(qwe);
		int[] expectArray = {7654321};
		assertThat(resultArray, is(expectArray));
	}
	@Test
	public void backTurnFalse() {
		Turn turn = new Turn();
		int[] qwe = {1,2,3,4,5,6,7};
		int[] resultArray = turn.back(qwe);
		int[] expectArray = {1234567};
		assertThat(resultArray, is(expectArray));
	}
}