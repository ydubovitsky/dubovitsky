package ru.job4j.array;

/**
 * Массив заполнен true или false.
 */
public class Check {

    /**
     * Метод должен проверить, что все элементы в массиве являются true или false.
     * @param data - входной массив boolean;
     * @return - true, если массив весь состоит из true; иначе false;
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] != data[i+1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
