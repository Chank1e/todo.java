package Instances;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class Task {
    private UUID id;
    private String name;
    private String description;
    private Date deadline = new Date();
    private boolean isDone = false;

    private static String _defaultDateFormat = "dd-MM-yyyy";

    public Task(String name, String description, String deadlineStr) throws ParseException{
        this.name = name;
        this.description = description;
        this.setDeadline(deadlineStr);
        this.generateUUID();
    }

    public Task(){
        this.name = "";
        this.description = "";
        this.generateUUID();
    }
    private void generateUUID(){
        id = UUID.randomUUID();
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    private void setDeadline(String deadline) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(_defaultDateFormat, Locale.getDefault());
        Date parsedDeadline = sdf.parse(deadline);
        this.deadline = parsedDeadline;
    }

    public Date getDeadline() {
        return deadline;
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Task)) return false;
        Task otherTask = (Task)other;
        return this.id == otherTask.id;
    }
}

