import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToDolyApp {

    public static void main(String[] args) {

        String fileName = "src/main/todo.txt";
        ArrayList<Task> taskList = new ArrayList<>();
        ToDoList todolist = new ToDoList(taskList);

        try {
            todolist.load(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CmdMenu cmdMenu = new CmdMenu(taskList, todolist);
        cmdMenu.showWelcome();
    }
}
