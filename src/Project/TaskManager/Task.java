package Project.TaskManager;

public class Task {

    private String title;
    private String description;
    private TaskStatus status;
    private Priority priority;

    public Task(String title, String description, TaskStatus status, Priority priority){
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void changeStatus(TaskStatus newStatus){
        this.status = newStatus;
    }

    public void printTask(){
        System.out.println("Title: " + title + "\nDescription: " + description + "\nStatus: " + status + "\nPriority: " + priority);
    }
}
