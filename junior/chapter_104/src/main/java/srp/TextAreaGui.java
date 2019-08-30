package srp;

import javax.swing.*;

public class TextAreaGui {

    public JTextArea getjTextArea() {
        return jTextArea;
    }

    private JTextArea jTextArea;
    private InteractCalcApp interactCalcApp;

    public TextAreaGui(InteractCalcApp i) {
        this.interactCalcApp = i;
        jTextArea = new JTextArea();
        addTextArea();
    }

    public void addTextArea() {
        this.interactCalcApp.addButton(getjTextArea());
    }
}
