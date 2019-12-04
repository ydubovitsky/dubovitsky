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

    @Override
    public int hashCode() {
        return 31 * this.name.hashCode() * this.age.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;
        return this.age == user.age && this.name == user.name;
    }
}
