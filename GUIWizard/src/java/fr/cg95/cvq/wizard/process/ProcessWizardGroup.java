package fr.cg95.cvq.wizard.process;

import java.util.ArrayList;
import java.util.List;

import fr.cg95.cvq.wizard.process.xmlbean.ProcessDefinitionType;
import fr.cg95.cvq.wizard.process.xmlbean.ProcessType;

public class ProcessWizardGroup implements Comparable {

    private ProcessDefinitionType group = null;
    private List<ProcessType> processes = new ArrayList<ProcessType>();
    
    public ProcessWizardGroup(ProcessDefinitionType group) {
        this.group = group;
    }

    public String getName() {
        return group.getGroup();
    }
    
    public String getCaption() {
        return group.getCaption();
    }
    
    public List<ProcessType> getProcesses() {
        return processes;
    }
    
    public int getOrder() {
        if (group.isSetOrder())
            return group.getOrder();
        
        return 0;
    }

    public int compareTo(Object o) {
        if (o instanceof ProcessWizardGroup) {
            ProcessWizardGroup group = (ProcessWizardGroup)o;
            
            if (this.getOrder() < group.getOrder())
                return -1;
            if (this.getOrder() > group.getOrder())
                return 1;
        }
        return 0;
    }
    
}
