package Instances;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Locale;
import java.util.UUID;

public class TaskList {
    private UUID id;
    private String name;
    private ArrayList<Task> tasks = new ArrayList<Task>();

    private static String _defaultDateFormat = "dd-MM-yyyy";


    public TaskList(){
        this.name = "";
        this.generateUUID();
    }

    public TaskList(String name) {
        this.name = name;
        this.generateUUID();
    }

    private void generateUUID(){
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public ArrayList<Task> getTasks() {
        return new ArrayList<Task>(tasks);
    }

    public ArrayList<Task> getTasksInRange(String dateFromStr, String dateToStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(_defaultDateFormat, Locale.getDefault());
        Date dateFrom = sdf.parse(dateFromStr);
        Date dateTo = sdf.parse(dateToStr);

        ArrayList<Task> result = new ArrayList<Task>();

        for(Task task: tasks) {
            if(!(task.getDeadline().before(dateFrom) || task.getDeadline().after(dateTo))){
                result.add(task);
            }
        }
        return result;
    }

}
