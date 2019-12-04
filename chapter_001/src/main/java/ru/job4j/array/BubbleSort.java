package ru.job4j.array;

/**
 * @author Dubovitsky Y. (y.dubovitsky@gmail.com)
 * @version 1.0
 * @since 0.1
 */
public class BubbleSort {

	/**
	 * Метод реализует "Пузырьковую" сортировку.
	 * @param array - массив, который нужно отсортировать.
	 * @return - отсортированный массив.
	 */
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
			