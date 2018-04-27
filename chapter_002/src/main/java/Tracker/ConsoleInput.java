package Tracker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ConsoleInput {
    private Scanner scanner = new Scanner(System.in);
    private Tracker tracker = new Tracker();

    public void input() {
        boolean exit = true;
        while(exit) {
            Item[] item;
            switch(scanner.nextLine()) {
                case("0"): {
                    // а - это метка
                    a: System.out.println("Введите через запятую ИМЯ, ОПИСАНИЕ, ДАТУ СОЗДАНИЯ, КОМЕНТАРИЙ для нового элемента:");
                    try {
                        String[] result = scanner.nextLine().split(", ");
                        if (result.length > 4) {
                            System.out.println("Ошибка! Повторите ввод.");
                            System.out.println("Пример ввода: Имя, Описание, 12.8, забрать почту");
                            break;
                        }
                        tracker.add(new Item(result[0], result[1], Long.parseLong(result[2]), result[3]));
                        System.out.println("Вы добавили новый элемент под именем " + " в Трекер.");
                        break;
                    } catch (Exception e) {
                        // Пишем в лог ошибки
                        LogFileOut.createFile();
                        LogFileOut.logged(e.getMessage());
                    }
                }
                case("1"): {
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
                    break;
                }
                case("2"): {
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
                    break;
                }
                case("3"): {
                    System.out.println("Введите id элемента, который вы хотите удалить");
                    int id = Integer.parseInt(scanner.nextLine());
                    tracker.delete(id);
                }
                case("4"): {
                    System.out.println("Введите id элемента, который вы хотите найти");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println(tracker.findById(id));
                    break;
                }
                case("5"): {
                    System.out.println("Введите имя элемента, который вы хотите найти");
                    String name = scanner.nextLine();
                    System.out.println(tracker.findByName(name));
                    break;
                }
                case("6"): {
                    System.out.println("Всего вам доброго.");
                    exit = false;
                    break;
                }
                default: {
                    System.out.println("Пожалуйста введите цифры от 1 до 6");
                    break;
                }
            }
        }
    }
}

class MyExeption extends Exception {
    MyExeption(String errorName) {
        super(errorName);
    }
}

class LogFileOut {

    static Path currentRelativePath = Paths.get("");
    static String strPath = currentRelativePath.toAbsolutePath().toString() + "/log.txt";

    public static void createFile() {
        try {
            File file = new File(LogFileOut.strPath);
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Не удалось создать файл! Держи стэк-трейс:");
            System.out.println(e.getStackTrace());
        }
    }

    public static void logged(String a) {
        try {
            FileOutputStream file = new FileOutputStream(LogFileOut.strPath);
            if (a.length() > 0) {
                byte[] buffer = a.getBytes();
                file.write(buffer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
