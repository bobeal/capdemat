
package fr.cg95.cvq.business.request.urbanism;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import fr.cg95.cvq.xml.request.urbanism.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class SewerConnectionRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = SewerConnectionRequestData.conditions;

    @AssertValid(message = "")
    private SewerConnectionRequestData sewerConnectionRequestData;

    public SewerConnectionRequest(RequestData requestData, SewerConnectionRequestData sewerConnectionRequestData) {
        super(requestData);
        this.sewerConnectionRequestData = sewerConnectionRequestData;
    }

    public SewerConnectionRequest() {
        super();
        this.sewerConnectionRequestData = new SewerConnectionRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public SewerConnectionRequestData getSpecificData() {
        return sewerConnectionRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(SewerConnectionRequestData sewerConnectionRequestData) {
        this.sewerConnectionRequestData = sewerConnectionRequestData;
    }

    @Override
    public final String modelToXmlString() {
        SewerConnectionRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final SewerConnectionRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        SewerConnectionRequestDocument sewerConnectionRequestDoc = SewerConnectionRequestDocument.Factory.newInstance();
        SewerConnectionRequestDocument.SewerConnectionRequest sewerConnectionRequest = sewerConnectionRequestDoc.addNewSewerConnectionRequest();
        super.fillCommonXmlInfo(sewerConnectionRequest);
        int i = 0;
        
        sewerConnectionRequest.setLocality(getLocality());
      
        if (getMoreThanTwoYears() != null)
            sewerConnectionRequest.setMoreThanTwoYears(getMoreThanTwoYears().booleanValue());
      
        if (getNumber() != null)
            sewerConnectionRequest.setNumber(new BigInteger(getNumber().toString()));
      
        if (getOwnerAddress() != null)
            sewerConnectionRequest.setOwnerAddress(Address.modelToXml(getOwnerAddress()));
      
        sewerConnectionRequest.setOwnerFirstNames(getOwnerFirstNames());
      
        sewerConnectionRequest.setOwnerLastName(getOwnerLastName());
      
        if (getRequesterQuality() != null)
            sewerConnectionRequest.setRequesterQuality(fr.cg95.cvq.xml.request.urbanism.ScrRequesterQualityType.Enum.forString(getRequesterQuality().toString()));
      
        sewerConnectionRequest.setSection(getSection());
      
        sewerConnectionRequest.setTransportationRoute(getTransportationRoute());
      
        return sewerConnectionRequestDoc;
    }

    @Override
    public final SewerConnectionRequestDocument.SewerConnectionRequest modelToXmlRequest() {
        return modelToXml().getSewerConnectionRequest();
    }

    public static SewerConnectionRequest xmlToModel(SewerConnectionRequestDocument sewerConnectionRequestDoc) {
        SewerConnectionRequestDocument.SewerConnectionRequest sewerConnectionRequestXml = sewerConnectionRequestDoc.getSewerConnectionRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        SewerConnectionRequest sewerConnectionRequest = new SewerConnectionRequest();
        sewerConnectionRequest.fillCommonModelInfo(sewerConnectionRequest, sewerConnectionRequestXml);
        
        sewerConnectionRequest.setLocality(sewerConnectionRequestXml.getLocality());
      
        sewerConnectionRequest.setMoreThanTwoYears(Boolean.valueOf(sewerConnectionRequestXml.getMoreThanTwoYears()));
      
        sewerConnectionRequest.setNumber(sewerConnectionRequestXml.getNumber());
      
        if (sewerConnectionRequestXml.getOwnerAddress() != null)
            sewerConnectionRequest.setOwnerAddress(Address.xmlToModel(sewerConnectionRequestXml.getOwnerAddress()));
      
        sewerConnectionRequest.setOwnerFirstNames(sewerConnectionRequestXml.getOwnerFirstNames());
      
        sewerConnectionRequest.setOwnerLastName(sewerConnectionRequestXml.getOwnerLastName());
      
        if (sewerConnectionRequestXml.getRequesterQuality() != null)
            sewerConnectionRequest.setRequesterQuality(fr.cg95.cvq.business.request.urbanism.ScrRequesterQualityType.forString(sewerConnectionRequestXml.getRequesterQuality().toString()));
        else
            sewerConnectionRequest.setRequesterQuality(fr.cg95.cvq.business.request.urbanism.ScrRequesterQualityType.getDefaultScrRequesterQualityType());
      
        sewerConnectionRequest.setSection(sewerConnectionRequestXml.getSection());
      
        sewerConnectionRequest.setTransportationRoute(sewerConnectionRequestXml.getTransportationRoute());
      
        return sewerConnectionRequest;
    }

  
    public final void setLocality(final String locality) {
        sewerConnectionRequestData.setLocality(locality);
    }

    
    public final String getLocality() {
        return sewerConnectionRequestData.getLocality();
    }
  
    public final void setMoreThanTwoYears(final Boolean moreThanTwoYears) {
        sewerConnectionRequestData.setMoreThanTwoYears(moreThanTwoYears);
    }

    
    public final Boolean getMoreThanTwoYears() {
        return sewerConnectionRequestData.getMoreThanTwoYears();
    }
  
    public final void setNumber(final java.math.BigInteger number) {
        sewerConnectionRequestData.setNumber(number);
    }

    
    public final java.math.BigInteger getNumber() {
        return sewerConnectionRequestData.getNumber();
    }
  
    public final void setOwnerAddress(final fr.cg95.cvq.business.users.Address ownerAddress) {
        sewerConnectionRequestData.setOwnerAddress(ownerAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getOwnerAddress() {
        return sewerConnectionRequestData.getOwnerAddress();
    }
  
    public final void setOwnerFirstNames(final String ownerFirstNames) {
        sewerConnectionRequestData.setOwnerFirstNames(ownerFirstNames);
    }

    
    public final String getOwnerFirstNames() {
        return sewerConnectionRequestData.getOwnerFirstNames();
    }
  
    public final void setOwnerLastName(final String ownerLastName) {
        sewerConnectionRequestData.setOwnerLastName(ownerLastName);
    }

    
    public final String getOwnerLastName() {
        return sewerConnectionRequestData.getOwnerLastName();
    }
  
    public final void setRequesterQuality(final fr.cg95.cvq.business.request.urbanism.ScrRequesterQualityType requesterQuality) {
        sewerConnectionRequestData.setRequesterQuality(requesterQuality);
    }

    
    public final fr.cg95.cvq.business.request.urbanism.ScrRequesterQualityType getRequesterQuality() {
        return sewerConnectionRequestData.getRequesterQuality();
    }
  
    public final void setSection(final String section) {
        sewerConnectionRequestData.setSection(section);
    }

    
    public final String getSection() {
        return sewerConnectionRequestData.getSection();
    }
  
    public final void setTransportationRoute(final String transportationRoute) {
        sewerConnectionRequestData.setTransportationRoute(transportationRoute);
    }

    
    public final String getTransportationRoute() {
        return sewerConnectionRequestData.getTransportationRoute();
    }
  
}
