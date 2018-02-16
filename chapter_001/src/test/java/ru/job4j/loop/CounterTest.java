package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.*;

public class CounterTest {

	 @Test
	 public void addTestDefault() {
	 // создаем объект класса Counter.
	 Counter a = new Counter();
	 // Подсчиываем сумму
	 int result = a.add(0,20);
	 // Задаем ожидаемый результат.
	 double expected = 110;
	 //Проверяем результат и ожидаемое значение.
	 assertThat(result, is(expected));
	 }
	 
	 @Test
	 public void addTest() {
	 // создаем объект класса Counter.
	 Counter a = new Counter(0, 20);
	 // Подсчиываем сумму
	 int result = a.add();
	 // Задаем ожидаемый результат.
	 double expected = 110;
	 //Проверяем результат и ожидаемое значение.
	 assertThat(result, is(expected));
	 }
}