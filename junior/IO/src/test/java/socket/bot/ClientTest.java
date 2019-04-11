package socket.bot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    Client client;


    @BeforeEach
    void setUp() throws UnknownHostException {
        client = new Client(InetAddress.getLocalHost(), 3000, System.in);
    }

    @Test
    void sendMsgOnServer() {
        ByteArrayInputStream b = new ByteArrayInputStream("Successful testing".getBytes());
        OutputStream o = System.out;
        client.sendMsg(o, b);
    }
}