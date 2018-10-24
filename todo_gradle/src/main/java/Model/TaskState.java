package Model;

import java.util.Map;

public class TaskState extends State {
    @Override
    public void setState(Map<String, Object> newData) {
        super.setState(newData); // Обновляем данные

        this.invokeNotifiers();
    }

}
