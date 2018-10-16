import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class List {
    String name;
    ArrayList<Task> tasks = new ArrayList<Task>();

    List(){
        this.name = "";
    }

    List(String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void showTasks() {
        for (Task task: tasks) {
            System.out.println(task.getName()+" - "+task.getDescription()+" (deadline: "+task.getDeadline().toString()+")");
        }
    }
}
