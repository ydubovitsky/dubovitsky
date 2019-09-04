package srp.calculator.console;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.Calculator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInputImplTest {

    UserInputImpl ui;

    @BeforeEach
    void setUp() {
        ui = new UserInputImpl(System.in, new Calculator());
    }

    @Test
    void getString() {
    }

    @Test
    void getOperations() {
    }

    @Test
    void main() {
    }
}