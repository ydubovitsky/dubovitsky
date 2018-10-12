package sort;

public class User implements Comparable<User> {
    /**
     * Имя пользователя
     */
    private String name;
    /**
     * Возраст пользователя
     */
    private Integer age;

    /**
     * Публичный конструктор.
     * @param name
     * @param age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Геттер для имени.
     * @return - имя пользователя.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Геттер для возраста.
     * @return
     */
    public Integer getAge() {
        return this.age;
    }

    @Override
    public int compareTo(User user) {
        return age.compareTo(user.age);
    }
}
