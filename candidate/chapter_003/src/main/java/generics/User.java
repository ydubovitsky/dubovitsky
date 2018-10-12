package generics;

/**
 * Класс пользователь.
 */
public class User {
    /**
     * id пользователя.
     */
    private int id;

    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Город пользователя.
     */
    private String city;

    /**
     * Конструктор класса.
     * @param id
     * @param name
     * @param city
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Геттер для id
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Геттер для Имени пользователя.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Геттер для города пользователя.
     * @return
     */
    public String getCity() {
        return city;
    }
}
