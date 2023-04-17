import cs2040s.BinaryHeap;
import cs2040s.Comparable;

public class TaskManager {
    private static class Task implements Comparable<Task>{
        String description;
        int priority;

        public Task(String description, int priority) {
            this.description = description;
            this.priority = priority;
        }

        @Override
        public int compareTo(Task anotherTask) {
            return this.priority - anotherTask.priority;
        }
    }

    BinaryHeap<Task> priorityQueue;

    public TaskManager() {
        this.priorityQueue = new BinaryHeap<>();
    }

    public TaskManager(int size) {
        this.priorityQueue = new BinaryHeap<>(size);
    }

    public void insert(String taskDescription, int priority) {
        this.priorityQueue.add(new Task(taskDescription, priority));
    }

    public String getNextTask() {
        return this.priorityQueue.extractMax().description;
    }
}
