package srp.calculator.console.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.Calculator;

/**
 * This is a test class;
 */
class InteractCalcTest {

    InteractCalc interactCalc;

    @BeforeEach
    void setUp() {
        interactCalc = new InteractCalc(new CalcWrapper(new Calculator()));
    }

    /**
     * Testing a public double add(double a, double b) method!
     */
    @Test
    void add() {
        Assertions.assertEquals(4, interactCalc.add(2,2));
    }

}