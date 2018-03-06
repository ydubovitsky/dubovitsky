package Tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TrackerTest {

    @Test
    public void add() {
        Tracker tracker = new Tracker();
        Item item = new Item("name","desc",123l,"comments");
        tracker.add(item);
        int result = tracker.getPosition();
        int expect = 1;
        assertThat(result, is(expect));
    }

    @Test
    public void replace() {
        Tracker tracker = new Tracker();
        Item resultFunctionItem = new Item("name","desc",123l,"comments");
        // Добавляев новый объект в массив
        tracker.add(resultFunctionItem);
        Item itemReplace = new Item("TestName","TestDesc",123l,"comments");
        int expectId = resultFunctionItem.getId();
        itemReplace.setId(expectId);
        // Вызываем функцию в которой имени одного объекта присваивается имя другого при совпадении их id.
        tracker.replace(expectId, itemReplace);
        String result = resultFunctionItem.getName();
        assertThat(result, is("TestName"));
    }

    @Test
    public void delete() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name","desc",123l,"comments");
        Item item2 = new Item("TestName","TestDesc",123l,"comments");
        Item item3 = new Item("TestName","TestDesc",123l,"comments");
        Item item4 = new Item("name","desc",123l,"comments");
        // Добавляев новые объекты в массивы
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        //
        int id = tracker.getItems()[1].getId();
        tracker.delete(id);
        //
    }

    @Test
    public void findAll() {
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
        // Вызываем метод
        Item[] returnArray = tracker.findAll();
        assertThat(returnArray[1].getName(), is("name2"));
    }

    @Test
    public void findByName() {
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
        Item[] itemResult = tracker.findByName("name3");
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
        // Вызываем функцию
        System.out.println(tracker.findById(id).getName());
    }
}