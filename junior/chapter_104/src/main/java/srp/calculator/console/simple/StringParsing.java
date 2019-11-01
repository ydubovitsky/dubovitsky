package srp.calculator.console.simple;

import ru.job4j.Calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParsing {

    public List<Double> arg = new ArrayList<>();
    public String functionName;
    public Map<String, FunctionalInterface> map = new HashMap<>();

    //TODO Тут я пытаюсь связать сразу знак "+" с функцией!
    public void fillMapFunctions() {
        map.put("+", (a) -> {
            InteractCalc calc = new InteractCalc(new Calculator());
            return calc.add(a[0], a[1]);
        });
        map.put("tang", (a) -> {
            InteractCalc calc = new InteractCalc(new Calculator());
            return calc.tang(a[0]);
        });
    }

    /**
     * Этот метод ищет числовые аргументы в строке!
     * @param str
     */
    public void getArg(String str) {
        arg.clear(); // clearing list before add a new values
        Pattern pattern = Pattern.compile("[+-]?([0-9]*[.])?[0-9]+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            arg.add(Double.valueOf(matcher.group()));
        }
    }

    public void getFunction(String str) {
        //TODO Тут должно быть выражение, которые будет проссматривать все ключи из MAP
        // И если такой ключ найден, то добавляет его в functionName
        for (String action : map.keySet()) {
            Pattern pattern = Pattern.compile(action);
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                functionName = action;
                break;
            }
        }
    }



    public static void main(String[] args) {
        StringParsing stringParsing = new StringParsing();
        stringParsing.fillMapFunctions();
        stringParsing.getArg("2+2");
        System.out.println(stringParsing.map.get("+").calculate(stringParsing.arg.get(0), stringParsing.arg.get(1)));
        System.out.println(stringParsing.map.get("tang").calculate(new double[]{1,1}));
    }
}
