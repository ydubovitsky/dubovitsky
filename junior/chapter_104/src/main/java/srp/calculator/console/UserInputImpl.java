package srp.calculator.console;

import ru.job4j.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputImpl implements UserInput {

    InputStream input;
    Calculator calculator;

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

    private List<Double> variables  = new ArrayList<>();

    /**
     * Return string from console
     * @return
     */
    private String getString() {
        String str = null;
        try {
            // getting user input
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            // TODO Проблема с возвращаемым значением
            str = reader.readLine();
        }catch (IOException e) {
            System.out.println("Repeat input");
        }
        return str;
    }

    /**
     * This method added two numbers into list;
     * @param str
     */
    private void getNumbers(String str) {
        variables.clear(); // clearing list before add a new values
        Pattern pattern = Pattern.compile("\\d");
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
                    // it is wrong; replace 0 and 1
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
        getNumbers(getString());
        doAction(getString());
    }
}
