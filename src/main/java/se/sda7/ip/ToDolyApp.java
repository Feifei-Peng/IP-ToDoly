package se.sda7.ip;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class provide an entry point to run the program. It initializes the file path to read and
 * save, the taskList to store the tasks and an instance of ToDoList and create a CML interface to
 * interact with users.
 *
 * @author Feifei Peng
 * @version 2020.03.27
 */
public class ToDolyApp {

  public static void main(String[] args) {

    String fileName = "src/main/resources/todo.txt";
    ArrayList<Task> taskList = new ArrayList<>();
    ToDoList toDoList = new ToDoList(taskList);
    // load the todo list from the file
    try {
      toDoList.load(fileName);
    } catch (IOException e) {
      e.printStackTrace();
    }

    CmdMenu cmdMenu = new CmdMenu(taskList, toDoList);
    cmdMenu.showWelcome();
  }
}
