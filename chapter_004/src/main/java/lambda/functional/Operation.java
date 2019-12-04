package lambda.functional;

/**
 * Функциональный Интерфейс описывает функцию принимающую два параметра left, right
 * и возвращающую значение типа double.
 */
public interface Operation {
    double calc(int left, int right);
}
