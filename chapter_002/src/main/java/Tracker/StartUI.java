package Tracker;

import java.util.ArrayList;
import java.util.Scanner;

public class StartUI {

    private Scanner scanner = new Scanner(System.in);
    private Tracker tracker = new Tracker();
    private Item[] item;
    private boolean exit = true;

    public static void main(String[] args) {
        //
        StartUI startUI = new StartUI();
        startUI.showMenu();
    }

    public void start() {
        while (exit) {
            switch (scanner.nextLine()) {
                case ("0"): {
                    addElement();
                    break;
                }
                case ("1"): {
                    showAllElements();
                    break;
                }
                case ("2"): {
                    editElement();
                    break;
                }
                case ("3"): {
                    deleteElement();
                    break;
                }
                case ("4"): {
                    searchElement();
                    break;
                }
                case ("5"): {
                    searchElementByName();
                    break;
                }
                case ("6"): {
                    exit();
                    break;
                }
                default: {
                    uncknownOperation();
                    break;
                }
            }
        }
    }

    public void showMenu() {
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
        start();
    }

    public void addElement() {
        System.out.println("Введите через запятую ИМЯ, ОПИСАНИЕ, ДАТУ СОЗДАНИЯ, КОМЕНТАРИЙ для нового элемента:");
        try {
            String[] result = scanner.nextLine().split(", ");
            if (result.length > 4) {
                System.out.println("Ошибка! Повторите ввод.");
                System.out.println("Пример ввода: Имя, Описание, 2018, забрать почту");
            }
            tracker.add(new Item(result[0], result[1], Long.parseLong(result[2]), result[3]));
            System.out.println("Вы добавили новый элемент под именем " + " в Трекер.");
        } catch (Exception e) {
            // Пишем в лог ошибки
            LogFileOut.createFile();
            LogFileOut.logged(e.getMessage());
        }
    }

    public void showAllElements() {
        if (tracker.findAll().length > 0) {
            item = tracker.findAll();
            System.out.println("Выводим все элементы Трекера на экран.");
            for (int i = 0; i < item.length; i++) {
                System.out.println(i + " Имя элемента - " + item[i].getName() +
                        " и id - " + item[i].getId());
            }
        } else {
            System.out.println("В трекере нет элементов для отображения.");
        }
    }

    public void editElement() {
        System.out.println("Введите номер элемента, который вы хотите отредактировать:");
        int id = Integer.parseInt(scanner.nextLine());
        // Создаем элемент для замены
        System.out.println("Какое новое ИМЯ вы хотите присвоить элементу?");
        String name = scanner.nextLine();
        System.out.println("Какое новое ОПИСАНИЕ вы хотите присвоить элементу?");
        String desc = scanner.nextLine();
        System.out.println("Какую ДАТУ СОЗДАНИЯ вы хотите присвоить элементу?");
        long create = Long.parseLong(scanner.nextLine());
        System.out.println("Какой КОМЕНТАРИЙ вы хотите присвоить элементу?");
        String comments = scanner.nextLine();
        Item itemReplace = new Item(name, desc, create, comments);
        tracker.replace(id, itemReplace);
        System.out.println("Элементу c id№" + id + " Присвоено имя " + tracker.findById(id).getName());
    }


    public void deleteElement() {
        System.out.println("Введите id элемента, который вы хотите удалить");
        int id = Integer.parseInt(scanner.nextLine());
        tracker.delete(id);
    }

    public void searchElement() {
        System.out.println("Введите id элемента, который вы хотите найти");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println(tracker.findById(id));
    }

    public void searchElementByName() {
        System.out.println("Введите имя элемента, который вы хотите найти");
        String name = scanner.nextLine();
        System.out.println(tracker.findByName(name));
    }

    public void exit() {
        System.out.println("Всего вам доброго.");
        exit = false;
    }

    public void uncknownOperation() {
        System.out.println("Пожалуйста введите цифры от 0 до 6");
    }
}
