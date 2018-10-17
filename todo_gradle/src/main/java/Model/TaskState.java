package Model;

import java.util.Map;

public class TaskState extends State {
    EventHandler eventHandler = new EventHandler();

    @Override
    public void setState(Map<String, Object> newData) {
        super.setState(newData); // Обновляем данные

        eventHandler.updateListeners(newData); // Вызываем обработчиков, которые подписаны на изменения обновленных данных
    }

    public EventHandler getEventHandler(){
      return eventHandler;
    };
}
