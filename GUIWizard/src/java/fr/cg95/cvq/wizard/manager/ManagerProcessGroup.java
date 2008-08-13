package fr.cg95.cvq.wizard.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.cg95.cvq.wizard.manager.xmlbean.ManagerProcessType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerProcessesType;

public class ManagerProcessGroup implements Comparable {

    private ManagerProcessesType group = null;
    private List<ManagerProcessType> processes = new ArrayList<ManagerProcessType>();
    
    public ManagerProcessGroup(ManagerProcessesType group) {
        this.group = group;
    }

    public ManagerProcessesType getGroup() {
        return group;
    }
    
    public String getName() {
        return group.getGroup();
    }
    
    public String getCaption() {
        return group.getCaption();
    }
    
    public String getIcon() {
        return group.getIcon();
    }
    
    public List<ManagerProcessType> getProcesses() {
        return processes;
    }
    
    public void addProcesses(ManagerProcessType[] processes) {
        this.processes.addAll(Arrays.asList(processes));
    }
    
    public int getOrder() {
        if (group.isSetOrder())
            return group.getOrder();
        
        return 0;
    }

    public int compareTo(Object o) {
        if (o instanceof ManagerProcessGroup) {
            ManagerProcessGroup group = (ManagerProcessGroup)o;
            
            if (this.getOrder() < group.getOrder())
                return -1;
            if (this.getOrder() > group.getOrder())
                return 1;
        }
        return 0;
    }

}
