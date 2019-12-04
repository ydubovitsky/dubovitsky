package tracker;

import java.util.*;
import java.util.function.Predicate;

/**
 * Класс Трекер.
 * Содержит в себе методы по обработке заявок.
 */
public class Tracker implements ITracker{

    /**
     * Максимальное количество заявок в трекере.
     */
    private Item[] items = new Item[100];

    /**
     * Число заявок в трекере в текущий момент.
     */
    private int position = 0;

    /**
     * @param item
     * @return
     */
    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    /**
     * Генерируем id случайным образом
     * @return
     */
    private int generateId() {
        Date date = new Date();
        return (int) (date.hashCode() / (Math.random() * -100));
    }

    /**
     * Редактирование заявок.
     Ищем в массиве объектов items заявку по ключу, если нашли, то присваиваем ей новый сгенерированный ключ
     и досрочно выходим из цикла.
     * @param id
     * @param item
     */
    public void replace(int id, Item item) {
        for (int i = 0; i < items.length; i++) {
            if (id == items[i].getId()) {
                item.setId(id);
                items[i] = item;
                break;
            }
        }
    }

    /**
     * Удаляем заявку из трекера.
     * @param id
     */
    public void delete(int id) {
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getId() == id) {
                System.arraycopy(items, index + 1, items, index, items.length - index - 1);
                position--;
                break;
            }
        }
    }

    /**
     * Производим поиск всех заявок в трекере.
     * @return
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Производим поиск заявки в трекере по имени заявки.
     * Сперва вчисляется количество заявок с одинаковыми именами, затем создается массив длинной равной
     * количеству этих заявок.
     * Затем этот массив заполняется этими заявками и возвращается.
     * Метод возвращает массив заявок с одинаковыми именами.
     *
     * В методе используются lambda-выражения на основе функционального встроенного интерфейса Predicate<Item>.
     * predicate.test(items[j])
     * @param key
     * @return
     */
    public Item[] findByName(String key) {
        int arrayLength = 0;
        for(int i = 0; i < position; i++) {
            Predicate<Item> predicate = (Item itm) -> key.equals(itm.getName());
            if (predicate.test(items[i])) {
                arrayLength++;
            }
        }
        Item[] resultArray = new Item[arrayLength];
        for(int j = 0; j < arrayLength; j++) {
            Predicate<Item> predicate = (Item itm) -> key.equals(itm.getName());
            if (predicate.test(items[j])) {
                resultArray[j] = items[j];
                j++;
            }
        }
        return resultArray;
    }

    /**
     * Функция производит поиск заявки по id.
     * В функции используется lambda-выражение c применением предопределенного функционального интерфейса Predicate<T>.
     * @param id
     * @return
     * @throws MenuOutException
     */
    public Item findById(int id) throws MenuOutException {
        Item item = new Item();
        for (int i = 0; i < position; i++) {
            Predicate<Item> predicate = (itm) -> id == itm.getId();
            if (predicate.test(items[i])) {
                item = items[i];
                break;
            }
        }
        return item;
    }
}