package Tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TrackerTest {

    @Test
    public void add() {
        Tracker tracker = new Tracker();
        // Добавляем 100 объектов типа Item в массив Item[] items объекта типа Tracker под именем tracker.
        for(int i = 0; i < 99; i++) {
            Item item = new Item("name" + i, "desc", i, "this ic comments № " + i);
            tracker.add(item);
        }
        int result = tracker.getPosition();
        int expect = 99;
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
        Item itemFromTrackerObject = tracker.getItems()[0];
        assertThat(itemFromTrackerObject, is(itemReplace));
    }

    @Test
    public void delete() {
        Tracker tracker = new Tracker();
        for(int i = 0; i < 10; i++) {
            tracker.add(new Item("name " + i, "desc", i, "this ic comments № " + i));
        }
        Item[] items  = tracker.getItems();
        int id = items[2].getId();
        tracker.delete(id);
        for (int i = 0; i < tracker.getPosition(); i++) {
            System.out.println(tracker.getItems()[i].getName());
        }
    }

    @Test
    public void findAll() {
        Tracker tracker = new Tracker();
        for(int i = 0; i < tracker.getPosition(); i++) {
            tracker.add(new Item("name" + i, "desc", i, "this ic comments № " + i));
        }
        Item[] returnArray = tracker.findAll();
        assertThat(returnArray[55], is(tracker.getItems()[55]));
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        for(int i = 0; i < 50; i++) {
            tracker.add(new Item("name" + i, "desc", i, "this ic comments № " + i));
        }
        Item[] itemResult = tracker.findByName("name3");
        assertThat(itemResult[0].getName(), is("name3"));
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