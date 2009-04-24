package fr.cg95.cvq.business.request.localpolice;

import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.localpolice.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.xml.common.RequestType;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="holiday_security_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class HolidaySecurityRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public HolidaySecurityRequest() {
        super();
        alarm = Boolean.valueOf(false);
        light = Boolean.valueOf(false);
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
    }


    public final String modelToXmlString() {

        HolidaySecurityRequestDocument object = (HolidaySecurityRequestDocument) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final XmlObject modelToXml() {

        Calendar calendar = Calendar.getInstance();
        Date date = null;
        HolidaySecurityRequestDocument holidaySecurityRequestDoc = HolidaySecurityRequestDocument.Factory.newInstance();
        HolidaySecurityRequestDocument.HolidaySecurityRequest holidaySecurityRequest = holidaySecurityRequestDoc.addNewHolidaySecurityRequest();
        super.fillCommonXmlInfo(holidaySecurityRequest);
        holidaySecurityRequest.setOtherContactLastName(this.otherContactLastName);
        date = this.absenceEndDate;
        if (date != null) {
            calendar.setTime(date);
            holidaySecurityRequest.setAbsenceEndDate(calendar);
        }
        if (this.alarm != null)
            holidaySecurityRequest.setAlarm(this.alarm.booleanValue());
        if (this.otherContactAddress != null)
            holidaySecurityRequest.setOtherContactAddress(Address.modelToXml(this.otherContactAddress));
        holidaySecurityRequest.setOtherContactFirstName(this.otherContactFirstName);
        if (this.light != null)
            holidaySecurityRequest.setLight(this.light.booleanValue());
        holidaySecurityRequest.setOtherContactPhone(this.otherContactPhone);
        if (this.rulesAndRegulationsAcceptance != null)
            holidaySecurityRequest.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance.booleanValue());
        holidaySecurityRequest.setAlertPhone(this.alertPhone);
        date = this.absenceStartDate;
        if (date != null) {
            calendar.setTime(date);
            holidaySecurityRequest.setAbsenceStartDate(calendar);
        }
        return holidaySecurityRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        HolidaySecurityRequestDocument holidaySecurityRequestDoc =
            (HolidaySecurityRequestDocument) modelToXml();
        return holidaySecurityRequestDoc.getHolidaySecurityRequest();
    }

    public static HolidaySecurityRequest xmlToModel(HolidaySecurityRequestDocument holidaySecurityRequestDoc) {

        HolidaySecurityRequestDocument.HolidaySecurityRequest holidaySecurityRequestXml = holidaySecurityRequestDoc.getHolidaySecurityRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HolidaySecurityRequest holidaySecurityRequest = new HolidaySecurityRequest();
        holidaySecurityRequest.fillCommonModelInfo(holidaySecurityRequest,holidaySecurityRequestXml);
        holidaySecurityRequest.setOtherContactLastName(holidaySecurityRequestXml.getOtherContactLastName());
        calendar = holidaySecurityRequestXml.getAbsenceEndDate();
        if (calendar != null) {
            holidaySecurityRequest.setAbsenceEndDate(calendar.getTime());
        }
        holidaySecurityRequest.setAlarm(Boolean.valueOf(holidaySecurityRequestXml.getAlarm()));
        if (holidaySecurityRequestXml.getOtherContactAddress() != null)
            holidaySecurityRequest.setOtherContactAddress(Address.xmlToModel(holidaySecurityRequestXml.getOtherContactAddress()));
        holidaySecurityRequest.setOtherContactFirstName(holidaySecurityRequestXml.getOtherContactFirstName());
        holidaySecurityRequest.setLight(Boolean.valueOf(holidaySecurityRequestXml.getLight()));
        holidaySecurityRequest.setOtherContactPhone(holidaySecurityRequestXml.getOtherContactPhone());
        holidaySecurityRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(holidaySecurityRequestXml.getRulesAndRegulationsAcceptance()));
        holidaySecurityRequest.setAlertPhone(holidaySecurityRequestXml.getAlertPhone());
        calendar = holidaySecurityRequestXml.getAbsenceStartDate();
        if (calendar != null) {
            holidaySecurityRequest.setAbsenceStartDate(calendar.getTime());
        }
        return holidaySecurityRequest;
    }

    private String otherContactLastName;

    public final void setOtherContactLastName(final String otherContactLastName) {
        this.otherContactLastName = otherContactLastName;
    }


    /**
     * @hibernate.property
     *  column="other_contact_last_name"
     *  length="38"
     */
    public final String getOtherContactLastName() {
        return this.otherContactLastName;
    }

    private java.util.Date absenceEndDate;

    public final void setAbsenceEndDate(final java.util.Date absenceEndDate) {
        this.absenceEndDate = absenceEndDate;
    }


    /**
     * @hibernate.property
     *  column="absence_end_date"
     */
    public final java.util.Date getAbsenceEndDate() {
        return this.absenceEndDate;
    }

    private Boolean alarm;

    public final void setAlarm(final Boolean alarm) {
        this.alarm = alarm;
    }


    /**
     * @hibernate.property
     *  column="alarm"
     */
    public final Boolean getAlarm() {
        return this.alarm;
    }

    private fr.cg95.cvq.business.users.Address otherContactAddress;

    public final void setOtherContactAddress(final fr.cg95.cvq.business.users.Address otherContactAddress) {
        this.otherContactAddress = otherContactAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="other_contact_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getOtherContactAddress() {
        return this.otherContactAddress;
    }

    private String otherContactFirstName;

    public final void setOtherContactFirstName(final String otherContactFirstName) {
        this.otherContactFirstName = otherContactFirstName;
    }


    /**
     * @hibernate.property
     *  column="other_contact_first_name"
     *  length="38"
     */
    public final String getOtherContactFirstName() {
        return this.otherContactFirstName;
    }

    private Boolean light;

    public final void setLight(final Boolean light) {
        this.light = light;
    }


    /**
     * @hibernate.property
     *  column="light"
     */
    public final Boolean getLight() {
        return this.light;
    }

    private String otherContactPhone;

    public final void setOtherContactPhone(final String otherContactPhone) {
        this.otherContactPhone = otherContactPhone;
    }


    /**
     * @hibernate.property
     *  column="other_contact_phone"
     *  length="10"
     */
    public final String getOtherContactPhone() {
        return this.otherContactPhone;
    }

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

    private String alertPhone;

    public final void setAlertPhone(final String alertPhone) {
        this.alertPhone = alertPhone;
    }


    /**
     * @hibernate.property
     *  column="alert_phone"
     *  length="10"
     */
    public final String getAlertPhone() {
        return this.alertPhone;
    }

    private java.util.Date absenceStartDate;

    public final void setAbsenceStartDate(final java.util.Date absenceStartDate) {
        this.absenceStartDate = absenceStartDate;
    }


    /**
     * @hibernate.property
     *  column="absence_start_date"
     */
    public final java.util.Date getAbsenceStartDate() {
        return this.absenceStartDate;
    }

}
