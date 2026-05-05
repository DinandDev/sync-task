package io.github.dinanddev;

import io.github.dinanddev.service.JsonStorage;
import io.github.dinanddev.service.TaskManager;
import io.github.dinanddev.view.TaskConsoleApp;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    static void main() {
        JsonStorage jsonStorage = new JsonStorage("tasks.json");
        TaskManager taskManager = new TaskManager(jsonStorage);
        TaskConsoleApp taskConsoleApp = new TaskConsoleApp(taskManager);
        taskConsoleApp.run();
    }



}
