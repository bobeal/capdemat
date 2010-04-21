
package fr.cg95.cvq.business.request.urbanism;

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
import fr.cg95.cvq.xml.request.urbanism.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class AlignmentNumberingConnectionRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = AlignmentNumberingConnectionRequestData.conditions;

    @AssertValid(message = "")
    private AlignmentNumberingConnectionRequestData alignmentNumberingConnectionRequestData;

    public AlignmentNumberingConnectionRequest(RequestData requestData, AlignmentNumberingConnectionRequestData alignmentNumberingConnectionRequestData) {
        super(requestData);
        this.alignmentNumberingConnectionRequestData = alignmentNumberingConnectionRequestData;
    }

    public AlignmentNumberingConnectionRequest() {
        super();
        this.alignmentNumberingConnectionRequestData = new AlignmentNumberingConnectionRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public AlignmentNumberingConnectionRequestData getSpecificData() {
        return alignmentNumberingConnectionRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(AlignmentNumberingConnectionRequestData alignmentNumberingConnectionRequestData) {
        this.alignmentNumberingConnectionRequestData = alignmentNumberingConnectionRequestData;
    }

    @Override
    public final String modelToXmlString() {
        AlignmentNumberingConnectionRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final AlignmentNumberingConnectionRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        AlignmentNumberingConnectionRequestDocument alignmentNumberingConnectionRequestDoc = AlignmentNumberingConnectionRequestDocument.Factory.newInstance();
        AlignmentNumberingConnectionRequestDocument.AlignmentNumberingConnectionRequest alignmentNumberingConnectionRequest = alignmentNumberingConnectionRequestDoc.addNewAlignmentNumberingConnectionRequest();
        super.fillCommonXmlInfo(alignmentNumberingConnectionRequest);
        int i = 0;
        
        if (getIsNumbering() != null)
            alignmentNumberingConnectionRequest.setIsNumbering(getIsNumbering().booleanValue());
      
        if (getOtherAddress() != null)
            alignmentNumberingConnectionRequest.setOtherAddress(Address.modelToXml(getOtherAddress()));
      
        alignmentNumberingConnectionRequest.setOwnerFirstNames(getOwnerFirstNames());
      
        if (getNumber() != null)
            alignmentNumberingConnectionRequest.setNumber(new BigInteger(getNumber().toString()));
      
        if (getArea() != null)
            alignmentNumberingConnectionRequest.setArea(new BigInteger(getArea().toString()));
      
        if (getMoreThanTwoYears() != null)
            alignmentNumberingConnectionRequest.setMoreThanTwoYears(getMoreThanTwoYears().booleanValue());
      
        if (getOwnerAddress() != null)
            alignmentNumberingConnectionRequest.setOwnerAddress(Address.modelToXml(getOwnerAddress()));
      
        if (getRequesterQuality() != null)
            alignmentNumberingConnectionRequest.setRequesterQuality(fr.cg95.cvq.xml.request.urbanism.AncrRequesterQualityType.Enum.forString(getRequesterQuality().toString()));
      
        alignmentNumberingConnectionRequest.setSection(getSection());
      
        alignmentNumberingConnectionRequest.setTransportationRoute(getTransportationRoute());
      
        alignmentNumberingConnectionRequest.setLocality(getLocality());
      
        if (getIsConnection() != null)
            alignmentNumberingConnectionRequest.setIsConnection(getIsConnection().booleanValue());
      
        if (getIsAccountAddress() != null)
            alignmentNumberingConnectionRequest.setIsAccountAddress(getIsAccountAddress().booleanValue());
      
        if (getIsAlignment() != null)
            alignmentNumberingConnectionRequest.setIsAlignment(getIsAlignment().booleanValue());
      
        alignmentNumberingConnectionRequest.setOwnerLastName(getOwnerLastName());
      
        return alignmentNumberingConnectionRequestDoc;
    }

    @Override
    public final AlignmentNumberingConnectionRequestDocument.AlignmentNumberingConnectionRequest modelToXmlRequest() {
        return modelToXml().getAlignmentNumberingConnectionRequest();
    }

    public static AlignmentNumberingConnectionRequest xmlToModel(AlignmentNumberingConnectionRequestDocument alignmentNumberingConnectionRequestDoc) {
        AlignmentNumberingConnectionRequestDocument.AlignmentNumberingConnectionRequest alignmentNumberingConnectionRequestXml = alignmentNumberingConnectionRequestDoc.getAlignmentNumberingConnectionRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        AlignmentNumberingConnectionRequest alignmentNumberingConnectionRequest = new AlignmentNumberingConnectionRequest();
        alignmentNumberingConnectionRequest.fillCommonModelInfo(alignmentNumberingConnectionRequest, alignmentNumberingConnectionRequestXml);
        
        alignmentNumberingConnectionRequest.setIsNumbering(Boolean.valueOf(alignmentNumberingConnectionRequestXml.getIsNumbering()));
      
        if (alignmentNumberingConnectionRequestXml.getOtherAddress() != null)
            alignmentNumberingConnectionRequest.setOtherAddress(Address.xmlToModel(alignmentNumberingConnectionRequestXml.getOtherAddress()));
      
        alignmentNumberingConnectionRequest.setOwnerFirstNames(alignmentNumberingConnectionRequestXml.getOwnerFirstNames());
      
        alignmentNumberingConnectionRequest.setNumber(alignmentNumberingConnectionRequestXml.getNumber());
      
        alignmentNumberingConnectionRequest.setArea(alignmentNumberingConnectionRequestXml.getArea());
      
        alignmentNumberingConnectionRequest.setMoreThanTwoYears(Boolean.valueOf(alignmentNumberingConnectionRequestXml.getMoreThanTwoYears()));
      
        if (alignmentNumberingConnectionRequestXml.getOwnerAddress() != null)
            alignmentNumberingConnectionRequest.setOwnerAddress(Address.xmlToModel(alignmentNumberingConnectionRequestXml.getOwnerAddress()));
      
        if (alignmentNumberingConnectionRequestXml.getRequesterQuality() != null)
            alignmentNumberingConnectionRequest.setRequesterQuality(fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType.forString(alignmentNumberingConnectionRequestXml.getRequesterQuality().toString()));
        else
            alignmentNumberingConnectionRequest.setRequesterQuality(fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType.getDefaultAncrRequesterQualityType());
      
        alignmentNumberingConnectionRequest.setSection(alignmentNumberingConnectionRequestXml.getSection());
      
        alignmentNumberingConnectionRequest.setTransportationRoute(alignmentNumberingConnectionRequestXml.getTransportationRoute());
      
        alignmentNumberingConnectionRequest.setLocality(alignmentNumberingConnectionRequestXml.getLocality());
      
        alignmentNumberingConnectionRequest.setIsConnection(Boolean.valueOf(alignmentNumberingConnectionRequestXml.getIsConnection()));
      
        alignmentNumberingConnectionRequest.setIsAccountAddress(Boolean.valueOf(alignmentNumberingConnectionRequestXml.getIsAccountAddress()));
      
        alignmentNumberingConnectionRequest.setIsAlignment(Boolean.valueOf(alignmentNumberingConnectionRequestXml.getIsAlignment()));
      
        alignmentNumberingConnectionRequest.setOwnerLastName(alignmentNumberingConnectionRequestXml.getOwnerLastName());
      
        return alignmentNumberingConnectionRequest;
    }

  
    public final void setIsNumbering(final Boolean isNumbering) {
        alignmentNumberingConnectionRequestData.setIsNumbering(isNumbering);
    }

    
    public final Boolean getIsNumbering() {
        return alignmentNumberingConnectionRequestData.getIsNumbering();
    }
  
    public final void setOtherAddress(final fr.cg95.cvq.business.users.Address otherAddress) {
        alignmentNumberingConnectionRequestData.setOtherAddress(otherAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getOtherAddress() {
        return alignmentNumberingConnectionRequestData.getOtherAddress();
    }
  
    public final void setOwnerFirstNames(final String ownerFirstNames) {
        alignmentNumberingConnectionRequestData.setOwnerFirstNames(ownerFirstNames);
    }

    
    public final String getOwnerFirstNames() {
        return alignmentNumberingConnectionRequestData.getOwnerFirstNames();
    }
  
    public final void setNumber(final java.math.BigInteger number) {
        alignmentNumberingConnectionRequestData.setNumber(number);
    }

    
    public final java.math.BigInteger getNumber() {
        return alignmentNumberingConnectionRequestData.getNumber();
    }
  
    public final void setArea(final java.math.BigInteger area) {
        alignmentNumberingConnectionRequestData.setArea(area);
    }

    
    public final java.math.BigInteger getArea() {
        return alignmentNumberingConnectionRequestData.getArea();
    }
  
    public final void setMoreThanTwoYears(final Boolean moreThanTwoYears) {
        alignmentNumberingConnectionRequestData.setMoreThanTwoYears(moreThanTwoYears);
    }

    
    public final Boolean getMoreThanTwoYears() {
        return alignmentNumberingConnectionRequestData.getMoreThanTwoYears();
    }
  
    public final void setOwnerAddress(final fr.cg95.cvq.business.users.Address ownerAddress) {
        alignmentNumberingConnectionRequestData.setOwnerAddress(ownerAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getOwnerAddress() {
        return alignmentNumberingConnectionRequestData.getOwnerAddress();
    }
  
    public final void setRequesterQuality(final fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType requesterQuality) {
        alignmentNumberingConnectionRequestData.setRequesterQuality(requesterQuality);
    }

    
    public final fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType getRequesterQuality() {
        return alignmentNumberingConnectionRequestData.getRequesterQuality();
    }
  
    public final void setSection(final String section) {
        alignmentNumberingConnectionRequestData.setSection(section);
    }

    
    public final String getSection() {
        return alignmentNumberingConnectionRequestData.getSection();
    }
  
    public final void setTransportationRoute(final String transportationRoute) {
        alignmentNumberingConnectionRequestData.setTransportationRoute(transportationRoute);
    }

    
    public final String getTransportationRoute() {
        return alignmentNumberingConnectionRequestData.getTransportationRoute();
    }
  
    public final void setLocality(final String locality) {
        alignmentNumberingConnectionRequestData.setLocality(locality);
    }

    
    public final String getLocality() {
        return alignmentNumberingConnectionRequestData.getLocality();
    }
  
    public final void setIsConnection(final Boolean isConnection) {
        alignmentNumberingConnectionRequestData.setIsConnection(isConnection);
    }

    
    public final Boolean getIsConnection() {
        return alignmentNumberingConnectionRequestData.getIsConnection();
    }
  
    public final void setIsAccountAddress(final Boolean isAccountAddress) {
        alignmentNumberingConnectionRequestData.setIsAccountAddress(isAccountAddress);
    }

    
    public final Boolean getIsAccountAddress() {
        return alignmentNumberingConnectionRequestData.getIsAccountAddress();
    }
  
    public final void setIsAlignment(final Boolean isAlignment) {
        alignmentNumberingConnectionRequestData.setIsAlignment(isAlignment);
    }

    
    public final Boolean getIsAlignment() {
        return alignmentNumberingConnectionRequestData.getIsAlignment();
    }
  
    public final void setOwnerLastName(final String ownerLastName) {
        alignmentNumberingConnectionRequestData.setOwnerLastName(ownerLastName);
    }

    
    public final String getOwnerLastName() {
        return alignmentNumberingConnectionRequestData.getOwnerLastName();
    }
  
}
