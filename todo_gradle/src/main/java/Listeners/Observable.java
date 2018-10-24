package Listeners;

import java.util.ArrayList;

public class Observable {
    private ArrayList<Listener> listeners = new ArrayList<>();

    public void addEventListenet(Listener listener){
        listeners.add(listener);
    }

    public void invokeNotifiers(){
        listeners.forEach(Listener::update);
    }
}
