package fr.cg95.cvq.bo.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.wizard.manager.ManagerWizardState;

public class WindowIndexFormTag extends BaseBodyTag {

    private String action = null;
    private String styleId = null;
    
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();

            out.print("<form name=\"" + getName() + "\" method=\"post\" " +
                            "action=\"" + RequestUtils.getActionMappingURL(getAction(), this.pageContext) + "\"");
            
            if (getStyleId() != null)
                out.print(" id=\"" + getStyleId() + "\"");
            
            if (getStyleClass() != null)
                out.print(" class=\"" + getStyleClass() + "\"");

            out.println(">");
            
        } catch (Exception ignored) {
        }
        return EVAL_BODY_INCLUDE;
    }

    public int doEndTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();

            out.println("</form>");

        } catch (Exception ignored) {
        }
        return EVAL_PAGE;
    }

    public String getAction() {
        if (action.indexOf('?') > 0)
            return action + "&" + ManagerWizardState.WIZARD_REQUEST_PARAMETER + "=" + getWindowIndex();

        return action + "?" + ManagerWizardState.WIZARD_REQUEST_PARAMETER + "=" + getWindowIndex();
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

}
