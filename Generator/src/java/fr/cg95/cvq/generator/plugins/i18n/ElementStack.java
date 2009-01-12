package fr.cg95.cvq.generator.plugins.i18n;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author rdj@zenexity.fr
 */
public class ElementStack {

    private List<Stack<ElementI18n>> elements;
    private int depth;
    
    public ElementStack() {
        elements = new ArrayList<Stack<ElementI18n>>();
        
        // add an empty stack at depth == 0
        elements.add(new Stack<ElementI18n>());
        depth = 0;
    }
    
    public void push(int depth, ElementI18n element) {
        if (depth == this.depth + 1) {
            elements.add(new Stack<ElementI18n>());
            this.depth ++;
        }
        if (depth == this.depth)
            elements.get(this.depth).push(element);
    }
    
    public ElementI18n pop(int depth) {
        if (depth != 1 || this.depth != 1)
            return null;
        
        ElementI18n element = elements.get(depth).pop();
        
        if (elements.get(depth).size() == 0) {
            elements.remove(depth);
            this.depth --;
        }
        
        return element;
    }
    
    public ElementI18n peek(int depth) {
        if (depth > this.depth || this.depth == 0)
            return null;
        
        return elements.get(depth).peek();
    }
    
    public void store(int depth) {
        if (depth == 1)
            return;
        
        ElementI18n element = elements.get(depth).pop();
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
