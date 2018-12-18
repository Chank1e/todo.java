package domain.entity;

import java.util.ArrayList;

public class TaskBoard {
    private String name;
    private ArrayList<TaskList> lists = new ArrayList<TaskList>();

    public TaskBoard(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void connectList(TaskList list){
        lists.add(list);
    }
}
