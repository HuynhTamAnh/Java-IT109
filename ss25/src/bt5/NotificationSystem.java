package bt5;

import java.util.List;
import java.util.ArrayList;

public class NotificationSystem implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String latestNotification;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        this.latestNotification = message;
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public String getLatestNotification() {
        return latestNotification;
    }
}