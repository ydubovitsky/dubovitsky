package stream.guide;

import java.util.*;
import java.util.stream.*;

/**
 * Stream — это объект для универсальной работы с данными.
 * Мы указываем, какие операции хотим провести, при этом не заботясь о деталях реализации.
 */
public class StreamGuide {

    /**
     * Главный метод
     * @param args
     */
    public static void main(String[] args) {
        StreamGuide streamGuide = new StreamGuide();
        // Запускаем получение стримов.
        streamGuide.getStream();
        // Параллельный стрим
        streamGuide.parallelStream();
        // Стримы для примитивов
        streamGuide.simpleStream();
        // Операторы Stream API
        streamGuide.operators();
    }

    /**
     * Операторы Stream API
     */
    public void operators() {

        /**
         * inner class;
         * of(T value)
         */
        class Person {

            String name;
            double age;

            void setAge(double age) {
                this.age = age;
            }

            Person(String name, double age) {
                this.name = name;
                this.age = age + Math.random();
            }
        }

        // of(T value)
        Person person = new Person("Ivan", 15);
        Stream.of(person, person, person).forEach(x -> {
            System.out.println("age = " + x.age);
        });

        // ofNullable(T t)
        String str = Math.random() > 0.5 ? "Мне повезло" : null;
        Stream.of(str).forEach(System.out::print);

        // generate(Supplier s)
        //Возвращает стрим с бесконечной последовательностью элементов, генерируемых функцией Supplier s.
        Stream.generate(() -> {
            int[] a = new int[3];
            for (int i = 0; i < a.length; i++) {
                a[i] = i;
            }
            return a;
        }).limit(5)
                .forEach(a -> {
                    int i = 0;
                    while (a.length > i) {
                        System.out.println(i + " = " + a[i]);
                        i++;
                    }
                });
        // iterate​(T seed, UnaryOperator f)
        // Возвращает бесконечный стрим с элементами,
        // которые образуются в результате последовательного применения функции f к итерируемому значению.
        // Первым элементом будет seed, затем f(seed), затем f(f(seed)) и так далее.
        Person[] persons = new Person[]{
                new Person("Ivan", 123),
                new Person("Matthey", 54)
        };
        Stream.iterate(persons, pr -> {
            for (int i = 0; i < pr.length; i++) {
                pr[i].setAge(Math.random() * pr[i].age);
                System.out.println("age = " + pr[i].age);
            }
            return pr;
        })
                .limit(4)
                .forEach(System.out::print);
        // Для понимания
        // !!!! Передается один и тот же объект!!!!
        Stream.iterate(new Person("ivan", 34.0), anonymos -> {
            System.out.println("Был возраст = " + anonymos.age);
            anonymos.age *= Math.random();
            return anonymos;
        })
                .limit(5)
                .forEach(x -> {
                    System.out.println("age = " + x.age);
                });
        // concat(Stream a, Stream b)
        // Объединяет два стрима так, что вначале идут элементы стрима A, а по его окончанию последуют элементы стрима B.
        Stream.concat(
                Stream.of(1,23,4,5,23),
                Stream.of(0,0,0,0,0,0,0))
                .forEach(System.out::print);
        //
        Stream.concat(
                Stream.of(4,5,23,5),
                Stream.of(new Person("Adam", 34.0))
        )
                .forEach(x -> {
                    if (x instanceof Person) {
                        System.out.println("Age = " + ((Person) x).age);
                    }
                });
        // builder()
        // Создаёт мутабельный объект для добавления элементов в стрим без использования какого-либо контейнера для этого.
        Stream.Builder<Integer> streamBuider = Stream.<Integer>builder()
                .add(0)
                .add(1);
        for (int i = 2; i <= 8; i += 2) {
            streamBuider.accept(i);
        }
        streamBuider
                .add(9)
                .add(10)
                .build()
                .forEach(System.out::println);
        //
        Stream.Builder<Integer> strbl = Stream.<Integer>builder();
            strbl.add(0);
            for (int i = 0; i < 10; i++) {
                strbl.add(i);
            }
            strbl.build()
                    .forEach(System.out::print);
        // Test
        List<Integer> intList = Arrays.asList(1,2,3,4,5);
        Stream.of(intList)
                .filter(integers -> {
                    boolean tr = true;
                    for (int i = 0; i < integers.size(); i++) {
                        if (integers.get(i) == 0) {
                            tr = false;
                        }
                    }
                    return tr;
                })
                .collect(Collectors.toList());
    }

    /**
     * Стримы для примитивов
     */
    public void simpleStream() {
        IntStream.generate(() -> 0).limit(5).forEach(System.out::println);
        DoubleStream.iterate(0.0, (m) -> m + 1.1).limit(10).forEach(m -> {
            System.out.println("Variable = " + m);
        });
    }

    /**
     * Параллельные стримы
     */
    public void parallelStream() {
        List list = new ArrayList();
        list.addAll(Arrays.asList(-5, 653, 23, 43));
        list.stream().sorted().forEach(System.out::print);
        // Ниже стрим не понимает как сортировать
        Stream.of(Arrays.asList(-5, 653, 23, 43, "Rbyj", "123", "Str", "Place")).parallel().sorted().forEach(System.out::print);
        // Так не делай при параллеьных стримах
        // Не потокобезопасно
        final List<Integer> ints = new ArrayList<>();
        IntStream.range(0, 1000000)
                .parallel() // Attention!
                .forEach(i -> ints.add(i));
        System.out.println(ints.size());
    }

    /**
     * Пулучение стримов
     */
    public void getStream() {
        // Получаем пустой стрим.
        java.util.stream.Stream.empty();
        // Стрим из Листа.
        List list = new ArrayList();
        list.stream();
        // Стрим из мап
        Map map = new HashMap();
        map.entrySet().stream();
        // Стрим из массива.
        int[][] array = {
                {1, 4, 6, 6},
                {5, 2, 5, 1}
        };
        Arrays.stream(array);
        // Stream из элементов.
        String a = java.util.stream.Stream.of(1, 5, 7, 89, 5).toString();
        System.out.println("a = " + a);
        //
        List<Integer> strList = new ArrayList<>();
        IntStream.of(new int[]{1, 4, 6, 7, 9})
                .filter(z -> z > 5)
                .map(z -> z + 1)
                .forEach(z -> strList.add(z)); // <- Так вроде делать нельзя?
        // Использовать в лямбда-выражении куски из внешнего кода
        for (int b : strList) {
            System.out.println(b);
        }
        // Массив строк.
        List<String> elseList = Arrays.stream(new String[]{"a", "b", "c"})
                .filter(s -> s.length() <= 2)
                .collect(Collectors.toList());
        // Не работает.
        List list1 = java.util.stream.Stream.of(new int[]{50, 1, 4, 6, 8})
                .sorted()
                .collect(Collectors.toList());
        for (Object q : list1) {
            System.out.println("Отсортировали = " + q);
        }
        //
        ArrayList<Integer> arrayList = new ArrayList<>();
        IntStream.of(35, 25, 23, 73, 623, 523524)
                .sorted()
                .forEach(System.out::println);
    }
}
