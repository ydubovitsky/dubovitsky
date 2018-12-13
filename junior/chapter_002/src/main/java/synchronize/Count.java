package synchronize;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * класс, который будет иметь два метода:
 * увеличить внутренне поле на 1 и второй метод - получить значение этого поля.
 */
@ThreadSafe
class Count {
    @GuardedBy("this")
    private int value;

    synchronized void increment() {
        this.value++;
    }

    synchronized int get() {
        return this.value;
    }
}
