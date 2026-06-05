package beaninfo;

import beans.Person;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.BeanDescriptor;
import java.beans.EventSetDescriptor;
import java.beans.MethodDescriptor;
// Note: javax.swing.ImageIcon / AWT Image aren't required for this assignment.

public class PersonBeanInfo implements BeanInfo {


    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor name = new PropertyDescriptor("name", Person.class);
            PropertyDescriptor age = new PropertyDescriptor("age", Person.class);
            return new PropertyDescriptor[]{name, age};
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BeanDescriptor getBeanDescriptor() {
        return null;
    }

    @Override
    public EventSetDescriptor[] getEventSetDescriptors() {
        return null;
    }

    @Override
    public MethodDescriptor[] getMethodDescriptors() {
        return null;
    }

    @Override
    public java.awt.Image getIcon(int iconKind) {
        return null;
    }


    @Override
    public int getDefaultEventIndex() {
        return -1;
    }

    @Override
    public int getDefaultPropertyIndex() {
        return -1;
    }

    @Override
    public java.beans.BeanInfo[] getAdditionalBeanInfo() {
        return null;
    }




}


