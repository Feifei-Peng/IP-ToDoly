# ToDoly
This is an individual project for SDA-7-LUND

> ### Project Specification
>The task is to build a todo list application. The application will allow a user to create new tasks, assign them a title and due date, and choose a project for that task to belong to. They will need to use a text based user interface via the command-line (hint: see BlueJ World of Zuul project for some ideas on this). Once they are using the application, the user should be able to also edit, mark as done or remove tasks. They can also quit and save the current task list to file, and then restart the application with the former state restored. The interface should look similar to the mockup below:
>\>> Welcome to ToDoLy    
\>> You have X tasks todo and Y tasks are done!  
\>> Pick an option:     
\>> (1) Show Task List (by date or project)  
\>> (2) Add New Task   
\>> (3) Edit Task (update, mark as done, remove)   
\>> (4) Save and Quit  
\>>    
>### Requirements
>The solution must achieve the following requirements:
Model a task with a task title, due date, status and project
Display a collection of tasks that can be sorted both by date and project
Support the ability to add, edit, mark as done, and remove tasks
Support a text-based user interface
Load and save task list to file
The solution may also include other creative features at your discretion in case you wish to show some flair(but this will not affect the default evaluation -- see checklist).
### Tools
- VS code
- Intellij IDEA
### Class diagram

![image](./figures/ip_class_diagram.png)
### User Manual
This provides a brief introduction how to use the program and here is the [link](./User_manual.md).


<!-- ```puml
'skinparam classAttributeIconSize 0
class Task {
    -String title
    -String dueDate
    -String projectTitle
    -boolean isDone 
    +getTitle()
    +setTitle()
    +getProjectTitle()
    +setProjectTitle()
    +getDueDate()
    +setDueDate()
    +isTaskDone()
    +setTaskDone()
    +toString()
}

class ToDoList {
    -ArrayList<Task> taskList
    -fileName
    +showTask()
    +getNumberOfTasksDone()
    +showTaskByDueDate()
    +showTaskByProject()
    +addTask()
    +editTask()
    +updateTask()
    +markTaskDone()
    +removeTask()
    +showTaskByIndex()
    +write()
    +load()
}

class CmdMenu {
    -ArrayList<Task>
    ~ToDoList
    ~fileName
    +showWelcome()
}

class ToDolyApp {
    ~fileName
    ~ArrayList<Task>
    ~ToDoList
    
    
}


Task <-- CmdMenu 
Task <-- ToDolyApp
ToDoList o-- Task 
ToDoList <-- CmdMenu
ToDoList <-- ToDolyApp


``` -->

### License
This project is licensed under the GNU General Public License v3.0 - see the [LICENSE.md](https://github.com/melvinmajor/TodoList/blob/master/LICENSE.md) file for details.
