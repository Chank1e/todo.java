package View;

import domain.entity.Task;
import domain.entity.TaskBoard;
import domain.entity.TaskList;
import Model.State;

import java.util.HashMap;
import java.util.Map;

import ui.listeners.Listener;

public class App implements Listener {
    private State state = new State();

    public void init(){
        state.addListener(this);
        this.mockState();
    }

    private void mockState(){
        Map<String, Object> tmpState = new HashMap<>();

        TaskBoard board = new TaskBoard("BoardName");

        TaskList list1 = new TaskList("List1");
        list1.addTask(new Task("Task1_1", "Task1_1Description", "22-12-2018"));
        list1.addTask(new Task("Task2_1", "Task2_1Description", "19-09-2019"));
        list1.addTask(new Task("Task3_1", "Task3_1Description", "01-01-2022"));

        TaskList list2 = new TaskList("List2");
        list2.addTask(new Task("Task1_2", "Task1_2Description", "01-03-2022"));
        list2.addTask(new Task("Task2_2", "Task2_2Description", "01-05-2024"));

        tmpState.put("board", board);

        state.setState(tmpState); // Обновляем state. После обновления сработает коллбэк
    }


    public void update(){
        System.out.println("Updated!");
    }
}
