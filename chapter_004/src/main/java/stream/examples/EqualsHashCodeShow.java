package stream.examples;

/**
 * Следует понимать, что множество возможных хеш-кодов ограничено примитивным типом int,
 * а множество объектов ограничено только нашей фантазией.
 * Отсюда следует утверждение: “Множество объектов мощнее множества хеш-кодов”.
 * Из-за этого ограничения, вполне возможна ситуация, что хеш-коды разных объектов могут совпасть.
 *
 * Если хеш-коды разные, то и входные объекты гарантированно разные.
 * Если хеш-коды равны, то входные объекты не всегда равны.
 */
public class EqualsHashCodeShow {
    public static void main(String[] args) {
        // в java, каждый вызов оператора new порождает новый объект в памяти.
        Object object = new Object();
        for (int i = 0; i < 10; i++) {
            //  хеш-код это число, у которого есть свой предел, который для java ограничен примитивным целочисленным типом int.
            int hash = object.hashCode();
            System.out.println("HashCode of this Object = " + hash);
        }
    }

    @Override
    public int hashCode() {
        final int var = 1;
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
