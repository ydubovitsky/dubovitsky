package socket.bot;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.*;

class DataExchangeTest {

    /**
     * Implementation of abstract class DataExchange
     */
    RealClass realClass;

    class RealClass extends DataExchange {

        @Override
        boolean connection() {
            // this is a stub, or how we will be testing abstract class?
            return false;
        }
    }

    @BeforeEach
    void setUp() {
        realClass = new RealClass();
    }

    @RepeatedTest(10)
    void sendMsg() {
        realClass.setUserInput(new ByteArrayInputStream("Hello my dear".getBytes()));
        OutputStream o = System.out;
        realClass.sendMsg(o,realClass.userInput);
    }

    @RepeatedTest(10)
    void consoleOut() {
        Answers answers = new Answers();
        String actual = answers.getAnswer();
        //TODO Опять не работает кодировка, а так тест работает
        String result = realClass.consoleOut(new ByteArrayInputStream(actual.getBytes()));
        Assert.assertEquals(result, actual);
    }

    @Test
    void setUserInput() throws IOException {
        InputStream inputStream = realClass.setUserInput(new ByteArrayInputStream("Hello".getBytes()));
        int i;
        while ((i = inputStream.read()) != -1) {
            System.out.print((char)i);
        }
    }
}