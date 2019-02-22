package socket.bot;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    /**
     * Порт Сервера
     */
    private int serverPort;

    private final String exit = "пока";

    public Server(int port) {
        this.serverPort = port;
    }

    public void answer() {
        // Создаем сервер-сокет, который будет принимать запросы клиентов
        try(ServerSocket serverSocket = new ServerSocket(serverPort)) {

            // Создаем Сокет и ждем входящие запросы
            System.out.println("Ждем входящее подключение");
            Socket socket = serverSocket.accept();

            // Создаем потоки ввода-вывода данных
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Входные данные
            String str = dataInputStream.readUTF();

            while (!str.equals(exit)) {
                System.out.println(dataInputStream.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        Server server = new Server(3000);
        server.answer();
    }
}

