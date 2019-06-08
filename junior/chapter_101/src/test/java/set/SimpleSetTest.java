package set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SimpleSetTest {

    SimpleSet simpleSet;

    @Before
    public void setUp() throws Exception {
        simpleSet = new SimpleSet();
    }

    @Test
    public void add() throws Exception {
        Assert.assertEquals(true, simpleSet.add(1));
        Assert.assertEquals(true, simpleSet.add(2));
        Assert.assertEquals(false, simpleSet.add(2));
        Assert.assertEquals(true, simpleSet.add(3));
        Assert.assertEquals(false, simpleSet.add(2));
    }

    @Test
    public void next() throws NoSuchMethodException {
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(2);
        simpleSet.add(3);
        Iterator iterator = simpleSet.iterator();
        Assert.assertEquals(1, iterator.next());
        Assert.assertEquals(2, iterator.next());
        Assert.assertEquals(3, iterator.next());
    }

    /**
     * Проверка переполнения.
     * @throws NoSuchMethodException
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNoMoreElementsInSet() throws NoSuchMethodException {
        simpleSet.add(1);
        simpleSet.add(2);
        Iterator iterator = simpleSet.iterator();
        Assert.assertEquals(1, iterator.next());
        Assert.assertEquals(2, iterator.next());
        Assert.assertEquals(2, iterator.next());
    }

    @Test
    public void hasNext() throws NoSuchMethodException {
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(2);
        simpleSet.add(3);
        Iterator iterator = simpleSet.iterator();
        Assert.assertEquals(true, iterator.hasNext());
        Assert.assertEquals(true, iterator.hasNext());
        Assert.assertEquals(true, iterator.hasNext());
        Assert.assertEquals(true, iterator.hasNext());
        Assert.assertEquals(true, iterator.hasNext());
        Assert.assertEquals(true, iterator.hasNext());
    }
}