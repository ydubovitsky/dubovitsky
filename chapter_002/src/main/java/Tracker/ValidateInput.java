package Tracker;

public class ValidateInput extends ConsoleInput {

    @Override
    public String ask(String question) {
        int value = -1;
        try {
            value = Integer.parseInt(super.ask(question));
            // Используются константы - плохо.
            if (value >= 6 || value < 0) {
                throw new MenuOutException("Необходимо выбрать значение из диапазона меню");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " Введите значение в цифровом формате");
        } catch (MenuOutException e) {
            System.out.println(e.getMessage() + " Выкидываем рукотворное исключение");
        } catch (Exception e) {
            System.out.println(e.getMessage() + " Упс, что то пошло не так!");
        }
        return String.valueOf(value);
    }

    @Override
    public int ask(String question, int[] range) {
        return -1;
    }
}
