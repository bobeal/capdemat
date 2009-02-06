package fr.cg95.cvq.generator.plugins.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author rdj@zenexity.fr
 *  * TODO : use generic to merge this class with fo and i18n one
 */
public class ElementStack {

    private List<Stack<ElementBo>> elements;
    private int depth;
    
    public ElementStack() {
        elements = new ArrayList<Stack<ElementBo>>();
        
        // add an empty stack at depth == 0
        elements.add(new Stack<ElementBo>());
        depth = 0;
    }
    
    public void push(int depth, ElementBo element) {
        if (depth == this.depth + 1) {
            elements.add(new Stack<ElementBo>());
            this.depth ++;
        }
        if (depth == this.depth)
            elements.get(this.depth).push(element);
    }
    
    public ElementBo pop(int depth) {
//        if (depth != 1 || this.depth != 1)
//            return null;
        
        ElementBo element = elements.get(depth).pop();
        
        if (elements.get(depth).size() == 0) {
            elements.remove(depth);
            this.depth --;
        }
        
        return element;
    }
    
    public ElementBo peek(int depth) {
        if (depth > this.depth || this.depth == 0)
            return null;
        
        return elements.get(depth).peek();
    }
    
    public void store(int depth) {
        if (depth == 1)
            return;
        
        ElementBo element = elements.get(depth).pop();
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
