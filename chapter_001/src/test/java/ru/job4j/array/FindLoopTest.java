package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
	@Test
	public void whenIndexOfNotFound() {
		// Создаем объект класса FindLoop.
		FindLoop findLoop = new FindLoop();
		int[] ar = {1,2,3,4,5};
		int functionResul = findLoop.indexOf(ar, 3);
		//Сравниваем ожидаемый результат и результат работы функции.
		assertThat(functionResul,is(2));
	}
	@Test
	public void whenIndexOfFound() {
		FindLoop findLoop = new FindLoop();
		int[] ar = {1,2,3,4,5};
		int functionResul = findLoop.indexOf(ar, 3);
		//Сравниваем ожидаемый результат и результат работы функции.
		assertThat(functionResul,is(535));
	}
}
	