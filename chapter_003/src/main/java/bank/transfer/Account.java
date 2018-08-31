package bank.transfer;

/**
 * Класс аккаунт.
 * @param <T>
 */
public class Account<T> {

    /**
     * Количество денег на счету
     */
    private double value;

    /**
     * Реквизиты счета
     */
    private T requisites;

    public void setValue(double value) {
        this.value = value;
    }

    public void setRequisites(T requisites) {
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public T getRequisites() {
        return requisites;
    }
}
