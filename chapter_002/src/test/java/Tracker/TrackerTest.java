package Tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TrackerTest {

    @Test
    public void add() {
        Tracker tracker = new Tracker();
        // Добавляем 2 объекта типа Item в массив Item[] items объекта типа Tracker под именем tracker.
        tracker.add(new Item("name1", "desc", 17, "test"));
        tracker.add(new Item("name2", "desc2", 13, "test2"));
        int result = tracker.findByName("name2").length;
        int expect = 2;
        // Проверяем сколько элементов добавлено в массив.
        assertThat(result, is(expect));
    }

    @Test
    public void replace() {
        Tracker tracker = new Tracker();
        Item resultFunctionItem = new Item("name","desc",123l,"comments");
        // Добавляев новый объект в массив
        tracker.add(resultFunctionItem);
        Item itemReplace = new Item("replaced!","TestDesc",123l,"comments");
        // Находим id добавленного объекта и присваиваем его объекту который будем передавать в функцию.
        int expectId = resultFunctionItem.getId();
        itemReplace.setId(expectId);
        tracker.replace(expectId, itemReplace);
        // Проверяем совпадают ли объекты
        Item itemFromTrackerObject = tracker.findAll()[0];
        assertThat(itemFromTrackerObject, is(itemReplace));
    }

    @Test
    public void delete() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name1", "desc", 13, "test"));
        tracker.add(new Item("name2", "desc2", 13, "test2"));
        tracker.delete(tracker.findAll()[0].getId());
        assertThat(tracker.findAll()[0].getName(), is("name2"));
    }

    @Test
    public void findAll() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("task1", "test", 12, "test"));
        assertThat(tracker.findAll()[0].getName(), is("task1"));
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name","desc",123l,"comments");
        Item item2 = new Item("name2","TestDesc",123l,"comments");
        // Добавляев новые объекты в массивы
        tracker.add(item1);
        tracker.add(item2);
        Item[] itemResult = tracker.findByName("name2");
        assertThat(itemResult[0].getName(), is("name2"));
    }

    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name","desc",123l,"comments");
        Item item2 = new Item("name2","TestDesc",123l,"comments");
        Item item3 = new Item("name3","TestDesc",123l,"comments");
        Item item4 = new Item("name4","desc",123l,"comments");
        // Добавляев новые объекты в массивы
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        //
        int id = item1.getId();
        // Смотрим, совпадает ли имя найденного по id объекта с ожидаемым именем.
        assertThat(tracker.findById(id).getName(), is("name"));
    }
}