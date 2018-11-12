package iterator;

import org.junit.Assert;
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
    private EvenArrayIterator evenArrayIterator;

    /**
     * Создается объект и присваивается ссылке.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        evenArrayIterator = new EvenArrayIterator(new Integer[]{1,4,3,5,3,7,5,7,7,1,7,8});
    }

    /**
     * Тестируем метод hasNext.
     * @throws Exception
     */
    @Test
    public void hasNext() throws Exception {
        assertThat(evenArrayIterator.hasNext(), is(false));
        assertThat(evenArrayIterator.hasNext(), is(true));
        assertThat(evenArrayIterator.hasNext(), is(false));
        assertThat(evenArrayIterator.hasNext(), is(false));
        assertThat(evenArrayIterator.hasNext(), is(false));
        assertThat(evenArrayIterator.hasNext(), is(false));
        assertThat(evenArrayIterator.hasNext(), is(false));
        assertThat(evenArrayIterator.hasNext(), is(false));
        assertThat(evenArrayIterator.hasNext(), is(false));
        assertThat(evenArrayIterator.hasNext(), is(false));
        assertThat(evenArrayIterator.hasNext(), is(false));
        assertThat(evenArrayIterator.hasNext(), is(true));
    }

    /**
     * Тестируем метод next.
     * @throws Exception
     */
    @Test
    public void next() throws Exception {
        Assert.assertEquals(4, evenArrayIterator.next());
        Assert.assertEquals(8, evenArrayIterator.next());
    }
}