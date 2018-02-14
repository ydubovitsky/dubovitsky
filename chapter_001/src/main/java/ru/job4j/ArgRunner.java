package ru.job4j;

class ArgRunner {
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.add(123,54);
		calculator.getResult();
		calculator.div(51,0);
		calculator.getResult();
		calculator.div(124,124);
		calculator.getResult();
	}
}