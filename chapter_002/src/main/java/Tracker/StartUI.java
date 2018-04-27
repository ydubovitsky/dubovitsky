package Tracker;

import java.util.ArrayList;

public class StartUI {
    public static void main(String[] args) {
        ArrayList<String> menuArray = new ArrayList<>();
        menuArray.add("0. Add new Item");
        menuArray.add("1. Show all items");
        menuArray.add("2. Edit item");
        menuArray.add("3. Delete item");
        menuArray.add("4. Find item by Id");
        menuArray.add("5. Find items by name");
        menuArray.add("6. Exit Program");
        menuArray.add("Select: ");

        for (int i = 0; i < menuArray.size(); i++) {
            System.out.println(menuArray.get(i));
        }
        ConsoleInput consoleInput = new ConsoleInput();
        consoleInput.input();
    }
}