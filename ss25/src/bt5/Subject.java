package bt5;

import java.util.List;
import java.util.ArrayList;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String message);
}