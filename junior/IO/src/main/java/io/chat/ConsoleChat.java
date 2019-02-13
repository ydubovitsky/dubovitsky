package io.chat;

import java.io.*;

public class ConsoleChat implements Chat {

    InputStream inputStream;
    Logs logs;

    /**
     * Принимает входной поток данных
     * @param inputStream
     */
    public ConsoleChat(InputStream inputStream, Logs logs) {
        this.inputStream = inputStream;
        this.logs = logs;
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat(new UserOne().sendMsg(), new LogFile(new File("C:\\Users\\user\\IdeaProjects\\dubovitsky\\junior\\IO\\src\\main\\java\\io\\chat\\text.txt")));
        consoleChat.showMsg();
    }

    @Override
    public void showMsg() {
        int c;
        try {
            while ((c = inputStream.read()) != -1) {
                logs.save(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
