### Questions for IP

- what exactly is project? means each task need to be included in a project? ``List<Task> [] toDoly = new ArralyList<>()[];`` **This is wrong! java don't allow to create parameterized types** Instead we could write like this: ``List<List<Task>> toDoly = new ArrayList<List<Task>>();``  This makes things compliecated. just make ``project`` a parameter to the class ``Task``.
- Any suggestions for workflow? what is the procedure to conduct an individual project? After intializing the project description (like UML), what the procedures to write the code step by step? like what kind of classes to write first? 
- java file operation
- java stream operation
- java unit test
- java package usage
- git branch usage



### Check

- Yes, the tasks need to be created within the project. Make ``project`` a parameter to the class ``Task``. So the class``Task`` can be written as ``public class Task { String title; String dueDate; Project project}`` What will be contained inside class ``Project``. **Here just try to make project as a label, once a task is created, assign it to a project, later on we can catergorize by this label.** For example: Project "A": taska1, taska2, taska3; Project "B": taskeb1, taskb2,taskb3;...