package srp.calculator.gui;

import ru.job4j.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.*;

public class MathButtonGui {

    private Map<String, JButton> buttons = new HashMap<>();
    private final String[] names = new String[]{"+","-","/","*","="};

    private InteractCalcApp main;
    private Calculator calculator;
    private TextAreaGui text;

    private double[] values = new double[2];
    private String flag = null;

    /**
     * number of button clicks
     */
    private int pressed = 0;

    public MathButtonGui(InteractCalcApp main, Calculator calculator, TextAreaGui text) {
        this.main = main;
        this.calculator = calculator;
        this.text = text;
        setButtons();
        setAction();
        addButton();
    }

    private void setButtons() {
        for (int i = 0; i < names.length; i++) {
            buttons.put(names[i], new JButton(String.valueOf(names[i])));
        }
    }

    private void setAction() {
        buttons.get("=").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (flag) {
                    case "+": // +
                        values[1] = Double.valueOf(text.getText());
                        calculator.add(values[0], values[1]);
                        text.setText(String.valueOf(calculator.getResult()));
                        break;
                    case "-": // -
                        values[1] = Double.valueOf(text.getText());
                        calculator.subtract(values[0], values[1]);
                        text.setText(String.valueOf(calculator.getResult()));
                        break;
                    case "*": // *
                        // TODO Доделать
                }
            }
        });
        buttons.get("+").addActionListener((e) -> {
            buttonLogic(this.calculator, "+", "add");
            }
        );
        buttons.get("-").addActionListener((e) -> {
                    buttonLogic(this.calculator, "-", "subtract");
                }
        );
    }

    /**
     * In this method invoke function by name; uses reflection
     * @param object - the name of the class from which the function is called
     * @param f - name of math function
     * @param str - flag of button
     */
    private void buttonLogic(Object object, String f, String str) {
        if (pressed == 0) {
            // Запоминаем и обнуляем значение
            values[0] = Double.valueOf(text.getText());
            text.setText(null);
            flag = f;
        }
        if (pressed == 1) {
            values[1] = Double.valueOf(text.getText());
            try {
                Method method = object.getClass().getMethod(str);
                method.invoke(values[0],values[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setText(String.valueOf(calculator.getResult()));
            pressed = 0;
        }
        pressed++;
    }

    /**
     * Added all button on the main app interface
     */
    private void addButton() {
        List<JButton> list = new ArrayList<>(buttons.values());
        for (JButton b : list) {
            main.addButton((b));
        }
    }
}
