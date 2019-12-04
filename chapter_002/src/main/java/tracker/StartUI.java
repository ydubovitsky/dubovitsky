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
     * Final variable Tracker;
     */
    private final ITracker iTracker;

    /**
     * Конструктор.
     * @param input
     */
    public StartUI(Input input, ITracker iTracker) {
        this.iTracker = iTracker;
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
        MenuTracker menu = new MenuTracker(input, this.iTracker);
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
        new StartUI(
                new ValidateInput(
                        // TODO Зависит от конкретного класса Tracker
                        new ConsoleInput()), new Tracker()
        ).init();
    }
}
