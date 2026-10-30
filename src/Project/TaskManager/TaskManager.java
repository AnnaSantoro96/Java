package Project.TaskManager;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    private ArrayList<Task> tasks;

    public TaskManager(){
        tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        if(task != null){
            tasks.add(task);
        }else {
            System.out.println("Invalid input...");
        }
    }

    public void printAllTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks available");
        }else{
            for(Task task : tasks){
                task.printTask();
            }
        }
    }

    public void completeTask(String title){
        boolean found = false;

        for(Task task : tasks){
            if(task.getTitle().equalsIgnoreCase(title)){
                task.changeStatus(TaskStatus.COMPLETED);
                found = true;
            }
        }

        if(!found) {
            System.out.println("Task not found");
        }else{
            System.out.println("Task completed.");
        }
    }

    public void deleteTask(String title){
        boolean found = false;

     for(int i = 0; i < tasks.size(); i++){
         if(tasks.get(i).getTitle().equalsIgnoreCase(title)){
             tasks.remove(i);
             found = true;
             break;
         }
     }

        if(!found) {
            System.out.println("Task not found");
        }else{
            System.out.println("Task removed.");
        }
    }

    public Task searchTask(String title){
        for(Task task : tasks){
            if(task.getTitle().equalsIgnoreCase(title)){
                return  task;
            }
        }

        return null;
    }

    public void printTasksByStatus(TaskStatus status){
        boolean found = false;

        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getStatus() == status){
                tasks.get(i).printTask();
                found = true;
            }
        }

        if(!found){
            System.out.println("No tasks found with this status");
        }

    }

    public int countTasksByStatus(TaskStatus status){
        int count = 0;

        for (Task task : tasks) {
            if (task.getStatus() == status) {
                count++;
            }
        }

        return count;
    }

    public void changeTaskPriority(String title, Priority newPriority){
        boolean found = false;

        for(Task task : tasks){
            if(task.getTitle().equalsIgnoreCase(title)){
                task.setPriority(newPriority);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Task not found");
        }else{
            System.out.println("Task changed.");
        }

    }

    public void changeTaskDescription(String title, String newDescription){
        boolean found = false;

        if (newDescription == null || newDescription.isBlank()) {
            System.out.println("Invalid description.");
            return;
        }

        for(Task task: tasks){
            if(task.getTitle().equalsIgnoreCase(title)){
                task.setDescription(newDescription);
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("Task not found");
        }else{
            System.out.println("Description changed.");
        }
    }

    public void printTasksByPriority(Priority priority){
        boolean found = false;

        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getPriority() == priority){
                tasks.get(i).printTask();
                found = true;
            }
        }

        if(!found){
            System.out.println("No tasks found with this priority.");
        }
    }

    public int countTasksByPriority(Priority priority){
        int count = 0;

        for (Task task : tasks) {
            if (task.getPriority() == priority) {
                count++;
            }
        }

        return count;
    }

    public Task getHighestPriorityTask(){
        for(Task task : tasks){
            if(task.getPriority() == Priority.HIGH){
                return task;
            }
        }

        return null;
    }

    public Task getMostImportantTask(){
        if(tasks.isEmpty()){
            return null;
        }

        Task mostImportant = tasks.get(0);
        Priority mostPriority = mostImportant.getPriority();

        for(Task task : tasks){
            if(task.getPriority().compareTo(mostPriority) > 0){
                mostPriority = task.getPriority();
                mostImportant = task;
            }
        }
        return mostImportant;
    }

}
