package se.sda7.ip;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class stores the details of a task, like the title, due date, status and which project it
 * belongs to.
 *
 * @author Feifei Peng
 * @version 2020.03.27
 */
public class Task {

  private String title;
  private Date dueDate;
  private String projectTitle;
  private boolean isDone = false;

  /** Constructor with no parameters */
  public Task() {
    // auto generated constructor
  }

  /**
   * Constructor to initialize a task
   *
   * @param title The task's title or a simple description of a task
   * @param dueDate The due date of a task, in a format yyyy-MM-dd
   * @param projectTitle The project's title, where stores several tasks
   */
  public Task(String title, Date dueDate, String projectTitle) {

    this.title = title;
    this.dueDate = dueDate;
    this.projectTitle = projectTitle;
  }

  /**
   * Return the title of a task
   *
   * @return the title of a task
   */
  public String getTitle() {

    return title;
  }

  /**
   * Set the title of a task
   *
   * @param title The description or title of a task
   */
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
  /** Transfer an object to a String so it could be printed out */
  public String toString() {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    // sdf.format(Date) to transfer Date type to String type
    if (isTaskDone() == true)
      return title + "\t\t" + sdf.format(dueDate) + "\t\t" + projectTitle + "\t\t" + "Done";
    else return title + "\t\t" + sdf.format(dueDate) + "\t\t" + projectTitle + "\t\t" + "ToDo";
  }
}
