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


    public Client(InetAddress inetAddress, int port) {
        this.inetAddress = inetAddress;
        this.port = port;
    }

    /**
     * This method create new connection to server and create new socket.
     */
    public void connection() {
        try {
            this.socket = new Socket(this.inetAddress, port);
            while (true) {
                // create new IO streams
                OutputStream o = this.socket.getOutputStream();
                InputStream i = this.socket.getInputStream();
                // invoke 2 methods
                this.sendMsg(o, this.userInput);

                // invoke method from parent`s class
                this.consoleOut(i);
                // close 2 streams
                o.close();
                o.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        // create client
        Client client = new Client(InetAddress.getLocalHost(), 3000);
        // set user input
        client.setUserInput(new BufferedInputStream(System.in));
        // starting client
        client.connection();
    }
}
