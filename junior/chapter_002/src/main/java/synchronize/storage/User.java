package synchronize.storage;

/**
 * Класс клиентов банка.
 */
public class User {
    /**
     * Номер пользователя.
     */
    private int id;
    /**
     * Количество денег на счету.
     */
    private int amount;

    /**
     * Конструктор.
     * @param id
     * @param amount
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        return getAmount() == user.getAmount();
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getAmount();
        return result;
    }
}
