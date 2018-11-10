package list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;


public class SimpleStackTest {

    SimpleStack simpleStack;

    /**
     * Выполняется каждый раз до запуска тестов.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
    }

    @Test
    public void poll() throws Exception {
        Assert.assertEquals(3, simpleStack.poll());
        Assert.assertEquals(2, simpleStack.poll());
        Assert.assertEquals(1, simpleStack.poll());
    }

    /**
     * Если в стеке нет элементов, выбросится исключение.
     */
    @Test(expected = NullPointerException.class, timeout = 100)
    public void whenPollReturnException() {
        simpleStack.poll();
    }


    @Test
    public void push() throws Exception {
        simpleStack.push(1);
    }

    /**
     * Проверка работы метода удаления.
     * @throws Exception
     */
    @Test
    public void delete() throws Exception {
        Field field = this.simpleStack.getClass().getDeclaredField("lastElement");
        field.setAccessible(true);
        ContainerShow.Container container = (ContainerShow.Container)field.get(simpleStack);
        simpleStack.delete();
        Assert.assertEquals(container.previous.value, simpleStack.poll());
    }

}