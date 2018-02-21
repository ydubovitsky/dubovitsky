package ru.job4j.array;

/**
 * @author Dubovitsky Y. (y.dubovitsky@gmail.com)
 * @version 1.0
 * @since 0.1
 */

public class BubbleSort {
	
	//public static void main(String[] args) {
	//	BubbleSort bs = new BubbleSort();
	//	int[] mas = {9,8,-3,0,7,6,5,0,4,3,2,1};
	//	int[] qwe = bs.sort(mas);
	//	for(int i = 0; i < qwe.length; i++) {
	//		System.out.print(qwe[i]);
	//	}
	//}		
	
	public int[] sort(int[] array) {
		for(int j = 0; j < array.length - 1; j++) {
			for(int i = 0; i < array.length - 1; i++) {
				int variable = array[i + 1];
				if(array[i] > array[i+1]) {
					array[i+1] = array[i];
					array[i] = variable;
				}
			}
		}
		return array;
	}
}
			