package socket.bot.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class UtilsTest {

    Utils utils;

    @BeforeEach
    void init() {
        utils = new Utils();
    }

    @RepeatedTest(10)
    void writeLogs() {
        utils.writeLogs("server.txt", "hello");
    }
}