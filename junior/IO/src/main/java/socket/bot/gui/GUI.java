package socket.bot.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JFrame jFrame;
    private JPanel jPanel;
    private JTextArea jTextArea;
    private JLabel jLabel;
    private JButton jButton;

    public static void main(String[] args) {
        new GUI().build();
    }

    //TODO Убрать константы из метода или добавить их в переменные эеземпляра с модификатором final
    private void build() {
        this.jLabel = new JLabel("Socket Chat with Smart Oracle");
        this.jTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(
                this.jTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        jScrollPane.setSize(300,300);
        jTextArea.setRows(15);
        this.jButton = new JButton("Send Message");
        this.jButton.addActionListener(new ButtonListener());
        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(jLabel);
        box.add(jScrollPane);
        box.add(jButton);
        this.jPanel = new JPanel();
        this.jPanel.add(BorderLayout.CENTER, box);
        this.jFrame = new JFrame();
        this.jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.jFrame.getContentPane().add(this.jPanel);
        this.jFrame.setSize(300,400);
        this.jFrame.setVisible(true);
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
