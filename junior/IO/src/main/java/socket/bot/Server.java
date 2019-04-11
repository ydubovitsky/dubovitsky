package socket.bot;

import java.io.*;
import java.net.*;

/**
 * The server class
 */
public class Server extends DataExchange {

    /**
     * Server s port.
     */
    private int serverPort;

    /**
     * Server socket object
     */
    private Socket serverSocket = null;

    /**
     * Oracle s answers.
     */
    private AnswersQuestions answers;

    /**
     * Chat "exit' word
     */
    private final String exit = "пока";

    /**
     * Client s data
     */
    private DataInputStream dataInput;

    /**
     * Constructor
     * @param port - server s port
     */
    public Server(int port, AnswersQuestions answers) {
        this.serverPort = port;
        this.answers = answers;
        this.connection();
    }

    /**
     * Create server socket.
     * @return - socket
     */
    public void connection() {
        // create server socket
        try{
            ServerSocket s = new ServerSocket(this.serverPort);
            this.serverSocket = s.accept();
            InputStream i = serverSocket.getInputStream();
            OutputStream o = serverSocket.getOutputStream();
            while (true) {

                // invoke method from parent`s class
                this.consoleOut(i);

                this.sendMsg(o, getUserInput());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getting user`s InputStream from another class.
     */
    public InputStream getUserInput() {
        // getting random answer;
        String answer = new Answers().getAnswer();

        // getting new is
        ByteArrayInputStream data = new ByteArrayInputStream(answer.getBytes());
        return data;
    }

    public static void main(String[] args) throws Exception{
        Server server = new Server(3000, new Answers());
        //server.inputСonnection();
        //server.answer();
        //server.getAllAdress();
    }
}

