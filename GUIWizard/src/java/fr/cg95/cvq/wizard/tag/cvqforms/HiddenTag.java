package fr.cg95.cvq.wizard.tag.cvqforms;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class HiddenTag extends CvqFormTag {
    
    String property = null;

    public HiddenTag() {
        super();
    }

    public int doEndTag() throws JspException {

        if (display())
            try {
                JspWriter out = pageContext.getOut();

                out.print("<input type=\"hidden\" " +
                        "name=\"" + getName() + "\" " +
                        "id=\"" + getName() + "\" ");
                
                if (!getBooleanValue())
                    out.print("disabled ");
                
                out.println("value=\"" + getProperty() + "\"/>");

            } catch (Exception ignored) {
            }
        return EVAL_PAGE;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

}
