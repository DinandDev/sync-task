package io.github.dinanddev.view;

import io.github.dinanddev.model.Task;
import io.github.dinanddev.service.TaskManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskConsoleApp {
    private final TaskManager taskManager;
    private final Scanner input;


    public TaskConsoleApp() {
        this.taskManager = new TaskManager();
        this.input = new Scanner(System.in);
    }

    public void run() {
        String choice;
        do {
            printMenu();
            choice = input.next();
            executeChoice(choice);

        } while (!choice.equals("0"));
    }
    public void printMenu() {
        System.out.println("\n--- SyncTask Console Center ---");
        System.out.println("1. ➕ Create New Task");
        System.out.println("2. ❌️ Remove a Task");
        System.out.println("3. 📋 View All Tasks");
        System.out.println("4. ✅ Mark Task as Completed");
        // System.out.println("4. 💾 Save to JSON"); // For the next milestone
        System.out.println("0. ❌ Exit");
        System.out.print("Select an option: ");
    }
public void executeChoice(String choice) {
        switch (choice) {
            case "1":
                createNewTask();
                break;
            case "2":
                removeTask();
                break;
            case "3":
                viewAllTasks();
                break;
            case "4":
                markTaskAsCompleted();
                break;
            case "0":
                break;
            default:
                System.out.println("Please enter a valid option.");
        }
    }


    private void createNewTask() {
        System.out.println("Title of the task: ");
        String title = input.nextLine();
        System.out.println("Description of the task: ");
        String description = input.nextLine();
        LocalDateTime dueDateTime = null;
        while (dueDateTime == null) {
            try {
                System.out.println("Date and Time of when the task is due (Format: YYYY-MM-DDTHH:MM:SS, " +
                        "e.g. 2007-12-03T10:15:30) or NONE for no date and time: ");
                String dueDateTimeString = input.nextLine();
                if (dueDateTimeString.equals("NONE")) break;
                dueDateTime = LocalDateTime.parse(dueDateTimeString);
            } catch (DateTimeParseException _){}
        }
        Task task = new Task(title, description, dueDateTime);
        taskManager.addTask(task);

    }

    private int getTaskIndex(String message) {
        if (taskManager.getTasks().isEmpty()) {
            System.out.println("No tasks available.");
            return -1;
        }

        Integer index = null;
        boolean invalid = true;
        while (invalid) {
            try {
                System.out.println(message);
                for (int i = 1; i <= taskManager.getTasks().size(); i++) {
                    System.out.println(i + " - " + taskManager.getTasks().get(i - 1));
                }
                index = input.nextInt();
                if (index <= taskManager.getTasks().size() && index >= 1) invalid = false;
                else System.out.println("Invalid number, please try again.");
            } catch (InputMismatchException _) {}
        }
        return index - 1;
    }

    private void removeTask() {
        int index = getTaskIndex("Enter the number of the task to remove: ");
        if (index != -1) taskManager.removeTask(taskManager.getTasks().get(index).getId());

    }

    private void viewAllTasks() {
        for (Task task : taskManager.getTasks()) {
            System.out.println("- " + task);
        }
    }

    private void markTaskAsCompleted() {
        int index = getTaskIndex("Enter the number of the task to mark completed: ");
        if (index != -1) taskManager.markCompleted(taskManager.getTasks().get(index).getId());
    }
}
