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
    String name;

    /**
     * Количество детей.
     */
    int children;

    /**
     * День рождения пользователя.
     */
    Calendar birthday;

    public User(String name, int children, GregorianCalendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("Василий", 45, new GregorianCalendar(1975,
                Calendar.DECEMBER, 31));
        User user2 = new User("Василий", 45, new GregorianCalendar(1975,
                Calendar.DECEMBER, 31));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "1");
        map.put(user2, "2");
        System.out.println(map);
    }
}
