package srp.calculator.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyBoardGui {

    private Map<String, JButton> buttons = new HashMap<>();
    private InteractCalcApp main;
    private TextAreaGui text;

    public KeyBoardGui(InteractCalcApp main, TextAreaGui text) {
        this.main = main;
        this.text = text;
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
                    // old text
                    String local = text.getText();
                    // update text
                   text.setText(local + b.getText());
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
}
