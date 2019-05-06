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
    private Socket serverSocket;

    /**
     * Oracle s answers.
     */
    private AnswersQuestions answers;

    /**
     * Chat "exit' word
     */
    private final String exit = "пока";

    /**
     * IO Streams
     */
    private InputStream inputStream;
    private OutputStream outputStream;

    /**
     * Constructor
     * @param port - server s port
     */
    public Server(int port) {
        this.serverPort = port;
        this.answers = answers;
    }

    /**
     * Answers setter;
     * @param answers
     */
    public void setAnswers(AnswersQuestions answers) {
        this.answers = answers;
    }

    /**
     * Getter answers;
     * @return
     */
    public AnswersQuestions getAnswers() {
        return this.answers;
    }

    /**
     * Create server socket.
     * @return - socket
     */
    public boolean connection() {
        // flag of connection
        boolean connection = false;
        // create server socket
        try{
            ServerSocket s = new ServerSocket(this.serverPort);
            this.serverSocket = s.accept();

            // checking
            if (this.serverSocket.isConnected()) {
                connection = true;
                System.out.println("Connected");
            }

            // getting IOStreams
            this.inputStream = serverSocket.getInputStream();
            this.outputStream = serverSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        // starting server
        Server server = new Server(3000);
        // set answers
        server.setAnswers(new Answers());
        //TODO Слишком громоздко
        server.setUserInput(new ByteArrayInputStream(server.getAnswers().getAnswer().getBytes()));

        // Server starting
        server.connection();
        //TODO Почему цикл не завершается если клиент завершил работу?
        while (!server.serverSocket.isClosed()) {
            //server.sendMsg(System.out, server.inputStream);
            server.consoleOut(server.inputStream);
        }
    }
}
