package Tracker;

import java.util.*;
import java.util.Arrays;

public class Tracker {

    private Item[] items = new Item[100];
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public Item[] getItems() {
        return items;
    }

	/*
	Добавление заявки с уникальным ID.
	 */
	public Item add(Item item) {
		item.setId(generateId());
		items[position++] = item;
		return items[position];
	}

    /*
    Генерируем уникальный ID.
     */
	private int generateId() {
		Date date = new Date();
		int random = (int) (Math.random() * date.getTime());
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
                items[i] = item;
                break;
            }
        }
	}

	public void delete(int id) {
	    for (int i = 0; i < position; i++) {
	        if (items[i].getId() == id) {
	            // Будет скопировано (position - i) элементов из массива-источника items в результирующий массив items,
                // начиная с i + 1 индекса источника во i индекс результирующего массива.
                System.arraycopy(items, i + 1, items, i,position - i);
                items[position] = null;
            } else {
                System.out.println(id + " не найден.");
            }
        }
    }

	/*
	Возвращает копию массива, именно копию а не ссылку на тот же массив.
	 */
	public Item[] findAll() {
        Item[] findAllItems = Arrays.copyOf(items, items.length);
        return findAllItems;
	}

	/*
    Получение списка элементов с одинаковым именем.
	 */
	public Item[] findByName(String key) {
        Item[] resultArray = new Item[position];
        for(int i = 0, j = 0; i < position; i++) {
            if (key.equals(items[i].getName())) {
                resultArray[j] = items[i];
                j++;
            }
        }
        return resultArray;
	}

	public Item findById(int id) {
	    int i = 0;
        for( ; i < items.length; i++) {
            if(id == items[i].getId()) {
                break;
            }
        }
        return items[i];
	}
}