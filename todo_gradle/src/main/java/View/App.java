package View;

import Entities.Task;
import Entities.TaskBoard;
import Entities.TaskList;
import Model.TaskState;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import Listeners.Listener;

public class App extends Listener{
    private TaskState state = new TaskState();

    public void init(){
        state.addEventListenet(this);
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

    @Override
    public void update(){
        System.out.println("Updated!");
    }
}
