package socket.bot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

/**
 * Utils Class
 */
public class Utils {

    /**
     * This method write input strings into file;
     * @param path - file path
     * @param str - input String
     */
    public void writeLogs(String path, String str) {
        // getting class loader
        ClassLoader loader = this.getClass().getClassLoader();

        // getting logFile
        File file = new File(Objects.requireNonNull(loader.getResource(path)).getFile());

        // trying write in the end of file
        try(FileWriter writer = new FileWriter(file, true)) {
            writer.write(str + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
