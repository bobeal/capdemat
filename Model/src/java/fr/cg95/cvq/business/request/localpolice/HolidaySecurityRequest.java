
package fr.cg95.cvq.business.request.localpolice;

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
import fr.cg95.cvq.xml.request.localpolice.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class HolidaySecurityRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = HolidaySecurityRequestData.conditions;

    @AssertValid(message = "")
    private HolidaySecurityRequestData holidaySecurityRequestData;

    public HolidaySecurityRequest(RequestData requestData, HolidaySecurityRequestData holidaySecurityRequestData) {
        super(requestData);
        this.holidaySecurityRequestData = holidaySecurityRequestData;
    }

    public HolidaySecurityRequest() {
        super();
        this.holidaySecurityRequestData = new HolidaySecurityRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public HolidaySecurityRequestData getSpecificData() {
        return holidaySecurityRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(HolidaySecurityRequestData holidaySecurityRequestData) {
        this.holidaySecurityRequestData = holidaySecurityRequestData;
    }

    @Override
    public final String modelToXmlString() {
        HolidaySecurityRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final HolidaySecurityRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        HolidaySecurityRequestDocument holidaySecurityRequestDoc = HolidaySecurityRequestDocument.Factory.newInstance();
        HolidaySecurityRequestDocument.HolidaySecurityRequest holidaySecurityRequest = holidaySecurityRequestDoc.addNewHolidaySecurityRequest();
        super.fillCommonXmlInfo(holidaySecurityRequest);
        int i = 0;
        
        date = getAbsenceEndDate();
        if (date != null) {
            calendar.setTime(date);
            holidaySecurityRequest.setAbsenceEndDate(calendar);
        }
      
        date = getAbsenceStartDate();
        if (date != null) {
            calendar.setTime(date);
            holidaySecurityRequest.setAbsenceStartDate(calendar);
        }
      
        if (getAlarm() != null)
            holidaySecurityRequest.setAlarm(getAlarm().booleanValue());
      
        holidaySecurityRequest.setAlertPhone(getAlertPhone());
      
        if (getLight() != null)
            holidaySecurityRequest.setLight(getLight().booleanValue());
      
        if (getOtherContact() != null)
            holidaySecurityRequest.setOtherContact(getOtherContact().booleanValue());
        HsrOtherContactType hsrOtherContactTypeOtherContactInformations = holidaySecurityRequest.addNewOtherContactInformations();
        if (getOtherContactAddress() != null)
            hsrOtherContactTypeOtherContactInformations.setOtherContactAddress(Address.modelToXml(getOtherContactAddress()));
      
        hsrOtherContactTypeOtherContactInformations.setOtherContactFirstName(getOtherContactFirstName());
      
        hsrOtherContactTypeOtherContactInformations.setOtherContactLastName(getOtherContactLastName());
      
        hsrOtherContactTypeOtherContactInformations.setOtherContactPhone(getOtherContactPhone());
      
        if (getRulesAndRegulationsAcceptance() != null)
            holidaySecurityRequest.setRulesAndRegulationsAcceptance(getRulesAndRegulationsAcceptance().booleanValue());
      
        return holidaySecurityRequestDoc;
    }

    @Override
    public final HolidaySecurityRequestDocument.HolidaySecurityRequest modelToXmlRequest() {
        return modelToXml().getHolidaySecurityRequest();
    }

    public static HolidaySecurityRequest xmlToModel(HolidaySecurityRequestDocument holidaySecurityRequestDoc) {
        HolidaySecurityRequestDocument.HolidaySecurityRequest holidaySecurityRequestXml = holidaySecurityRequestDoc.getHolidaySecurityRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        HolidaySecurityRequest holidaySecurityRequest = new HolidaySecurityRequest();
        holidaySecurityRequest.fillCommonModelInfo(holidaySecurityRequest, holidaySecurityRequestXml);
        
        calendar = holidaySecurityRequestXml.getAbsenceEndDate();
        if (calendar != null) {
            holidaySecurityRequest.setAbsenceEndDate(calendar.getTime());
        }
      
        calendar = holidaySecurityRequestXml.getAbsenceStartDate();
        if (calendar != null) {
            holidaySecurityRequest.setAbsenceStartDate(calendar.getTime());
        }
      
        holidaySecurityRequest.setAlarm(Boolean.valueOf(holidaySecurityRequestXml.getAlarm()));
      
        holidaySecurityRequest.setAlertPhone(holidaySecurityRequestXml.getAlertPhone());
      
        holidaySecurityRequest.setLight(Boolean.valueOf(holidaySecurityRequestXml.getLight()));
      
        holidaySecurityRequest.setOtherContact(Boolean.valueOf(holidaySecurityRequestXml.getOtherContact()));
      
        if (holidaySecurityRequestXml.getOtherContactInformations().getOtherContactAddress() != null)
            holidaySecurityRequest.setOtherContactAddress(Address.xmlToModel(holidaySecurityRequestXml.getOtherContactInformations().getOtherContactAddress()));
      
        holidaySecurityRequest.setOtherContactFirstName(holidaySecurityRequestXml.getOtherContactInformations().getOtherContactFirstName());
      
        holidaySecurityRequest.setOtherContactLastName(holidaySecurityRequestXml.getOtherContactInformations().getOtherContactLastName());
      
        holidaySecurityRequest.setOtherContactPhone(holidaySecurityRequestXml.getOtherContactInformations().getOtherContactPhone());
      
        holidaySecurityRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(holidaySecurityRequestXml.getRulesAndRegulationsAcceptance()));
      
        return holidaySecurityRequest;
    }

  
    public final void setAbsenceEndDate(final java.util.Date absenceEndDate) {
        holidaySecurityRequestData.setAbsenceEndDate(absenceEndDate);
    }

    
    public final java.util.Date getAbsenceEndDate() {
        return holidaySecurityRequestData.getAbsenceEndDate();
    }
  
    public final void setAbsenceStartDate(final java.util.Date absenceStartDate) {
        holidaySecurityRequestData.setAbsenceStartDate(absenceStartDate);
    }

    
    public final java.util.Date getAbsenceStartDate() {
        return holidaySecurityRequestData.getAbsenceStartDate();
    }
  
    public final void setAlarm(final Boolean alarm) {
        holidaySecurityRequestData.setAlarm(alarm);
    }

    
    public final Boolean getAlarm() {
        return holidaySecurityRequestData.getAlarm();
    }
  
    public final void setAlertPhone(final String alertPhone) {
        holidaySecurityRequestData.setAlertPhone(alertPhone);
    }

    
    public final String getAlertPhone() {
        return holidaySecurityRequestData.getAlertPhone();
    }
  
    public final void setLight(final Boolean light) {
        holidaySecurityRequestData.setLight(light);
    }

    
    public final Boolean getLight() {
        return holidaySecurityRequestData.getLight();
    }
  
    public final void setOtherContact(final Boolean otherContact) {
        holidaySecurityRequestData.setOtherContact(otherContact);
    }

    
    public final Boolean getOtherContact() {
        return holidaySecurityRequestData.getOtherContact();
    }
  
    public final void setOtherContactAddress(final fr.cg95.cvq.business.users.Address otherContactAddress) {
        holidaySecurityRequestData.setOtherContactAddress(otherContactAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getOtherContactAddress() {
        return holidaySecurityRequestData.getOtherContactAddress();
    }
  
    public final void setOtherContactFirstName(final String otherContactFirstName) {
        holidaySecurityRequestData.setOtherContactFirstName(otherContactFirstName);
    }

    
    public final String getOtherContactFirstName() {
        return holidaySecurityRequestData.getOtherContactFirstName();
    }
  
    public final void setOtherContactLastName(final String otherContactLastName) {
        holidaySecurityRequestData.setOtherContactLastName(otherContactLastName);
    }

    
    public final String getOtherContactLastName() {
        return holidaySecurityRequestData.getOtherContactLastName();
    }
  
    public final void setOtherContactPhone(final String otherContactPhone) {
        holidaySecurityRequestData.setOtherContactPhone(otherContactPhone);
    }

    
    public final String getOtherContactPhone() {
        return holidaySecurityRequestData.getOtherContactPhone();
    }
  
    public final void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        holidaySecurityRequestData.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
    }

    @IsRulesAcceptance
    public final Boolean getRulesAndRegulationsAcceptance() {
        return holidaySecurityRequestData.getRulesAndRegulationsAcceptance();
    }
  
}
