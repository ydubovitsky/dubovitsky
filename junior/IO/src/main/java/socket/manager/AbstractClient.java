package socket.manager;

public class AbstractClient implements Client {

    /**
     * Любой класс, реализующий интерфейс Сервер.
     */
    private Server server;

    /**
     * Конструктор. Используем компазицию.
     * @param server
     */
    public AbstractClient (Server server) {
        this.server = server;
    }
}