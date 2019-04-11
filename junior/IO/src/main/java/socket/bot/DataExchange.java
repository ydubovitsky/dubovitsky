package socket.bot;

import java.io.*;

/**
 * This class must extends all Clients and Servers.
 */
public abstract class DataExchange {

    abstract void connection();

    abstract InputStream getUserInput();

    /**
     * This method write into output stream user`s data from input stream;
     * @param outputStream
     * @param inputStream
     */
    void sendMsg(OutputStream outputStream, InputStream inputStream) {
        try{
            //TODO Почему не работает эта обертка?
            // OutputStreamWriter o = new OutputStreamWriter(outputStream);
            BufferedReader b = new BufferedReader(new InputStreamReader(inputStream));

            // sending input user`s data on server
            outputStream.write(b.readLine().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method receive input data and write it on Console
     * @param inputStream
     */
    void consoleOut(InputStream inputStream) {
        try{
            int a;
            while ((a = inputStream.read()) != -1) {

                // write on console
                System.out.print((char)a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
