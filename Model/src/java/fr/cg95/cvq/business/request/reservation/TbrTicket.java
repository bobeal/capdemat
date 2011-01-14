
package fr.cg95.cvq.business.request.reservation;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.joda.time.LocalTime;

import net.sf.oval.constraint.*;
import org.apache.xmlbeans.XmlOptions;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.reservation.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="tbr_ticket"
 *  lazy="false"
 */
public class TbrTicket implements Serializable {

    private static final long serialVersionUID = 1L;

    public TbrTicket() {
        super();
      
    }

    public final String modelToXmlString() {
        TbrTicketType object = (TbrTicketType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final TbrTicketType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LocalTime localTime = new LocalTime();
        TbrTicketType tbrTicket = TbrTicketType.Factory.newInstance();
        int i = 0;
    
        tbrTicket.setEventName(this.eventName);
      
        tbrTicket.setEventPlace(this.eventPlace);
      
        if (this.placeCategoryId != null)
            tbrTicket.setPlaceCategoryId(this.placeCategoryId.longValue());
      
        if (this.placeNumber != null)
            tbrTicket.setPlaceNumber(new BigInteger(this.placeNumber.toString()));
      
        if (this.price != null)
            tbrTicket.setPrice(this.price);
      
        tbrTicket.setFareType(this.fareType);
      
        tbrTicket.setPlaceCategory(this.placeCategory);
      
        date = this.eventDate;
        if (date != null) {
            calendar.setTime(date);
            tbrTicket.setEventDate(calendar);
        }
      
        return tbrTicket;
    }

    public static TbrTicket xmlToModel(TbrTicketType tbrTicketDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        TbrTicket tbrTicket = new TbrTicket();
    
        tbrTicket.setEventName(tbrTicketDoc.getEventName());
      
        tbrTicket.setEventPlace(tbrTicketDoc.getEventPlace());
      
        if (tbrTicketDoc.getPlaceCategoryId() != 0)
            tbrTicket.setPlaceCategoryId(new Long(tbrTicketDoc.getPlaceCategoryId()));
      
        tbrTicket.setPlaceNumber(tbrTicketDoc.getPlaceNumber());
      
        if (tbrTicketDoc.getPrice() != null)
            tbrTicket.setPrice(tbrTicketDoc.getPrice());
      
        tbrTicket.setFareType(tbrTicketDoc.getFareType());
      
        tbrTicket.setPlaceCategory(tbrTicketDoc.getPlaceCategory());
      
        calendar = tbrTicketDoc.getEventDate();
        if (calendar != null) {
            tbrTicket.setEventDate(calendar.getTime());
        }
      
        return tbrTicket;
    }

    @Override
    public TbrTicket clone() {
        TbrTicket result = new TbrTicket();
        
          
            
        result.setEventName(eventName);
      
          
        
          
            
        result.setEventPlace(eventPlace);
      
          
        
          
            
        result.setPlaceCategoryId(placeCategoryId);
      
          
        
          
            
        result.setPlaceNumber(placeNumber);
      
          
        
          
            
        result.setPrice(price);
      
          
        
          
            
        result.setFareType(fareType);
      
          
        
          
            
        result.setPlaceCategory(placeCategory);
      
          
        
          
            
        result.setEventDate(eventDate);
      
          
        
        return result;
    }

    private Long id;

    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * @hibernate.id
     *  column="id"
     *  generator-class="sequence"
     */
    public final Long getId() {
        return this.id;
    }

  
    
    private String eventName;

    public final void setEventName(final String eventName) {
        this.eventName = eventName;
    }

    /**
  
        * @hibernate.property
        *  column="event_name"
        
      
    */
    public final String getEventName() {
        return this.eventName;
    }
  
    
    private String eventPlace;

    public final void setEventPlace(final String eventPlace) {
        this.eventPlace = eventPlace;
    }

    /**
  
        * @hibernate.property
        *  column="event_place"
        
      
    */
    public final String getEventPlace() {
        return this.eventPlace;
    }
  
    
    private Long placeCategoryId;

    public final void setPlaceCategoryId(final Long placeCategoryId) {
        this.placeCategoryId = placeCategoryId;
    }

    /**
  
        * @hibernate.property
        *  column="place_category_id"
        
      
    */
    public final Long getPlaceCategoryId() {
        return this.placeCategoryId;
    }
  
    
      @NotNull(
        
        
        profiles = {"entertainments"},
        message = "placeNumber"
      )
    
    private java.math.BigInteger placeNumber;

    public final void setPlaceNumber(final java.math.BigInteger placeNumber) {
        this.placeNumber = placeNumber;
    }

    /**
  
        * @hibernate.property
        *  column="place_number"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getPlaceNumber() {
        return this.placeNumber;
    }
  
    
      @NotNull(
        
        
        profiles = {"entertainments"},
        message = "price"
      )
    
    private java.math.BigDecimal price;

    public final void setPrice(final java.math.BigDecimal price) {
        this.price = price;
    }

    /**
  
        * @hibernate.property
        *  column="price"
        
      
    */
    public final java.math.BigDecimal getPrice() {
        return this.price;
    }
  
    
    private String fareType;

    public final void setFareType(final String fareType) {
        this.fareType = fareType;
    }

    /**
  
        * @hibernate.property
        *  column="fare_type"
        
      
    */
    public final String getFareType() {
        return this.fareType;
    }
  
    
    private String placeCategory;

    public final void setPlaceCategory(final String placeCategory) {
        this.placeCategory = placeCategory;
    }

    /**
  
        * @hibernate.property
        *  column="place_category"
        
      
    */
    public final String getPlaceCategory() {
        return this.placeCategory;
    }
  
    
    private java.util.Date eventDate;

    public final void setEventDate(final java.util.Date eventDate) {
        this.eventDate = eventDate;
    }

    /**
  
        * @hibernate.property
        *  column="event_date"
        
      
    */
    public final java.util.Date getEventDate() {
        return this.eventDate;
    }
  
}
