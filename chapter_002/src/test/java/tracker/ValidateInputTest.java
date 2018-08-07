package tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Плохой тест, нужно его переписать.
 * @author Дубовицкий Ю.А.
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"Нет такого пункта меню", "1"})
        );
        input.ask("Нет такого пункта меню", 1);
        assertThat(
                this.mem.toString(),
                is(
                        new StringBuilder()
                        .append("Нет такого пункта меню Нет такого пункта меню")
                        .append(System.lineSeparator())
                        .append("Необходимо ввести корректное значение")
                        .append(System.lineSeparator())
                        .append("Нет такого пункта меню 1")
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }
}