package sort.compare.string;

import java.util.Comparator;

/**
 * Класс реализует сравнение строк.
 */
public class ListCompare implements Comparator<String> {

    /**
     * Сперва вычисляется длина наименьшего слова, затем идет цикл сравнения
     * двух слов;
     * Если наименьшее слово полность входит в более длинное слово, то
     * как результат возвращается -1.
     * @param left - первое сравниваемое слово.
     * @param right - второе сравниваемое слово.
     * @return - 0 - если слов равны; -1 если слово left < right; 1 если right > left;
     */
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int size = left.length() < right.length() ? left.length() : right.length();
        for (int i = 0; i < size; i++) {
            if (left.charAt(i) < right.charAt(i)) {
                result = -1;
                break;
            }
            if (left.charAt(i) > right.charAt(i)) {
                result = 1;
                break;
            }
        }
        if (left.length() < right.length() && result == 0) {
            result = -1;
        }
        return result;
    }
}