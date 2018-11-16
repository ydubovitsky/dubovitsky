package map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс модели - это класс, который представляет объект данных,
 * который может использоваться для передачи данных в Java-приложении.
 * Он инкапсулирует прямой доступ к данным в объекте и
 * обеспечивает доступ ко всем данным в объекте с помощью методов getter.

 Даже можно подумать, что класс модели может представлять объекты базы данных
 для доступа к данным с использованием структур ORM.
 */
public class User {

    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Количество детей.
     */
    private int children;

    /**
     * День рождения пользователя.
     */
    private Calendar birthday;

    /**
     * Конструктор
     * @param name
     * @param children
     * @param birthday
     */
    public User(String name, int children, GregorianCalendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

//    /**
//     * Переопределяем метод хэш-код.
//     * Результат, например com.foo.MyType@2f92e0f4, может быть объяснен как:
//     com.foo.MyType - имя класса, то есть класс MyType в пакете com.foo.
//     @ - соединяет строку вместе
//     2f92e0f4 хэш-код объекта.
//     * @return
//     */
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + children;
//        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
//        return result;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (children != user.children) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }

    /**
     * Инициализирующий метод.
     * @param args
     */
    public static void main(String[] args) {
        User user1 = new User("Василий", 45, new GregorianCalendar(1975,
                Calendar.DECEMBER, 31));
        User user2 = new User("Василий", 45, new GregorianCalendar(1975,
                Calendar.DECEMBER, 31));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "1");
        map.put(user2, "2");
        System.out.println(map + " size = " + map.size());
    }
}
