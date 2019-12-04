package bank.transfer;

import java.util.List;

/**
 * Класс реализующий пользователя.
 */
public class User {

    /**
     * Имя пользователя
     */
    private String name;

    /**
     * Паспортные данные пользователя
     */
    private String pasport;

    /**
     * Список счетов пользователя.
     */
    private List<Account> accounts;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    /**
     * Добавляет аккаунт в список пользовательских аккаунтов.
     * @param account
     */
    public void addAccount(Account account) {
        accounts.add(account);
    }

    /**
     * Возвращает список аккаунтов пользователя.
     * @return
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    public String getPasport() {
        return pasport;
    }

    /**
     * Возвращает сам себя.
     * @return
     */
    public User getUser() {
        return this;
    }
}
