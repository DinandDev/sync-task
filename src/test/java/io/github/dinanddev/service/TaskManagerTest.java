package io.github.dinanddev.service;

import io.github.dinanddev.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    @TempDir
    Path tempDir; // Automatically creates and deletes a temp folder for tests

    private TaskManager manager;
    private JsonStorage storage;

    @BeforeEach
    void setUp() {
        // Resolve a path within the temporary directory
        String testPath = tempDir.resolve("tasks.json").toString();
        storage = new JsonStorage(testPath);
        manager = new TaskManager(storage);
    }

    @Test
    void addTask_shouldUpdateListAndSave() {
        Task task = new Task("Test Title", "Test Desc", null);
        manager.addTask(task);

        assertEquals(1, manager.getTasks().size());
        assertEquals(task.getId(), manager.getTasks().getFirst().getId());
    }

    @Test
    void addNullTask_shouldNotThrow() {
        // Verifies the safety check: if (task != null)
        assertDoesNotThrow(() -> manager.addTask(null));
        assertEquals(0, manager.getTasks().size());
    }

    @Test
    void removeTask_shouldUpdateList() {
        Task task = new Task("Remove Me", "Desc", null);
        manager.addTask(task);

        manager.removeTask(task.getId());

        assertTrue(manager.getTasks().isEmpty());
    }

    @Test
    void markCompleted_shouldUpdateStatus() {
        Task task = new Task("Complete Me", "Desc", null);
        manager.addTask(task);

        manager.markCompleted(task.getId());

        assertTrue(manager.getTasks().getFirst().isCompleted());
    }

    @Test
    void persistence_shouldLoadSavedTasksOnStartup() {
        Task task = new Task("Persistent Task", "Desc", null);
        manager.addTask(task);

        // Create a new manager instance pointing to the same storage
        // This simulates the app closing and reopening
        TaskManager secondManager = new TaskManager(storage);

        assertEquals(1, secondManager.getTasks().size());
        assertEquals("Persistent Task", secondManager.getTasks().getFirst().getTitle());
    }
}