package fr.cg95.cvq.wizard;

import java.util.ArrayList;
import java.util.Collection;

public class StageFormList extends ArrayList {
    private ListListener listListener = null;
    private Object userData = null;
    
    public StageFormList() {
        super();
    }

    public StageFormList(ListListener listListener, Object data) {
        super();
        this.listListener = listListener;
        this.userData = data;
    }

    public StageFormList(int initialCapacity) {
        super(initialCapacity);
    }

    public StageFormList(Collection c) {
        super(c);
    }

    public boolean add(Object o) {
        if (listListener != null)
            listListener.onAdd(userData, o);
        
        return super.add(o); 
    }

    public void save(Object o) {
        if (listListener != null)
            listListener.onSave(userData, o);
    }

    public Object select(int index) {
        Object o = super.get(index);

        if (listListener != null)
            listListener.onSelect(userData, o);
        
        return o;
    }

    public Object create(Object o) {
        if (listListener != null)
            listListener.onNew(userData, o);
        
        return o;
    }

    public Object remove(int index) {
        Object o = super.get(index);

        if (listListener != null)
            listListener.onRemove(userData, o);
        
        o = super.remove(index);
        return o;
    }
    
}
