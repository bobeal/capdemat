package fr.cg95.cvq.wizard.tag.cvqforms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.wizard.manager.ManagerWizard;
import fr.cg95.cvq.wizard.process.ProcessWizardGroup;
import fr.cg95.cvq.wizard.process.ProcessWizardPlugin;
import fr.cg95.cvq.wizard.process.xmlbean.ProcessType;

public class ProcessSelectionTag extends CvqFormTag {
    String name = null;
    String property = null;
    String action = null;
    String var = null;
    
    public int doEndTag() throws JspException {
        
        try {
            ManagerWizard.loadSessionObject(pageContext.getSession(),true);
            
            if (!writeTag("processselect","end",this)) {
                JspWriter out = pageContext.getOut();
                out.println("Not Implemented!");
            }    
        } catch (Exception ignored) {
        }
        return EVAL_PAGE;
    }
    
    public Collection getProcessGroups() {
        ArrayList<ProcessWizardGroup> validGroups = new ArrayList<ProcessWizardGroup>();
        
        HashMap<String, ProcessWizardGroup> groups = ProcessWizardPlugin.plugin().getProcessGroups();
        
        for (ProcessWizardGroup group : groups.values()) {
            if (displayGroup(group))
                validGroups.add(group);
        }
        Collections.sort(validGroups);
        return validGroups;
    }
    
    public String getHref(ProcessType process) {
        return getHref(null, getAction(), process.getName());     
    }
    
    private boolean displayGroup(ProcessWizardGroup group) {
        if (group.getProcesses() != null) {
            for (ProcessType process : group.getProcesses()) {
                if (displayProcess(process.getName()))
                    return true;
            }
        }
        return false;
    }
    
    public boolean displayProcess(String process) {
        // Check the condition to display
        boolean inverse = false;
        
        String prop = getProperty();
        if (prop != null) {
            if (prop.startsWith("!")) {
                inverse = true;
                prop = prop.substring(1);
            }
            if ((var != null) && (var.length() > 0)) {
                prop = prop.replaceFirst("\\" + var,process);
                if (prop.indexOf(process) == -1)
                    return false;
            }
        }
        try {
            Object condition = RequestUtils.lookup(pageContext, name, prop, "session");
    
            if (condition != null) {
                if (condition instanceof Boolean)
                    // Condition object is a boolean, we display according to the boolean value
                    return (inverse) ? !((Boolean)condition).booleanValue() : ((Boolean)condition).booleanValue();
                
                // Condition object available and not a boolean, we display
                return (inverse) ? false : true;
            }
        } catch (JspException e) {
        }
        // No condition defined we display
        return true;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

}
