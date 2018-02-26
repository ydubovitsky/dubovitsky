package ru.job4j.array;

public class Matrix {
	
	//public static void main(String[] args) {
	//	Matrix mtrx = new Matrix();
	//	System.out.print(mtrx.multiple(9));
	//}
	
	public int[][] multiple(int size) {
		int[][] qwer = new int[size + 1][size + 1];
		//StringBuilder screen = new StringBuilder();
		for(int i = 1; i < size + 1; i++) {
			for(int j = 1; j < size + 1; j++) {
				//screen.append(i*j + " ");
				qwer[i][j] = i*j;
				//System.out.print(i*j + " ");
			}
			//screen.append(System.lineSeparator());
			//System.out.println();
		}
		//System.out.println(screen.toString());
		return qwer;
	}
}
				