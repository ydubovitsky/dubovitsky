//package Tracker;
//
//import java.util.Scanner;
//
///*
//Нужно написать больше методов в класс Трекер.
//Например такой как отоборажение всех свойств элемента из массива items,
//т.е. написать свою реализацию toString();
// */
//
//public class ConsoleInput {
//    private Scanner scanner = new Scanner(System.in);
//    private Tracker tracker = new Tracker();
//
//    public void input() {
//        boolean exit = true;
//        while(exit) {
//            Item[] item;
//            switch(scanner.nextLine()) {
//                case("0"): {
//                    System.out.println("Введите имя:");
//                    String name = scanner.nextLine();
//                    tracker.add(new Item(name));
//                    System.out.println("Вы добавили новый элемент под именем " + name + " в Трекер.");
//                    break;
//                }
//                case("1"): {
//                        if (tracker.getPosition() > 0) {
//                            item = tracker.findAll();
//                            System.out.println("Выводим все элементы Трекера на экран.");
//                            for (int i = 0; i <= item.length; i++) {
//                                System.out.println(i + " Имя элемента - " + item[i].getName() +
//                                        " и id - " + item[i].getId());
//                            }
//                        } else {
//                            System.out.println("В трекере нет элементов для отображения.");
//                        }
//                    break;
//                }
//                case("2"): {
//                    System.out.println("Введите номер элемента, который вы хотите отредактировать:");
//                    int id = Integer.parseInt(scanner.nextLine());
//                    System.out.println("Какое новое имя вы хотите присвоить элементу?");
//                    String name = scanner.nextLine();
//                    item = tracker.getItems();
//                    item[id].setName(name);
//                    System.out.println("Элементу " + id + " Присвоено имя " + item[id].getName());
//                    break;
//                }
//                case("3"): {
//                    // Нужно разобраться с методом
//                }
//                case("4"): {
//                    System.out.println("Введите id элемента, который вы хотите найти");
//                    int id = Integer.parseInt(scanner.nextLine());
//                    System.out.println(tracker.findById(id));
//                    break;
//                }
//                case("5"): {
//                    System.out.println("Введите имя элемента, который вы хотите найти");
//                    String name = scanner.nextLine();
//                    System.out.println(tracker.findByName(name));
//                    break;
//
//                }
//                case("6"): {
//                    System.out.println("Всего вам доброго.");
//                    exit = false;
//                    break;
//                }
//                default: {
//                    System.out.println("Пожалуйста введите цифры от 1 до 6");
//                    break;
//                }
//            }
//        }
//    }
//}
