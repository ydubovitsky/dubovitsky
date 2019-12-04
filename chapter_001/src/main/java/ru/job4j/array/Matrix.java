package ru.job4j.array;

/**
 * Класс отвечающий за создание матрицы [m]x[n].
 */
public class Matrix {

	/**
	 * Метод, создающий матрицу [m]x[n].
	 * @param size - размер матрицы.
	 * @return
	 */
	public int[][] multiple(int size) {
		int[][] matrix = new int[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				matrix[i][j] = i*j;
			}
		}
		return matrix;
	}
}
				