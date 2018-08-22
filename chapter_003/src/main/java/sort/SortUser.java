package sort;

import java.util.*;

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

    /**
     * Метод сортирует по длине имени.
     * @return
     */
    public List<User> sortNameLength (List<User> list) {
        Comparator<User> comparator = new UserCompareNameLength();
        TreeSet<User> set = new TreeSet<>(comparator);
        List<User> resultList = new ArrayList<>();
        resultList.addAll(set);
        return resultList;
    }

    /**
     * Метод сортирует по длине имени, а затем по возрасту.
     * @return
     */
    public List<User> sortByAllFields (List<User> list)  {
        Comparator<User> comparator = new UserCompareNameLength().thenComparing(new UserCompareAllParameters());
        TreeSet<User> set = new TreeSet<>(comparator);
        List<User> resultList = new ArrayList<>();
        resultList.addAll(set);
        return resultList;
    }

    /**
     * Класс, в котором определяется компаратор для сортировки по длине имени.
     */
    class UserCompareNameLength implements Comparator<User> {
        /**
         * Переопределенный компаратор.
         * @param user1
         * @param user2
         * @return
         */
        @Override
        public int compare(User user1, User user2) {
            int value = 0;
            if (user1.getName().length() > user2.getName().length()) {
                value = -1;
            } else {
                value = 1;
            }
            return value;
        }
    }

    /**
     * В данном классе определен компаратор для сортировки по возрасту.
     */
    class UserCompareAllParameters implements Comparator<User> {

        /**
         * Компаратор для сортировки по возрасту.
         * @param user
         * @param user2
         * @return
         */
        @Override
        public int compare(User user, User user2) {
            return user.getAge().compareTo(user2.getAge());
        }
    }
}
