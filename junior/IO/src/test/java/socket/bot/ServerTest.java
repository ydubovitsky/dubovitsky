package socket.bot;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

    Server server;

    @Before
    void setUp() throws UnknownHostException {
        server = new Server(3000, new Answers());
    }

    @Test
    void getInputStream() {
        byte[] bytes = "Successful test!".getBytes();
        ByteArrayInputStream i = new ByteArrayInputStream(bytes);
        server.consoleOut(i);
        //TODO НЕ понимаю как протестировать выходной поток
    }
}