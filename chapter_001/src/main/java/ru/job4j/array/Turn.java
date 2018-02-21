package ru.job4j.array;

public class Turn {
	
	//public static void main(String[] args) {
		//Turn turn = new Turn();
		//int[] qwe = {1,2,3,4,5,6,7};
		//turn.back(qwe);
		//for(int i = 0; i < qwe.length; i++) {
		//	System.out.print(qwe[i]);
		//}
	//}
	
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
			