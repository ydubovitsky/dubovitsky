package Tracker;

import java.util.*;
import java.util.Arrays;

public class Tracker {

    private Item[] items = new Item[100];
    private int position = 0;

	/*
	Добавление заявки с уникальным ID.
	 */
	public Item[] add(Item item) {
		item.setId(generateId());
		items[position++] = item;
		return items;
	}

    /*
    Генерируем уникальный ID.
     */
	private int generateId() {
		Date date = new Date();
		int random = (int) (date.hashCode() / (Math.random() * -100));
		return random;
	}

	/*
	Редактирование заявок.
	Ищем в массиве объектов items заявку по ключу, если нашли, то присваиваем ей новый сгенерированный ключ
	и досрочно выходим из цикла.
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

    public void delete(int id) {
        Item[] result = new Item[items.length];
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getId() == id) {
                System.arraycopy(items, 0, result, 0, index);
                System.arraycopy(items, index + 1, result, index, items.length - index - 1);
                items = result;
                position--;
                break;
            }
        }
    }

	/*
	Возвращает копию массива, именно копию а не ссылку на тот же массив.
	 */
	public Item[] findAll() {
        Item[] findAllItems = Arrays.copyOf(items, position);
        return findAllItems;
	}

	/*
    Получение списка элементов с одинаковым именем.
	 */
	public ArrayList<Item> findByName(String key) {
        ArrayList<Item> resultArray = new ArrayList<>();
        for(int i = 0, j = 0; i < position; i++) {
            if (key.equals(items[i].getName())) {
                resultArray.add(items[i]);
                j++;
            }
        }
        return resultArray;
	}

	public Item findById(int id) {
	    int i = 0;
        for( ; i < position; i++) {
            if(id == items[i].getId()) {
                break;
            }
        }
        return items[i];
	}
}