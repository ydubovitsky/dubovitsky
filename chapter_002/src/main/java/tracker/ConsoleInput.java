package tracker;


import java.util.Scanner;

public class ConsoleInput implements Input {
    Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public int ask(String question, int range) {
        int key = -1;
        do {
            try {
                key = Integer.valueOf(ask(question));
                if (key > range || key < 0) {
                    throw new MenuOutException("Необходимо выбрать значение из диапазона меню");
                } else {
                    break;
                }
            } catch (MenuOutException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return key;
    }
}

