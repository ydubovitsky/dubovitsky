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
    public void connection() {
        while (true) {
            try (Socket socket = new Socket(this.inetAddress, port)) {
                //TODO Обрати внимание!
                processMsg(socket.getInputStream(), System.out);
                System.out.println("Вышел из метода");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method write into output stream user`s data from input stream;
     * @param outputStream
     * @param inputStream
     */
    public void processMsg(InputStream inputStream, OutputStream outputStream) {
        try(PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String msg;
            while ((msg = reader.readLine()) != null) {
                writer.write(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        // create client
        Client client = new Client(InetAddress.getLocalHost(), 4343);
        // set user input
        client.connection();
    }
}
