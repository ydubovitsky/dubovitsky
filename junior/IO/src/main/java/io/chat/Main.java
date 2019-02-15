package io.chat;

import java.io.*;

/**
 * Тестовый метод
 */
public class Main {
    public static void main(String[] args) throws IOException {
        UserOne userOne = new UserOne();
        ConsoleChat consoleChat = new ConsoleChat(userOne.sendMsg(),
                new LogFile(
                        new File("C:\\Users\\user\\IdeaProjects\\dubovitsky\\junior\\IO\\src\\main\\java\\io\\chat\\text.txt")),

                // Связываем выходной поток с консолью
                System.out);
        consoleChat.showMsg();
    }
}
