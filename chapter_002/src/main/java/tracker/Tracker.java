package tracker;

import java.util.*;

/**
 *
 */
public class Tracker {

    /**
     * Максимальное количество заявок в трекере.
     */
    private Item[] items = new Item[100];

    /**
     * Число заявок в трекере в текущий момент.
     */
    private int position = 0;

    /**
     *
     * @param item
     * @return
     */
	public Item[] add(Item item) {
		item.setId(generateId());
		items[position++] = item;
		return items;
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
     * @param key
     * @return
     */
    public Item[] findByName(String key) {
        int arrayLength = 0;
        for(int i = 0; i < position; i++) {
            if (key.equals(items[i].getName())) {
                arrayLength++;
            }
        }
        Item[] resultArray = new Item[arrayLength];
        for(int j = 0; j < arrayLength; j++) {
            if (key.equals(items[j].getName())) {
                resultArray[j] = items[j];
                j++;
            }
        }
        return resultArray;
	}

    /**
     * Производим поиск по id
     * @param id
     * @return
     */
    public Item findById(int id) {
        Item item = null;
        for(int i = 0; i < position; i++) {
            if(id == items[i].getId()) {
                item = items[i];
                break;
            }
        }
        return item;
    }
}