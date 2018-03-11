package Tracker;

import java.util.*;
import java.util.Arrays;
import java.lang.System;

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
	Генерирование уникального ID.
	 */
	private int generateId() {
		Date date = new Date();
		int random = (int) (Math.random() * date.getTime());
		return random;
	}

	/*
	Редактирование заявок.
	Ищем в массиве объектов items заявку по ключу, если нашли,
	то присваиваем items новый объект переданный в функцию
	и досрочно выходим из цикла.
	 */
	public void replace(int id, Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (id == this.items[i].getId()) {
                // теперь обе переменые ссылаются на один и тотже объект!
                this.items[i] = item;
                break;
            }
        }
	}

	public void delete(int id) {
        for (int i = 0; i < this.items.length; i++) {
            if (id == this.items[i].getId()) {
                System.arraycopy(this.items, i + 1, this.items, i, 99 - i);
                break;
                }
            }
        }

	/*
	Возвращает копию массива, именно копию, а не ссылку на тот же массив.
	 */
	public Item[] findAll() {
        Item[] findAllItems = Arrays.copyOf(this.items, this.items.length);
        return findAllItems;
	}

	/*
	Сделать потом рефакторинг:
	Сперва вычисляем длинну результирущего массива, затем уже заносим элементы в новый массив.
	 */
	public Item[] findByName(String key) {
        Item[] resultArray = new Item[100];
        int k = 0;
        for(int i = 0; i < 99; i++) {
            if (key.equals(this.items[i].getName())) {
                resultArray[k] = this.items[i];
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