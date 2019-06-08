package synchronize.storage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Класс хранилище клиентов банка.
 */
@ThreadSafe
public class UserStorage {

    /**
     * Хранилище пользователей;
     */
    @GuardedBy("this")
    private Map<Integer, User> map = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в хранилище.
     * @param user - пользователь.
     * @return - true, если пользователь добавлен.
     */
    synchronized boolean add (User user) {
        int before = map.size();
        map.put(user.getId(), user);
        return before < map.size();
    }

    /**
     * Обновляем данные пользователя по id, если такой id существует.
     * @param user
     * @return
     */
    synchronized boolean update(User user) {
        boolean result = false;
        Set<Integer> keySet = this.map.keySet(); // Находим множество всех ключей.
        if (keySet.contains(user.getId())) { // Если пользователь с таким id существует, производим замену.
            User before = map.get(user.getId());
            map.replace(user.getId(), user);
            result = !before.equals(map.get(user.getId()));
        }
        return result;
    }

    /**
     * Удаляем пользователя
     * @param user
     * @return
     */
    synchronized boolean delete(User user){
        int before = map.size();
        if (map.size() > 0) {
            map.remove(user.getId());
        }
        return before > map.size();
    }

    /**
     * Выполняем перевод, если достаточно средств.
     * @param fromId
     * @param toId
     * @param amount
     */
    synchronized void transfer(int fromId, int toId, int amount) {
        User from = map.get(fromId);
        User to = map.get(toId);
        if (from.getAmount() >= amount) {
            from.setAmount(from.getAmount() - amount);
            to.setAmount(to.getAmount() + amount);
            this.update(from);
            this.update(to);
        }
    }
}
