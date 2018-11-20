package strategy;

import org.junit.Test;
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
}
