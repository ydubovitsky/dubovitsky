package tracker;

public class ValidateInput extends ConsoleInput {

    public int ask(String question, int range) {
        int key = -1;
        boolean validate = true;
        do {
            try {
                key = Integer.valueOf(ask(question));
                if (key > range || key < 0) {
                    throw new MenuOutException("Необходимо выбрать значение из диапазона меню");
                } else {
                    validate = false;
                }
            } catch (MenuOutException exp) {
                System.out.println(exp.getMessage());
            } catch (NumberFormatException exp) {
                System.out.println("Необходимо ввести корректное значение");
            }
        } while(validate);
        return key;
    }
}
