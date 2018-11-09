package list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.Assert.*;

public class ContainerShowTest {

    ContainerShow containerShow;

    @Before
    public void setUp() throws Exception {
        containerShow = new ContainerShow();
        containerShow.add(1);
        containerShow.add(2);
        containerShow.add(3);
        containerShow.add(4);
        containerShow.add(5);
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(1, containerShow.get(0));
        Assert.assertEquals(5, containerShow.get(4));
    }

    @Test
    public void iterator() throws Exception {
        Iterator iterator = containerShow.iterator();
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
        Iterator iterator = containerShow.iterator();
        containerShow.add(6);
        iterator.next();
    }

}