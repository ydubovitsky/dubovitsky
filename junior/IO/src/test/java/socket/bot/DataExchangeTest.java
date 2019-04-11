package socket.bot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class DataExchangeTest {

    RealClass realClass;

    class RealClass extends DataExchange {

        @Override
        void connection() {
            // this is a stub, or how we will be testing abstract class?
        }

        @Override
        InputStream getUserInput() {
            return null; // and this is a stub,
        }
    }

    @BeforeEach
    void setUp() {
        realClass = new RealClass();
    }

    @Test
    void consoleOut() {
        realClass.consoleOut(new ByteArrayInputStream("Success!".getBytes()));
    }
}