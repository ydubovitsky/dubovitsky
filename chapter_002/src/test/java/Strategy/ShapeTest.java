package Strategy;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ShapeTest {
    @Test
    public void squareDraw() {
        Square square = new Square();
        assertThat(
                square.draw(),
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
                        .toString()
                )
        );
    }

    @Test
    public void triangleDraw() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
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
                            .toString()
                )
        );
    }
    @Test
    public void whenDrawSquare() {
        // получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        // Создаем буфур для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
        // выполняем действия пишушиее в консоль.
        final String myTriangle = new Paint(new Triangle()).executePain();
        // проверяем результат вычисления
        assertThat(
                myTriangle,
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
                                .toString()
                )
        );
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }
}
