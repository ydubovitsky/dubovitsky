package Tracker;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StartUI extends Thread {

    private Scanner scanner = new Scanner(System.in);
    private Tracker tracker = new Tracker();
    private Item[] item;
    private boolean exit = true;
    private final List<String> menuArray = Arrays.asList("0. Add new Item", "1. Show all items", "2. Edit item",
            "3. Delete item", "4. Find item by Id", "5. Find items by name", "6. Exit Program", "Select: ");
    enum Points {
        One("Введите ИМЯ нового элемента:"), Two("Введите Описание нового элемента:"),
            Three("Введите Дату Создания нового элемента:"), Four("Введите Коментарий:");

        private String value;

        Points(String a) {
            value = a;
        }
        String getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        new StartUI().start();
    }

    public void run() {
        while (exit) {
            for (int i = 0; i < menuArray.size(); i++) {
                System.out.println(menuArray.get(i));
            }
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
                    searchElementById();
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

    synchronized private void addElement() {
        System.out.println("Для ввода данных через запятую нажмите \"y\", в строчку - \"n\"");
        switch(scanner.nextLine()) {
            case ("y"): {
                System.out.println("Введите через запятую ИМЯ, ОПИСАНИЕ, ДАТУ СОЗДАНИЯ, КОМЕНТАРИЙ для нового элемента:");
                try {
                    String[] result = scanner.nextLine().split(", ");
                    if (result.length != 4) {
                        System.out.println("Ошибка! Повторите ввод.");
                        System.out.println("Пример ввода: Имя, Описание, 2018, забрать почту");
                    }
                    tracker.add(new Item(result[0], result[1], Long.parseLong(result[2]), result[3]));
                    System.out.println("Вы добавили новый элемент под именем " + result[0] + " в Трекер и вернулись в главное меню");
                } catch (Exception e) {
                    // Пишем в лог ошибки
                    LogFileOut.createFile();
                    LogFileOut.logged(e.getMessage());
                }
                break;
            }
            case ("n"): {
                String results[] = new String[4];
                //Points points;
                for (int i = 0; i < results.length; i++) {
                    System.out.println(Points.values()[i].getValue());
                    results[i] = scanner.nextLine();
                }
                try {
                    tracker.add(new Item(results[0], results[1], Long.parseLong(results[2]), results[3]));
                } catch (NumberFormatException e) {
                    System.out.println("Неправильный формат ввода данных! Повторите ввод.");
                    break;
                }
                System.out.println("Вы добавили новый элемент под именем " + results[0] + " в Трекер и вернулись в главное меню");
                break;
            }
            default: {
                System.out.println("Введите y или n");
            }
        }
    }

    private void showAllElements() {
        if (tracker.findAll().length > 0) {
            item = tracker.findAll();
            System.out.println("Выводим все элементы Трекера на экран.");
            for (int i = 0; i < item.length; i++) {
                System.out.println(i + " Id элемента - " + item[i].getId() +
                        " Имя - " + item[i].getName());
            }
        } else {
            System.out.println("В трекере нет элементов для отображения.");
        }
    }

    synchronized private void editElement() {
        System.out.println("Введите номер элемента, который вы хотите отредактировать:");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            // Создаем элемент для замены
            System.out.println("Введите через запятую ИМЯ, ОПИСАНИЕ, ДАТУ СОЗДАНИЯ, КОМЕНТАРИЙ для нового элемента:");
            String[] result = scanner.nextLine().split(", ");
            Item itemReplace = new Item(result[0], result[1], Long.parseLong(result[2]), result[3]);
            tracker.replace(id, itemReplace);
            System.out.println("Элементу c id№" + id + " отредактирован");
        } catch (NumberFormatException n) {
            System.out.println("Вы ввели неверные данные. Повторите ввод.");
        }
    }


    synchronized private void deleteElement() {
        System.out.println("Введите id элемента, который вы хотите удалить");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            tracker.delete(id);
            System.out.println("Элементы с id " + id + " удален.");
        } catch (NumberFormatException n) {
            System.out.println("Неправильный формат id, повторите попытку.");
        }
    }

    private void searchElementById() {
        // Мы исходим из того, что id не могут быть одинаковы.
        System.out.println("Введите id элемента, который вы хотите найти");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Имя заявки: " + tracker.findById(id).getName());
        } catch (NumberFormatException e) {
            System.out.println("Недопустимый формат id");
        }
    }

    private void searchElementByName() {
        System.out.println("Введите имя элемента, который вы хотите найти");
        String name = scanner.nextLine();
        System.out.println("Результаты поиска:");
        if (tracker.findByName(name).size() != 0) {
            System.out.println("Length = " + tracker.findByName(name).size());
            for (int i = 0; i < tracker.findByName(name).size(); i++)
                System.out.println("id заявки: " + tracker.findByName(name).get(i).getId());
        } else {
            System.out.println("Поиск не дал результата");
        }
    }

    private void exit() {
        System.out.println("Всего вам доброго.");
        exit = false;
    }

    private void uncknownOperation() {
        System.out.println("Пожалуйста введите цифры от 0 до 6");
    }
}
