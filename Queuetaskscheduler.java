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
    public int compareTo(Task other) {
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
        scheduler.addTask("Task 1", 3);
        scheduler.addTask("Task 2", 1);
        scheduler.addTask("Task 3", 2);

        scheduler.executeNextTask(); 
        scheduler.executeNextTask();
        scheduler.executeNextTask(); 

        scheduler.addTask("Task 4", 1);
        scheduler.addTask("Task 5", 4);

        scheduler.removeTask();

        scheduler.executeNextTask(); 
        scheduler.executeNextTask(); 
        scheduler.executeNextTask(); 
    }
}
