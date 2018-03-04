package Tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TrackerTest {

    @Test
    public void add() {
        Tracker tracker = new Tracker();
        Item item = new Item("First");
        tracker.add(item);
        assertThat(tracker.getItems()[0].getName(), is("First"));
    }

    @Test
    public void replace() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findByName() {
    }

    @Test
    public void findById() {
    }
}