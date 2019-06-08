package socket.bot.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Objects;

/**
 * Utils Class
 */
public class Utils {

    /**
     * This method write input strings into file and current date;
     * @param path - file path
     * @param str - input String
     */
    public static void writeLogs(String path, String str) {
        // getting class loader
        ClassLoader loader = Utils.class.getClassLoader();

        // getting logFile
        File file = new File(Objects.requireNonNull(loader.getResource(path)).getFile());

        // trying write in the end of file
        try(FileWriter writer = new FileWriter(file, true)) {
            writer.write(
                    LocalDateTime.now()
                            + str
                            + System.lineSeparator()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
