package srp.calculator.console.simple;

/**
 * * Интерфейс - Наблюдатель; Реализуется всеми классами, которые наблюдают
 *  * за состояниями субъекта.
 */
public interface Observer {

    void update(String string);

}
