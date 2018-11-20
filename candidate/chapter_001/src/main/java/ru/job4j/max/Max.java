package ru.job4j.max;

public class Max {
	
	public int max(int first, int second) {
		int max;
		max = first > second ? first : second;
		return max;
	}
	
	/*
	* 1. Метод должен возвращать максимум из трех чисел
	* 2. В этом методе надо использовать только другой метод
	* 3. В этом методе не должно быть if или тернарного оператора.
	*/
	
	public int max(int first, int second, int third) {
		int maxOne = max(first, second);
		int maxTwo = max(maxOne, third);
		return maxTwo;
	}
}