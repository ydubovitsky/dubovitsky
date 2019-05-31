package socket.bot;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

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
     * Socket and IO streams;
     */
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    /**
     * Constructor
     * @param inetAddress - server Address
     * @param port - server port
     */
    public Client(InetAddress inetAddress, int port) {
        this.inetAddress = inetAddress;
        this.port = port;
    }

    /**
     * This method create new connection to server and create new socket.
     */
    public void start() {
        while (true) {
            try {
                socket = new Socket(inetAddress, port);
                this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                //TODO Можно добавить болье абстракции заменив PrintWriter На OutputStream
                this.writer = new PrintWriter(socket.getOutputStream());

                // Starting a new thread for sending process
                Thread thread = new Thread(new SendingMsg(this.writer));
                thread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Inner class for sending msg to server;
     */
    class SendingMsg implements Runnable{

        PrintWriter writer;

        public SendingMsg(PrintWriter writer) {
            this.writer = writer;
        }

        @Override
        public void run() {
            sendMsg(writer, getConsoleMsg());
        }

        /**
         * This method getting OutputStream and write into msg
         * @param writer
         * @param msg
         */
        public void sendMsg(PrintWriter writer, String msg) {
                writer.write(msg);
                writer.flush();
                writer.close();
        }

        /**
         * Return string from console
         * @return - console string.
         */
        private String getConsoleMsg() {
            String result = null;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                result = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
    }


    public static void main(String[] args) throws Exception {
        // create client
        new Client(InetAddress.getLocalHost(), 4343).start();
    }
}
