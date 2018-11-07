package list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Класс, отвечающий за тестирование SimpleArrayList.
 */
public class SimpleArrayListTest {

    /**
     * Ссылка на объект тестируемого класса.
     */
    SimpleArrayList<String> simpleArrayList;

    /**
     * Метод выполняется до выполнения всех тестов.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        simpleArrayList = new SimpleArrayList<>();
    }

    /**
     * Метод тестирует сразу добавление и доступ к элементу.
     * @throws Exception
     */
    @Test
    public void whenAddAndGetElementFromList() throws Exception {
        simpleArrayList.add("0");
        simpleArrayList.add("1");
        simpleArrayList.add("2");
        simpleArrayList.add("3");
        simpleArrayList.add("4");
        simpleArrayList.add("5");
        simpleArrayList.add("6");
        simpleArrayList.add("7");
        simpleArrayList.add("8");
        simpleArrayList.add("9");
        simpleArrayList.add("10");
        simpleArrayList.add("11");
        Assert.assertEquals("0", simpleArrayList.get(0));
        Assert.assertEquals("1", simpleArrayList.get(1));
        Assert.assertEquals("11", simpleArrayList.get(11));
    }

    /**
     * Тестируем итератор.
     */
    @Test
    public void iteratorTesting() {
        simpleArrayList.add("0");
        simpleArrayList.add("1");
        simpleArrayList.add("2");
        Iterator iterator = simpleArrayList.iterator();
        Assert.assertEquals("0", iterator.next());
    }

    /**
     * Тест проходит, если выбрасывается исключение при расширении листа.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void iteratorException() {
        Iterator iterator = simpleArrayList.iterator();
        simpleArrayList.add("0");
        iterator.next();
    }
}