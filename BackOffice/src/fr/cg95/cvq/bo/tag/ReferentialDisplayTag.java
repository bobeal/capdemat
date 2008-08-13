package fr.cg95.cvq.bo.tag;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.business.authority.LocalReferentialEntry;
import fr.cg95.cvq.business.authority.LocalReferentialType;
import fr.cg95.cvq.business.authority.PlaceReservationType;
import fr.cg95.cvq.business.authority.PlaceReservationType.TicketSelection;

public class ReferentialDisplayTag extends BaseTag {
    private String height = null;
    
    public int doEndTag() {
        try {
            setWindowIndex();
            
            JspWriter out = pageContext.getOut();

            Collection parameters = null;
            
            if ((name.length() == 0) && (property.length() == 0))
                parameters = BusinessManager.getReferentialRequestData("All");
            else
                parameters = (Collection) RequestUtils.lookup(pageContext, name, property, getScope());
                
            if (parameters != null) {
                Iterator iter = parameters.iterator();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintWriter pw = new PrintWriter(baos);
                int nbLines = 0;
                while (iter.hasNext()) {
                    Object data = iter.next();
                    if (data instanceof LocalReferentialType) {
                        nbLines += displayReferential(pw,(LocalReferentialType)data);
                        
                    } else if (data instanceof PlaceReservationType) {
                        nbLines += displayPlaceReservation(pw,(PlaceReservationType)data);
                    }
                }
                pw.close();
                
                String style = "list003";
                
                if (getHeight() != null) {
                    if (nbLines > 15) {
                        style += " overflow002";
                    }
                }
                out.println("<ul class=\"" + style + "\">");
                out.print(baos.toString());
                out.println("</ul>");
            }
        } catch (Exception ignored) {
            ignored.getMessage();
        }
        return EVAL_PAGE;
    }
    
    private int displayReferential(PrintWriter out, LocalReferentialType data) throws IOException {
        int nbLines = 1;
        String elementStyle = (data.getEntries() != null) ? "full" : "empty";
        out.println("<li class=\"element element_" + elementStyle + "\"><span class=\"item\">" + data.getLabelsMap().get("fr") + "</span>");

        if (data.getEntries() != null) {
            nbLines++;
            out.println("<ul class=\"list\">");
            
            Iterator iter = data.getEntries().iterator();
            while (iter.hasNext())
                nbLines += displayReferentialEntry(out, (LocalReferentialEntry) iter.next());

            nbLines++;
            out.println("</ul></li>");
        }
        return nbLines;
    }
    
    private int displayReferentialEntry(PrintWriter out, LocalReferentialEntry entry) throws IOException {
        int nbLines = 1;
        String elementStyle = (entry.getEntries() != null) ? "full" : "empty";
        out.println("<li class=\"element element_" + elementStyle + "\"><span class=\"item\">" + entry.getLabelsMap().get("fr") + "</span>");
        if (entry.getEntries() != null) {
            nbLines++;
            out.println("<ul class=\"list\">");
            
            Iterator iter = entry.getEntries().iterator();
            while (iter.hasNext())
                nbLines += displayReferentialEntry(out, (LocalReferentialEntry) iter.next());

            nbLines++;
            out.println("</ul></li>");
        }
        return nbLines;
    }

    private int displayPlaceReservation(PrintWriter out, PlaceReservationType data) throws IOException {
        int nbLines = 1;
        String elementStyle = (data.getTicketsSelection() != null) ? "full" : "empty";
        out.println("<li class=\"element element_" + elementStyle + "\"><span class=\"item\">" + data.getLabelsMap().get("fr") + "</span>");

        if (data.getTicketsSelection() != null) {
            nbLines++;
            out.println("<ul class=\"list\">");
            
            Iterator iter = data.getTicketsSelection().iterator();
            while (iter.hasNext())
                nbLines += displayTicketSelection(out, (TicketSelection) iter.next());

            nbLines++;
            out.println("</ul></li>");
        }
        return nbLines;
    }

    private int displayTicketSelection(PrintWriter out, TicketSelection ticket) throws IOException {
        out.println("<li class=\"element element_empty\"><span class=\"item\">" + ticket.getLabelsMap().get("fr") + "</span></li>");
        return 1;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

}
