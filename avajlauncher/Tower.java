package avajlauncher;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List <Flyable> observers = new ArrayList <Flyable> ();

    public void register(Flyable flyable, String type) {
        observers.add(flyable);
        AvajLauncher.output.println("Tower transmission: " + type + "#" + flyable.getName() + "(" + flyable.getId() +  ") registered with the weather tower");
    }

    public void unregister(Flyable flyable, String type) {
        observers.remove(flyable);
        AvajLauncher.output.println("Tower transmission: " + type + "#" + flyable.getName() + "(" + flyable.getId() +  ") unregistered with the weather tower");
    }

    protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}