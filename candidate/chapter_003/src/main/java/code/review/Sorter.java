package code.review;


import java.util.*;

public class Sorter {

    public Sorter(){

    }

    Set<User> sort (List<User> list) {
        TreeSet<User> sortedList = new TreeSet<>();
        sortedList.addAll(list);
        return sortedList;
    }

    List<User> sortnamelength (List<User> list) {
        Comparator<User> compar = Comparator.comparingInt(o -> o.getName().length());
        list.sort(compar);
        return list;
    }

    List<User> sortboth (List<User> list) {
        Comparator<User> compar1 = Comparator.comparing(User::getName);
        Comparator<User> compar2 = Comparator.comparingInt(User::getAge);
        list.sort(compar1.thenComparing(compar2));
        return list;
    }
}