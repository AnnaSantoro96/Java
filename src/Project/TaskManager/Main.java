package Project.TaskManager;

import java.util.Scanner;

public class Main {

    private static Priority readPriority(Scanner in) {
        Priority priority = null;

        while (priority == null) {
            System.out.println("Enter the new priority");
            String newPriority = in.nextLine();

            try {
                priority = Priority.valueOf(newPriority.toUpperCase().trim());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid priority!");
            }
        }

        return priority;
    }

    private static TaskStatus readStatus(Scanner in){
        TaskStatus status = null;

        while(status == null){
            System.out.println("Enter the new status");
            String newStatus = in.nextLine();

            try {
                status = TaskStatus.valueOf(newStatus.toUpperCase().trim());
            }catch (IllegalArgumentException e){
                System.out.println("Invalid status!");
            }
        }

        return status;
    }

    static void main() {

        Scanner in = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        int value = -1;

        do {
            System.out.println("\n==== TASK MANAGER ====");
            System.out.println("1. Add a task");
            System.out.println("2. Print all tasks");
            System.out.println("3. Remove task");
            System.out.println("4. Complete task");
            System.out.println("5. Search task");
            System.out.println("6. Change priority");
            System.out.println("7. Print most important task");
            System.out.println("8. Change description");
            System.out.println("0. Exit");
            System.out.println("Choose an option:");

            if (!in.hasNextInt()) {
                System.out.println("Incorrect input...");
                in.nextLine();
                continue;
            }

            value = in.nextInt();
            in.nextLine();



            if(value == 0){
                System.out.println("BYE BYE...");
                break;
            }

            if (value < 0 || value > 8) {
                System.out.println("Incorrect value");
                continue;
            }

            switch (value){
                case 1:
                    System.out.println("ADD A NEW TASK");
                    System.out.println("Enter title");
                    String title = in.nextLine();

                    System.out.println("Enter description");
                    String description = in.nextLine();

                    while(title.isBlank()) {
                        System.out.println("Invalid input");

                        System.out.println("Enter another title");
                        title = in.nextLine();
                    }

                    while(description.isBlank()){
                        System.out.println("Invalid input");

                        System.out.println("Enter another description");
                        description = in.nextLine();
                    }

                    TaskStatus taskStatus = readStatus(in);

                    Priority priority = readPriority(in);

                    taskManager.addTask(new Task(title, description, taskStatus, priority));
                    break;


                case 2:
                    System.out.println();
                    System.out.println("ALL TASKS");
                    taskManager.printAllTasks();
                    break;

                case 3:
                    System.out.println("Enter the task that you want remove");
                    String removeTask = in.nextLine();
                    taskManager.deleteTask(removeTask);
                    break;

                case 4:
                    System.out.println("Enter the task that you want complete");
                    String completedTask = in.nextLine();
                    taskManager.completeTask(completedTask);
                    break;

                case 5:
                    System.out.println("Enter the task that you want search");
                    String searchedTask = in.nextLine();
                    Task task = taskManager.searchTask(searchedTask);
                    if(task != null){
                        task.printTask();
                    }else{
                        System.out.println("Task not found");
                    }
                    break;

                case 6:
                    System.out.println("Enter the task that you want change the priority");
                    String changePriority = in.nextLine();

                    Task taskToChange = taskManager.searchTask(changePriority);

                    if (taskToChange == null) {
                        System.out.println("Task not found.");
                        break;
                    }

                    Priority priority1 = readPriority(in);


                    taskManager.changeTaskPriority(changePriority, priority1);
                    break;

                case 7:
                    System.out.println("MOST IMPORTANT TASK");
                    Task mostImportant = taskManager.getMostImportantTask();

                    if (mostImportant != null) {
                        mostImportant.printTask();
                    } else {
                        System.out.println("No tasks available.");
                    }
                    break;

                case 8:
                    System.out.println("Enter the task that you want change");
                    String search = in.nextLine();

                    while (search.isBlank() || taskManager.searchTask(search) == null){
                        System.out.println("Task not present");
                        System.out.println("Enter another task");
                        search = in.nextLine();
                    }

                    System.out.println("Enter the new description");
                    String newDescription = in.nextLine();

                    while (newDescription.isBlank()) {
                        System.out.println("Enter another description");
                        newDescription = in.nextLine();
                    }

                    taskManager.changeTaskDescription(search, newDescription);
                    break;

                default:
                    System.out.println("ERROR...");
            }

        }while (value != 0);

    }


}
