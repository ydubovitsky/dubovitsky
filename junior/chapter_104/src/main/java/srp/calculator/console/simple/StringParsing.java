package srp.calculator.console.simple;

import ru.job4j.Calculator;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParsing implements Observer{

    /**
     * Function_s arguments; Example a + b;
     * a=stackArg[0], b=stackArg[1]
     */
    public Double[] stackArg = new Double[2];
    public Map<String, FunctionalInterface> map = new HashMap<>();
    private String stringExpression;

    /**
     * any User_s outputStream
     */
    private OutputStream outputStream;

    public StringParsing(OutputStream out) {
        this.outputStream = out;
    }

    // TODO Можно сделать элегантней, например передавать в этот класс калькулятор и из него извлекать уже map с функциями или в интерфейсе вообще определить этот метод
    public void fillMapFunctions() {
        map.put("\\+", (a) -> {
            InteractCalc calc = new InteractCalc(new CalcWrapper(new Calculator()));
            return calc.add(a[0], a[1]);
        });
        map.put("tang", (a) -> {
            InteractCalc calc = new InteractCalc(new CalcWrapper(new Calculator()));
            return calc.tang(a[0]);
        });
        map.put("\\-", (a) -> {
            InteractCalc calc = new InteractCalc(new CalcWrapper(new Calculator()));
            return calc.subtract(a[0],a[1]);
        });
        map.put("\\*", (a) -> {
            InteractCalc calc = new InteractCalc(new CalcWrapper(new Calculator()));
            return calc.multiple(a[0], a[1]);
        });
        map.put("\\\\", (a) -> {
            InteractCalc calc = new InteractCalc(new CalcWrapper(new Calculator()));
            return calc.div(a[0], a[1]);
        });
    }

    /**
     * Этот метод ищет числовые аргументы в строке!
     * stringExpression; это строка которая приходит от Субъекта.
     */
    private synchronized void getArg() {
        try {
            while (stringExpression == null) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
        Pattern pattern = Pattern.compile("[+-]?([0-9]*[.])?[0-9]+");
        Matcher matcher = pattern.matcher(stringExpression);
        while (matcher.find()) {
            stackArg[0] = Double.valueOf(matcher.group());
            stackArg[1] = Double.valueOf(matcher.group());
        }
    }

    /**
     * Этот метод проссматривает набор ключей(имен функций) из карты, если он нашел такой ключ,
     * то выполняет метод, связанный с этим ключем
     */
    public double calculate() {
        Double result = null;
        Set<String> set = map.keySet();
        for (String o : set) {
            Pattern pattern = Pattern.compile(o);
            Matcher matcher = pattern.matcher(stringExpression);
            if (matcher.find()) {
                result = map.get(o).calculate(stackArg);
                break;
            }
        }
        return result;
    }

    /**
     * В этом методе результат вычисления должен записываться в любой выходной поток,
     * полученный в конструкторе
     * @param d
     */
    // TODO Fix it! Not Work!
    public void writeOut(double d) {
        DataOutputStream data = new DataOutputStream(outputStream);
        try {
            data.writeChars(String.valueOf(d));
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Этот метод обновляет значение входной пользовательской строки с математическим выражеением
     * и вызывает метод вычисления выражения.
     * @param string
     */
    @Override
    public void update(String string) {
        this.stringExpression = string;
        getArg();
        System.out.println(calculate());
    }
}
