import java.util.*;

class TaskManager {
    // Task structure (immutable once created)
    private static class Task {
        int userId, taskId, priority;
        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    // Maps taskId -> Task (for quick lookup/edit/removal)
    private Map<Integer, Task> taskMap;

    // Max-Heap sorted by priority, then taskId
    private PriorityQueue<Task> maxHeap;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (b.priority != a.priority) return b.priority - a.priority; // higher priority first
            return b.taskId - a.taskId; // tie-breaker: higher taskId first
        });

        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            Task task = new Task(userId, taskId, priority);
            taskMap.put(taskId, task);
            maxHeap.offer(task);
        }
    }

    // Add a new task
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        maxHeap.offer(task);
    }

    // Edit an existing task’s priority (create a fresh Task to avoid stale mutation issues)
    public void edit(int taskId, int newPriority) {
        Task oldTask = taskMap.get(taskId);
        if (oldTask != null) {
            Task newTask = new Task(oldTask.userId, taskId, newPriority);
            taskMap.put(taskId, newTask);
            maxHeap.offer(newTask);
        }
    }

    // Remove a task
    public void rmv(int taskId) {
        taskMap.remove(taskId);
        // Lazy removal: old entries remain in heap but will be skipped in execTop
    }

    // Execute the highest priority task
    public int execTop() {
        while (!maxHeap.isEmpty()) {
            Task top = maxHeap.poll();
            Task current = taskMap.get(top.taskId);

            // If it matches the current state, it's valid
            if (current != null && current.priority == top.priority) {
                taskMap.remove(top.taskId);
                return top.userId;
            }
            // Otherwise, skip stale task
        }
        return -1; // No tasks left
    }
}
