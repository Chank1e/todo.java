package domain.db;

import domain.db.models.TaskListModel;
import domain.db.models.TaskModel;
import sequelize.Sequelize;
import sequelize.model.Model;
import ui.listeners.Listener;
import ui.listeners.Observable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainDB implements Observable {
    private static Sequelize sequelize = new Sequelize("postgres", "rsadmin", "rsadminpassword");
    private static Boolean isInited = false;

    private static Map<String,Model> models = new HashMap<>();

    private final List<Listener> listeners = new ArrayList<>();

    public static Sequelize instance(){
        if(!isInited)
            init();
        return sequelize;
    }

    public static void init(){
        TaskModel task = new TaskModel();
        models.put(task.getName(), task.defineModel(sequelize));

        TaskListModel taskList = new TaskListModel();
        models.put(taskList.getName(), taskList.defineModel(sequelize));

        getModel("Task").belongsTo(getModel("TaskList"), "list_id");

        sequelize.sync();
    }

    public static Model getModel(String name){
        return models.get(name);
    }

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void notifyListeners() {
        listeners.forEach(Listener::update);
    }
}
