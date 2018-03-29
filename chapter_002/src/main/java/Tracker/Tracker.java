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
        return this.items;
    }

	/*
	Добавление заявки с уникальным ID.
	 */
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items[this.position++] = item;
		return this.items[position];
	}

    /*
    Генерируем уникальный ID.
     */
	private int generateId() {
		Date date = new Date();
		int random = (int) (Math.random() * date.hashCode());
		return random;
	}
	/*
	Редактирование заявок.
	Ищем в массиве объектов items заявку по ключу, если нашли, но присваиваем ей новый сгенерированный ключ
	и досрочно выходим из цикла.
	 */
	public void replace(int id, Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (id == this.items[i].getId()) {
                this.items[i].setName(item.getName());
                break;
            }
        }
	}

	public void delete(int id) {
	    for (int i = 0; i < this.position; i++) {
	        if (this.getItems()[i].getId() == id) {
	            for (int j = i; j < this.position - 1; j++) {
	                this.getItems()[j] = this.getItems()[j + 1];
                }
                this.getItems()[this.position] = null;
                break;
            }
        }
    }

	/*
	Возвращает копию массива, именно копию а не ссылку на тот же массив.
	 */
	public Item[] findAll() {
        Item[] findAllItems = Arrays.copyOf(this.items, this.items.length);
        return findAllItems;
	}

	/*
	Сперва вычисляем длинну результирущего массива, затем уже заносим ИМЯ совпавшего элемента в новый массив.
	P/s Нужно сделать потом рефакторинг.
	 */
	public Item[] findByName(String key) {
	    int length = 0;
        for(int i = 0; i < 100; i++) {
            if (key.equals(this.items[i].getName())) {
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
	    int i = 0;
        for( ; i < this.items.length; i++) {
            if(id == this.items[i].getId()) {
                break;
            }
        }
        return this.items[i];
	}
}