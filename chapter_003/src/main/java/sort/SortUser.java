package sort;

import java.util.*;

/**
 * Класс, реализующий сортировку пользователей
 */
public class SortUser {
    /**
     * Метод сортирует пользователей по возрасту.
     * @param list - Лист пользователей для сортировки.
     * @return - отсортированное множество пользователей.
     */
    public Set<User> sort (List<User> list){
        return new TreeSet<User>(list);
    }

    /**
     * Сортирует List<User> по длине имени с использованием локального компаратора.
     * В теле метода мы переопределяем компаратор класса Collections на собственный.
     * @param list
     * @return
     */
    public List<User> sortNameLength (List<User> list) {

        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                int result = 0;
                if (user1.getName().length() > user2.getName().length()) {
                    result = -1;
                } else {
                    result = 1;
                }
                return result;
            }

        });
        return list;
    }

    /**
     * Метод, отвечающий за сортировку сперва по возрасту, затем по имени.
     * В теле метода мы переопределяем компаратор класса Collections на собственный.
     * @return
     */
    public List<User> sortByAllFields (List<User> list) {

        Collections.sort(list, new Comparator<User>() {

            @Override
            public int compare(User user1, User user2) {
                return user1.getAge() - user2.getAge();
            }
        });

        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getName().compareTo(user2.getName());
            }
        });
        return list;
    }
}
