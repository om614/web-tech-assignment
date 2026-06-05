package constrained;

import java.beans.PropertyVetoException;

public class MainPersonConstrained {
    public static void main(String[] args) {
        PersonConstrained pc = new PersonConstrained();
        pc.enableAgeMinimumRule();

        try {
            pc.setAge(17);
            System.out.println("ERROR: age was set to 17 but should be vetoed");
        } catch (PropertyVetoException e) {
            System.out.println("Veto caught as expected: " + e.getMessage());
        }

        try {
            pc.setAge(18);
            System.out.println("Age set successfully: " + pc.getAge());
        } catch (PropertyVetoException e) {
            System.out.println("ERROR: veto occurred for valid age: " + e.getMessage());
        }
    }
}

