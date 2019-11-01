package srp.calculator.console.simple;

import ru.job4j.Calculator;

public class InteractCalc {

    private Calculator calculator;
    private double calculateResult;

    public InteractCalc(Calculator calculator) {
        this.calculator = calculator;
    }

    /**
     * This method return result of "+";
     */
    //TODO Что это за шаблон? Адаптер?
    public double add(double a, double b) {
        calculator.add(a,b);
        return calculateResult = calculator.getResult();
    }

    /**
     * Return result of last calculation!
     * @return
     */
    private double getLastResult() {
        return calculateResult;
    }

    /**
     * Tang calculation!
     * @param a
     * @return
     */
    public double tang(double a) {
        return Math.tan(a);
    }
}
