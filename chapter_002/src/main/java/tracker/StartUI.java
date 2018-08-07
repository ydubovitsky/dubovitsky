package tracker;

/**
 * Главный класс приложения Трекер.
 */
public class StartUI {

    /**
     * Параметр отвечающий за ввод данных.
     */
    private Input input;

    /**
     * Конструктор.
     * @param input
     */
    public StartUI(final Input input) {
        this.input = input;
    }

    /**
     * Метод запускающий приложение.
     */
    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(input, tracker);
        menu.fillActions();
        do {
            menu.show();
            // Запрашиваем у пользователя действие
            menu.doAction(input.ask("Выберите пункт меню: ", menu.getActionsLength()));
        } while (!"y".equals(input.ask("Вы хотите выйти? y/n")));
    }

    /**
     * Главный метод, отвечающий за запуск приложения.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput())).init();
    }
}
