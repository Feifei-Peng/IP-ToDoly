// package import
// import com.ToDoly

public class Task {

    private String title;
    private String dueDate;
    private boolean taskStatus;

    // create new tasks using constructor
    // or using the patern simple factory 

    public Task(String title, String dueDate, boolean taskStatus) {
        this.title = title;
        this.dueDate = dueDate;
        this.taskStatus = taskStatus;
    }

    public void setTitle(String title) {

        this.title = title;
        
    }

    public void setDueDate(String dueDate) {

        this.dueDate = dueDate;

    }

    public void setTaskStatus(boolean taskStatus) {

        this.taskStatus = taskStatus;

    }

    public String getTitle() {

        return title;
        
    }

    public String getDueDate() {

        return dueDate;

    }

    public boolean getTaskStatus() {

        return taskStatus;

    }
}