package fr.cg95.cvq.wizard.tag.cvqforms;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import fr.cg95.cvq.wizard.IProcessWizard;
import fr.cg95.cvq.wizard.process.ProcessWizard;
import fr.cg95.cvq.wizard.process.ProcessWizardPlugin;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.wizard.process.xmlbean.ProcessType;
import fr.cg95.cvq.wizard.process.xmlbean.StageType;

public class ProcessPresentationTag extends CvqFormTag {

    private ProcessType xmlbProcess = null;
    
    public ProcessPresentationTag() {
        super();
    }

    public int doEndTag() throws JspException {
        ProcessWizard process = null;
        String processName = (String)pageContext.getSession().getAttribute(IProcessWizard.PROCESS_NAME);
        if (processName != null) {
            process = (ProcessWizard)ProcessWizardPlugin.plugin().getProcess(processName);
        }
        ProcessWizardState wizardState = ProcessWizardState.getWizardState(pageContext.getSession()); 
        if ((process != null) && (wizardState != null)) {
            JspWriter out = pageContext.getOut();
            try {

                if ((getMode() != null) && getMode().equals("private")) {
                    writePrivate(out, process, wizardState);
                    ProcessWizardState.removeWizardState(pageContext.getSession());
                } else {
                    writePublic(out, process, wizardState);
                }
            } catch (Exception ignored) {
            }
        }
        return EVAL_PAGE;
    }

    private void writePrivate(JspWriter out, ProcessWizard process, ProcessWizardState wizardState) throws IOException {
        out.println("  <div class=\"overflow\">");
        out.println("    <table class=\"table_type3\">");

        String trClass = null;
        for (int i = 0; i < wizardState.sizeOfStageArray(); i++) {
            StageType stage = process.getWizardStage(wizardState.getStageArray(i));
            
            if (trClass == null)
                trClass = " class=\"tr_first\"";
            
            else if (i == wizardState.sizeOfStageArray() - 1)
                trClass = " class=\"tr_last\"";
            
            else
                trClass = "";
            
            out.println("      <tr" + trClass + ">");
            out.println("        <td class=\"td td1\"><p class=\"paragraph\"><span class=\"custom_color\"></span>" + stage.getCaption() + "</p></td>");
            out.println("        <td class=\"td td2\"><p class=\"paragraph\">" + stage.getInfo() + "</p></td>");
            out.println("      </tr>");
        }
        out.println("    </table>");
        out.println("  </div>");
    }
    
    private void writePublic(JspWriter out, ProcessWizard process, ProcessWizardState wizardState) throws IOException {
        out.println("<ul class=\"list_inscription_steps\">");
        
        for (int i = 0; i < wizardState.sizeOfStageArray() - 1; i++) {
            StageType stage = process.getWizardStage(wizardState.getStageArray(i));
            out.println("  <li class=\"row\">");
            out.println("    <p class=\"label\"><span class=\"picto_step\"></span>" + stage.getCaption() + "</p>");
            out.println("    <p class=\"paragraph\">" + stage.getInfo() + "</p>");
            out.println("  </li>");
        }
        StageType stage = process.getWizardStage(wizardState.getStageArray(wizardState.sizeOfStageArray()-1));
        out.println("  <li class=\"last_row\">");
        out.println("    <p class=\"label\"><span class=\"picto_step\"></span>" + stage.getCaption() + "</p>");
        out.println("    <p class=\"paragraph\">" + stage.getInfo() + "</p>");
        out.println("  </li>");
        out.println("</ul>");
    }
    
    public ProcessType getProcess() {
        return xmlbProcess;
    }

    public void setProcess(ProcessType xmlbProcess) {
        this.xmlbProcess = xmlbProcess;
    }

}
