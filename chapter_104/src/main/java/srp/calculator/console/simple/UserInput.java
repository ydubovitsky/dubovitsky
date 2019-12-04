package srp.calculator.console.simple;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User input
 */
class UserInput implements Subject, Runnable{

    private InputStream input;

    /**
     * User_s input string from some king InputStream
     */
    private String userString;

    private List<Observer> observers = new ArrayList<>();

    /**
     * Constructor
     * @param in
     */
    public UserInput(InputStream in) {
        this.input = in;
    }

    /**
     * This method fill the string stack from UserInput;
     * And Starting new Thread!
     */
    public void fillStack() {
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            userString = scanner.next();
            // Строка меняет свое состояние и все наблюдатели оповещабтся
            notifyObserver();
        }
    }

    @Override
    public boolean registerObserver(Observer o) {
        return observers.add(o);
    }

    @Override
    public boolean removeObserver(Observer o) {
        return observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(this.userString);
        }
    }

    @Override
    public void run() {
        fillStack();
    }
}
