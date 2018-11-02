package generic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    /**
     * Пустая ссылка типа SimpleArray.
     */
    SimpleArray simpleArray;

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
        simpleArray.delete(2);
        Assert.assertThat(simpleArray.get(2), is(4));
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
        Assert.assertThat(true, is(simpleArray.iterator().hasNext()));
        Assert.assertThat(true, is(simpleArray.iterator().hasNext()));
        Assert.assertThat(true, is(simpleArray.iterator().hasNext()));
        Assert.assertThat(false, is(simpleArray.iterator().hasNext()));
    }
}