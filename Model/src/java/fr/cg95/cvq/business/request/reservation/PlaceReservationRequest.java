
package fr.cg95.cvq.business.request.reservation;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
public class PlaceReservationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = PlaceReservationRequestData.conditions;

    @AssertValid(message = "")
    private PlaceReservationRequestData placeReservationRequestData;

    public PlaceReservationRequest(RequestData requestData, PlaceReservationRequestData placeReservationRequestData) {
        super(requestData);
        this.placeReservationRequestData = placeReservationRequestData;
    }

    public PlaceReservationRequest() {
        super();
        this.placeReservationRequestData = new PlaceReservationRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public PlaceReservationRequestData getSpecificData() {
        return placeReservationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(PlaceReservationRequestData placeReservationRequestData) {
        this.placeReservationRequestData = placeReservationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        PlaceReservationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final PlaceReservationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        PlaceReservationRequestDocument placeReservationRequestDoc = PlaceReservationRequestDocument.Factory.newInstance();
        PlaceReservationRequestDocument.PlaceReservationRequest placeReservationRequest = placeReservationRequestDoc.addNewPlaceReservationRequest();
        super.fillCommonXmlInfo(placeReservationRequest);
        int i = 0;
        
        placeReservationRequest.setSubscriberNumber(getSubscriberNumber());
      
        if (getIsSubscriber() != null)
            placeReservationRequest.setIsSubscriber(getIsSubscriber().booleanValue());
      
        i = 0;
        if (getPlaceReservation() != null) {
            fr.cg95.cvq.xml.common.PlaceReservationDataType[] placeReservationTypeTab = new fr.cg95.cvq.xml.common.PlaceReservationDataType[getPlaceReservation().size()];
            for (PlaceReservationData object : getPlaceReservation()) {
              placeReservationTypeTab[i++] = PlaceReservationData.modelToXml(object);
            }
            placeReservationRequest.setPlaceReservationArray(placeReservationTypeTab);
        }
      
        placeReservationRequest.setPaymentReference(getPaymentReference());
      
        return placeReservationRequestDoc;
    }

    @Override
    public final PlaceReservationRequestDocument.PlaceReservationRequest modelToXmlRequest() {
        return modelToXml().getPlaceReservationRequest();
    }

    public static PlaceReservationRequest xmlToModel(PlaceReservationRequestDocument placeReservationRequestDoc) {
        PlaceReservationRequestDocument.PlaceReservationRequest placeReservationRequestXml = placeReservationRequestDoc.getPlaceReservationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        PlaceReservationRequest placeReservationRequest = new PlaceReservationRequest();
        placeReservationRequest.fillCommonModelInfo(placeReservationRequest, placeReservationRequestXml);
        
        placeReservationRequest.setSubscriberNumber(placeReservationRequestXml.getSubscriberNumber());
      
        placeReservationRequest.setIsSubscriber(Boolean.valueOf(placeReservationRequestXml.getIsSubscriber()));
      
        List<fr.cg95.cvq.business.request.PlaceReservationData> placeReservationList = new ArrayList<fr.cg95.cvq.business.request.PlaceReservationData>(placeReservationRequestXml.sizeOfPlaceReservationArray());
        for (PlaceReservationDataType object : placeReservationRequestXml.getPlaceReservationArray()) {
            placeReservationList.add(fr.cg95.cvq.business.request.PlaceReservationData.xmlToModel(object));
        }
        placeReservationRequest.setPlaceReservation(placeReservationList);
      
        placeReservationRequest.setPaymentReference(placeReservationRequestXml.getPaymentReference());
      
        return placeReservationRequest;
    }

  
    public final void setSubscriberNumber(final String subscriberNumber) {
        placeReservationRequestData.setSubscriberNumber(subscriberNumber);
    }

    
    public final String getSubscriberNumber() {
        return placeReservationRequestData.getSubscriberNumber();
    }
  
    public final void setIsSubscriber(final Boolean isSubscriber) {
        placeReservationRequestData.setIsSubscriber(isSubscriber);
    }

    
    public final Boolean getIsSubscriber() {
        return placeReservationRequestData.getIsSubscriber();
    }
  
    public final void setPlaceReservation(final List<fr.cg95.cvq.business.request.PlaceReservationData> placeReservation) {
        placeReservationRequestData.setPlaceReservation(placeReservation);
    }

    
    public final List<fr.cg95.cvq.business.request.PlaceReservationData> getPlaceReservation() {
        return placeReservationRequestData.getPlaceReservation();
    }
  
    public final void setPaymentReference(final String paymentReference) {
        placeReservationRequestData.setPaymentReference(paymentReference);
    }

    
    public final String getPaymentReference() {
        return placeReservationRequestData.getPaymentReference();
    }
  
}
