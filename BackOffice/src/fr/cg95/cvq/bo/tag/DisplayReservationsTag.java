package fr.cg95.cvq.bo.tag;

import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.wizard.ReservationNode;

public class DisplayReservationsTag extends BaseTag {

    public int doEndTag() {
        try {
            setWindowIndex();
            
            JspWriter out = pageContext.getOut();

            ReservationNode reservations = (ReservationNode)RequestUtils.lookup(pageContext, name, property, getScope());

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
                            out.println("        " + place.getText() + ": " + reservedPlaces(place)); 
                            out.println("      </label>");
                            out.println("      <div class=\"price\" >");
                            out.println("        à " + place.getPrice() + " &euro;");
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
                out.println("   Total de la commande: " + reservations.getTotalPrice() + " &euro;"); 
                out.println("</div>");
            }
        } catch (Exception ignored) {
            ignored.getMessage();
        }
        return EVAL_PAGE;
    }

    private String reservedPlaces(ReservationNode place) {
        if (place.getReserved() == 1)
            return "1 place";
        
        return place.getReserved() + " places";
    }

}
