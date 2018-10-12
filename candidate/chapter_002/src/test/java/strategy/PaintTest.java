package strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
    // получаем ссылку на стандартный вывод в консоль.
    public final PrintStream stdout = System.out;
    // Создаем буфур для хранения вывода.
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
    }
    @After
    // выполняем действия пишушиее в консоль.
    public void writeConsole() {
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }

    @Test
    public void whenDrawSquare() {
        Paint paint = new Paint();
        paint.setShape(new Square());
        paint.executePain();
        // проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("+++++++")
                                .append(System.lineSeparator())
                                .append("+     +")
                                .append(System.lineSeparator())
                                .append("+     +")
                                .append(System.lineSeparator())
                                .append("+     +")
                                .append(System.lineSeparator())
                                .append("+++++++")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
    @Test
    public void whenDrawTriangle() {
        Paint paint = new Paint();
        paint.setShape(new Triangle());
        paint.executePain();
        // проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("+")
                                .append(System.lineSeparator())
                                .append("++")
                                .append(System.lineSeparator())
                                .append("+++")
                                .append(System.lineSeparator())
                                .append("++++")
                                .append(System.lineSeparator())
                                .append("+++++")
                                .append(System.lineSeparator())
                                .append("++++++")
                                .append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}