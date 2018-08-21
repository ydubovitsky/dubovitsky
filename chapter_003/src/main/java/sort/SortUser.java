package sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Класс, реализующий сортировку пользователей.
 */
public class SortUser {
    /**
     * Метод сортирует пользователей по возрасту.
     * @param list - Лист пользователей для сортировки.
     * @return - отсортированное множество пользователей.
     */
    public Set<User> sort (List<User> list){
        TreeSet resultSet = new TreeSet<>();
        resultSet.addAll(list);
        return resultSet;
    }
}
