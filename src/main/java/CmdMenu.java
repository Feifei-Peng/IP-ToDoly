

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class CmdMenu {

    private ArrayList<Task> taskList;
    ToDoList todolist;
    String fileName = "src/main/todo.txt";

    public CmdMenu(ArrayList<Task> taskList, ToDoList todolist) {

        this.taskList = taskList;
        this.todolist = todolist;
    }

    public void showWelcome() {



        int choice = 0;

        while (choice != 4) {

            int numberOfTasksDone = todolist.getNumberOfTasksDone();

            System.out.println();
            System.out.println("-------------------------------");
            System.out.println(">> Welcome to ToDoly");
            System.out.println(">> You have " + (taskList.size() - numberOfTasksDone) + " tasks todo and " + numberOfTasksDone + " tasks are done!");
            System.out.println(">> Pick an option:");
            System.out.println(">> (1) Show Task list (by date or project)");
            System.out.println(">> (2) Add New Task");
            System.out.println(">> (3) Edit Task (update, mark as done, remove)");
            System.out.println(">> (4) Save and Quit");
            System.out.print(">> ");

            Scanner scanner = new Scanner(System.in);

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            switch (choice) {

                case 1:
                    todolist.showTask();
                    break;
                case 2:
                    todolist.addTask();
                    break;
                case 3:
                    todolist.editTask();
                    break;
                case 4:
                    try {
                        todolist.write(fileName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    System.out.println("Not a valid input!");
                    break;


            }
        }
    }
}
