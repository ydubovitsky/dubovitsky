package Tracker;

public class StartUI {

    private Input input;
    private static boolean exit = true;

    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(input, tracker);
        menu.fillActions();
        do {
            menu.show();
            // Запрашиваем у пользователя действие
            int key = Integer.parseInt(input.ask("Выберите пункт меню: "));
            menu.doAction(key);
        } while (exit);
    }

    protected static void setExit() {
        exit = false;
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }
}
