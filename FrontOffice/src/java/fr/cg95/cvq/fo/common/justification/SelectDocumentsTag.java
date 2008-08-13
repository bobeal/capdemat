package fr.cg95.cvq.fo.common.justification;

import java.util.Collection;

import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.fo.common.action.BaseAction;
import fr.cg95.cvq.fo.common.form.DocumentForm;
import fr.cg95.cvq.fo.taglib.BaseTag;

public class SelectDocumentsTag extends BaseTag {
    
    private String mode="";

    public int doEndTag() {
        try {
            JspWriter out = pageContext.getOut();

            BaseAction.setCurrentEcitizen(pageContext.getSession());
            Collection<DocumentForm> documents = null;
            try {
                documents = (Collection<DocumentForm>) RequestUtils.lookup(pageContext, name, property, getScope());
            } catch (Exception e) {
            }

            for (DocumentForm document : documents) {
                out.println("<li class=\"checkbox_row\">");
                String disabled = "";
                if (mode.equals("disabled") || document.isSupplied())
                    disabled = "disabled ";

                String checked = "";
                if (document.isSelected())
                    checked = "checked=\"checked\" ";

                out.println("  <input type=\"checkbox\" name=\"" + document.getTypeId() + "\" id=\"" + document.getTypeId() + "\" " + disabled + checked + "/>");
                out.println("  <label for=\"" + document.getTypeId() + "\" class=\"document\">" + document.getType() + "</label>");
                out.println("</li>");
                
            }
            
        } catch (Exception ignored) {
        }
        return EVAL_PAGE;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

}
