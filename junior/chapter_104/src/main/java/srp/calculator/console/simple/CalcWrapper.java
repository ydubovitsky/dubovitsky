package srp.calculator.console.simple;

import ru.job4j.Calculator;

/**
 * This is class-wrapper under Calculator!
 */
//TODO Не уверен что это нужно делать =) Но должно пригодиться
public class CalcWrapper implements Calculable{

    private Calculator calculator;

    public CalcWrapper(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public double add(double a, double b) {
        calculator.add(a,b);
        return calculator.getResult();
    }

    @Override
    public double subtract(double a, double b) {
        calculator.subtract(a,b);
        return calculator.getResult();
    }

    @Override
    public double div(double a, double b) {
        calculator.div(a,b);
        return calculator.getResult();
    }

    @Override
    public double multiple(double a, double b) {
        calculator.multiple(a,b);
        return calculator.getResult();
    }

    @Override
    public double getResult() {
        return calculator.getResult();
    }
}
