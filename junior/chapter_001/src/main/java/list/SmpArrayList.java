package list;

import java.util.NoSuchElementException;

public class SmpArrayList<e> {
    private int size;
    private Node<e> first;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(e date) {
        Node<e> newLink = new Node<>(date);
        newLink.previous = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Реализовать метод удаления первого элемент в списке.
     */
    public void delete() {
        if (first != null && size > 0) {
            Node<e> newLink = this.first;
            for (int i = size - 1; i >= 0; i--) {
                newLink = newLink.previous;
                if (i == 1) {
                    newLink.previous = null; // Обнуляем связь с первым элементом.
                    size--;
                }
            }
        } else {
            throw new NoSuchElementException("В листе нет элементов.");
        }
    }

    /**
     * Метод получения элемента по индексу.
     */
    public e get(int index) throws NoSuchElementException {
        Node<e> result = this.first;
        if (index >= size) {
            throw new NoSuchElementException();
        }
        for (int i = size - 1; i != index; i--) {
            result = result.previous;
        }
        return result.date;
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<e> {

        e date;
        Node<e> previous;

        Node(e date) {
            this.date = date;
        }
    }
}

