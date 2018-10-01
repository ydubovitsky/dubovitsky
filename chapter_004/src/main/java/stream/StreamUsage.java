package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Этот интерфейс позволяет гибко работать над коллекциями.

 Stream API работает совместно с лямбда.

 Самый простой способ начать использовать этот АПИ.

 Начнем с базовой схемы работы потоков.

 Каждый элемент коллекции проходить 3 стадии.

 1. Фильтрация.

 2. Преобразование.

 3. Упрощении или Хранение.

 Каждая стадия может использоваться отдельно или совместно.
 */
public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", spent=" + spent +
                    '}';
        }
    }

    /**
     * Рассмотрим деталей.

     List<Task> bugs = tasks.stream().filter(
     task -> task.name.contains("Bug")
     ).collect(Collectors.toList());

     tasks.stream() - получаем объект типа Stream

     filter(
     task -> task.name.contains("Bug")
     )
     Для этого объекта выполняем метод filter, который принимает лямбда выражение Predicate<Task>
     task -> task.name.contains("Bug")  - задаем условие. что пропускать только те задачи, которые содержат слово Bug.

     .collect(Collectors.toList()); - полученные результат сохранить в коллекции типа List.
     * @param args
     */
    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task("Bug #1", 100),
                new Task("Task #2", 100),
                new Task("Bug #3", 100)

        );
        List<Task> bugs = tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);
    }
}
