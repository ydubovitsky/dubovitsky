package priority.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод добавляет задачу в начало связного списка.
     * После добавления, метод сортирует задачи по приоритету.
     * @param task
     */
    public void put(Task task) {
    //TODO добавить вставку в связанный список.
    tasks.addFirst(task);
        for (int j = 0; j < tasks.size(); j++) {
            for (int i = 0; i < tasks.size() - 1; i++) {
                if (tasks.get(i).getPriority() > tasks.get(i + 1).getPriority()) {
                    Task temp = tasks.get(i);
                    tasks.set(i, tasks.get(i + 1));
                    tasks.set(i + 1, temp);
                }
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.put(new Task("Учить java целый день", 1));
        priorityQueue.put(new Task("Сходить в спортзал", 2));
        priorityQueue.put(new Task("Поспать", 3));
        priorityQueue.put(new Task("Попить водички", 4));
        priorityQueue.put(new Task("Поработать", 5));
        priorityQueue.put(new Task("Сделать еще что то", 6));
        priorityQueue.put(new Task("МУЗЫКА", 7));
        for (int i = 0; i < priorityQueue.tasks.size(); i++) {
            System.out.println(priorityQueue.tasks.get(i).getDesc());
        }
    }
}
