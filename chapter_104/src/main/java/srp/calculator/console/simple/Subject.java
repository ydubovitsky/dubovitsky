package srp.calculator.console.simple;

/**
 * Интерфейс - Субъект; Реализуется классом, который изменяет состояние и
 * оповещает об этом наблюдателей.
 */
public interface Subject {

    boolean registerObserver(Observer o);

    boolean removeObserver(Observer o);

    void notifyObserver();

}
