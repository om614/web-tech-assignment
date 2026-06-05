package beaninfo;

import beans.Person;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class MainPersonBeanInfo {
    public static void main(String[] args) throws IntrospectionException {
        // Use our explicit BeanInfo implementation.
        BeanInfo bi = new PersonBeanInfo();
        System.out.println("Properties from PersonBeanInfo:");
        for (PropertyDescriptor pd : bi.getPropertyDescriptors()) {
            System.out.println("- " + pd.getName() + " (" + pd.getPropertyType().getSimpleName() + ")");
        }

        // Also show default introspection for cross-check.
        BeanInfo bi2 = Introspector.getBeanInfo(Person.class);
        System.out.println("Properties from Introspector.getBeanInfo(Person.class):");
        for (PropertyDescriptor pd : bi2.getPropertyDescriptors()) {
            System.out.println("- " + pd.getName());
        }
    }
}

