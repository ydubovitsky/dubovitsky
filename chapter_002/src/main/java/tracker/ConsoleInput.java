package tracker;


import java.util.Scanner;

public class ConsoleInput implements Input {
    Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public int ask(String question, int range) {
        int key = Integer.valueOf(ask(question));
        if (key > range || key < 0) {
            System.out.println("out of range");
        }
        return key;
    }
}

