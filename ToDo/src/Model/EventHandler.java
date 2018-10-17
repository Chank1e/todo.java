package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class EventHandler {
    private Map<String, Consumer<Object>> listeners = new HashMap<>();

    public void addEventListener(String key, Consumer<Object> callback) {
        listeners.put(key, callback);
    }

    void updateListeners(Map<String, Object> data) {
        for (Map.Entry<String, Object> updated : data.entrySet()) {
            String key = updated.getKey();
            Object value = updated.getValue();

            sendEventToListeners(key, value);

        }
    }

    private void sendEventToListeners(String updatedKey, Object updatedValue) {

        for (Map.Entry<String, Consumer<Object>> entry : listeners.entrySet()) {

            String key = entry.getKey();
            Consumer<Object> callback = entry.getValue();

            if (key.equals(updatedKey)) callback.accept(updatedValue);
        }
    }
}
