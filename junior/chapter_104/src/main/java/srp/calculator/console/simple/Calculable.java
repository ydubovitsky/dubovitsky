package srp.calculator.console.simple;

/**
 * Базовый интерфейс для калькулятора.
 */
public interface Calculable {

    /**
     * a + b
     */
    double add(double a, double b);

    /**
     * a - b
     */
    double subtract(double a, double b);

    /**
     * a / b
     */
    double div(double a, double b);

    /**
     * a * x
     */
    double multiple(double a, double b);

    double getResult();
}
