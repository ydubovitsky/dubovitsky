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
        for (int i = 0; i < this.items.length; i++) {
            if (id == this.items[i].getId()) {
                // Заменяем найденный по id элемент на элементы переданный в функцию.
                // По идее тут нужно либо клонировать объект, а лучше делать серриализацию,
                // но пока я не знаю как это делать, поэтому напишу так:
                this.items[i].setName(item.getName());
                break;
            }
        }
	}

	public void delete(int id) {
        for (int i = 0; i < this.items.length; i++) {
            if (id == this.items[i].getId()) {
                System.arraycopy(this.items, i + 1, this.items, i, 100 - i);
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