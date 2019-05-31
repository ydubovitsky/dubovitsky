package socket.bot;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * The server class
 */
public class Server extends DataExchange {

    /**
     * Server s port.
     */
    private int serverPort;

    /**
     * Oracle s answers.
     */
    private AnswersQuestions answers;

    /**
     * List of Clients for sending msg
     */
    private ArrayList<OutputStream> clientsOut;

    /**
     * Constructor
     *
     * @param port - server s port
     */
    public Server(int port) {
        this.serverPort = port;
        this.clientsOut = new ArrayList<>();
        this.answers = new Answers();
    }

    /**
     * Log-file;
     */
    private final String log = "logs.txt";

    /**
     * Create server socket.
     * @return - socket
     */
    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(this.serverPort);
            while (true) {
                Socket socket = serverSocket.accept();

                //TODO Может быть добавлять сокет а не выходной поток? Тогда во внутреннем классе
                // меньше будет проверок?
                // add clients into list
                clientsOut.add(socket.getOutputStream());

                // starting a new thread
                Thread thread = new Thread(new ClientsProcess(socket));
                thread.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sending msg for all register classes;
     * @param msg
     */
    private void sendMsgAllClients(String msg) {
        for (int i = 0; i < clientsOut.size(); i++) {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(clientsOut.get(i)), true);
            pw.println(msg);
        }
    }

    /**
     * Inner class for process clients requests.
     */
    private class ClientsProcess implements Runnable {

        /**
         * Input Socket
         */
        Socket socket;

        /**
         * Chat key words
         */
        private final String exit = "пока";
        private final String start = "старт";

        /**
         * Constructor
         * @param socket
         */
        public ClientsProcess(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            new ClientsProcess(socket).sendAnswer();
        }

        /**
         * This method process clients msg and sending answers.
         */
        private void sendAnswer() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                String clientMsg = br.readLine();

                // checking! if client sending "stop words", him remove from observers list;
                if (clientMsg.equals(exit)) {
                    //TODO Или синхронизировать весь метод?
                    synchronized(this) {
                        clientsOut.remove(this.socket.getOutputStream());
                    }
                }
                if (clientMsg.equals(start)) {
                    // if List of clients not contain this socket, add into list
                    synchronized (this) {
                        if (!clientsOut.contains(socket.getOutputStream())) {
                            clientsOut.add(socket.getOutputStream());
                        }
                    }
                    // invoke method from outer class
                    sendMsgAllClients(answers.getAnswer());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // starting server
        new Server(4343).start();
    }
}

