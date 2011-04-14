
package fr.cg95.cvq.business.request.urbanism;

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
import fr.cg95.cvq.xml.request.urbanism.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class AlignmentCertificateRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = AlignmentCertificateRequestData.conditions;

    @AssertValid(message = "")
    private AlignmentCertificateRequestData alignmentCertificateRequestData;

    public AlignmentCertificateRequest(RequestData requestData, AlignmentCertificateRequestData alignmentCertificateRequestData) {
        super(requestData);
        this.alignmentCertificateRequestData = alignmentCertificateRequestData;
    }

    public AlignmentCertificateRequest() {
        super();
        this.alignmentCertificateRequestData = new AlignmentCertificateRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("cadastre", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("document", stepState);
        
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
    public AlignmentCertificateRequestData getSpecificData() {
        return alignmentCertificateRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(AlignmentCertificateRequestData alignmentCertificateRequestData) {
        this.alignmentCertificateRequestData = alignmentCertificateRequestData;
    }

    @Override
    public final String modelToXmlString() {
        AlignmentCertificateRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final AlignmentCertificateRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        AlignmentCertificateRequestDocument alignmentCertificateRequestDoc = AlignmentCertificateRequestDocument.Factory.newInstance();
        AlignmentCertificateRequestDocument.AlignmentCertificateRequest alignmentCertificateRequest = alignmentCertificateRequestDoc.addNewAlignmentCertificateRequest();
        super.fillCommonXmlInfo(alignmentCertificateRequest);
        int i = 0;
        
        if (getRequesterQuality() != null)
            alignmentCertificateRequest.setRequesterQuality(fr.cg95.cvq.xml.request.urbanism.AcrRequesterQualityType.Enum.forString(getRequesterQuality().toString()));
      
        alignmentCertificateRequest.setSection(getSection());
      
        alignmentCertificateRequest.setTransportationRoute(getTransportationRoute());
      
        alignmentCertificateRequest.setOwnerFirstNames(getOwnerFirstNames());
      
        alignmentCertificateRequest.setLocality(getLocality());
      
        if (getNumber() != null)
            alignmentCertificateRequest.setNumber(new BigInteger(getNumber().toString()));
      
        alignmentCertificateRequest.setOwnerLastName(getOwnerLastName());
      
        if (getOwnerAddress() != null)
            alignmentCertificateRequest.setOwnerAddress(Address.modelToXml(getOwnerAddress()));
      
        return alignmentCertificateRequestDoc;
    }

    @Override
    public final AlignmentCertificateRequestDocument.AlignmentCertificateRequest modelToXmlRequest() {
        return modelToXml().getAlignmentCertificateRequest();
    }

    public static AlignmentCertificateRequest xmlToModel(AlignmentCertificateRequestDocument alignmentCertificateRequestDoc) {
        AlignmentCertificateRequestDocument.AlignmentCertificateRequest alignmentCertificateRequestXml = alignmentCertificateRequestDoc.getAlignmentCertificateRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        AlignmentCertificateRequest alignmentCertificateRequest = new AlignmentCertificateRequest();
        alignmentCertificateRequest.fillCommonModelInfo(alignmentCertificateRequest, alignmentCertificateRequestXml);
        
        if (alignmentCertificateRequestXml.getRequesterQuality() != null)
            alignmentCertificateRequest.setRequesterQuality(fr.cg95.cvq.business.request.urbanism.AcrRequesterQualityType.forString(alignmentCertificateRequestXml.getRequesterQuality().toString()));
        else
            alignmentCertificateRequest.setRequesterQuality(fr.cg95.cvq.business.request.urbanism.AcrRequesterQualityType.getDefaultAcrRequesterQualityType());
      
        alignmentCertificateRequest.setSection(alignmentCertificateRequestXml.getSection());
      
        alignmentCertificateRequest.setTransportationRoute(alignmentCertificateRequestXml.getTransportationRoute());
      
        alignmentCertificateRequest.setOwnerFirstNames(alignmentCertificateRequestXml.getOwnerFirstNames());
      
        alignmentCertificateRequest.setLocality(alignmentCertificateRequestXml.getLocality());
      
        alignmentCertificateRequest.setNumber(alignmentCertificateRequestXml.getNumber());
      
        alignmentCertificateRequest.setOwnerLastName(alignmentCertificateRequestXml.getOwnerLastName());
      
        if (alignmentCertificateRequestXml.getOwnerAddress() != null)
            alignmentCertificateRequest.setOwnerAddress(Address.xmlToModel(alignmentCertificateRequestXml.getOwnerAddress()));
      
        return alignmentCertificateRequest;
    }

    @Override
    public AlignmentCertificateRequest clone() {
        AlignmentCertificateRequest clone = new AlignmentCertificateRequest(getRequestData().clone(), alignmentCertificateRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("cadastre", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("document", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("validation", stepState);
        
        return clone;
    }

  
    public final void setRequesterQuality(final fr.cg95.cvq.business.request.urbanism.AcrRequesterQualityType requesterQuality) {
        alignmentCertificateRequestData.setRequesterQuality(requesterQuality);
    }

    
    public final fr.cg95.cvq.business.request.urbanism.AcrRequesterQualityType getRequesterQuality() {
        return alignmentCertificateRequestData.getRequesterQuality();
    }
  
    public final void setSection(final String section) {
        alignmentCertificateRequestData.setSection(section);
    }

    
    public final String getSection() {
        return alignmentCertificateRequestData.getSection();
    }
  
    public final void setTransportationRoute(final String transportationRoute) {
        alignmentCertificateRequestData.setTransportationRoute(transportationRoute);
    }

    
    public final String getTransportationRoute() {
        return alignmentCertificateRequestData.getTransportationRoute();
    }
  
    public final void setOwnerFirstNames(final String ownerFirstNames) {
        alignmentCertificateRequestData.setOwnerFirstNames(ownerFirstNames);
    }

    
    public final String getOwnerFirstNames() {
        return alignmentCertificateRequestData.getOwnerFirstNames();
    }
  
    public final void setLocality(final String locality) {
        alignmentCertificateRequestData.setLocality(locality);
    }

    
    public final String getLocality() {
        return alignmentCertificateRequestData.getLocality();
    }
  
    public final void setNumber(final java.math.BigInteger number) {
        alignmentCertificateRequestData.setNumber(number);
    }

    
    public final java.math.BigInteger getNumber() {
        return alignmentCertificateRequestData.getNumber();
    }
  
    public final void setOwnerLastName(final String ownerLastName) {
        alignmentCertificateRequestData.setOwnerLastName(ownerLastName);
    }

    
    public final String getOwnerLastName() {
        return alignmentCertificateRequestData.getOwnerLastName();
    }
  
    public final void setOwnerAddress(final fr.cg95.cvq.business.users.Address ownerAddress) {
        alignmentCertificateRequestData.setOwnerAddress(ownerAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getOwnerAddress() {
        return alignmentCertificateRequestData.getOwnerAddress();
    }
  
}
