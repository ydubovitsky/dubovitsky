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

    /**
     * Создаем выходной поток символов и связываем его с консолью
     */
    PrintStream printStream;

    /**
     * Чат-Бот.
     */
    Bot bot;

    private final String endChat = "закончить";
    private final String freezeChat = "остановить";
    private final String continueChat = "продолжить";

    /**
     * Принимает входной поток данных, Лог, и Выходной поток.
     * @param reader
     */
    public ConsoleChat(Reader reader, Logs logs, PrintStream printStream, Bot bot) {
        this.reader = reader;
        this.logs = logs;
        this.printStream = printStream;
        this.bot = bot;
    }

    @Override
    public void showMsg() {
        // Строка в которую будет записываться строка из потока ввода символов
        String str = new String();
        boolean flag = false;

        // Можно сделать фабричный метод
        try(BufferedReader br = (BufferedReader)this.reader) {

            while (!((str = br.readLine()).equals(this.endChat))) {
                String result = str;

                if (str.equals(this.freezeChat)) {
                    flag = true;
                } if (str.equals(this.continueChat)){
                    flag = false;
                } else if(!flag){
                    result = str + " Бот вам отвечает: " + this.bot.returnRandomString();
                }
                this.printStream.println(result);
                this.logs.save(result);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
