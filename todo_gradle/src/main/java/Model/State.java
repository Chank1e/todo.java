package Model;


import java.util.HashMap;
import java.util.Map;
import Listeners.Observable;

public class State extends Observable {
    private final Map<String, Object> data = new HashMap<>();

    public void setState(Map<String, Object> newData){
        newData.forEach(data::put); // similar to ((key,value)->data.put(key,value))


    }

    public Object get(String param){
        return data.get(param);
    }
}
