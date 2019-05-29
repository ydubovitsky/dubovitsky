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
     * Chat key words
     */
    private final String exit = "пока";
    private final String start = "старт";
    private boolean flag = true;

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
     * Create server socket.
     * @return - socket
     */
    public void connection() {
        while (true) {
            try {
                ServerSocket serverSocket = new ServerSocket(this.serverPort);
                while (flag) {
                    Socket socket = serverSocket.accept();
                    System.out.println("Подключились");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String clientMsg = reader.readLine();
                    if (clientMsg.equals(exit)) {
                        flag = false;
                    }
                    if(flag || clientMsg.equals(start)) {
                        flag = true;
                        System.out.println("ngdfngndfgndg");
                        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                        writer.write(answers.getAnswer());
                        writer.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


        public static void main(String[] args) {
            // starting server
            Server server = new Server(4343);
            server.setAnswers(new Answers());
            // set answers
            server.connection();
        }
    }
