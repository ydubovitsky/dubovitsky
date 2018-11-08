package list;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SmpArrayListTest {

    private SmpArrayList list;

    @Before
    public void beforeTest() {
        list = new SmpArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeleteFirstElementInList() {
        list.delete();
        Assert.assertEquals(3, list.get(0));
        Assert.assertEquals(2, list.get(1));
    }

    /**
     * Тест проходит проверку, если после удаления элемента и при попытке доступа к нему
     * выбрасывается исключение.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenMethodDeleteThrowException() {
        list.delete();
        Assert.assertEquals(3, list.get(0));
        Assert.assertEquals(2, list.get(1));
        Assert.assertEquals(1, list.get(2));
    }
}
