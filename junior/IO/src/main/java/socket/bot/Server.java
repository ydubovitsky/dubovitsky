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
    public void connection() {
        // create server socket
        try{
            ServerSocket s = new ServerSocket(this.serverPort);
            this.serverSocket = s.accept();
            System.out.println("Connected");
            InputStream i = serverSocket.getInputStream();
            OutputStream o = serverSocket.getOutputStream();

            // end of cycle
            String end = null;
            do {
                // invoke method from parent`s class
                end = this.consoleOut(i);
                this.sendMsg(o, userInput);

                // end of cycle if user input "this.exit word"
            } while (!end.equals(this.exit));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        // starting server
        Server server = new Server(3000);
        // set answers
        server.setAnswers(new Answers());
        //TODO Слишком громоздко
        server.setUserInput(new ByteArrayInputStream(server.getAnswers().getAnswer().getBytes()));
        //start data change
        server.connection();
    }
}
