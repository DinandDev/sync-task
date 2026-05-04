package io.github.dinanddev;

import io.github.dinanddev.service.TaskManager;
import io.github.dinanddev.view.TaskConsoleApp;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    static void main() {
        TaskConsoleApp taskConsoleApp = new TaskConsoleApp();
        taskConsoleApp.run();
    }



}
