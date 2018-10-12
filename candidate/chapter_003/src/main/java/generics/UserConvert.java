package generics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс конвертации списка в Map.
 */
public class UserConvert {

    /**
     * Метод принимает в себя список пользователей и конвертирует его
     * в Map с ключом Integer id и соответствующим ему User.
     * @param list
     * @return
     */
    public Map<Integer, User> process(List<User> list) {
        Map<Integer, User> map = new HashMap<>();
        for (User user : list) {
            map.put(user.getId(), user);
        }
        return map;
    }
}
