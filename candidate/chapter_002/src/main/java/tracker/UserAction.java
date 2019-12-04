package tracker;

public interface UserAction {

    // Запрашиваем у пользователя действие(ключ из меню), которое он хочет выполнить.
    int key();
    // Наши основные действия в трекере.
    void execute(Input input, ITracker tracker);
    // Что метод делает
    String info();
}
