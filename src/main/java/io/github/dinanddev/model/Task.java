package io.github.dinanddev.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    private final String id;
    private String title;
    private String description;
    private final LocalDateTime creationDateTime;
    private LocalDateTime dueDateTime;
    private boolean completed;

    /**\
     * Constructor for a new Task
     * @param title the title of the Task
     * @param description describes the Task
     * @param dueDate when the Task is due
     */
    public Task(String title, String description, LocalDateTime dueDate) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.creationDateTime = LocalDateTime.now();
        this.dueDateTime = dueDate;
        this.completed = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (Due: %s) - %s",
                completed ? "X" : " ",
                title,
                dueDateTime != null ? dueDateTime.toLocalDate() : "No date",
                id.substring(0, 8)); // Just show first 8 chars of UUID to keep it clean
    }
}
