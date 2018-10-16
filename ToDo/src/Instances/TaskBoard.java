package Instances;

import java.util.ArrayList;
import java.util.List;

public class TaskBoard {
    private String name;
    private ArrayList<List> lists = new ArrayList<List>();

    public TaskBoard(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void connectList(List list){
        lists.add(list);
    }
}
