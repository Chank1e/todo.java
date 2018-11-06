package ui.listeners;

import ui.listeners.Listener;

public interface Observable {

    void addListener(Listener listener);

    void notifyListeners();
}
