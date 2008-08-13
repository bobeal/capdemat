package fr.cg95.cvq.wizard.tag.cvqforms;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import fr.cg95.cvq.wizard.IProcessWizard;
import fr.cg95.cvq.wizard.process.ProcessWizard;
import fr.cg95.cvq.wizard.process.ProcessWizardPlugin;

public class ProcessHrefTag extends CvqFormTag {
    
    private static final String JAVASCRIPT ="javascript:";
    
    private String action ="";
    private boolean script = false;

    public ProcessHrefTag() {
        super();
    }

    public int doEndTag() throws JspException {
        ProcessWizard process = null;

        String processName = getName();
        if (processName == null)
            processName = (String)pageContext.getSession().getAttribute(IProcessWizard.PROCESS_NAME);
        
        if (processName != null)
            process = (ProcessWizard)ProcessWizardPlugin.plugin().getProcess(processName);
        
        if (process != null) {
            JspWriter out = pageContext.getOut();
            try {
                String href = getHref(process.getProcess().getConfirmArray(), getAction(), process.getName());
                if (script) {
                    if (href.startsWith(JAVASCRIPT)) {
                        href = href.substring(JAVASCRIPT.length());
                    } else {
                        href = "document.location.href = \"" + href + "\"";
                    }
                }
                out.print(href);

            } catch (Exception ignored) {
            }
        }
        return EVAL_PAGE;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isScript() {
        return script;
    }

    public void setScript(boolean script) {
        this.script = script;
    }
    

}
