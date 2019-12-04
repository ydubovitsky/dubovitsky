package ru.job4j.array;

/**
 * @author Dubovitsky Y. (y.dubovitsky@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class FindLoop {
	public int indexOf(int[] data, int el) {
		int rsl = -1; // если элемента нет в массиве, то возвращаем -1.
		for (int i = 0; i < data.length; i++) {
			if (data[i] == el) {
				rsl = i;
				break;
			}
		}
		return rsl;
	}
}