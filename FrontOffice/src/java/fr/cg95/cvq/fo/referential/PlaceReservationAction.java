package fr.cg95.cvq.fo.referential;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import fr.cg95.cvq.business.authority.PlaceReservationType;
import fr.cg95.cvq.business.authority.PlaceReservationType.TicketSelection;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.service.authority.IPlaceReservationService;
import fr.cg95.cvq.wizard.ReservationNode;

public class PlaceReservationAction extends Action {
    
    public static final String MAX_SUBSCRIBER_PLACES = "max.subscriber.places";
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String repository = request.getParameter("repository");
        Map<String, Integer> authorizedPlaces = (Map<String, Integer>)request.getSession().getAttribute(MAX_SUBSCRIBER_PLACES);
        
        ReservationNode reservations = getReservations(repository, authorizedPlaces != null, request.getSession());
        if (request.getParameter("load") != null) {
            response.setContentType("text/xml; charset=UTF-8");
            loadReservations(reservations, authorizedPlaces, response.getOutputStream());
            response.setStatus(200);

        } else if (request.getParameter("savexml") != null) { 
            int status = updateRemainingPlaces(repository, reservations, request.getInputStream(), response.getOutputStream());
            response.setContentType("text/xml; charset=UTF-8");
            response.setStatus(status);

        } else {
            response.setStatus(200);
        }

        return null;
    }

    private ReservationNode getReservations(String data, boolean forSubscriber, HttpSession session) {
        
        ReservationNode reservations = (ReservationNode)session.getAttribute(data);
        if (reservations == null) {
            ArrayList reservationTypes = new ArrayList(BusinessManager.getReservationData(data, forSubscriber));
            Collections.sort(reservationTypes, new ReservationComparator());
            
            reservations = new ReservationNode();
            Iterator iter = reservationTypes.iterator();
            while (iter.hasNext()) {
               PlaceReservationType place = (PlaceReservationType)iter.next();
               
               ReservationNode reservation = reservations.addDetail(
                                                               place.getKey(),
                                                               place.getLabelsMap().get("fr").toString(),
                                                               place.getMessage(),
                                                               place.getEventDate(),
                                                               place.getRemainingPlaces());
               
               try { //if (place.getTicketsSelection() != null) {
                   Iterator tickets = place.getTicketsSelection().iterator();
                   while (tickets.hasNext()) {
                       TicketSelection ticket = (TicketSelection)tickets.next();
                       ReservationNode price = reservation.addDetail(  ticket.getName(), 
                                                                       ticket.getLabelsMap().get("fr").toString(),
                                                                       ticket.getPrice());
                       price.setSubsrcriberPrice(ticket.isSubscriberPrice());
                       price.setFullPrice(ticket.getName().equals(IPlaceReservationService.FULL_PRICE_SUBSCRIBER));
                       price.setHalfPrice(ticket.getName().equals(IPlaceReservationService.REDUCED_PRICE_SUBSCRIBER));
                   }
               } catch (NullPointerException npe) {
                   npe.getMessage();
               }
            }
            session.setAttribute(data, reservations);
        }
        return reservations;
    }
    
    private void loadReservations(ReservationNode reservations, Map<String, Integer> authorizedPlaces, ServletOutputStream out) throws IOException {
        out.print("<reservations type=\"ticket\"");
        if (authorizedPlaces != null) {
            for (String key : authorizedPlaces.keySet()) {
                Integer maxPlaces = authorizedPlaces.get(key);
                if (key.equals(IPlaceReservationService.FULL_PRICE_SUBSCRIBER))
                    out.print(" maxFullPlaces=\"" + maxPlaces + "\"");
                else if (key.equals(IPlaceReservationService.REDUCED_PRICE_SUBSCRIBER))
                    out.print(" maxHalfPlaces=\"" + maxPlaces + "\"");
            }
        }
        out.print(">");
        
        out.print(reservations.write(null));
        out.print("</reservations>");
    }

    private int updateRemainingPlaces(String data, ReservationNode reservations, 
                                        ServletInputStream input, ServletOutputStream output) throws IOException {
        Document xmlDocument = parseXmlStream(input);
        
        Node xmlNode = xmlDocument.getFirstChild();
        String key = xmlNode.getAttributes().getNamedItem("key").getNodeValue();
        ReservationNode reservation = reservations.getDetail(key);

        xmlNode = xmlNode.getFirstChild();
        while (xmlNode != null) {
            if (xmlNode.getNodeName().equals("data")) {
                key = xmlNode.getAttributes().getNamedItem("key").getNodeValue();
                ReservationNode tarif = reservation.getDetail(key);  
                String reserved = xmlNode.getAttributes().getNamedItem("reserved").getNodeValue();
                try {
                    tarif.setReserved(Integer.parseInt(reserved));
                } catch (Exception e) {
                }
            }
            xmlNode = xmlNode.getNextSibling();
        }
        
        int deltaReserved = reservation.getAllReserved() - reservation.getLastReserved();
        
        Integer remaining = BusinessManager.updateReservationData(data, reservation.getKey(), deltaReserved);
        reservation.setLastReserved(reservation.getAllReserved());
        
        if (remaining != null) {

            if (reservation != null) {
                int diff = reservation.getRemaining() - remaining.intValue(); 
                if (diff != 0) {
                    reservation.setAvailable(reservation.getAvailable() - diff);
                    String buffer = "<results>";
                    buffer += "<data key=\"" + reservation.getKey() + "\" available=\"" + reservation.getAvailable() + "\" />";
                    buffer += "</results>";
                    output.print(buffer);
                }
            
                return 200;
            }
        }
        return 500;
    }
    
    private Document parseXmlStream(InputStream is) {
        Document document = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(is);

        } catch (SAXParseException spe) {
            // Error generated by the parser
            System.out.println("\n** Parsing error" + ", line " + spe.getLineNumber() + ", uri " + spe.getSystemId());
            System.out.println("   " + spe.getMessage());

            // Use the contained exception, if any
            Exception x = spe;
            if (spe.getException() != null)
                x = spe.getException();
            x.printStackTrace();

        } catch (SAXException sxe) {
            // Error generated during parsing)
            Exception x = sxe;
            if (sxe.getException() != null)
                x = sxe.getException();
            x.printStackTrace();

        } catch (ParserConfigurationException pce) {
            // Parser with specified options can't be built
            pce.printStackTrace();

        } catch (IOException ioe) {
            // I/O error
            ioe.printStackTrace();
        }
        return document;
    }

}

class ReservationComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        PlaceReservationType place1 = (PlaceReservationType)o1;
        PlaceReservationType place2 = (PlaceReservationType)o2;
        
        if (place1 != null) {
            if (place2 == null) {
                // place2 is null so place1 is after place2
                return 1;
            }
            return place1.getEventDate().compareTo(place2.getEventDate());
            
        } if (place2 != null) {
            // place1 is null so place1 is before place2
            return -1;
        }
        return 0;
    }
    
}