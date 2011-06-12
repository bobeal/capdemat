
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
import org.joda.time.LocalTime;

import net.sf.oval.constraint.AssertValid;
import org.apache.xmlbeans.XmlOptions;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.request.annotation.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.reservation.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class TicketBookingRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = TicketBookingRequestData.conditions;

    @AssertValid(message = "")
    private TicketBookingRequestData ticketBookingRequestData;

    public TicketBookingRequest(RequestData requestData, TicketBookingRequestData ticketBookingRequestData) {
        super(requestData);
        this.ticketBookingRequestData = ticketBookingRequestData;
    }

    public TicketBookingRequest() {
        super();
        this.ticketBookingRequestData = new TicketBookingRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("entertainments", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("rules", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("validation", stepState);
        
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public TicketBookingRequestData getSpecificData() {
        return ticketBookingRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(TicketBookingRequestData ticketBookingRequestData) {
        this.ticketBookingRequestData = ticketBookingRequestData;
    }

    @Override
    public final String modelToXmlString() {
        TicketBookingRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final TicketBookingRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        TicketBookingRequestDocument ticketBookingRequestDoc = TicketBookingRequestDocument.Factory.newInstance();
        TicketBookingRequestDocument.TicketBookingRequest ticketBookingRequest = ticketBookingRequestDoc.addNewTicketBookingRequest();
        super.fillCommonXmlInfo(ticketBookingRequest);
        int i = 0;
        
        if (getRulesAndRegulationsAcceptance() != null)
            ticketBookingRequest.setRulesAndRegulationsAcceptance(getRulesAndRegulationsAcceptance().booleanValue());
      
        ticketBookingRequest.setSubscriberLastName(getSubscriberLastName());
      
        i = 0;
        if (getTbrTicket() != null) {
            fr.cg95.cvq.xml.request.reservation.TbrTicketType[] tbrTicketTypeTab = new fr.cg95.cvq.xml.request.reservation.TbrTicketType[getTbrTicket().size()];
            for (TbrTicket object : getTbrTicket()) {
              tbrTicketTypeTab[i++] = object.modelToXml();
            }
            ticketBookingRequest.setTbrTicketArray(tbrTicketTypeTab);
        }
      
        if (getTotalPrice() != null)
            ticketBookingRequest.setTotalPrice(getTotalPrice());
      
        ticketBookingRequest.setSubscriberNumber(getSubscriberNumber());
      
        ticketBookingRequest.setSubscriberFirstName(getSubscriberFirstName());
      
        if (getIsSubscriber() != null)
            ticketBookingRequest.setIsSubscriber(getIsSubscriber().booleanValue());
      
        ticketBookingRequest.setPaymentReference(getPaymentReference());
      
        return ticketBookingRequestDoc;
    }

    @Override
    public final TicketBookingRequestDocument.TicketBookingRequest modelToXmlRequest() {
        return modelToXml().getTicketBookingRequest();
    }

    public static TicketBookingRequest xmlToModel(TicketBookingRequestDocument ticketBookingRequestDoc) {
        TicketBookingRequestDocument.TicketBookingRequest ticketBookingRequestXml = ticketBookingRequestDoc.getTicketBookingRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        TicketBookingRequest ticketBookingRequest = new TicketBookingRequest();
        ticketBookingRequest.fillCommonModelInfo(ticketBookingRequest, ticketBookingRequestXml);
        
        ticketBookingRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(ticketBookingRequestXml.getRulesAndRegulationsAcceptance()));
      
        ticketBookingRequest.setSubscriberLastName(ticketBookingRequestXml.getSubscriberLastName());
      
        List<fr.cg95.cvq.business.request.reservation.TbrTicket> tbrTicketList = new ArrayList<fr.cg95.cvq.business.request.reservation.TbrTicket>(ticketBookingRequestXml.sizeOfTbrTicketArray());
        for (TbrTicketType object : ticketBookingRequestXml.getTbrTicketArray()) {
            tbrTicketList.add(fr.cg95.cvq.business.request.reservation.TbrTicket.xmlToModel(object));
        }
        ticketBookingRequest.setTbrTicket(tbrTicketList);
      
        if (ticketBookingRequestXml.getTotalPrice() != null)
            ticketBookingRequest.setTotalPrice(ticketBookingRequestXml.getTotalPrice());
      
        ticketBookingRequest.setSubscriberNumber(ticketBookingRequestXml.getSubscriberNumber());
      
        ticketBookingRequest.setSubscriberFirstName(ticketBookingRequestXml.getSubscriberFirstName());
      
        ticketBookingRequest.setIsSubscriber(Boolean.valueOf(ticketBookingRequestXml.getIsSubscriber()));
      
        ticketBookingRequest.setPaymentReference(ticketBookingRequestXml.getPaymentReference());
      
        return ticketBookingRequest;
    }

    @Override
    public TicketBookingRequest clone() {
        TicketBookingRequest clone = new TicketBookingRequest(getRequestData().clone(), ticketBookingRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("entertainments", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("rules", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("validation", stepState);
        
        return clone;
    }

  
    public final void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        ticketBookingRequestData.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
    }

    @IsRulesAcceptance
    public final Boolean getRulesAndRegulationsAcceptance() {
        return ticketBookingRequestData.getRulesAndRegulationsAcceptance();
    }
  
    public final void setSubscriberLastName(final String subscriberLastName) {
        ticketBookingRequestData.setSubscriberLastName(subscriberLastName);
    }

    
    public final String getSubscriberLastName() {
        return ticketBookingRequestData.getSubscriberLastName();
    }
  
    public final void setTbrTicket(final List<fr.cg95.cvq.business.request.reservation.TbrTicket> tbrTicket) {
        ticketBookingRequestData.setTbrTicket(tbrTicket);
    }

    
    public final List<fr.cg95.cvq.business.request.reservation.TbrTicket> getTbrTicket() {
        return ticketBookingRequestData.getTbrTicket();
    }
  
    public final void setTotalPrice(final java.math.BigDecimal totalPrice) {
        ticketBookingRequestData.setTotalPrice(totalPrice);
    }

    
    public final java.math.BigDecimal getTotalPrice() {
        return ticketBookingRequestData.getTotalPrice();
    }
  
    public final void setSubscriberNumber(final String subscriberNumber) {
        ticketBookingRequestData.setSubscriberNumber(subscriberNumber);
    }

    
    public final String getSubscriberNumber() {
        return ticketBookingRequestData.getSubscriberNumber();
    }
  
    public final void setSubscriberFirstName(final String subscriberFirstName) {
        ticketBookingRequestData.setSubscriberFirstName(subscriberFirstName);
    }

    
    public final String getSubscriberFirstName() {
        return ticketBookingRequestData.getSubscriberFirstName();
    }
  
    public final void setIsSubscriber(final Boolean isSubscriber) {
        ticketBookingRequestData.setIsSubscriber(isSubscriber);
    }

    
    public final Boolean getIsSubscriber() {
        return ticketBookingRequestData.getIsSubscriber();
    }
  
    public final void setPaymentReference(final String paymentReference) {
        ticketBookingRequestData.setPaymentReference(paymentReference);
    }

    
    public final String getPaymentReference() {
        return ticketBookingRequestData.getPaymentReference();
    }
  
}
