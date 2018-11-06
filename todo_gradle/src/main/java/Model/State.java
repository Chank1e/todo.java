package Model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ui.listeners.Listener;
import ui.listeners.Observable;

public class State implements Observable {
    private final Map<String, Object> data = new HashMap<>();

    private final List<Listener> listeners = new ArrayList<>();

    public void setState(Map<String, Object> newData){
        newData.forEach(data::put); // similar to ((key,value)->data.put(key,value))

        this.notifyListeners();
    }

    public Object get(String param){
        return data.get(param);
    }


    public void addListener(Listener listener){
        listeners.add(listener);
    }

    public void notifyListeners(){
        listeners.forEach(Listener::update);
    }
}
