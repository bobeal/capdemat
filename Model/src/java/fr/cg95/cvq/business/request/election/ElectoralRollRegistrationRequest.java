
package fr.cg95.cvq.business.request.election;

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
import fr.cg95.cvq.xml.request.election.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class ElectoralRollRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = ElectoralRollRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private ElectoralRollRegistrationRequestData electoralRollRegistrationRequestData;

    public ElectoralRollRegistrationRequest(RequestData requestData, ElectoralRollRegistrationRequestData electoralRollRegistrationRequestData) {
        super(requestData);
        this.electoralRollRegistrationRequestData = electoralRollRegistrationRequestData;
    }

    public ElectoralRollRegistrationRequest() {
        super();
        this.electoralRollRegistrationRequestData = new ElectoralRollRegistrationRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("registration", stepState);
        
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
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("administration", stepState);
        
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public ElectoralRollRegistrationRequestData getSpecificData() {
        return electoralRollRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(ElectoralRollRegistrationRequestData electoralRollRegistrationRequestData) {
        this.electoralRollRegistrationRequestData = electoralRollRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        ElectoralRollRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final ElectoralRollRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        ElectoralRollRegistrationRequestDocument electoralRollRegistrationRequestDoc = ElectoralRollRegistrationRequestDocument.Factory.newInstance();
        ElectoralRollRegistrationRequestDocument.ElectoralRollRegistrationRequest electoralRollRegistrationRequest = electoralRollRegistrationRequestDoc.addNewElectoralRollRegistrationRequest();
        super.fillCommonXmlInfo(electoralRollRegistrationRequest);
        int i = 0;
        
        if (getElectoralNumber() != null)
            electoralRollRegistrationRequest.setElectoralNumber(getElectoralNumber().longValue());
      
        if (getMotive() != null)
            electoralRollRegistrationRequest.setMotive(fr.cg95.cvq.xml.request.election.ElectoralMotiveType.Enum.forString(getMotive().getLegacyLabel()));
      
        electoralRollRegistrationRequest.setPollingSchoolName(getPollingSchoolName());
      
        if (getPollingStation() != null)
            electoralRollRegistrationRequest.setPollingStation(getPollingStation().longValue());
      
        if (getSubjectAddressOutsideCity() != null)
            electoralRollRegistrationRequest.setSubjectAddressOutsideCity(Address.modelToXml(getSubjectAddressOutsideCity()));
      
        if (getSubjectNationality() != null)
            electoralRollRegistrationRequest.setSubjectNationality(fr.cg95.cvq.xml.common.NationalityType.Enum.forString(getSubjectNationality().getLegacyLabel()));
      
        electoralRollRegistrationRequest.setSubjectOldCity(getSubjectOldCity());
      
        return electoralRollRegistrationRequestDoc;
    }

    @Override
    public final ElectoralRollRegistrationRequestDocument.ElectoralRollRegistrationRequest modelToXmlRequest() {
        return modelToXml().getElectoralRollRegistrationRequest();
    }

    public static ElectoralRollRegistrationRequest xmlToModel(ElectoralRollRegistrationRequestDocument electoralRollRegistrationRequestDoc) {
        ElectoralRollRegistrationRequestDocument.ElectoralRollRegistrationRequest electoralRollRegistrationRequestXml = electoralRollRegistrationRequestDoc.getElectoralRollRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        ElectoralRollRegistrationRequest electoralRollRegistrationRequest = new ElectoralRollRegistrationRequest();
        electoralRollRegistrationRequest.fillCommonModelInfo(electoralRollRegistrationRequest, electoralRollRegistrationRequestXml);
        
        if (electoralRollRegistrationRequestXml.getElectoralNumber() != 0)
            electoralRollRegistrationRequest.setElectoralNumber(new Long(electoralRollRegistrationRequestXml.getElectoralNumber()));
      
        if (electoralRollRegistrationRequestXml.getMotive() != null)
            electoralRollRegistrationRequest.setMotive(fr.cg95.cvq.business.request.election.ElectoralMotiveType.forString(electoralRollRegistrationRequestXml.getMotive().toString()));
        else
            electoralRollRegistrationRequest.setMotive(fr.cg95.cvq.business.request.election.ElectoralMotiveType.getDefaultElectoralMotiveType());
      
        electoralRollRegistrationRequest.setPollingSchoolName(electoralRollRegistrationRequestXml.getPollingSchoolName());
      
        if (electoralRollRegistrationRequestXml.getPollingStation() != 0)
            electoralRollRegistrationRequest.setPollingStation(new Long(electoralRollRegistrationRequestXml.getPollingStation()));
      
        if (electoralRollRegistrationRequestXml.getSubjectAddressOutsideCity() != null)
            electoralRollRegistrationRequest.setSubjectAddressOutsideCity(Address.xmlToModel(electoralRollRegistrationRequestXml.getSubjectAddressOutsideCity()));
      
        if (electoralRollRegistrationRequestXml.getSubjectNationality() != null)
            electoralRollRegistrationRequest.setSubjectNationality(fr.cg95.cvq.business.users.NationalityType.forString(electoralRollRegistrationRequestXml.getSubjectNationality().toString()));
        else
            electoralRollRegistrationRequest.setSubjectNationality(fr.cg95.cvq.business.users.NationalityType.getDefaultNationalityType());
      
        electoralRollRegistrationRequest.setSubjectOldCity(electoralRollRegistrationRequestXml.getSubjectOldCity());
      
        return electoralRollRegistrationRequest;
    }

    @Override
    public ElectoralRollRegistrationRequest clone() {
        ElectoralRollRegistrationRequest clone = new ElectoralRollRegistrationRequest(getRequestData().clone(), electoralRollRegistrationRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("registration", stepState);
        
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
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("administration", stepState);
        
        return clone;
    }

  
    public final void setElectoralNumber(final Long electoralNumber) {
        electoralRollRegistrationRequestData.setElectoralNumber(electoralNumber);
    }

    
    public final Long getElectoralNumber() {
        return electoralRollRegistrationRequestData.getElectoralNumber();
    }
  
    public final void setMotive(final fr.cg95.cvq.business.request.election.ElectoralMotiveType motive) {
        electoralRollRegistrationRequestData.setMotive(motive);
    }

    
    public final fr.cg95.cvq.business.request.election.ElectoralMotiveType getMotive() {
        return electoralRollRegistrationRequestData.getMotive();
    }
  
    public final void setPollingSchoolName(final String pollingSchoolName) {
        electoralRollRegistrationRequestData.setPollingSchoolName(pollingSchoolName);
    }

    
    public final String getPollingSchoolName() {
        return electoralRollRegistrationRequestData.getPollingSchoolName();
    }
  
    public final void setPollingStation(final Long pollingStation) {
        electoralRollRegistrationRequestData.setPollingStation(pollingStation);
    }

    
    public final Long getPollingStation() {
        return electoralRollRegistrationRequestData.getPollingStation();
    }
  
    public final void setSubjectAddressOutsideCity(final fr.cg95.cvq.business.users.Address subjectAddressOutsideCity) {
        electoralRollRegistrationRequestData.setSubjectAddressOutsideCity(subjectAddressOutsideCity);
    }

    
    public final fr.cg95.cvq.business.users.Address getSubjectAddressOutsideCity() {
        return electoralRollRegistrationRequestData.getSubjectAddressOutsideCity();
    }
  
    public final void setSubjectNationality(final fr.cg95.cvq.business.users.NationalityType subjectNationality) {
        electoralRollRegistrationRequestData.setSubjectNationality(subjectNationality);
    }

    
    public final fr.cg95.cvq.business.users.NationalityType getSubjectNationality() {
        return electoralRollRegistrationRequestData.getSubjectNationality();
    }
  
    public final void setSubjectOldCity(final String subjectOldCity) {
        electoralRollRegistrationRequestData.setSubjectOldCity(subjectOldCity);
    }

    
    public final String getSubjectOldCity() {
        return electoralRollRegistrationRequestData.getSubjectOldCity();
    }
  
}
