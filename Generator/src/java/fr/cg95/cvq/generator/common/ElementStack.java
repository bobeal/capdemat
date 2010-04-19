package fr.cg95.cvq.generator.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author rdj@zenexity.fr
 * @author jsb@zenexity.fr
 */
public class ElementStack<E extends ElementSpecific<E>> {

    private List<Stack<E>> elements;

    private int depth;

    public ElementStack() {
        elements = new ArrayList<Stack<E>>();
        elements.add(new Stack<E>());
        depth = 0;
    }

    public void push(int depth, E element) {
        if (depth == this.depth + 1) {
            elements.add(new Stack<E>());
            this.depth ++;
        }
        if (depth == this.depth)
            elements.get(this.depth).push(element);
    }

    public E pop(int depth) {
        E element = elements.get(depth).pop();
        if (elements.get(depth).size() == 0) {
            elements.remove(depth);
            this.depth --;
        }
        return element;
    }

    public E peek(int depth) {
        if (depth > this.depth || this.depth == 0)
            return null;
        return elements.get(depth).peek();
    }

    public void store(int depth) {
        if (depth == 1)
            return;
        E element = elements.get(depth).pop();
        elements.get(depth -1).peek().addElement(element);
        if (elements.get(depth).size() == 0) {
            elements.remove(depth);
            this.depth --;
        }
    }

    public int getDepth() {
        return depth;
    }
}
