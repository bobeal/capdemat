package fr.cg95.cvq.generator.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rdj@zenexity.fr
 * @author jsb@zenexity.fr
 */
public abstract class ElementSpecific<E> {

    protected List<E> elements;

    public ElementSpecific() {
        elements = new ArrayList<E>();
    }

    public List<E> getElements() {
        return elements;
    }

    public void addElement(E element) {
        elements.add(element);
    }
}
