package ru.job4j.max;

public class Max {
	
	public int max(int first, int second) {
		int max;
		max = first > second ? first : second;
		return max;
	}
}