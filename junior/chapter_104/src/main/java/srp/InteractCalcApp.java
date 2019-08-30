package srp;

import ru.job4j.Calculator;

import javax.swing.*;
import java.awt.*;

public class InteractCalcApp {

    private final JFrame frame;
    // TODO улучшить очень много зависимостей в связанном коде!
    // TODO Сделать геттеры тут?
    private KeyBoardGui keyBoard;
    private MathButtonGui mathButton;
    private TextAreaGui text;

    public InteractCalcApp() {
        frame = new JFrame();
        text = new TextAreaGui(this);
        keyBoard = new KeyBoardGui(this, text);
        mathButton = new MathButtonGui(this, new Calculator(), this.text);
    }

    /**
     * Add some button on the panel
     * @param component
     */
    public void addButton(Component component) {
        this.frame.add(component);
    }

    /**
     * This method create calculator graphic interface
     */
    private void interfaceGeneration() {
        frame.setLayout(new GridLayout(4,4));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        InteractCalcApp m = new InteractCalcApp();
        m.interfaceGeneration();
    }
}
