package list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.Assert.*;

public class DynamicСontainerBasedOnLinkedListTest {

    DynamicСontainerBasedOnLinkedList container;

    @Before
    public void setUp() throws Exception {
        container = new DynamicСontainerBasedOnLinkedList();
        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);
        container.add(5);
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(1, container.get(0));
        Assert.assertEquals(5, container.get(4));
    }

    /**
     * Тестируем метод удаляющий любой элемент по индексу из связного списка.
     */
    @Test
    public void delete() {
        container.delete(4);
        Assert.assertEquals(4, container.get(3));
        container.delete(0);
        Assert.assertEquals(2, container.get(0));
        container.add(12345); // Размер увеличился на 1
        container.delete(2);
        Assert.assertEquals(12345, container.get(2));
    }

    @Test
    public void iterator() throws Exception {
        Iterator iterator = container.iterator();
        Assert.assertEquals(1, iterator.next());
        Assert.assertEquals(2, iterator.next());
        iterator.next();
        iterator.next();
    }

    /**
     * Когда список притерпевает изменения, итератор выкидывает исключение.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorThrowException() {
        Iterator iterator = container.iterator();
        container.add(6);
        iterator.next();
    }
}