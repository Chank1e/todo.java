package domain.entity;

import sequelize.*;
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

    public Task(String name, String description, String deadlineStr){
        this.name = name;
        this.description = description;
        this.setDeadline(deadlineStr);
        this.id = this.generateUUID();
    }

    public Task(){
        this.name = "";
        this.description = "";
        this.id = this.generateUUID();
    }
    private UUID generateUUID(){
        return UUID.randomUUID();
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    private void setDeadline(String deadline) {
        SimpleDateFormat sdf = new SimpleDateFormat(_defaultDateFormat, Locale.getDefault());
        Date parsedDeadline;
        try {
            parsedDeadline = sdf.parse(deadline);
        } catch(ParseException e){
            parsedDeadline = new Date();
        }
        this.deadline = parsedDeadline;
    }

    public Date getDeadline() {
        return new Date(deadline.getTime());
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

