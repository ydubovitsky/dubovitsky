package socket.bot;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The server class, implements pattern Observer;
 */
public class Server {

    private final int port = 4343;
    private AnswersQuestions answers;
    private InputStream input;
    private OutputStream output;
    private boolean flag = true;

    public Server(AnswersQuestions answers) {
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
                    this.input = socket.getInputStream();
                    this.output = socket.getOutputStream();

                    // call method
                    inputProcess(this.input, this.output);
                }
                // if previous cycle ended, this method go to first cycle and starts waiting a new client!
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void inputProcess(InputStream input, OutputStream out) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(out));
        try {
            String clientMsg;
            while ((clientMsg = reader.readLine())!= null) {
                System.out.println(clientMsg);
                // if client send "stop"
                if (clientMsg.equals("stop") || !flag) {
                    //System.out.println("Yeas!");
                    writer.write("\n");
                    writer.flush();
                    flag = false;
                }
                // if client send "start" or another different word
                if (clientMsg.equals("start") || flag) {
                    writer.write(this.answers.getAnswer() + "\n");
                    writer.flush();
                    flag = true;
                }
            }
            System.out.println("Вышли из цикла");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server(new Answers()).start();
    }
}

