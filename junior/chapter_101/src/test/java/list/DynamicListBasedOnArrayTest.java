package list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс, отвечающий за тестирование SimpleArrayList.
 */
public class DynamicListBasedOnArrayTest {

    /**
     * Ссылка на объект тестируемого класса.
     */
    DynamicListBasedOnArray<String> dynamic;

    /**
     * Метод выполняется до выполнения всех тестов.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        dynamic = new DynamicListBasedOnArray<>();
        dynamic.add("0");
        dynamic.add("1");
        dynamic.add("2");
        dynamic.add("3");
        dynamic.add("4");
        dynamic.add("5");
        dynamic.add("6");
        dynamic.add("7");
        dynamic.add("8");
        dynamic.add("9");
        dynamic.add("10");
        dynamic.add("11");
    }

    /**
     * Метод тестирует сразу добавление и доступ к элементу.
     * @throws Exception
     */
    @Test
    public void whenAddAndGetElementFromList() throws Exception {
        Assert.assertEquals("0", dynamic.get(0));
        Assert.assertEquals("1", dynamic.get(1));
        Assert.assertEquals("11", dynamic.get(11));
    }

    /**
     * Тестирует попытку обратиться к несуществующему элементу (Тест Переполнения).
     * @throws NoSuchMethodException
     */
    @Test(expected = NoSuchElementException.class)
    public void whenTryGetMoreElementsWhatIsAvailable() throws NoSuchMethodException {
        Assert.assertEquals("0", dynamic.get(30));
    }

    /**
     * Тестируем итератор.
     */
    @Test
    public void iteratorTesting() {
        Iterator iterator = dynamic.iterator();
        Assert.assertEquals("0", iterator.next());
        Assert.assertEquals("1", iterator.next());
        Assert.assertEquals("2", iterator.next());
    }

    /**
     * Тест проходит, если выбрасывается исключение при расширении листа.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void iteratorException() {
        Iterator iterator = dynamic.iterator();
        for (Integer i = 0 ; i < 15; i++) {
            dynamic.add(i.toString());
        }
        iterator.next();
    }
}