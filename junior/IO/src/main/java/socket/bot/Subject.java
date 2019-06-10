package socket.bot;

import java.net.Socket;

/**
 * Subject Interface
 */
public interface Subject {

    void addObserver(Socket socket);

    void unregisterObserver(Socket socket);
}

