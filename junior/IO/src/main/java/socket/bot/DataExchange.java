package socket.bot;

import java.io.*;

/**
 * This class must extends all Clients and Servers.
 */
public abstract class DataExchange {

    /**
     * User`s input stream data
     */
    protected InputStream userInput;

    abstract void connection();

    /**
     * UserInput Setter
     * @param inputStream
     * @return
     */
    InputStream setUserInput(InputStream inputStream) {
        this.userInput = inputStream;
        return this.userInput;
    }

    /**
     * This method write into output stream user`s data from input stream;
     * @param outputStream
     * @param inputStream
     */
    void sendMsg(OutputStream outputStream, InputStream inputStream) {
        try{
            //TODO Почему не работает эта обертка?
            // OutputStreamWriter o = new OutputStreamWriter(outputStream);
            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
            // sending input user`s data on server
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method receive input data and write it on Console and return user`s string
     * @param inputStream
     */
    //TODO Этот метод можно улучшить, задавая выходной поток: консоль, файл или что то еще...
    String consoleOut(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try{
            int a;
            while ((a = inputStream.read()) != -1) {

                // create String
                sb.append((char)a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
