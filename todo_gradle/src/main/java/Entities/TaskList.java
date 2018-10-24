package Entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class TaskList {
    private UUID id;
    private String name;
    private ArrayList<Task> tasks = new ArrayList<Task>();

    private static String _defaultDateFormat = "dd-MM-yyyy";


    public TaskList(){
        this.name = "";
        this.id = this.generateUUID();
    }

    public TaskList(String name) {
        this.name = name;
        this.id = this.generateUUID();
    }

    private UUID generateUUID(){
        return UUID.randomUUID();
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

    public ArrayList<Task> getTasksInRange(String dateFromStr, String dateToStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(_defaultDateFormat, Locale.getDefault());
        Date dateFrom;
        Date dateTo;
        try {
            dateFrom = sdf.parse(dateFromStr);
            dateTo = sdf.parse(dateToStr);
        } catch(ParseException e){
            dateFrom = new Date();
            dateTo = new Date();
        }

        ArrayList<Task> result = new ArrayList<Task>();

        for(Task task: tasks) {
            if(!(task.getDeadline().before(dateFrom) || task.getDeadline().after(dateTo))){
                result.add(task);
            }
        }
        return result;
    }

}
