package priority.queue;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод принимает задачу и ее приоритет.
     * Можно словить IndexOutOfBoundsException,
     * если указанный индекс окажется отрицательным или большим текущего значения size.
     * @param task
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
        while (task.getPriority() + 1 > this.tasks.size()) {
                this.tasks.add(new Task("Нет задач", 0));
        }
        this.tasks.set(task.getPriority(), task);
    }

    public Task take() {
        return this.tasks.poll();
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.put(new Task("Учить java целый день", 0));
        priorityQueue.put(new Task("Сходить в спортзал", 3));
        priorityQueue.put(new Task("Поспать", 7));
        for (int i = 0; i < priorityQueue.tasks.size(); i++) {
            System.out.println(priorityQueue.tasks.get(i).getDesc());
        }
    }
}
