package bound;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PersonBound {
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    private String name;
    private int age;

    public PersonBound() {
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String old = this.name;
        this.name = name;
        pcs.firePropertyChange("name", old, name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        int old = this.age;
        this.age = age;
        pcs.firePropertyChange("age", old, age);
    }
}

