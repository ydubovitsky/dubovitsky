package socket.bot;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * The server class, implements pattern Observer;
 */
public class Server implements Subject, Serializable {

    private final int port = 4343;
    private AnswersQuestions answers;
    private List<Socket> observers = new ArrayList<>();

    private Server(AnswersQuestions answers) {
        this.answers = answers;
    }

    private void start() {
        // first cycle for a permanent server
        while (true) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                while (true) {
                    // this cycle for connected client
                    Socket socket = serverSocket.accept();

                    // add new observer
                    addObserver(socket);

                    // call method
                    logicProcess(socket);
                }
                // if previous cycle ended, this method go to first cycle and starts waiting a new client!
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void logicProcess(Socket socket) {
        try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientMsg;
            while ((clientMsg = reader.readLine())!= null) {
                System.out.println(clientMsg);
                // if client send "stop"
                if (clientMsg.equals("stop")) {
                    unregisterObserver(socket);
                }
                // if client sending anything than "stop"
                else {
                    sendAnswer();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Register socket like Observer and send him Object Server;
     * @param socket
     */
    public void addObserver(Socket socket) {
        try {
            // create and sending for client this object (SERVER) =) stupid, but fun
            ObjectOutputStream object = new ObjectOutputStream(new DataOutputStream(socket.getOutputStream()));
            object.writeObject(this);
            this.observers.add(socket);
            System.out.println("Count of registers users = " + observers.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends answers for all register clients
     */
    private void sendAnswer() {
        try {
            for (Socket socket : observers) {
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                writer.write(this.answers.getAnswer() + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void unregisterObserver(Socket socket) {
        observers.remove(socket);
        System.out.println("Count of registers users = " + observers.size());
    }

    public static void main(String[] args) {
        new Server(new Answers()).start();
    }
}

