package srp;

import ru.job4j.Calculator;

import javax.swing.*;
import java.awt.*;

public class MainGui {

    private final JFrame frame;
    private KeyBoardGui keyBoard;
    private MathButtonGui mathButton;
    private JTextArea text;

    public MainGui() {
        frame = new JFrame();
        text = new JTextArea();
        keyBoard = new KeyBoardGui(this);
        mathButton = new MathButtonGui(this, this.keyBoard, new Calculator());
    }

    /**
     * Add some button on the panel
     * @param component
     */
    public void addButton(Component component) {
        this.frame.add(component);
    }

    private void interfaceGeneration() {
        frame.setLayout(new GridLayout(4,4));
        frame.add(text);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MainGui m = new MainGui();
        m.interfaceGeneration();
    }

    public JTextArea gettingText() {
        return text;
    }
}
