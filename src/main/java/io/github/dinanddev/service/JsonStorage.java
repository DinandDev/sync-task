package io.github.dinanddev.service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.dinanddev.model.Task;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonStorage {
    private final File file;
    private final ObjectMapper objectMapper;


    public JsonStorage(String filePath) {
        this.file = new File(filePath);
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        try {
            file.createNewFile();
        } catch (IOException _) {}

    }

    /**
     * Saves the list of tasks to a file
     * @param taskList the list of tasks to save
     */
    public void saveTasks(List<Task> taskList) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, taskList);
        } catch (IOException _) {}

    }

    /**
     * Loads the saved tasks from a file
     * @return the list of tasks retrieved from the file
     */
    public List<Task> loadTasks() {
        try {
            return objectMapper.readValue(file,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Task.class));
        } catch (IOException _) {
            return new ArrayList<>();
        }

    }

}
