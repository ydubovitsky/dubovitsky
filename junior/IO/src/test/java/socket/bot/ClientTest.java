package socket.bot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;


class ClientTest {

    Client client;

    @BeforeEach
    void setUp() throws UnknownHostException {
        client = new Client(InetAddress.getLocalHost(), 3000);
    }
}