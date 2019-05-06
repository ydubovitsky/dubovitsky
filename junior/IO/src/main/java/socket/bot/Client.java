package socket.bot;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The client class
 */
public class Client extends DataExchange{

    /**
     * Server`s inet address
     */
    private final InetAddress inetAddress;

    /**
     * Server`s port
     */
    private final int port;

    /**
     * Client`s socket
     */
    private Socket socket;

    /**
     * IO Streams
     */
    private InputStream inputStream;
    private OutputStream outputStream;

    /**
     * Count of try connection to server
     */
    private int count = 20;


    public Client(InetAddress inetAddress, int port) {
        this.inetAddress = inetAddress;
        this.port = port;
    }

    /**
     * This method create new connection to server and create new socket.
     */
    public boolean connection() {
        //TODO Почему нельзя вынести за пределеы метода?
        // connection flag
        boolean connection = false;
        try {
            this.socket = new Socket(this.inetAddress, port);
            if (this.socket != null) {
                connection = true;
            }
            // create new IO streams
            this.outputStream = this.socket.getOutputStream();
            this.inputStream = this.socket.getInputStream();
        } catch (IOException e) {
            System.out.println("Reconnection... Try № " + this.count--);
        }
        return connection;
    }

    public static void main(String[] args) throws Exception {
        // create client
        Client client = new Client(InetAddress.getLocalHost(), 3000);
        // set user input
        client.setUserInput(new ByteArrayInputStream("Hello".getBytes()));
        // starting client
        while (client.connection() || client.count > 0) {
            //TODO Тело метода где будут отсылаться и получаться сообщения
            if (client.socket != null && client.socket.isConnected()) {
                while (client.socket.isConnected()) {
                    client.sendMsg(client.outputStream, client.userInput);
                }
            }
        }
    }
}
