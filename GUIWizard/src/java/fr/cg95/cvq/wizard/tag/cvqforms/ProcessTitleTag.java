package fr.cg95.cvq.wizard.tag.cvqforms;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import fr.cg95.cvq.wizard.IProcessWizard;
import fr.cg95.cvq.wizard.process.ProcessWizard;
import fr.cg95.cvq.wizard.process.ProcessWizardPlugin;
import fr.cg95.cvq.wizard.process.xmlbean.ProcessType;

public class ProcessTitleTag extends CvqFormTag {
    
    public ProcessTitleTag() {
        super();
    }

    public int doEndTag() throws JspException {
        
        // Save the process name in the session
        String processName = (String)pageContext.getSession().getAttribute(IProcessWizard.PROCESS_NAME);
        
        if (processName != null) try {
            ProcessWizard process = (ProcessWizard)ProcessWizardPlugin.plugin().getProcess(processName);
            if (process != null) {
                ProcessType xmlbProcess = process.getProcess();

                JspWriter out = pageContext.getOut();
                out.print(xmlbProcess.getTitle());
            }
        } catch (IOException ioe) {
            
        }
        return EVAL_PAGE;
    }

}
