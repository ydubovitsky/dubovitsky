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
     * Переменная, отвечающая за работу цикла.
     */
    private volatile boolean active = true;

    /**
     * Конструктор.
     * @param input
     */
    public StartUI(final Input input) {
        this.input = input;
    }

    /**
     *
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Метод запускающий приложение.
     */
    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(input, tracker);
        menu.fillActions(this);
        do {
            menu.show();
            // Запрашиваем у пользователя действие
            menu.doAction(input.ask("Выберите пункт меню: ", menu.getActionsLength()));
        } while (active);
    }

    /**
     * Главный метод, отвечающий за запуск приложения.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput())).init();
    }
}
