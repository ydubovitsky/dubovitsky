package Tracker;

public interface UserAction {

    // Запрашиваем у пользователя действие, которое он хочет выполнить.
    int key();
    // Наши основные действия в трекере.
    void execute();
    // Что метод делает
    String info();
}
