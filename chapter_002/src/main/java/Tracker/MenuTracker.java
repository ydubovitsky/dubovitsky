package Tracker;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

public class MenuTracker {
    // Что делает наше меню?

    private Input input;
    private Tracker tracker;
    // Список всех наших функций
    private ArrayList<UserAction> actions = new ArrayList<UserAction>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions.add(0, new AddItem());
        this.actions.add(1, new MenuTracker.ShowAllElements(this.input, this.tracker));
        this.actions.add(2, new EditElement(this.input, this.tracker));
        this.actions.add(3, new DeleteElement());
        this.actions.add(4, new SearchElementById());
        this.actions.add(5, new SearchByName());
        this.actions.add(6, new Exit(this.input));
    }

    public void doAction(int key) {
        if (key >= actions.size() || key < 0) {
            System.out.println("Вы ввели некорректный номер, повторите ввод.");
        } else {
            actions.get(key).execute();
        }
    }

    public void show() {
        for (UserAction action: this.actions) {
            System.out.println(action.info());
        }
    }

    private class AddItem implements UserAction {

        public int key() {
            return 0;
        }

        public void execute() {
            String name = input.ask("Введите Имя задачи");
            String desc = input.ask("Введите Описание нового элемента:");
            Long date = Long.parseLong(input.ask("Введите Дату Создания нового элемента:"));
            String comment = input.ask("Введите Коментарий:");
            tracker.add(new Item(name, desc, date, comment));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Добавить новый элемент");
        }
    }
// Статический класс тут неудобен! Приходится создавать свои переменные,
// которым потом присваиваются значения из внешнего НЕстатического класса.
    private static class ShowAllElements implements UserAction {

        Tracker tracker;
        Input input;

        public ShowAllElements(Input input, Tracker tracker) {
            this.tracker = tracker;
            this.input = input;
        }

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute (){
            if (tracker.findAll().length > 0) {
                System.out.println("Выводим все элементы Трекера на экран.");
                for (int i = 0; i < tracker.findAll().length; i++) {
                    System.out.println(i + " Id элемента - " + tracker.findAll()[i].getId() +
                            " Имя - " + tracker.findAll()[i].getName());
                }
            } else {
                System.out.println("В трекере нет элементов для отображения.");
            }
        }

        @Override
        public String info() {
            return  String.format("%s. %s", this.key(), "Показать все элементы:");
        }
    }

    class DeleteElement implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute() {
            try {
                int id = Integer.parseInt(input.ask("Введите id элемента, который вы хотите удалить"));
                tracker.delete(id);
                System.out.println("Элементы с id " + id + " удален.");
            } catch (NumberFormatException n) {
                System.out.println("Неправильный формат id, повторите попытку.");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Удалить заявку:");
        }
    }

    class SearchElementById implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute() {
            // Мы исходим из того, что id не могут быть одинаковы.
            try {
                int id = Integer.parseInt(input.ask("Введите id элемента, который вы хотите найти"));
                System.out.println("Имя заявки: " + tracker.findById(id).getName());
            } catch (NumberFormatException e) {
                System.out.println("Недопустимый формат id");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Найти элемент по id");
        }
    }

    class SearchByName implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute() {
            String name = input.ask("Введите имя элемента, который вы хотите найти");
            System.out.println("Результаты поиска:");
            if (tracker.findByName(name).size() != 0) {
                System.out.println("Length = " + tracker.findByName(name).size());
                for (int i = 0; i < tracker.findByName(name).size(); i++)
                    System.out.println("id заявки: " + tracker.findByName(name).get(i).getId());
            } else {
                System.out.println("Поиск не дал результата");
            }
        }


        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Найти элемент по имени");
        }
    }

    static class Exit extends StartUI implements UserAction {

        public Exit(Input input) {
            super(input);
        }

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute() {
                StartUI.setExit();
            }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Завершить работу.");
        }
    }
}

// Внешний класс
// Тоже неудобен, так как нет возможности использовать приватные переменный класса public class MenuTracker!
class EditElement extends MenuTracker implements UserAction {

    Input input;
    Tracker tracker;

    EditElement(Input input, Tracker tracker) {
        super(input, tracker);
    }

    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute() {
        try {
            int id = Integer.parseInt(input.ask("Введите номер элемента, который вы хотите отредактировать:"));
            // Создаем элемент для замены
            String[] result = input.ask("Введите через запятую ИМЯ, ОПИСАНИЕ, ДАТУ СОЗДАНИЯ, КОМЕНТАРИЙ для нового элемента:").split(", ");
            Item itemReplace = new Item(result[0], result[1], Long.parseLong(result[2]), result[3]);
            tracker.replace(id, itemReplace);
            System.out.println("Элементу c id№" + id + " отредактирован");
        } catch (NumberFormatException n) {
            System.out.println("Вы ввели неверные данные. Повторите ввод.");
        }
    }

    @Override
    public String info() {
        return  String.format("%s. %s", this.key(), "Редактирование элементов списка:");
    }
}