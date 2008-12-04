package fr.cg95.cvq.generator.plugins.fo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import fr.cg95.cvq.generator.plugins.fo.Element;


/**
 * @author maxence.veyret@bull.net
 */
public final class FoStep {

    private static Logger logger = Logger.getLogger(FoStep.class);
    
    private Integer index;
    private String name;
    private String ref;
    
    private List<Element> elementList;
  
    public FoStep(final Integer index, final String name, final String ref) {
        this.index = index;
        this.name = name;
        if (ref != null)
            this.ref = ref;
        elementList = new ArrayList<Element>();
    }

    public Integer getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }
    
    public String getRef() {
        return this.ref;
    }
    
    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }
    
    public boolean addElement(Element element){
        if (elementList == null)
            elementList = new ArrayList<Element>();
        
       return( elementList.add(element));
    }
    
    public Element getChildElement(int index) {
        return elementList.get(index);
    }
}
