

import java.io.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;


public class ToDoList {



    private String fileName;
    private ArrayList<Task> taskList;

    public ToDoList (ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public int getNumberOfTasksDone() {

        int count = 0;
        for (Task task : taskList) {
            if (task.isTaskDone())
                count++;
        }

        return count;
    }

    public void showTask() {



        int choice = 0;

        while (choice != 3) {
            System.out.println(">>\n pick your option: \n");
            System.out.println(">> (1) Show all tasks by the due date");
            System.out.println(">> (2) Show tasks by project");
            System.out.println(">> (3) Back to main menu");

            Scanner scanner = new Scanner(System.in);
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            switch (choice) {
                case 1:
                    showTaskByDueDate();
                    break;
                case 2:
                    showTaskByProject();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Not a valid input!");
                    break;

            }
        }



    }




    public void showTaskByDueDate() {

        System.out.println("Task title\t\tDue date\t\tProject title\tTask status");
        taskList.stream().sorted((t1, t2) -> t1.getDueDate().compareTo(t2.getDueDate())).forEach(System.out::println);
    }

    public void showTaskByProject() {

        System.out.println("Task title\t\tDue date\t\tProject title\tTask status");
        taskList.stream().sorted((t1, t2) -> t1.getProjectTitle().compareToIgnoreCase(t2.getProjectTitle())).forEach(System.out::println);
    }

    public  void addTask() {

        System.out.println("\nAdd your new task: \n");
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the task title: \n");
        String title = input.nextLine();

        System.out.println("Enter the dueDate in the format of yyyy-MM-dd: \n");
        String dueDateString = input.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dueDate = null;
        try {
            dueDate = sdf.parse(dueDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Enter the project title: \n");
        String projectTitle = input.nextLine();

        Task newTask = new Task(title, dueDate, projectTitle);
        taskList.add(newTask);

    }

    public  void editTask() {

        int choice = 0;

        while (choice != 4) {
            System.out.println(">>\n pick your option: \n");
            System.out.println(">> (1) Update a task");
            System.out.println(">> (2) Mark a task Done");
            System.out.println(">> (3) Remove a task");
            System.out.println(">> (4) Back to main menu");

            Scanner scanner = new Scanner(System.in);
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            switch (choice) {
                case 1:
                    updateTask();
                    break;
                case 2:
                    markTaskDone();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Not a valid input!");
                    break;

            }
        }


    }

    public void updateTask() {

        System.out.println("\nChoose a task you want to update: \n");
        showTaskByIndex();

        Scanner scanner = new Scanner(System.in);

        int index = 0;

        try {
            index = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (index > 0 && index <= taskList.size()) {

            System.out.println("Enter the dueDate in the format of yyyy-MM-dd: \n");
            String dueDateString = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dueDate = null;
            try {
                dueDate = sdf.parse(dueDateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            taskList.get(index - 1).setDueDate(dueDate);

            System.out.println("Enter the project title: \n");
            String projectTitle = scanner.nextLine();
            taskList.get(index - 1).setProjectTitle(projectTitle);

            System.out.println("Enter the task status: ToDo or Done (ignore case)\n");
            String status = scanner.nextLine();

            if (status.equalsIgnoreCase("todo"))
                taskList.get(index - 1).setTaskDone(false);
            else if (status.equalsIgnoreCase("done"))
                taskList.get(index - 1).setTaskDone(true);
            else
                System.out.println("Not an appropriate input!");
        }
        else
            System.out.println("No such a task!");

    }

    public void markTaskDone() {

        System.out.println("\nChoose a task you want to mark as done: \n");
        showTaskByIndex();

        Scanner scanner = new Scanner(System.in);

        int index = 0;

        try {
            index = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (index > 0 && index <= taskList.size()) {
            taskList.get(index - 1).setTaskDone(true);
        }
        else
            System.out.println("No such a task!");
    }

    public void removeTask() {

        System.out.println("\nChoose a task you want to delete: \n");
        showTaskByIndex();

        Scanner scanner = new Scanner(System.in);

        int index = 0;

        try {
            index = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (index > 0 && index <= taskList.size()) {
            taskList.remove(index - 1);
        }
        else
            System.out.println("No such a task!");
    }

    public void showTaskByIndex() {

        System.out.println("Task ID\t\tTask title\t\tDue date\t\tProject title\t\tTask status");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + "\t\t\t" + taskList.get(i).toString());
        }
    }


    public void write(String fileName) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (Task task: taskList) {
            bw.write(task.toString());
            bw.write("\n");
        }
        bw.close();
        System.out.println("All changes saved!");
    }



    public void load(String fileName) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = "";
        while ((line = br.readLine()) != null) {
            // add tasks to the todolist
            Task task = parseDataToTask(line);
            taskList.add(task);
        }
        br.close();

    }

    /**
     * Parse a line of data to a task
     * @param line
     * @return
     */
    public Task parseDataToTask(String line) {

        Task task = new Task();
        // what is the default split for a txt file saved from an arraylist
        String[] data = line.split("\t\t");
        task.setTitle(data[0]);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            task.setDueDate(sdf.parse(data[1]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        task.setProjectTitle(data[2]);

        if(data[3].equals("Done"))
        task.setTaskDone(true);
        else
        task.setTaskDone(false);


        return task;


    }


}

