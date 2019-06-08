package synchronize.list;

import list.DynamicListBasedOnArray;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Потокобезопасный класс - Динамический список.
 */
@ThreadSafe
public class ThreadSafeList {

    @GuardedBy("this")
    private final DynamicListBasedOnArray list;

    public ThreadSafeList(DynamicListBasedOnArray dynamicListBasedOnArray) {
        this.list = dynamicListBasedOnArray;
    }

    /**
     * Итератор для копии.
     * @return
     */
    @NotNull
    //@Override
    public synchronized Iterator iterator() {
        return copy(this.list).iterator();
    }

    /**
     * метод создает новый обьект DynamicListBasedOnArray и переносит в него все значения  из поля класса
     * затем возвращает его;
     * @param dynamicListBasedOnArray
     * @return
     */
    private synchronized DynamicListBasedOnArray copy(DynamicListBasedOnArray dynamicListBasedOnArray) {
        DynamicListBasedOnArray dl = new DynamicListBasedOnArray();
        while (dynamicListBasedOnArray.iterator().hasNext()) {
            dl.add(dynamicListBasedOnArray.iterator().next());
        }
        return dl;
    }
}
