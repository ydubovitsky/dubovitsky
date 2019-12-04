package ru.job4j;

/**
 * Calculator class
 */
public class Calculator {

	/**
	 * Result of operation
	 */
	private double result;

	/**
	 * Sum of two numbers
	 */
	public void add(double first, double second) {
		this.result = first + second;
	}

	/**
	 * Subtraction
	 */
	public void subtract(double first, double second) {
		this.result = first - second;
	}

	/**
	 * Division
	 */
	public void div(double first, double second) {
		if(second == 0) {
			throw new ArithmeticException("На ноль делить нельзя");
		} else {
			this.result = first / second;
		}
	}

	/**
	 * Multiple
	 */
	public void multiple(double first, double second) {
		this.result = first * second;
	}

	/**
	 * Return result of operations
	 */
	public double getResult() {
		return this.result;
	}
}