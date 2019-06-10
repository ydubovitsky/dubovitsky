package socket.bot;

import java.io.*;
import java.net.Socket;

/**
 * The client class
 */
public class Client {

    private final String host = "127.0.0.1";
    private int port = 4343;

    private void start() {
            try {
                Socket socket = new Socket(host, port);
                OutputStream out = socket.getOutputStream();
                InputStream input = socket.getInputStream();

                // call method
                sendAndGet(input, out);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    /**
     * Gets message from input stream and outputs on the console.
     */
    private void sendAndGet(InputStream i, OutputStream o) {
            BufferedReader b = new BufferedReader(new InputStreamReader(i));
            PrintWriter w = new PrintWriter(new OutputStreamWriter(o));
            while (true) {
            w.write(userInput() + "\n");
            w.flush();
            String msg1;
            try {
                msg1 = b.readLine();
                System.out.println("Server say " + msg1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Get message from the console
     * @return - console message.
     */
    private String userInput() {
        String msg = null;
        BufferedReader userReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            msg = userReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }

    public static void main(String[] args) {
        new Client().start();
    }
}
