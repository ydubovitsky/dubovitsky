package srp;

import srp.calculator.console.UserInputImpl;

class UserInputImplTest {

    UserInputImpl in;
    String str = "Hello + values";

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        //in = new UserInputImpl(new InputStreamReader(System.in));
    }

    @org.junit.jupiter.api.Test
    boolean getValues(String str) {
        //Assertions.assertArrayEquals(true, getValues(str));
        return true;
    }
}