package ru.job4j.array;

public class Turn {
	
	public int[] back(int[] array) {
		int start;
		for(int i = 0; i < array.length / 2; i++) {
			start = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = start;
		}
		return array;
	}
}
			