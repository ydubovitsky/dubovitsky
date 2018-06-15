package Tracker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StartUITest {
    @Before
    public void out() {
        System.out.println("Начало Тестирования!");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        StubInput stubInput = new StubInput(new String[]{"0", "n", "Имя", "Описание", "2018", "забрать почту", "6"});
        StartUI startUI = new StartUI(tracker, stubInput);
        startUI.init();
        assertThat(tracker.findAll()[0].getName(), is("Имя"));
    }

    @Test
    public void whenUserEditElement() {
        Tracker tracker = new Tracker();
        Item item = new Item("Имя", "Описание", 2018, "забрать почту");
        tracker.add(item);
        StubInput stubInput = new StubInput(new String[]{"2", Integer.toString(tracker.findAll()[0].getId()), "Новое Имя, Описание, 2018, забрать почту", "6"});
        StartUI startUI = new StartUI(tracker, stubInput);
        startUI.init();
        assertThat(tracker.findAll()[0].getName(), is("Новое Имя"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenUSerDeleteElement() {
        Tracker tracker = new Tracker();
        Item item = new Item("Имя", "Описание", 2018, "забрать почту");
        tracker.add(item);
        StubInput stubInput = new StubInput(new String[]{"3", Integer.toString(tracker.findAll()[0].getId()), "6"});
        StartUI startUI = new StartUI(tracker, stubInput);
        startUI.init();
        assertThat(tracker.findAll()[0].getName(), is("Элемент был удален, значит будет исключение!"));
    }

    @Test
    public void whenUserSearchElementById() {
        Tracker tracker = new Tracker();
        Item item = new Item("Имя", "Описание", 2018, "забрать почту");
        tracker.add(item);
        StubInput stubInput = new StubInput(new String[]{"4", Integer.toString(tracker.findAll()[0].getId()), "6"});
        StartUI startUI = new StartUI(tracker, stubInput);
        startUI.init();
        assertThat("Имя заявки: " + tracker.findAll()[0].getName(), is("Имя заявки: Имя"));
    }

    @Test
    public void whenUserSearchElementByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("Имя", "Описание", 2018, "забрать почту");
        tracker.add(item);
        StubInput stubInput = new StubInput(new String[]{"4", tracker.findAll()[0].getName(), "6"});
        StartUI startUI = new StartUI(tracker, stubInput);
        startUI.init();
        assertThat("Имя заявки: " + tracker.findAll()[0].getName(), is("Имя заявки: Имя"));
    }
}
