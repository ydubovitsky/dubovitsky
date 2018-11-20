package ru.job4j;
/**
 * Описание класса Calculate.
 * В нем есть один статический метод main,
 * который выводит в консоль строку Hello Java World.
 * @author - Dubovitsky.
 * @version - 1.0.
 * Добавил commit из IDEA.
 */
public class Calculate {
    /**
     * Статический метод main который принимает в качестве аргумента
     * массив строк из командой строки.
     * @param args - args.
     * @return void.
     */
    public static void main(String[] args) {
        System.out.println("Hello Java World");
    }
    /**
     * Method echo.
     * @param name Your name.
     * @return Echo plus your name.
     */
    public String echo(String name) {
        return "Echo, echo, echo : " + name;
    }
}