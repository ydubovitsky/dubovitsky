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
     * @param list
     * @return
     */
    public List<User> sortNameLength (List<User> list) {
        /**
         * Локальный класс Компаратора.
         */
        class LocalComparator implements Comparator<User> {

            /**
             * Переопределенный компаратор.
             * @param user1
             * @param user2
             * @return
             */
            public int compare(User user1, User user2) {
                int result = 0;
                if (user1.getName().length() > user2.getName().length()) {
                    result = -1;
                } else {
                    result = 1;
                }
                return result;
            }
        }
        List<User> sorted = new ArrayList<>();
        TreeSet<User> treeSet = new TreeSet<>(new LocalComparator());
        treeSet.addAll(list);
        sorted.addAll(treeSet);
        return sorted;
    }

    /**
     * Метод, отвечающий за сортировку сперва по возрасту, затем по имени.
     * @return
     */
    public List<User> sortByAllFields (List<User> list) {
        /**
         * Класс реализующий локальный компаратор.
         */
        class LocalComparator implements Comparator<User> {

            /**
             * Сортировка по возрасту.
             * @param user1
             * @param user2
             * @return
             */
            @Override
            public int compare(User user1, User user2) {
                return user1.getAge() - user2.getAge();
            }
        }

        /**
         * Еще один компаратор.
         */
        class ElseOneLocalComparator implements Comparator<User> {

            /**
             * Реализует сортировку по имени в лексикографическиом порядке
             * @param user1
             * @param user2
             * @return
             */
            public int compare(User user1, User user2) {
                return user1.getName().compareTo(user2.getName());
            }
        }
        List<User> sorted = new ArrayList<>();
        TreeSet<User> treeSet = new TreeSet<>(new ElseOneLocalComparator().thenComparing(new LocalComparator()));
        treeSet.addAll(list);
        sorted.addAll(treeSet);
        return sorted;
    }
}
