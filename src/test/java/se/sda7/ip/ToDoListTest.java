package se.sda7.ip;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class ToDoListTest {

  private String fileName;
  private ArrayList<Task> taskList;
  private ToDoList toDoList;

  @Before
  public void setUp() {
    fileName = "src/main/resources/todo.txt";
    taskList = new ArrayList<>();
    toDoList = new ToDoList(taskList);
    try {
      toDoList.load(fileName);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void getNumberOfTasksDone() {
    int result = toDoList.getNumberOfTasksDone();
    Assert.assertEquals(3, result);
  }

  @Test
  public void showTaskByIndex() {
    Assert.assertTrue(taskList.get(0).getProjectTitle().equals("housework"));
    Assert.assertTrue(taskList.get(5).getTitle().equals("study lec1"));
  }
}
