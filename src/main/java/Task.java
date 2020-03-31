import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * This class stores the details of a task, like the title, due date, status and which project it belongs to.
 */

public class Task {

    private String title;
    private Date dueDate;
    private String projectTitle;
    private boolean isDone = false;

    /**
     * Constructor with no parameters
     */
    public Task() {
        // auto generated constructor
    }

    /**
     * Constructor to initialize a task
     * @param title
     * @param dueDate
     * @param projectTitle
     *
     */
    public Task(String title, Date dueDate, String projectTitle) {

        this.title = title;
        this.dueDate = dueDate;
        this.projectTitle = projectTitle;

    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public Date getDueDate() {

        return dueDate;
    }

    public void setDueDate(Date dueDate) {

        this.dueDate = dueDate;
    }

    public String getProjectTitle() {

        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {

        this.projectTitle = projectTitle;
    }

    public boolean isTaskDone() {

        return isDone;
    }

    public void setTaskDone(boolean isDone) {

        this.isDone = isDone;
    }

    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //sdf.format(Date) to transfer Date type to String type
        if (isTaskDone() == true)
            return title + "\t\t" + sdf.format(dueDate) + "\t\t" + projectTitle + "\t\t" + "Done";
        else
            return title + "\t\t" + sdf.format(dueDate) + "\t\t" + projectTitle + "\t\t" + "ToDo";
    }
}
