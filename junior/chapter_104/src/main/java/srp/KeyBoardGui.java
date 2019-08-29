package srp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import static srp.Validation.validation;

public class KeyBoardGui {

    private Map<String, JButton> buttons = new HashMap<>();
    private JButton clear = new JButton("Clear");
    private MainGui main;

    /**
     * Attention! This is current value in textArea
     */
    private double[] global = new double[2];

    /**
     * Count pressed of button;
     */
    private int pressed = 0;

    public KeyBoardGui(MainGui main) {
        this.main = main;
        setButtons();
        setAction();
        addButtons();
    }

    /**
     * In this method fill map from 0 to 9
     */
    private void setButtons() {
        for (int i = 0; i < 10; i++) {
            buttons.put(String.valueOf(i), new JButton(String.valueOf(i)));
        }
    }

    /**
     * In this method for all button assigned ActionListener
     */
    private void setAction() {
        // getting list of buttons
        List<JButton> list = new ArrayList<>(buttons.values());
        for (JButton b : list) {
            // можно заменить на лямбду
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    main.gettingText().setText(buttons.get(b).);
                }
            });
        }
    }

    /**
     * Added all button on main panel
     */
    private void addButtons() {
        List<JButton> list = new ArrayList<>(buttons.values());
        for (JButton b : list) {
            main.addButton((b));
        }
    }

    public Map<String, JButton> getButtons() {
        return buttons;
    }

    public double[] getGlobal() {
        return global;
    }
}
