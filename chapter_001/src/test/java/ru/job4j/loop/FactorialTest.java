package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.*;

public class FactorialTest {

	 @Test
	 public void calcZeroTest() {
	 // создаем объект класса Factorial.
	 Factorial a = new Factorial();
	 // Подсчиываем Факториал
	 int result = a.calc(0);
	 // Задаем ожидаемый результат.
	 double expected = 1;
	 //Проверяем результат и ожидаемое значение.
	 assertThat(result, is(expected));
	 }
	 
	 @Test
	 public void calcTest() {
	 // создаем объект класса Factorial.
	 Factorial a = new Factorial();
	 // Подсчиываем Факториал
	 int result = a.calc(10);
	 // Задаем ожидаемый результат.
	 double expected = 3 628 800
	 //Проверяем результат и ожидаемое значение.
	 assertThat(result, is(expected));
	 }
}