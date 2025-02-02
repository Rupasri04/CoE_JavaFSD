import java.util.*;

class Task implements Comparable<Task> {
    String id;
    String desc;
    int prior;

    public Task(String id, String desc, int prior) {
        this.id = id;
        this.desc = desc;
        this.prior = prior;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(other.prior, this.prior);
    }

    @Override
    public String toString() {
        return "Task{id='" + id + "', desc='" + desc + "', prior=" + prior + "}";
    }
}

class TaskManager {
    private PriorityQueue<Task> taskq;

    public TaskManager() {
        taskq = new PriorityQueue<>();
    }

    public void addTask(String id, String desc, int prior) {
        Task task = new Task(id, desc, prior);
        taskq.offer(task);
    }

    public void removeTask(String id) {
        List<Task> taskList = new ArrayList<>(taskq);
        taskList.removeIf(task -> task.id.equals(id));
        taskq.clear();
        taskq.addAll(taskList);
    }

    public Task getHighestPriorityTask() {
        return taskq.peek();
    }
}

public class CustomCollection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        System.out.println("Enter the number of tasks:");
        int n = scanner.nextInt();
        scanner.nextLine();  

        for (int i = 0; i < n; i++) {
            System.out.println("Enter task ID:");
            String id = scanner.nextLine();
            System.out.println("Enter task description:");
            String desc = scanner.nextLine();
            System.out.println("Enter task priority (integer):");
            int prior = scanner.nextInt();
            scanner.nextLine();

            manager.addTask(id, desc, prior);
        }

        System.out.println("Highest Priority Task: " + manager.getHighestPriorityTask());

        System.out.println("Enter task ID to remove:");
        String removeId = scanner.nextLine();
        manager.removeTask(removeId);

        System.out.println("Highest Priority Task after removal: " + manager.getHighestPriorityTask());
        scanner.close();
    }
}
