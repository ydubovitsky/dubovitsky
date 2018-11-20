package list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleStackTest {

    SimpleStack simpleStack;

    /**
     * Выполняется каждый раз до запуска тестов.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        simpleStack = new SimpleStack<>();
        simpleStack.push(0);
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
    }

    @Test
    public void poll() throws Exception {
        Assert.assertEquals(3, simpleStack.poll());
        Assert.assertEquals(2, simpleStack.poll());
        Assert.assertEquals(1, simpleStack.poll());
        simpleStack.push(12345);
        Assert.assertEquals(12345, simpleStack.poll());
    }

    /**
     * Если в стеке нет элементов, выбросится исключение.
     */
    @Test(expected = NullPointerException.class, timeout = 100)
    public void whenPollReturnException() {
        for (int i = 0; i < 15; i++) {
            simpleStack.poll();
        }
    }

    @Test
    public void push() throws Exception {
        simpleStack.push(1);
    }
}