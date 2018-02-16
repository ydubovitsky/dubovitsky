package ru.job4j.loop;

/*
* @author Dubovitsky Y. (dubovitsky@gmail.com).
* @varsion 1.0.
*/

public class Counter {
	/*
	* Значения по умолчанию.
	*/	
	int start = 0;
	int finish = 0;
	
	/*
	* Конструктор класса.
	*/
	
	public Counter(a, finish) {
		start = a;
		this.finish = finish;
	}
	
	/*
	* Перегруженный метод
	*/
	
	public int add() {
		int sum = 0;
		for(int i = this.start; i < this.finish; i++) {
			if((i % 2) == 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	/*
	* Метод подсчиывает сумму четных значений в диапазоне от start да finish.
	*/
	
	public int add(int start, int finish) {
		int sum = 0;
		for(int i = start; i < finish; i++) {
			if((i % 2) == 0) {
				sum += i;
			}
		}
		return sum;
	}
}