package generic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;

public class SimpleArrayTest {

    /**
     * Пустая ссылка типа SimpleArray.
     */
    private SimpleArray simpleArray;

    /**
     * Ссылке присваивается созданный объект.
     */
    @Before
    public void init() {
        simpleArray = new SimpleArray<Integer>(5);
    }

    /**
     * Проверяем метод добавления элементов в обобщенный массив.
     * @throws Exception
     */
    @Test
    public void add() throws Exception {
        simpleArray.add(1);
        simpleArray.add(2);
        Assert.assertThat(simpleArray.get(0), is(1));
        Assert.assertThat(simpleArray.get(1), is(2));
        // Проверка на null при переполнении
        //Assert.assertNull(simpleArray.get(2));
    }

    /**
     * Изменяем значение элемента в массиве.
     * @throws Exception
     */
    @Test
    public void set() throws Exception {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.set(0, 123456);
        Assert.assertThat(simpleArray.get(0), is(123456));
    }

    /**
     * Метод для тестирования операции удаления.
     * @throws Exception
     */
    @Test
    public void delete() throws Exception {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        simpleArray.delete(4);
        Assert.assertThat(simpleArray.get(1), is(2));
        Assert.assertNull(simpleArray.get(4));
    }

    /**
     * Тестовый-метод проверяющий метод get().
     * @throws Exception
     */
    @Test
    public void get() throws Exception {
        simpleArray.add(1);
        simpleArray.add(2);
        Assert.assertThat(simpleArray.get(0), is(1));
        Assert.assertThat(simpleArray.get(1), is(2));
        // Проверка переполнения
        Assert.assertNull(simpleArray.get(2));
    }

    /**
     * Метод тестирует итератор класса-обертки.
     * @throws Exception
     */
    @Test
    public void iterator() throws Exception {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(10);
        simpleArray.add(11);
        Iterator iterator = simpleArray.iterator();
        Assert.assertThat(iterator.next(), is(1));
        Assert.assertThat(iterator.next(), is(2));
        Assert.assertThat(iterator.next(), is(10));
        Assert.assertThat(iterator.next(), is(11));
    }

    /**
     * Проверка выхода за границы массива.
     * @throws Exception
     */
    @Test(expected = NoSuchElementException.class)
    public void whenIteratorThrowException() throws Exception {
        Assert.assertThat(true, is(simpleArray.iterator().next()));
    }

    /**
     * Проверка, не сдвигает ли указатель метод hasNext().
     */
    @Test
    public void hasNextAndThenNext() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(10);
        simpleArray.add(11);
        Iterator iterator = simpleArray.iterator();
        Assert.assertThat(iterator.next(), is(1));
        Assert.assertThat(iterator.hasNext(), is(true));
        Assert.assertThat(iterator.next(), is(2));
        Assert.assertThat(iterator.next(), is(10));
        Assert.assertThat(iterator.next(), is(11));
        Assert.assertThat(iterator.hasNext(), is(false));
    }
}