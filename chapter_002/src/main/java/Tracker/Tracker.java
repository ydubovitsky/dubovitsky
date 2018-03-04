package Tracker;

import java.util.*;

public class Tracker {

    private Item[] items = new Item[100];
	private int position = 0;

    public Item[] getItems() {
        return items;
    }

	// Добавление заявки с уникальным ID.
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items[this.position++] = item;
		return item;
	}

	private int generateId() {
		Date date = new Date();
		int random = (int) (Math.random() * date.getTime());
		return random;
	}
	/*
	Редактирование заявок.
	Ищем в массиве объектов items заявку по ключу, если нашли, но присваиваем ей новый сгенерированный ключ
	и досрочно выходим из цикла.
	 */
	public void replace(int id, Item item) {
        for (Item item1 : items) {
            if (id == item1.getId()) {
                item.setId(this.generateId());
                break;
            }
        }
	}

	/*
    Создаем копию исходного массива, ищем в цикле совпадение id, если находим то пропускаем элемент массива
    под индексом i за счет смещения, т.е. увеличения индекса i на 1, таким образом мы пропускаем найденный нами
    элемент в исходном массиве, и копируем 100 - i оставшихся значений, элемент массива под индексом 100 мы заполняем
    значением null, так как 1 элемент был удален.
	 */
	public void delete(int id) {
        for(int i = 0; i < items.length; i++) {
            if (id == items[i].getId()) {
                System.arraycopy (items, i, items, i + 1, 100 - i);
                items[100] = null;
                break;
            }
        }
	}

	// Возвращает копию массива, именно копию а не ссылку на тот же массив.
	public Item[] findAll() {
        Item[] findAllItems = Arrays.copyOf(items, items.length);
        return findAllItems;
	}

	/*
	Сперва вычисляем длинну результирущего массива, затем уже заносим ИМЯ совпавшего элемента в новый массив.
	 */
	public Item[] findByName(String key) {
	    int length = 0;
        for(int i = 0; i < items.length; i++) {
            if(key == items[i].getName()) {
                length++;
            }
        }
        Item[] resultArray = new Item[length];
        int k = 0;
        for (Item item : items) {
            if (key.equals(item.getName())) {
                resultArray[k].setName(item.getName());
                k++;
            }
        }
        return resultArray;
	}

	public Item findById(int id) {
	    int findId = 0;
        for(int i = 0; i < items.length; i++) {
            if(id == items[i].getId()) {
                findId = i;
                break;
            }
        }
        return items[findId];
	}
}