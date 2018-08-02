package tracker;

public class StartUI extends ValidateInput {

    private Input input;

    public StartUI(final Input input) {
        this.input = input;
    }

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

    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUI(input).init();
    }
}
