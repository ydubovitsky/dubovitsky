package srp.calculator.console.simple;

/**
 * This class implements basis calculable interface;
 */
public class InteractCalc implements Calculable{

    private Calculable calculator;
    private double calculateResult;

    public InteractCalc(Calculable calculator) {
        this.calculator = calculator;
    }

    /**
     * This method return result of "+";
     */
    //TODO Что это за шаблон? Адаптер?
    public double add(double a, double b) {
        calculator.add(a,b);
        return calculateResult = getResult();
    }

    public double subtract(double a, double b) {
        calculator.subtract(a,b);
        return calculateResult = getResult();
    }

    public double div(double a, double b) {
        calculator.div(a,b);
        return calculateResult = getResult();
    }

    public double multiple(double a, double b) {
        calculator.multiple(a,b);
        return calculateResult = getResult();
    }

    @Override
    public double getResult() {
        return calculator.getResult();
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
