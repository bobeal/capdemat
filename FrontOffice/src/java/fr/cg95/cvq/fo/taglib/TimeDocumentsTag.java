package fr.cg95.cvq.fo.taglib;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import fr.cg95.cvq.fo.business.RequestManager;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.DocumentForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.wizard.IProcessWizard;

public class TimeDocumentsTag extends BaseTag {

    private String mode = null;
    
    public TimeDocumentsTag() {
        super();
    }

    public int doEndTag() throws JspException {
        
        String processName = (String)pageContext.getSession().getAttribute(IProcessWizard.PROCESS_NAME);
        if (processName != null) {
            JspWriter out = pageContext.getOut();
            try {
                RequestManager requestManager = SessionManager.getRequestManager(pageContext.getSession());
                String time = requestManager.getTime(processName);
                String documents = getRequestDocuments();
                
                if ((getMode() != null) && getMode().equals("private")) {
                    writePrivate(out, time, documents);
                    
                } else {
                    writePublic(out, time, documents);
                }

            } catch (Exception ignored) {
            }
        }
        return EVAL_PAGE;
    }

    private void writePrivate(JspWriter out, String time, String documents) throws IOException {
        out.println("<ul class=\"list_type12\">");
        out.println("  <li class=\"item clock\">");
        out.println("    <p class=\"paragraph\">DUREE DE LA DEMARCHE : <strong>" + time + " MINUTES</strong></p>");
        out.println("  </li>");
        if (documents != null) {
            out.println("  <li class=\"item document\">");
            out.println("    <p class=\"paragraph\">DOCUMENTS A FOURNIR :<br /> <strong>" + documents + "</strong></p>");
            out.println("  </li>");
        }
        out.println("</ul>");
        
    }
    
    private void writePublic(JspWriter out, String time, String documents) throws IOException {
        out.println("<ul class=\"list_inline\">");
        out.println("  <li class=\"time_row\">");
        out.println("    <p class=\"paragraph\">DUREE DE LA DEMARCHE : <strong>" + time + " minutes</strong></p>");
        out.println("  </li>");

        if (documents != null) {
            out.println("  <li class=\"document_row\">");
            out.println("    <p class=\"paragraph\">DOCUMENTS A FOURNIR : <strong>" + documents + "</strong></p>");
            out.println("  </li>");
        }
        
        out.println("</ul>");
    }
    
    private String getRequestDocuments() {
        String documents = null;
        Request cvqRequest = (Request)pageContext.getSession().getAttribute(Request.class.getName());
        if (cvqRequest != null && cvqRequest.getHasDocumentsToScan()) {
            documents = "";
            Iterator iter = cvqRequest.getDocuments().iterator();
            while (iter.hasNext()) {
                DocumentForm document = (DocumentForm)iter.next();
                documents += document.getType() + ", ";
            }
            documents = documents.substring(0,documents.length() - 2);
        }
        return documents;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
    
}
