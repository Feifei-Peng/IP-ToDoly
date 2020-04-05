package se.sda7.ip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class show the welcome information of the program, the commands to execute the program and
 * takes the options a user input.
 *
 * @author Feifei Peng
 * @version 2020.03.27
 */
public class CmdMenu {

  ToDoList toDoList;
  String fileName = "src/main/resources/todo.txt";
  private ArrayList<Task> taskList;

  /**
   * Constructor takes two initial parameters to create a Main menu
   *
   * @param taskList a list of tasks
   * @param toDoList a instance of ToDoList
   */
  public CmdMenu(ArrayList<Task> taskList, ToDoList toDoList) {

    this.taskList = taskList;
    this.toDoList = toDoList;
  }

  /** Print the welcome information of the program and take user's options */
  public void showWelcome() {

    int choice = 0;

    while (choice != 4) {

      int numberOfTasksDone = toDoList.getNumberOfTasksDone();

      System.out.println();
      System.out.println("--------------------------------------------------------------");
      System.out.println(">> Welcome to ToDoly");
      System.out.println(
          ">> You have "
              + (taskList.size() - numberOfTasksDone)
              + " tasks todo and "
              + numberOfTasksDone
              + " tasks are done!");
      System.out.println(">> Pick an option:");
      System.out.println(">> (1) Show Task list (by date or project)");
      System.out.println(">> (2) Add New Task");
      System.out.println(">> (3) Edit Task (update, mark as done, remove)");
      System.out.println(">> (4) Save and Quit");
      System.out.println("--------------------------------------------------------------");


      Scanner scanner = new Scanner(System.in);

      try {
        choice = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }

      switch (choice) {
        case 1:
          toDoList.showTask();
          break;
        case 2:
          toDoList.addTask();
          break;
        case 3:
          toDoList.editTask();
          break;
        case 4:
          try {
            toDoList.write(fileName);
          } catch (IOException e) {
            e.printStackTrace();
          }
          System.out.println(">> Goodbye!");
          break;

        default:
          System.out.println(">> Not a valid input!");
          break;
      }
    }
  }
}
