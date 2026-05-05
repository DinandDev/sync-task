package io.github.dinanddev.service;

import io.github.dinanddev.model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TaskManager {
    private final JsonStorage jsonStorage;
    private List<Task> tasks;


    /**
     * Constructor for a new TaskManager
     * @param jsonStorage the storage engine for persistence of tasks
     */
    public TaskManager(JsonStorage jsonStorage) {
        this.jsonStorage = jsonStorage;
        this.tasks = jsonStorage.loadTasks();
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
        jsonStorage.saveTasks(tasks);
    }

    /**
     * Adds a task to the list of tasks
     * @param task the task to add
     */
    public void addTask(Task task) {
        if (task != null) {
            tasks.add(task);
            jsonStorage.saveTasks(tasks);
        }

    }

    /**
     * Removes a task from the list of tasks
     * @param id the id of the task to remove
     */
    public void removeTask(String id) {
        tasks.removeIf(task -> task.getId().equals(id));
        jsonStorage.saveTasks(tasks);
    }

    /**
     * Marks a task as being completed
     * @param id the id of the task to mark completed
     */
    public void markCompleted(String id) {
        Optional<Task> taskToComplete = tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
        taskToComplete.ifPresent(task -> task.setCompleted(true));
        jsonStorage.saveTasks(tasks);
    }
}
