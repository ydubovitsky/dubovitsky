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
        // TODO Упростить
        buttons.get("+").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Доработать логику
                double first = 0;
                double second = 0;
                if (pressed == 0) {
                    first = keyBoard.getGlobal()[0];
                    second = keyBoard.getGlobal()[1];
                    pressed++;
                }
                if (pressed == 1) {
                    first = keyBoard.getGlobal()[0];
                    second = keyBoard.getGlobal()[0];
                    pressed = 0;
                }
                calculator.add(first, second);
                main.gettingText()
                        .setText(calculator.getResult() + "");
            }
        });
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
