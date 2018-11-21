package code.review;

/**
 * Класс описывает аккаунт в аптеке).
 */
public class Account {

    /**
     * Количество лекарств.
     */
    private double values; // Можно сделать приватным

    /**
     * Название лекарства.
     */
    private String reqs; // Можно сделать приватным

    /**
     * Конструктор
     * @param values
     * @param requisites
     */
    public Account(double values, String requisites) {
        this.values = values;
        this.reqs = requisites;
    }

    /**
     * Геттер
     * @return
     */
    public double getValues() {
        return this.values;
    }

    /**
     * Геттер
     * @return
     */
    public String getReqs () {
        return this.reqs;
    }

    /**
     * Метод перевода с аккаунта на аккаунт.
     * @param destination - назначение аккаунта.
     * @param amount - количество.
     * @return
     */
    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 & amount < this.values & destination != null) { // Поставил полные Логические операнды вместо &&, чтобы вычислялись все логические выражения.
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    /**
     * Переопределяем метод из класса Object;
     * Упростил метод, добавил анотацию.
     * @return - Метод возвращает представление объекта в строковом виде.
     */
    @Override
    public String toString() {
        return  "Account{" + "values=" + values + ", reqs='" + reqs + "\\" + "}";
    }

    /**
     * Переопределяем метод equals из класса Object;
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Account)) {
            return false;
        }

        Account account = (Account) o;

        return this.reqs.equals(account.reqs) & this.values == ((Account) o).values; // Поставил полный логический оператор "и".
    }

    /**
     * Переопределяем метод hashCode из класса Object;
     * @return - уникальный hashCode для объекта класса Account.
     */
    public int hashCode() {
        return (int) (this.reqs.hashCode() + this.values);
    }
}