package iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс для тестирования.
 */
public class EvenArrayIteratorTest {

    /**
     * Ссылка на объект.
     */
    private EvenArrayIterator evenArrayIterator;

    /**
     * Создается объект и присваивается ссылке.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        evenArrayIterator = new EvenArrayIterator(new Integer[]{4,6,3,10});
    }

    /**
     * Тестируем метод hasNext.
     * @throws Exception
     */
    @Test
    public void hasNext() throws Exception {
        assertThat(evenArrayIterator.hasNext(), is(true));
        assertThat(evenArrayIterator.hasNext(), is(true));
        assertThat(evenArrayIterator.hasNext(), is(false));
        assertThat(evenArrayIterator.hasNext(), is(true));
    }

    /**
     * Когда происходит обращение к несуществующему элементу.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenMethodHasNextThrowException() {
        assertThat(evenArrayIterator.hasNext(), is(true));
        assertThat(evenArrayIterator.hasNext(), is(true));
        assertThat(evenArrayIterator.hasNext(), is(false));
        assertThat(evenArrayIterator.hasNext(), is(true));
        assertThat(evenArrayIterator.hasNext(), is(true));
    }

    /**
     * Тестируем метод next.
     * @throws Exception
     */
    @Test
    public void next() throws Exception {
        Assert.assertEquals(4, evenArrayIterator.next());
        Assert.assertEquals(6, evenArrayIterator.next());
        Assert.assertEquals(10, evenArrayIterator.next());
    }
}