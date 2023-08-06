import java.util.PriorityQueue;

class Task implements Comparable<Task> {
    private String name;
    private int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task other) {
        // Higher priority tasks should come before lower priority tasks in the queue
        return Integer.compare(other.priority, this.priority);
    }
}

class TaskScheduler {
    private PriorityQueue<Task> taskQueue;

    public TaskScheduler() {
        taskQueue = new PriorityQueue<>();
    }

    public void addTask(String name, int priority) {
        Task newTask = new Task(name, priority);
        taskQueue.add(newTask);
    }

    public void removeTask() {
        if (!taskQueue.isEmpty()) {
            taskQueue.poll();
        }
    }

    public void executeNextTask() {
        if (!taskQueue.isEmpty()) {
            Task nextTask = taskQueue.poll();
            System.out.println("Executing task: " + nextTask.getName() + ", Priority: " + nextTask.getPriority());
        } else {
            System.out.println("No tasks to execute.");
        }
    }
}

 class Queuetaskscheduler {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks with different priorities
        scheduler.addTask("Task 1", 3);
        scheduler.addTask("Task 2", 1);
        scheduler.addTask("Task 3", 2);

        // Executing tasks based on priority
        scheduler.executeNextTask(); // Task 2 with priority 1
        scheduler.executeNextTask(); // Task 3 with priority 2
        scheduler.executeNextTask(); // Task 1 with priority 3

        // Adding more tasks
        scheduler.addTask("Task 4", 1);
        scheduler.addTask("Task 5", 4);

        // Removing tasks
        scheduler.removeTask();

        // Executing tasks based on updated priority queue
        scheduler.executeNextTask(); // Task 4 with priority 1
        scheduler.executeNextTask(); // Task 5 with priority 4
        scheduler.executeNextTask(); // No tasks to execute.
    }
}
