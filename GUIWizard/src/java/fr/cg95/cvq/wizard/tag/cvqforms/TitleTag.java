package fr.cg95.cvq.wizard.tag.cvqforms;

import javax.servlet.jsp.JspException;

import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.wizard.process.xmlbean.SelectType;
import fr.cg95.cvq.wizard.process.xmlbean.StageType;

public class TitleTag extends CvqFormTag {

    private String stage = null;
    
    public TitleTag() {
        super();
    }

    public int doEndTag() throws JspException {
        
        if (display()) try {
            writeTag("title", "end", this);
        } catch (Exception ignored) {
        }
        return EVAL_PAGE;
    }

    public String getCaption() {
        
        StageType stageType = getStageType();
        
        if (stageType != null)
            return stageType.getCaption();
        
        return null;
    }
    
    public String getStyle() {
        String style = "rule";

        StageType stageType = getStageType();
        
        if (stageType != null) {
            if (stageType.sizeOfSelectArray() > 0) {
                SelectType select = stageType.getSelectArray(0);
                for (int i = 0; i < select.sizeOfDisplayArray(); i++) {
                    if (select.getDisplayArray(i).isSetType() && 
                       ("people document".indexOf(select.getDisplayArray(i).getType()) != -1)) {
                        style = select.getDisplayArray(i).getType();
                    }
                }
            }
        }
        return style;
    }
    
    private StageType getStageType() {
        ProcessWizardState wizardState = ProcessWizardState.getWizardState(pageContext.getSession()); 
        
        for (int i = 0; i < wizardState.sizeOfStageArray(); i++) {
            StageType stageType = wizardState.getStageArray(i); 
            if (stageType.isSetName() && stageType.getName().equals(stage))
                return wizardState.getStageArray(i);
        }
        return null;
    }
    
    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

}
