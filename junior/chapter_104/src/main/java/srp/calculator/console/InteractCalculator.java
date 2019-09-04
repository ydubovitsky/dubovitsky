package srp.calculator.console;

import ru.job4j.Calculator;

/**
 * Input into console expression:
 * Examples: 1+1, 45*45, 35/5, 10-2;
 * Press button: 'Enter'
 */
public class InteractCalculator {

    private UserInput ui;

    public InteractCalculator(UserInput ui) {
        this.ui = ui;
    }

    private void starting() {
        while (true) {
            System.out.println("Введите выражение: ");
            ui.starting();
        }
    }

    public static void main(String[] args) {
        new InteractCalculator(new UserInputImpl(System.in, new Calculator())).starting();
    }

}
