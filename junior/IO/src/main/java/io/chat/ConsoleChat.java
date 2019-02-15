package io.chat;

import java.io.*;

public class ConsoleChat implements Chat {

    /**
     * Поток ввода символов от пользователя
     */
    Reader reader;

    /**
     * Файл, куда будет записываться лог и откуда будет извлекаться случайная фраза
     */
    Logs logs;
    // Создаем выходной поток символов и связываем его с консолью
    //OutputStreamWriter out = new OutputStreamWriter(new BufferedOutputStream(System.out));

    /**
     * Принимает входной поток данных
     * @param reader
     */
    public ConsoleChat(Reader reader, Logs logs) {
        this.reader = reader;
        this.logs = logs;
    }

    @Override
    public void showMsg() {
        // Строка в которую будет записываться строка из потока ввода символов
        String str = new String();

        // Можно сделать фабричный метод
        try(BufferedReader br = (BufferedReader)this.reader) {
            while (!((str = br.readLine()).equals("hello"))) {
                System.out.println(str + " Бот отвечает : " + this.logs.returnRandomString());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        UserOne userOne = new UserOne();
        ConsoleChat consoleChat = new ConsoleChat(userOne.sendMsg(),
                new LogFile(
                        new File("C:\\Users\\user\\IdeaProjects\\dubovitsky\\junior\\IO\\src\\main\\java\\io\\chat\\text.txt")));
        consoleChat.showMsg();
        //consoleChat.showMsg();
    }
}
