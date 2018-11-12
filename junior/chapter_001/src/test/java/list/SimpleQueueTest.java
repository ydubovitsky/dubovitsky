package list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleQueueTest {

    SimpleQueue simpleQueue;

    @Before
    public void setUp() throws Exception {
        simpleQueue = new SimpleQueue();

    }

    @Test
    public void poll() throws Exception {
        simpleQueue.push(0);
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        simpleQueue.push(4);
        Assert.assertEquals(0, simpleQueue.poll());
        Assert.assertEquals(1, simpleQueue.poll());
        Assert.assertEquals(2, simpleQueue.poll());
        Assert.assertEquals(3, simpleQueue.poll());
        Assert.assertEquals(4, simpleQueue.poll());
    }

    @Test
    public void push() throws Exception {
    }
}