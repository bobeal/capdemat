
package fr.cg95.cvq.business.request.reservation;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.oval.constraint.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="ticket_booking_request"
 *  lazy="false"
 */
public class TicketBookingRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public TicketBookingRequestData() {
      
        rulesAndRegulationsAcceptance = Boolean.valueOf(true);
      
        isSubscriber = Boolean.valueOf(false);
      
    }

    @Override
    public TicketBookingRequestData clone() {
        TicketBookingRequestData result = new TicketBookingRequestData();
        
          
            
        result.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
      
          
        
          
            
        result.setSubscriberLastName(subscriberLastName);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.reservation.TbrTicket> tbrTicketList = new ArrayList<fr.cg95.cvq.business.request.reservation.TbrTicket>();
        for (TbrTicket object : tbrTicket) {
            tbrTicketList.add(object.clone());
        }
        result.setTbrTicket(tbrTicketList);
      
          
        
          
            
        result.setTotalPrice(totalPrice);
      
          
        
          
            
        result.setSubscriberNumber(subscriberNumber);
      
          
        
          
            
        result.setSubscriberFirstName(subscriberFirstName);
      
          
        
          
            
        result.setIsSubscriber(isSubscriber);
      
          
        
          
            
        result.setPaymentReference(paymentReference);
      
          
        
        return result;
    }

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

  
    
      @NotNull(
        
        
        profiles = {"rules"},
        message = "rulesAndRegulationsAcceptance"
      )
    
    private Boolean rulesAndRegulationsAcceptance;

    public final void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
    }

    /**
 
        * @hibernate.property
        *  column="rules_and_regulations_acceptance"
        
      
    */
    public final Boolean getRulesAndRegulationsAcceptance() {
        return this.rulesAndRegulationsAcceptance;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['isSubscriber'].test(_this.isSubscriber.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"entertainments"},
        message = "subscriberLastName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['isSubscriber'].test(_this.isSubscriber.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"entertainments"},
        message = "subscriberLastName"
      )
    
    private String subscriberLastName;

    public final void setSubscriberLastName(final String subscriberLastName) {
        this.subscriberLastName = subscriberLastName;
    }

    /**
 
        * @hibernate.property
        *  column="subscriber_last_name"
        
      
    */
    public final String getSubscriberLastName() {
        return this.subscriberLastName;
    }
  
    
      @AssertValid(
        
        
        profiles = {"entertainments"},
        message = "tbrTicket"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"entertainments"},
        message = "tbrTicket"
      )
    
    private List<fr.cg95.cvq.business.request.reservation.TbrTicket> tbrTicket;

    public final void setTbrTicket(final List<fr.cg95.cvq.business.request.reservation.TbrTicket> tbrTicket) {
        this.tbrTicket = tbrTicket;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="ticket_booking_request_id"
        * @hibernate.list-index
        *  column="tbr_ticket_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.reservation.TbrTicket"
      
    */
    public final List<fr.cg95.cvq.business.request.reservation.TbrTicket> getTbrTicket() {
        return this.tbrTicket;
    }
  
    
      @NotNull(
        
        
        profiles = {"entertainments"},
        message = "totalPrice"
      )
    
    private java.math.BigDecimal totalPrice;

    public final void setTotalPrice(final java.math.BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
 
        * @hibernate.property
        *  column="total_price"
        
      
    */
    public final java.math.BigDecimal getTotalPrice() {
        return this.totalPrice;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['isSubscriber'].test(_this.isSubscriber.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"entertainments"},
        message = "subscriberNumber"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['isSubscriber'].test(_this.isSubscriber.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"entertainments"},
        message = "subscriberNumber"
      )
    
    private String subscriberNumber;

    public final void setSubscriberNumber(final String subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }

    /**
 
        * @hibernate.property
        *  column="subscriber_number"
        
      
    */
    public final String getSubscriberNumber() {
        return this.subscriberNumber;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['isSubscriber'].test(_this.isSubscriber.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"entertainments"},
        message = "subscriberFirstName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['isSubscriber'].test(_this.isSubscriber.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"entertainments"},
        message = "subscriberFirstName"
      )
    
    private String subscriberFirstName;

    public final void setSubscriberFirstName(final String subscriberFirstName) {
        this.subscriberFirstName = subscriberFirstName;
    }

    /**
 
        * @hibernate.property
        *  column="subscriber_first_name"
        
      
    */
    public final String getSubscriberFirstName() {
        return this.subscriberFirstName;
    }
  
    
      @NotNull(
        
        
        profiles = {"entertainments"},
        message = "isSubscriber"
      )
    
    private Boolean isSubscriber;

    public final void setIsSubscriber(final Boolean isSubscriber) {
        this.isSubscriber = isSubscriber;
    }

    /**
 
        * @hibernate.property
        *  column="is_subscriber"
        
      
    */
    public final Boolean getIsSubscriber() {
        return this.isSubscriber;
    }
  
    
    private String paymentReference;

    public final void setPaymentReference(final String paymentReference) {
        this.paymentReference = paymentReference;
    }

    /**
 
        * @hibernate.property
        *  column="payment_reference"
        
      
    */
    public final String getPaymentReference() {
        return this.paymentReference;
    }
  
}
