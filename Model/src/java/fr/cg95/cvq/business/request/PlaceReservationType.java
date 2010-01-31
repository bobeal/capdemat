package fr.cg95.cvq.business.request;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Domain object for place reservation referential data.
 * 
 * @author bor@zenexity.fr
 */
public class PlaceReservationType {

    private String key;
    private Integer quota;
    private Date eventDate;
    private Integer remainingPlaces;
    /** a map of (ticket name, TicketSelection) */
    private Map availableTicketSelection;
    private Date reservationStartDate;
    private Date reservationEndDate;
    private String message;
    private Map labelsMap;
    
    public Collection getTicketsSelection() {
        if (availableTicketSelection != null)
            return availableTicketSelection.values();
        else
            return null;
    }
    
    public void addTicketSelection(TicketSelection ticketSelection) {
        if (this.availableTicketSelection == null)
            this.availableTicketSelection = new HashMap();
        this.availableTicketSelection.put(ticketSelection.getName(), ticketSelection);
    }
    
    public void removeTicketSelection(final String name) {
        if (this.availableTicketSelection == null)
            return;
        
        this.availableTicketSelection.remove(name);
    }
    
    public TicketSelection getTicketSelection(final String name) {
        if (this.availableTicketSelection == null)
            return null;
        
        return (TicketSelection) availableTicketSelection.get(name);
    }
    
    public Date getEventDate() {
        return eventDate;
    }
    
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
    
    public String getKey() {
        return key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public Integer getQuota() {
        return quota;
    }
    
    public void setQuota(Integer quota) {
        this.quota = quota;
    }
    
    public Integer getRemainingPlaces() {
        return remainingPlaces;
    }
    
    public void setRemainingPlaces(Integer remainingPlaces) {
        this.remainingPlaces = remainingPlaces;
    }

    public Date getReservationEndDate() {
        return reservationEndDate;
    }

    public void setReservationEndDate(Date reservationEndDate) {
        this.reservationEndDate = reservationEndDate;
    }

    public Date getReservationStartDate() {
        return reservationStartDate;
    }

    public void setReservationStartDate(Date reservationStartDate) {
        this.reservationStartDate = reservationStartDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public final Map getLabelsMap() {
        return labelsMap;
    }

    public final void setLabelsMap(Map labelsMap) {
        this.labelsMap = labelsMap;
    }

    public final void addLabel(final String lang, final String value) {
        if (labelsMap == null)
            labelsMap = new LinkedHashMap();
        labelsMap.put(lang, value);
    }

    public class TicketSelection {
        private String name;
        private Float price;
        private Map labelsMap;
        private boolean isSubscriberPrice;
        
        public TicketSelection(final String name, final Float price) {
            this.name = name;
            this.price = price;
            this.isSubscriberPrice = false;
        }

        public String getName() {
            return name;
        }

        public Float getPrice() {
            return price;
        }

        public void setName(final String name) {
            this.name = name;
        }
        
        public void setPrice(final Float price) {
            this.price = price;
        }
        
        public boolean isSubscriberPrice() {
            return isSubscriberPrice;
        }

        public void setIsSubscriberPrice(boolean isSubscriberPrice) {
            this.isSubscriberPrice = isSubscriberPrice;
        }

        public final Map getLabelsMap() {
            return labelsMap;
        }

        public final void setLabelsMap(Map labelsMap) {
            this.labelsMap = labelsMap;
        }

        public final void addLabel(final String lang, final String value) {
            if (labelsMap == null)
                labelsMap = new LinkedHashMap();
            labelsMap.put(lang, value);
        }
    }
}
