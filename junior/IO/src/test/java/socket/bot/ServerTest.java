package socket.bot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

class ServerTest {

    Server server;

    @BeforeEach
    void setUp() {
        this.server = new Server(3000);
    }
}