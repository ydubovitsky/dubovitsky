package srp;

import ru.job4j.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MathButtonGui {

    private Map<String, JButton> buttons = new HashMap<>();
    private final String[] names = new String[]{"+","-","/","*","="};

    private InteractCalcApp main;
    private Calculator calculator;

    private double[] values = new double[2];
    private String flag = null;

    /**
     * number of button clicks
     */
    private int pressed = 0;

    public MathButtonGui(InteractCalcApp main, Calculator calculator) {
        this.main = main;
        this.calculator = calculator;
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
                        values[1] = Double.valueOf(main.gettingText().getText());
                        calculator.add(values[0], values[1]);
                        main.gettingText().setText(String.valueOf(calculator.getResult()));
                        break;
                    case "-": // -
                        values[1] = Double.valueOf(main.gettingText().getText());
                        calculator.subtract(values[0], values[1]);
                        main.gettingText().setText(String.valueOf(calculator.getResult()));
                        break;
                }
            }
        });
        // TODO Упростить
        buttons.get("+").addActionListener((e) -> {
                if (pressed == 0) {
                    // Запоминаем и обнуляем значение
                    values[0] = Double.valueOf(main.gettingText().getText());
                    main.gettingText().setText(null);
                    flag = "+";
                }
                if (pressed == 1) {
                    values[1] = Double.valueOf(main.gettingText().getText());
                    calculator.add(values[0], values[1]);
                    main.gettingText().setText(String.valueOf(calculator.getResult()));
                    pressed = 0;
                }
                pressed++;
            }
        );
        // TODO Упростить
        buttons.get("-").addActionListener((e) -> {
                    if (pressed == 0) {
                        // Запоминаем и обнуляем значение
                        values[0] = Double.valueOf(main.gettingText().getText());
                        main.gettingText().setText(null);
                        flag = "-";
                    }
                    if (pressed == 1) {
                        values[1] = Double.valueOf(main.gettingText().getText());
                        calculator.subtract(values[0], values[1]);
                        main.gettingText().setText(String.valueOf(calculator.getResult()));
                        pressed = 0;
                    }
                    pressed++;
                }
        );
    }

    private void addButton() {
        List<JButton> list = new ArrayList<>(buttons.values());
        for (JButton b : list) {
            main.addButton((b));
        }
    }
}
