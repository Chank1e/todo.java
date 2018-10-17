package View;

import Instances.Task;
import Instances.TaskBoard;
import Instances.TaskList;
import Model.EventHandler;
import Model.TaskState;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class App {
    private TaskState state = new TaskState();
    private EventHandler eventHandler;
    public void init() throws ParseException{
        eventHandler = state.getEventHandler(); // Initialize event handler for created state
        this.mockState();
    }

    private void mockState() throws ParseException {
        Map<String, Object> tmpState = new HashMap<>();

        Consumer<Object> callback = new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                TaskBoard b = (TaskBoard)o;
                System.out.println(b.getName());
            }
        };

        eventHandler.addEventListener("board", callback); // Ставим коллбэк на обновление поля "board" в state

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
}
