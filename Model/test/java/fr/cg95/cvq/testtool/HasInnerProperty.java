package fr.cg95.cvq.testtool;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class HasInnerProperty<T> extends TypeSafeMatcher<T> {

    private String propertyName;

    public HasInnerProperty(String propertyName) {
        this.propertyName = propertyName;
    }

    private Class<?> findClassForProperty(String propertyName, Class<?> clazz) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            for (PropertyDescriptor property : beanInfo.getPropertyDescriptors()) {
                if (property.getName().equals(propertyName)) {
                    return property.getPropertyType();
                }
            }

            return null;
        } catch (IntrospectionException e) {
            // introspection failure is treated as a matcher failure
            return null;
        }
    }
    
    @Override
    public boolean matchesSafely(T obj) {

        String [] properties = propertyName.split(".");
        Class<?> classToInspect = obj.getClass();
        for (String property : properties) {
            classToInspect = findClassForProperty(property, classToInspect);
            if (classToInspect == null) {
                return false;
            }
        }
        
        return true;
    }

    public void describeTo(Description description) {
        description.appendText("hasInnerProperty(").appendValue(propertyName).appendText(")");
    }
    
    @Factory
    public static <T> Matcher<T> hasProperty(String propertyName) {
        return new HasInnerProperty<T>(propertyName);
    }
}
