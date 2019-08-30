package srp;

import ru.job4j.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MathButtonGui {

    private Map<String, JButton> buttons = new HashMap<>();
    private final String[] names = new String[]{"+","-","/","*","="};

    private MainGui main;
    private KeyBoardGui keyBoard;
    private Calculator calculator;

    private double[] values = new double[2];
    private int flag = 0;

    /**
     * number of button clicks
     */
    private int pressed = 0;

    public MathButtonGui(MainGui main, KeyBoardGui keyBoard, Calculator calculator) {
        this.main = main;
        this.keyBoard = keyBoard;
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
                    case 1: // +
                        values[1] = Double.valueOf(main.gettingText().getText());
                        calculator.add(values[0], values[1]);
                        main.gettingText().setText(String.valueOf(calculator.getResult()));
                        break;
                    case 2: // -
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
                    flag = 1;
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
                        flag = 2;
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


    public Map<String, JButton> getButtons() {
        return buttons;
    }
}
