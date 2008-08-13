package fr.cg95.cvq.bo.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.dispatcher.StartupServlet;
import fr.cg95.cvq.bo.record.PaperRecord;

public class DocumentThumbnailsTag extends BaseTag {

    private String property;
    private String scope;

    public int doEndTag() {
        try {
            setWindowIndex();
            
            JspWriter out = pageContext.getOut();

            PaperRecord record = (PaperRecord) RequestUtils.lookup(pageContext, name, property, getScope());

            if (record != null) {
                // Load document data on demand
                HttpSession session = pageContext.getSession();
                
                // Load document data on demand
                if (record.getDataFile() == null)
                    BusinessManager.getDocumentData(session, record);

                out.println("<div class=\"imagearea\">");

                String zoom = "";
                
                for (int page = 0; page < record.getNbPages(); page++) {
                    out.println(
                        "<div class=\"image\" " 
                            + "onclick=\"document.location.href='"
                            + zoom
                            + (page+1)
                            + "'\""
                            + ">");

                    out.println(
                        "<img src=\""
                            + StartupServlet.getFileContextName(
                                (HttpServletRequest) pageContext.getRequest(),
                                record.getDataFile(page))
                            + "\" alt=\"Page "
                            + (page+1)
                            + "\""
                            + "width=\"140\" height=\"195\">");
                    out.println("</div>");
                }
                out.println("</div>");
            }

        } catch (Exception ignored) {
            ignored.getMessage();
        }
        return EVAL_PAGE;
    }

    public String getProperty() {
        return property;
    }

    public String getScope() {
        if (scope == null)
            scope = "session";

        return scope;
    }

    public void setProperty(String string) {
        property = string;
    }

    public void setScope(String string) {
        scope = string;
    }

}
