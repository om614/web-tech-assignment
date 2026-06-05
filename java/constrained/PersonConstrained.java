package constrained;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.beans.PropertyVetoException;

public class PersonConstrained {
    private final VetoableChangeSupport vcs = new VetoableChangeSupport(this);
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    private String name;
    private int age;

    public PersonConstrained() {
    }

    public void addVetoableChangeListener(VetoableChangeListener listener) {
        vcs.addVetoableChangeListener(listener);
    }

    public void removeVetoableChangeListener(VetoableChangeListener listener) {
        vcs.removeVetoableChangeListener(listener);
    }

    // Convenience: allow observers for actual committed property changes.
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws PropertyVetoException {
        String old = this.name;
        vcs.fireVetoableChange("name", old, name);
        this.name = name;
        pcs.firePropertyChange("name", old, name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws PropertyVetoException {
        int old = this.age;
        // If a veto is thrown, the assignment is not committed.
        vcs.fireVetoableChange("age", old, age);
        this.age = age;
        pcs.firePropertyChange("age", old, age);
    }

    // Example veto rule: age cannot be less than 18.
    public void enableAgeMinimumRule() {
        vcs.addVetoableChangeListener(evt -> {
            if ("age".equals(evt.getPropertyName())) {
                int newAge = (Integer) evt.getNewValue();
                if (newAge < 18) {
                    throw new PropertyVetoException("Age cannot be less than 18", evt);
                }
            }
        });
    }
}

