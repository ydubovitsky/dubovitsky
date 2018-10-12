package lambda.diapason;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Класс для тестирования класса Reckon.java.
 */
public class ReckonTest {

    Reckon reckon;

    /**
     * Инициализация объекта тестируемого класса.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        reckon = new Reckon();
    }

    /**
     * Проверка линейной функции.
     */
    @Test
    public void whenFunctionIsLinear() {
        ArrayList<Double> expexted = new ArrayList<Double>(
                Arrays.asList(3.0, 6.0, 9.0));
        reckon.list = reckon.diapason(0.0, 3.0, reckon.linear);
        assertThat(reckon.list, is(expexted));
    }

    /**
     * Проверка логарифмической функции.
     */
    @Test
    public void whenFunctionIsLogarithm() {
        ArrayList<Double> expexted = new ArrayList<Double>(
                Arrays.asList(-Infinity, 0.0, 0.6309297535714574));
        reckon.list = reckon.diapason(0.0, 3.0, reckon.logarithm);
        assertThat(reckon.list, is(expexted));
    }

    /**
     * Проверка квадратичной функции.
     */
    @Test
    public void whenFunctionIsSquare() {
        ArrayList<Double> expexted = new ArrayList<Double>(
                Arrays.asList(3.0, 9.0, 21.0));
        reckon.list = reckon.diapason(0.0, 3.0, reckon.square);
        assertThat(reckon.list, is(expexted));
    }
}