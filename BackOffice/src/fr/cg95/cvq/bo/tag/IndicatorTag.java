package fr.cg95.cvq.bo.tag;

import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

public class IndicatorTag extends BaseTag {
    
    private String img = null;

    public int doEndTag() {
        try {
            setWindowIndex();
            
            JspWriter out = pageContext.getOut();

            Boolean indicator = null; 
            try {
                indicator = (Boolean)RequestUtils.lookup(pageContext, name, property, getScope());
            } catch (Exception e) {
            }
            if (indicator == null)
                indicator = new Boolean(false);

            if (indicator.booleanValue()) {
                out.print("<div class=\"block021\">");
                out.print("<img src=\"" + getImg() + "\"/>");
                out.println("</div>");
            }
        } catch (Exception ignored) {
        }
        return EVAL_PAGE;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
