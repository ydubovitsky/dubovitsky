package iterator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс для тестирования.
 */
public class EvenArrayIteratorTest {

    /**
     * Ссылка на объект.
     */
    EvenArrayIterator evenArrayIterator;

    /**
     * Создается объект и присваивается ссылке.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        evenArrayIterator = new EvenArrayIterator(new Integer[]{10,2,2,3,4,5,7,7,8,10,3});
    }

    /**
     * Тестируем метод hasNext.
     * @throws Exception
     */
    @Test
    public void hasNext() throws Exception {
        assertThat(evenArrayIterator.next(), is(10));
        assertThat(evenArrayIterator.next(), is(2));
        assertThat(evenArrayIterator.next(), is(2));
        assertThat(evenArrayIterator.next(), is(4));
        assertThat(evenArrayIterator.next(), is(8));
        assertThat(evenArrayIterator.next(), is(10));
    }

    /**
     * Тестируем метод next.
     * @throws Exception
     */
    @Test
    public void next() throws Exception {
        assertThat(evenArrayIterator.next(), is(10));
        assertThat(evenArrayIterator.next(), is(2));
        assertThat(evenArrayIterator.next(), is(2));
        assertThat(evenArrayIterator.next(), is(4));
        assertThat(evenArrayIterator.next(), is(8));
        assertThat(evenArrayIterator.next(), is(10));
    }
}