package fr.cg95.cvq.wizard.tag.cvqforms;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import fr.cg95.cvq.wizard.ReservationNode;

public class TicketTag extends CvqFormTag {

    private String repository = null;
    
    public int doEndTag() throws JspException {
        
        if (!writeTag("ticket","end",this)) {
            if (display()) try {
                JspWriter out = pageContext.getOut();
    
                if ((getMode() == null) || !getMode().equalsIgnoreCase("static")) {
                    out.println("<div id=\"" + getName() + "\">&nbsp;</div>");
                    out.println("<script language=\"JavaScript\">");
                    out.println("    initXmlReservation('placeReservationAction.do?repository=" + getRepository() + "', '" + getName() + "');");
                    out.println("</script>");
                } else {
                    displayStaticTickets(out);
                }
            } catch (Exception ignored) {
            }
        }
        return EVAL_PAGE;
    }

    private void displayStaticTickets(JspWriter out) throws IOException {
        ReservationNode reservations = (ReservationNode)pageContext.getSession().getAttribute(getRepository());
        if (reservations != null) {
            for (int i = 0; i < reservations.getChildren().size(); i++) {
                ReservationNode reservation = (ReservationNode)reservations.getChildren().get(i);
                if (reservation.getAllReserved() > 0) {
                    out.println("<div class=\"reservation\" >");
                    out.println("  <div class=\"reservation-header\" >");
                    out.println("    <div class=\"title\" >");
                    out.println("      " + reservation.getText());         
                    out.println("    </div>");
                    out.println("    <div class=\"available\" >");
                    out.println("      " + reservation.getDate());         
                    out.println("    </div>");
                    out.println("  </div>");
                    out.println("  <div class=\"detail\" >");
                    
                    for (int j = 0; j < reservation.getChildren().size(); j++) {
                        ReservationNode place = (ReservationNode)reservation.getChildren().get(j);
                        out.println("    <div class=\"detail-field\" >");
                        out.println("      <label>");
                        out.println("        " + place.getText() + ": "); 
                        out.println("      </label>");
                        out.println("      <div class=\"reserved\" >");
                        out.println("        " + reservedPlaces(place) + " à");
                        out.println("      </div>");
                        out.println("      <div class=\"price\" >");
                        out.println("        " + place.getPrice() + " &euro;");
                        out.println("      </div>");
                        out.println("      <div class=\"field\" >");
                        out.println("        " + place.getTotalPrice() + " &euro;");
                        out.println("      </div>");
                        out.println("    </div>");
                    }
                    out.println("  </div>");
                    out.println("</div>");
                }
            }
            out.println("<div class=\"header\" >");
            out.println("   Total de votre commande: " + reservations.getTotalPrice() + " &euro;"); 
            out.println("</div>");
        }
    }

    public String reservedPlaces(ReservationNode place) {
        if (place.getReserved() == 1)
            return "1 place";
        
        return place.getReserved() + " places";
    }

    public ReservationNode getReservations() {
        return (ReservationNode)pageContext.getSession().getAttribute(getRepository());
    }
    
    public String getRepository() {
        if (repository != null)
            return repository;
        
        return "";
    }

    public void setRepository(String data) {
        this.repository = data;
    }

}
