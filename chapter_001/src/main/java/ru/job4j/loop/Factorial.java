package ru.job4j.loop;

/*
* @author Dubovitsky Y. (dubovitsky@gmail.com(
* @version 1.0.
*/

public class Factorial {
	
	/* Считаем факториал.
	*
	* Но с двумя return было бы короче:
	*
	* public static int factorial(int n)
    * {
    *    if (n == 0) return 1;
    *    return n * factorial(n-1);
    * }
	*/
	
	public int calc(int n) {
		int factorial;
		if (n == 0) {
			factorial = 1;
		} else {
        factorial = n * calc(n-1);
		}
		return factorial;
	}
}
