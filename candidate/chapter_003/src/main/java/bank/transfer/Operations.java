package bank.transfer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Operations {

    /**
     * Ассоциативный массив пользователей и списка их аккаунтов.
     */
    private Map<User, List<Account>> maps;

    /**
     * Добавление пользователя.
     * @param user
     */
    public void addUser(User user) {
        maps.put(user, user.getAccounts());
    }

    /**
     * Удаление пользователя.
     * @param user
     */
    public void deleteUser(User user) {
        maps.remove(user);
    }

    /**
     * Добавить счёт пользователю.
     * Пробегаемся по ассоциативному массиву, ищем пользователя с заданными паспортными данными;
     * Если пользователя находим, то добавляем ему еще 1 аккаунт.
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
        for(Map.Entry<User, List<Account>> entry : maps.entrySet()) {
            if (entry.getKey().getPasport() == passport) {
                entry.getKey().addAccount(account);
            }
        }
    }

    /**
     * Удалить один счёт пользователя.
     * Пробегаемся по ассоциативному массиву, ищем пользователя с заданными паспортными данными;
     * Если пользователя находим, то ищем есть ли у него такой аккаунт;
     * Если аккаунт есть, то удаляем его.
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for(Map.Entry<User, List<Account>> entry : maps.entrySet()) {
            if (entry.getKey().getPasport() == passport) {
                for (Account ac : entry.getKey().getAccounts()) {
                    if (ac == account) {
                        entry.getKey().getAccounts().clear();
                    }
                }
            }
        }
    }

    /**
     * Получить список счетов для пользователя.
     * @param passport
     * @return
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> list = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : maps.entrySet()) {
            if (entry.getKey().getPasport() == passport) {
                list = entry.getKey().getAccounts();
                break;
            }
        }
        return list;
    }


    /**
     * Метод для перечисления денег с одного счёта на другой счёт;
     * Сперва находим пользователей в map, кто кому посылает деньги.
     * Затем ищем их счета, и уже проводим операцию перевода.
     * @param srcPassport - Паспортные данные отправителя
     * @param srcRequisite - Счет отправителя
     * @param destPassport - Паспортные данные получателя
     * @param dstRequisite - Счет получателя
     * @param amount - Сумма перевода.
     * @return
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean transfer = false;
        User sender = null;
        User recipient = null;
        Account accountSender = null;
        Account accountRecipient = null;
        for (Map.Entry<User, List<Account>> entry : maps.entrySet()) {
            if (entry.getKey().getPasport() == srcPassport) {
                sender = entry.getKey();
            } if (entry.getKey().getPasport() == destPassport) {
                recipient = entry.getKey();
            }
        }
        for (Account account : sender.getAccounts()) {
            if (account.getRequisites() == srcRequisite) {
                accountSender = account;
            } if (account.getRequisites() == dstRequisite) {
                accountRecipient = account;
            }
        }
        if (amount <= accountSender.getValue()) {
            accountSender.setValue(accountSender.getValue() - amount);
            transfer = true;
        } else {
            System.out.println("Недостаточно средств на счете!");
        }
        return transfer;
    }
}

