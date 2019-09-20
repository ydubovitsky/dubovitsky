package srp.calculator.console;

import ru.job4j.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputImpl implements UserInput {

    InputStream input;
    Calculator calculator;

    /**
     * queue with strings from user input
     */
    Queue<String> list = new ArrayDeque<>();

    /**
     * List with a and b from expression;
     * Example a + b = c;
     */
    private List<Double> variables  = new ArrayList<>();

    public UserInputImpl(InputStream reader, Calculator calculator) {
        this.input = reader;
        this.calculator = calculator;
    }

    /**
     * Map of math constant
     */
    private final Map<String, String> map = Map.ofEntries(
            Map.entry("\\+", "add"),
            Map.entry("-", "subtract"),
            Map.entry("\\*", "multiple"),
            Map.entry("/", "div")
    );

    /**
     * Return string from console
     * @return
     */
    private void getString() {
        Scanner scanner = new Scanner(input);
        String s = scanner.nextLine();
        list.add(s);
    }

    /**
     * This method added two numbers into list;
     * @param str
     */
    private void getNumbers(String str) {
        variables.clear(); // clearing list before add a new values
        Pattern pattern = Pattern.compile("[+-]?([0-9]*[.])?[0-9]+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            variables.add(Double.valueOf(matcher.group()));
        }
    }

    /**
     * This method invoke method by name from list operations;
     * @param str - string for searching
     */
    private double doAction(String str) {
        double result = 0;
        Set<String> set = map.keySet();
        for (String o : set) {
            Pattern pattern = Pattern.compile(o);
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                try {
                    // invoke method by name
                    Method method = calculator.getClass().getMethod(map.get(o), double.class, double.class);
                    method.invoke(calculator, variables.get(0), variables.get(1));
                    result = calculator.getResult();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        System.out.println(result);
        return result;
    }

    public void starting() {
        getString();
        String str = list.poll();
        getNumbers(str);
        doAction(str);
    }
}
