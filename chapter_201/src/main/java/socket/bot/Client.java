package socket.bot;

import java.io.*;
import java.net.Socket;

/**
 * The client class
 */
public class Client implements Observer {

    private final String host = "127.0.0.1";
    private int port = 4343;
    private Server server;
    private Socket socket;

    private void start() {
            try {
                this.socket = new Socket(host, port);
                OutputStream out = this.socket.getOutputStream();
                InputStream input = this.socket.getInputStream();
                // gets Server object for uses Server public API like register and unregister
                try {
                    ObjectInputStream object = new ObjectInputStream(new DataInputStream(input));
                    this.server = (Server) object.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

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
            w.write(userMessage() + "\n");
            w.flush();
            // Message from the server
            String serverMsg;
            try {
                serverMsg = b.readLine();
                System.out.println("Server: " + serverMsg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Get message from the console
     * @return - console message.
     */
    private String userMessage() {
        String msg = null;
        BufferedReader userReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            msg = userReader.readLine();
            switch (msg) {
                case "stop" : unregister();
                break;
                case "start" :register();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }

    public void unregister() {
        this.server.unregisterObserver(this.socket);
    }

    public void register() {
        this.server.addObserver(this.socket);
    }

    public static void main(String[] args) {
        new Client().start();
    }
}
