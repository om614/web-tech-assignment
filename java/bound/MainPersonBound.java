package bound;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainPersonBound {
    public static void main(String[] args) {
        PersonBound pb = new PersonBound();
        pb.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("Property changed: " + evt.getPropertyName() + " from " + evt.getOldValue() + " to " + evt.getNewValue());
            }
        });

        pb.setName("Bob");
        pb.setAge(30);
    }
}

