package io.github.dinanddev.service;

import io.github.dinanddev.model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TaskManager {
    private List<Task> tasks;

    /**
     * Constructor for a new TaskManager
     */
    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        if (task != null) tasks.add(task);
    }

    public void removeTask(String id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }

    public void markCompleted(String id) {
        Optional<Task> taskToComplete = tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
        taskToComplete.ifPresent(task -> task.setCompleted(true));
    }
}
