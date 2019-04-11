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
     * User`s input stream data
     */
    private InputStream inputStream;

    private Socket socket;


    public Client(InetAddress inetAddress, int port, InputStream inputStream) {
        this.inetAddress = inetAddress;
        this.port = port;
        this.inputStream = inputStream;
    }

    /**
     * This method create new connection to server and create new socket.
     */
    public void connection() {
        try {
            this.socket = new Socket(this.inetAddress, port);

            while (true) {

                // create IO streams
                OutputStream o = this.socket.getOutputStream();
                InputStream i = this.socket.getInputStream();

                // invoke 2 methods
                //TODO разобраться с этими 2мя методами и возможно вывести
                // их в интерфейс или абстрактный класс для сервера и клиента!
                this.sendMsg(o, getUserInput());

                // invoke method from parent`s class
                this.consoleOut(i);
                o.close();
                i.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getting user`s InputStream from console
     */
    public InputStream getUserInput() {
        // from console...
        BufferedInputStream b = new BufferedInputStream(System.in);
        return b;
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client(InetAddress.getLocalHost(), 3000, System.in);
        client.connection();
        //client.sendMsg();
    }
}
