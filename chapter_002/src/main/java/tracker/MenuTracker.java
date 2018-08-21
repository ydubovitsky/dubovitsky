package tracker;
/**
 * Этот класс отвечает за меню трекера.
 * Класс содержит набор внутренних классов,
 * отвечающих за работу с заявками.
 */
public final class MenuTracker {
    /**
     * Переменная, отвечающая за пользовательский ввод данных.
     */
    private final Input input;
    /**
     * Класс нашего трекера.
     */
    private final Tracker tracker;
    /**
     * Список всех наших функций
     */
    private final UserAction[] actions = new UserAction[7];

    /**
     * Метод возвращает массив ключей меню.
     * @return
     */
    public int[] getActionsLength() {
        int[] arrayOfKeys = new int[actions.length];
        for (int i = 0; i < actions.length; i++) {
            arrayOfKeys[i] = actions[i].key();
        }
        return arrayOfKeys;
    }

    /**
     *
     * @param input
     * @param tracker
     */
    public MenuTracker(final Input input, final Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод, отвечающий за заполнение меню трекера.
     * @param startUI
     */
    public void fillActions(StartUI startUI) {
        actions[0] = new AddItem(0, "Добавить новый элемент");
        actions[1] = new MenuTracker.ShowAllElements(1, "Показать все элементы");
        actions[2] = new DeleteElement(2, "Удалить заявку");
        actions[3] = new SearchElementById(3, "Найти заявку по id");
        actions[4] = new SearchByName(4, "Найти заявку по Имени");
        actions[5] = new EditElement(5, "Редактировать заявку");
        actions[6] = new ExitProgram(6, "Выйти из программы", startUI);
    }

    /**
     * Метод, отвечающий за выполнение действий из меню
     * по пользовательскому ключу.
     * @param key
     */
    public void doAction(final int key) {
        int i = 0;
        do {
            if (actions[i].key() == key) {
                actions[i].execute(input, tracker);
                break;
            }
            i++;
        }while (true);
    }

    /**
     * Метод, выводящий меню на экран пользователю.
     */
    public void show() {
        for (UserAction action : actions) {
            System.out.println(action.info());
        }
    }

    private static final class AddItem extends BaseAction {
        /**
         * Обычный конструктор, передающий в родительский класс ключ и название метода.
         * @param key
         * @param name
         */
        AddItem(final int key, final String name) {
            super(key, name);
        }

        /**
         * Метод, добавляющий в трекер новую заявку.
         * @param input
         * @param tracker
         */
        public void execute(final Input input, final Tracker tracker) {
            String name = input.ask("Введите Имя задачи");
            String desc = input.ask("Введите Описание нового элемента:");
            Long date = Long.parseLong(input.ask("Введите Дату Создания нового элемента:"));
            String comment = input.ask("Введите Коментарий:");
            tracker.add(new Item(name, desc, date, comment));
        }
    }

    static class ShowAllElements extends BaseAction {

        /**
         * Обычный конструктор, передающий в родительский класс ключ и название метода.
         * @param key
         * @param name
         */
        private ShowAllElements(final int key, final String name) {
            super(key, name);
        }

        /**
         * Метод, показывающий все созданные заявки.
         * @param input
         * @param tracker
         */
        public void execute(final Input input, final Tracker tracker) {
            if (tracker.findAll().length > 0) {
                System.out.println("Выводим все элементы Трекера на экран.");
                for (int i = 0; i < tracker.findAll().length; i++) {
                    System.out.println(i + " Id элемента - " + tracker.findAll()[i].getId()
                           + " Имя - " + tracker.findAll()[i].getName());
                }
            } else {
                System.out.println("В трекере нет элементов для отображения.");
            }
        }
    }
    /**
     * Класс, отвечающий за удаление заявок из трекера.
     */
    final class DeleteElement extends BaseAction {

        /**
         *
         * @param key
         * @param name
         */
        private DeleteElement(final int key, final String name) {
            super(key, name);
        }

        /**
         * Метод, удаляет заявку из трекера.
         * @param input
         * @param tracker
         */
        @SuppressWarnings("CheckStyle")
        @Override
        public void execute(Input input, Tracker tracker) {
                int id = Integer.parseInt(input.ask("Введите id элемента, который вы хотите удалить"));
                tracker.delete(id);
                System.out.println("Элементы с id " + id + " удален.");
        }
    }

    final class SearchElementById extends BaseAction {

        /**
         *
         * @param key
         * @param name
         */
        private SearchElementById(final int key, final String name) {
            super(key, name);
        }
        /**
         * Метод, для поиска заявки в трекере по id.
         * @param input
         * @param tracker
         */
        @Override
        public void execute(final Input input, final Tracker tracker) {
            // Мы исходим из того, что id не могут быть одинаковы.
            int id = Integer.parseInt(input.ask("Введите id элемента, который вы хотите найти"));
            String value = tracker.findById(id).getName();
            if (value == null) {
                System.out.println("Заявка с данным id не найдена!");
            } else {
                System.out.println("Имя заявки: " + value);
            }
        }
    }

    final class SearchByName extends BaseAction {
        /**
         *
         * @param key
         * @param name
         */
        private SearchByName(final int key, final String name) {
            super(key, name);
        }

        /**
         * Метод, ищет заявку в трекере по имени.
         * @param input
         * @param tracker
         */
        @Override
        public void execute(final Input input, final Tracker tracker) {
            String name = input.ask("Введите имя элемента, который вы хотите найти");
            System.out.println("Результаты поиска:");
            if (tracker.findByName(name).length != 0) {
                System.out.println("Length = " + tracker.findByName(name).length);
                for (int i = 0; i < tracker.findByName(name).length; i++)
                    System.out.println("id заявки: " + tracker.findByName(name)[i].getId());
            } else {
                System.out.println("Поиск не дал результата");
            }
        }
    }

    /**
     * Класс отвечающий за выход из программы.
     */
    class ExitProgram extends BaseAction {

        /**
         * В эту переменную передается экземпляр класса, который запускает программу.
         * Таким образом мы можем влиять на запускающий класс.
         */
        private final StartUI startUI;

        /**
         * Конструктор
         * @param key - Номер из меню трекера.
         * @param name
         * @param startUI - экземпляр класса, который запускает программу.
         */
        public ExitProgram(final int key, final String name, StartUI startUI) {
            super(key, name);
            this.startUI = startUI;
        }

        /**
         * Метод отвечающий за прерывание программы.
         * @param input
         * @param tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String answer = input.ask("Вы хотите выйти? y/n");
            if ("y".equals(answer)) {
                this.startUI.setActive(false);
            } else {
                this.startUI.setActive(true);
            }
        }
    }
}

/**
 * Внешний класс, отвечающий за редактирование элементов.
 */
class EditElement extends BaseAction {
    /**
     *
     * @param key
     * @param name
     */
    EditElement(final int key, final String name) {
        super(key, name);
    }

    /**
     * Метод, отвечающий за редактирование заявки в трекере.
     * @param input
     * @param tracker
     */
    @Override
    public void execute(final Input input, final Tracker tracker) {
            int id = Integer.parseInt(input.ask("Введите номер элемента, который вы хотите отредактировать:"));
            // Создаем элемент для замены
            String[] result = input.ask("Введите через запятую ИМЯ, ОПИСАНИЕ, ДАТУ СОЗДАНИЯ, КОМЕНТАРИЙ для нового элемента:").split(", ");
            Item itemReplace = new Item(result[0], result[1], Long.parseLong(result[2]), result[3]);
            tracker.replace(id, itemReplace);
            System.out.println("Элементу c id№" + id + " отредактирован");
    }
}