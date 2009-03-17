package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.school.*;

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
 *  table="study_grant_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class StudyGrantRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public StudyGrantRequest() {
        super();
        futureSchoolIsAbroad = Boolean.valueOf(false);
        hasCROUSHelp = Boolean.valueOf(false);
        hasParentsAddress = Boolean.valueOf(true);
        isInLastYear = Boolean.valueOf(false);
        hasOtherHelp = Boolean.valueOf(false);
    }


    public final String modelToXmlString() {

        StudyGrantRequestDocument object = (StudyGrantRequestDocument) this.modelToXml();
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
        StudyGrantRequestDocument studyGrantRequestDoc = StudyGrantRequestDocument.Factory.newInstance();
        StudyGrantRequestDocument.StudyGrantRequest studyGrantRequest = studyGrantRequestDoc.addNewStudyGrantRequest();
        super.fillCommonXmlInfo(studyGrantRequest);
        if (this.currentStudies != null)
            studyGrantRequest.setCurrentStudies(fr.cg95.cvq.xml.request.school.CurrentStudiesType.Enum.forString(this.currentStudies.toString()));
        date = this.abroadInternshipEndDate;
        if (date != null) {
            calendar.setTime(date);
            studyGrantRequest.setAbroadInternshipEndDate(calendar);
        }
        if (this.taxHouseholdAddress != null)
            studyGrantRequest.setTaxHouseholdAddress(Address.modelToXml(this.taxHouseholdAddress));
        studyGrantRequest.setFutureSchoolPhone(this.futureSchoolPhone);
        date = this.abroadInternshipStartDate;
        if (date != null) {
            calendar.setTime(date);
            studyGrantRequest.setAbroadInternshipStartDate(calendar);
        }
        studyGrantRequest.setBankName(this.bankName);
        studyGrantRequest.setTaxHouseholdFirstName(this.taxHouseholdFirstName);
        studyGrantRequest.setFutureSchoolName(this.futureSchoolName);
        studyGrantRequest.setSandwichCoursesLabel(this.sandwichCoursesLabel);
        studyGrantRequest.setLastYearType(this.lastYearType);
        studyGrantRequest.setBankCode(this.bankCode);
        SubjectInformationsType subjectInformationsTypeSubjetInformations = studyGrantRequest.addNewSubjetInformations();
        date = this.subjectBirthDate;
        if (date != null) {
            calendar.setTime(date);
            subjectInformationsTypeSubjetInformations.setSubjectBirthDate(calendar);
        }
        if (this.futureSchoolIsAbroad != null)
            studyGrantRequest.setFutureSchoolIsAbroad(this.futureSchoolIsAbroad.booleanValue());
        studyGrantRequest.setCounterCode(this.counterCode);
        if (this.hasCROUSHelp != null)
            studyGrantRequest.setHasCROUSHelp(this.hasCROUSHelp.booleanValue());
        subjectInformationsTypeSubjetInformations.setSubjectEmail(this.subjectEmail);
        if (this.hasParentsAddress != null)
            subjectInformationsTypeSubjetInformations.setHasParentsAddress(this.hasParentsAddress.booleanValue());
        if (this.futureSchoolAddress != null)
            studyGrantRequest.setFutureSchoolAddress(Address.modelToXml(this.futureSchoolAddress));
        if (this.abroadInternshipSchoolCountry != null)
            studyGrantRequest.setAbroadInternshipSchoolCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(this.abroadInternshipSchoolCountry.toString()));
        studyGrantRequest.setAbroadInternshipSchoolAddress(this.abroadInternshipSchoolAddress);
        studyGrantRequest.setTaxHouseholdPhone(this.taxHouseholdPhone);
        studyGrantRequest.setBankAgency(this.bankAgency);
        studyGrantRequest.setTaxHouseholdLastName(this.taxHouseholdLastName);
        studyGrantRequest.setAccountNumber(this.accountNumber);
        if (this.distance != null)
            studyGrantRequest.setDistance(fr.cg95.cvq.xml.request.school.DistanceType.Enum.forString(this.distance.toString()));
        subjectInformationsTypeSubjetInformations.setSubjectMobilePhone(this.subjectMobilePhone);
        if (this.isInLastYear != null)
            studyGrantRequest.setIsInLastYear(this.isInLastYear.booleanValue());
        studyGrantRequest.setAbroadInternshipSchoolName(this.abroadInternshipSchoolName);
        studyGrantRequest.setOtherHelpInformations(this.otherHelpInformations);
        studyGrantRequest.setAccountKey(this.accountKey);
        studyGrantRequest.setOtherStudiesLabel(this.otherStudiesLabel);
        subjectInformationsTypeSubjetInformations.setSubjectBirthPlace(this.subjectBirthPlace);
        studyGrantRequest.setFutureDiplomaLevel(this.futureDiplomaLevel);
        studyGrantRequest.setLastYearDate(this.lastYearDate);
        if (this.taxHouseholdIncome != null)
            studyGrantRequest.setTaxHouseholdIncome(this.taxHouseholdIncome.doubleValue());
        if (this.hasOtherHelp != null)
            studyGrantRequest.setHasOtherHelp(this.hasOtherHelp.booleanValue());
        studyGrantRequest.setFutureDiplomaName(this.futureDiplomaName);
        if (this.subjectAddress != null)
            subjectInformationsTypeSubjetInformations.setSubjectAddress(Address.modelToXml(this.subjectAddress));
        subjectInformationsTypeSubjetInformations.setSubjectPhone(this.subjectPhone);
        return studyGrantRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        StudyGrantRequestDocument studyGrantRequestDoc =
            (StudyGrantRequestDocument) modelToXml();
        return studyGrantRequestDoc.getStudyGrantRequest();
    }

    public static StudyGrantRequest xmlToModel(StudyGrantRequestDocument studyGrantRequestDoc) {

        StudyGrantRequestDocument.StudyGrantRequest studyGrantRequestXml = studyGrantRequestDoc.getStudyGrantRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        StudyGrantRequest studyGrantRequest = new StudyGrantRequest();
        studyGrantRequest.fillCommonModelInfo(studyGrantRequest,studyGrantRequestXml);
        if (studyGrantRequestXml.getCurrentStudies() != null)
            studyGrantRequest.setCurrentStudies(fr.cg95.cvq.business.request.school.CurrentStudiesType.forString(studyGrantRequestXml.getCurrentStudies().toString()));
        else
            studyGrantRequest.setCurrentStudies(fr.cg95.cvq.business.request.school.CurrentStudiesType.getDefaultCurrentStudiesType());
        calendar = studyGrantRequestXml.getAbroadInternshipEndDate();
        if (calendar != null) {
            studyGrantRequest.setAbroadInternshipEndDate(calendar.getTime());
        }
        if (studyGrantRequestXml.getTaxHouseholdAddress() != null)
            studyGrantRequest.setTaxHouseholdAddress(Address.xmlToModel(studyGrantRequestXml.getTaxHouseholdAddress()));
        studyGrantRequest.setFutureSchoolPhone(studyGrantRequestXml.getFutureSchoolPhone());
        calendar = studyGrantRequestXml.getAbroadInternshipStartDate();
        if (calendar != null) {
            studyGrantRequest.setAbroadInternshipStartDate(calendar.getTime());
        }
        studyGrantRequest.setBankName(studyGrantRequestXml.getBankName());
        studyGrantRequest.setTaxHouseholdFirstName(studyGrantRequestXml.getTaxHouseholdFirstName());
        studyGrantRequest.setFutureSchoolName(studyGrantRequestXml.getFutureSchoolName());
        studyGrantRequest.setSandwichCoursesLabel(studyGrantRequestXml.getSandwichCoursesLabel());
        studyGrantRequest.setLastYearType(studyGrantRequestXml.getLastYearType());
        studyGrantRequest.setBankCode(studyGrantRequestXml.getBankCode());
        calendar = studyGrantRequestXml.getSubjetInformations().getSubjectBirthDate();
        if (calendar != null) {
            studyGrantRequest.setSubjectBirthDate(calendar.getTime());
        }
        studyGrantRequest.setFutureSchoolIsAbroad(Boolean.valueOf(studyGrantRequestXml.getFutureSchoolIsAbroad()));
        studyGrantRequest.setCounterCode(studyGrantRequestXml.getCounterCode());
        studyGrantRequest.setHasCROUSHelp(Boolean.valueOf(studyGrantRequestXml.getHasCROUSHelp()));
        studyGrantRequest.setSubjectEmail(studyGrantRequestXml.getSubjetInformations().getSubjectEmail());
        studyGrantRequest.setHasParentsAddress(Boolean.valueOf(studyGrantRequestXml.getSubjetInformations().getHasParentsAddress()));
        if (studyGrantRequestXml.getFutureSchoolAddress() != null)
            studyGrantRequest.setFutureSchoolAddress(Address.xmlToModel(studyGrantRequestXml.getFutureSchoolAddress()));
        if (studyGrantRequestXml.getAbroadInternshipSchoolCountry() != null)
            studyGrantRequest.setAbroadInternshipSchoolCountry(fr.cg95.cvq.business.users.CountryType.forString(studyGrantRequestXml.getAbroadInternshipSchoolCountry().toString()));
        else
            studyGrantRequest.setAbroadInternshipSchoolCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
        studyGrantRequest.setAbroadInternshipSchoolAddress(studyGrantRequestXml.getAbroadInternshipSchoolAddress());
        studyGrantRequest.setTaxHouseholdPhone(studyGrantRequestXml.getTaxHouseholdPhone());
        studyGrantRequest.setBankAgency(studyGrantRequestXml.getBankAgency());
        studyGrantRequest.setTaxHouseholdLastName(studyGrantRequestXml.getTaxHouseholdLastName());
        studyGrantRequest.setAccountNumber(studyGrantRequestXml.getAccountNumber());
        if (studyGrantRequestXml.getDistance() != null)
            studyGrantRequest.setDistance(fr.cg95.cvq.business.request.school.DistanceType.forString(studyGrantRequestXml.getDistance().toString()));
        else
            studyGrantRequest.setDistance(fr.cg95.cvq.business.request.school.DistanceType.getDefaultDistanceType());
        studyGrantRequest.setSubjectMobilePhone(studyGrantRequestXml.getSubjetInformations().getSubjectMobilePhone());
        studyGrantRequest.setIsInLastYear(Boolean.valueOf(studyGrantRequestXml.getIsInLastYear()));
        studyGrantRequest.setAbroadInternshipSchoolName(studyGrantRequestXml.getAbroadInternshipSchoolName());
        studyGrantRequest.setOtherHelpInformations(studyGrantRequestXml.getOtherHelpInformations());
        studyGrantRequest.setAccountKey(studyGrantRequestXml.getAccountKey());
        studyGrantRequest.setOtherStudiesLabel(studyGrantRequestXml.getOtherStudiesLabel());
        studyGrantRequest.setSubjectBirthPlace(studyGrantRequestXml.getSubjetInformations().getSubjectBirthPlace());
        studyGrantRequest.setFutureDiplomaLevel(studyGrantRequestXml.getFutureDiplomaLevel());
        studyGrantRequest.setLastYearDate(studyGrantRequestXml.getLastYearDate());
        studyGrantRequest.setTaxHouseholdIncome(new Double(studyGrantRequestXml.getTaxHouseholdIncome()));
        studyGrantRequest.setHasOtherHelp(Boolean.valueOf(studyGrantRequestXml.getHasOtherHelp()));
        studyGrantRequest.setFutureDiplomaName(studyGrantRequestXml.getFutureDiplomaName());
        if (studyGrantRequestXml.getSubjetInformations().getSubjectAddress() != null)
            studyGrantRequest.setSubjectAddress(Address.xmlToModel(studyGrantRequestXml.getSubjetInformations().getSubjectAddress()));
        studyGrantRequest.setSubjectPhone(studyGrantRequestXml.getSubjetInformations().getSubjectPhone());
        return studyGrantRequest;
    }

    private fr.cg95.cvq.business.request.school.CurrentStudiesType currentStudies;

    public final void setCurrentStudies(final fr.cg95.cvq.business.request.school.CurrentStudiesType currentStudies) {
        this.currentStudies = currentStudies;
    }


    /**
     * @hibernate.property
     *  column="current_studies"
     */
    public final fr.cg95.cvq.business.request.school.CurrentStudiesType getCurrentStudies() {
        return this.currentStudies;
    }

    private java.util.Date abroadInternshipEndDate;

    public final void setAbroadInternshipEndDate(final java.util.Date abroadInternshipEndDate) {
        this.abroadInternshipEndDate = abroadInternshipEndDate;
    }


    /**
     * @hibernate.property
     *  column="abroad_internship_end_date"
     */
    public final java.util.Date getAbroadInternshipEndDate() {
        return this.abroadInternshipEndDate;
    }

    private fr.cg95.cvq.business.users.Address taxHouseholdAddress;

    public final void setTaxHouseholdAddress(final fr.cg95.cvq.business.users.Address taxHouseholdAddress) {
        this.taxHouseholdAddress = taxHouseholdAddress;
    }


    /**
     * @hibernate.many-to-one
     *  column="tax_household_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getTaxHouseholdAddress() {
        return this.taxHouseholdAddress;
    }

    private String futureSchoolPhone;

    public final void setFutureSchoolPhone(final String futureSchoolPhone) {
        this.futureSchoolPhone = futureSchoolPhone;
    }


    /**
     * @hibernate.property
     *  column="future_school_phone"
     *  length="10"
     */
    public final String getFutureSchoolPhone() {
        return this.futureSchoolPhone;
    }

    private java.util.Date abroadInternshipStartDate;

    public final void setAbroadInternshipStartDate(final java.util.Date abroadInternshipStartDate) {
        this.abroadInternshipStartDate = abroadInternshipStartDate;
    }


    /**
     * @hibernate.property
     *  column="abroad_internship_start_date"
     */
    public final java.util.Date getAbroadInternshipStartDate() {
        return this.abroadInternshipStartDate;
    }

    private String bankName;

    public final void setBankName(final String bankName) {
        this.bankName = bankName;
    }


    /**
     * @hibernate.property
     *  column="bank_name"
     */
    public final String getBankName() {
        return this.bankName;
    }

    private String taxHouseholdFirstName;

    public final void setTaxHouseholdFirstName(final String taxHouseholdFirstName) {
        this.taxHouseholdFirstName = taxHouseholdFirstName;
    }


    /**
     * @hibernate.property
     *  column="tax_household_first_name"
     *  length="38"
     */
    public final String getTaxHouseholdFirstName() {
        return this.taxHouseholdFirstName;
    }

    private String futureSchoolName;

    public final void setFutureSchoolName(final String futureSchoolName) {
        this.futureSchoolName = futureSchoolName;
    }


    /**
     * @hibernate.property
     *  column="future_school_name"
     */
    public final String getFutureSchoolName() {
        return this.futureSchoolName;
    }

    private String sandwichCoursesLabel;

    public final void setSandwichCoursesLabel(final String sandwichCoursesLabel) {
        this.sandwichCoursesLabel = sandwichCoursesLabel;
    }


    /**
     * @hibernate.property
     *  column="sandwich_courses_label"
     */
    public final String getSandwichCoursesLabel() {
        return this.sandwichCoursesLabel;
    }

    private String lastYearType;

    public final void setLastYearType(final String lastYearType) {
        this.lastYearType = lastYearType;
    }


    /**
     * @hibernate.property
     *  column="last_year_type"
     */
    public final String getLastYearType() {
        return this.lastYearType;
    }

    private String bankCode;

    public final void setBankCode(final String bankCode) {
        this.bankCode = bankCode;
    }


    /**
     * @hibernate.property
     *  column="bank_code"
     */
    public final String getBankCode() {
        return this.bankCode;
    }

    private java.util.Date subjectBirthDate;

    public final void setSubjectBirthDate(final java.util.Date subjectBirthDate) {
        this.subjectBirthDate = subjectBirthDate;
    }


    /**
     * @hibernate.property
     *  column="subject_birth_date"
     */
    public final java.util.Date getSubjectBirthDate() {
        return this.subjectBirthDate;
    }

    private Boolean futureSchoolIsAbroad;

    public final void setFutureSchoolIsAbroad(final Boolean futureSchoolIsAbroad) {
        this.futureSchoolIsAbroad = futureSchoolIsAbroad;
    }


    /**
     * @hibernate.property
     *  column="future_school_is_abroad"
     */
    public final Boolean getFutureSchoolIsAbroad() {
        return this.futureSchoolIsAbroad;
    }

    private String counterCode;

    public final void setCounterCode(final String counterCode) {
        this.counterCode = counterCode;
    }


    /**
     * @hibernate.property
     *  column="counter_code"
     */
    public final String getCounterCode() {
        return this.counterCode;
    }

    private Boolean hasCROUSHelp;

    public final void setHasCROUSHelp(final Boolean hasCROUSHelp) {
        this.hasCROUSHelp = hasCROUSHelp;
    }


    /**
     * @hibernate.property
     *  column="has_c_r_o_u_s_help"
     */
    public final Boolean getHasCROUSHelp() {
        return this.hasCROUSHelp;
    }

    private String subjectEmail;

    public final void setSubjectEmail(final String subjectEmail) {
        this.subjectEmail = subjectEmail;
    }


    /**
     * @hibernate.property
     *  column="subject_email"
     */
    public final String getSubjectEmail() {
        return this.subjectEmail;
    }

    private Boolean hasParentsAddress;

    public final void setHasParentsAddress(final Boolean hasParentsAddress) {
        this.hasParentsAddress = hasParentsAddress;
    }


    /**
     * @hibernate.property
     *  column="has_parents_address"
     */
    public final Boolean getHasParentsAddress() {
        return this.hasParentsAddress;
    }

    private fr.cg95.cvq.business.users.Address futureSchoolAddress;

    public final void setFutureSchoolAddress(final fr.cg95.cvq.business.users.Address futureSchoolAddress) {
        this.futureSchoolAddress = futureSchoolAddress;
    }


    /**
     * @hibernate.many-to-one
     *  column="future_school_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getFutureSchoolAddress() {
        return this.futureSchoolAddress;
    }

    private fr.cg95.cvq.business.users.CountryType abroadInternshipSchoolCountry;

    public final void setAbroadInternshipSchoolCountry(final fr.cg95.cvq.business.users.CountryType abroadInternshipSchoolCountry) {
        this.abroadInternshipSchoolCountry = abroadInternshipSchoolCountry;
    }


    /**
     * @hibernate.property
     *  column="abroad_internship_school_country"
     */
    public final fr.cg95.cvq.business.users.CountryType getAbroadInternshipSchoolCountry() {
        return this.abroadInternshipSchoolCountry;
    }

    private String abroadInternshipSchoolAddress;

    public final void setAbroadInternshipSchoolAddress(final String abroadInternshipSchoolAddress) {
        this.abroadInternshipSchoolAddress = abroadInternshipSchoolAddress;
    }


    /**
     * @hibernate.property
     *  column="abroad_internship_school_address"
     */
    public final String getAbroadInternshipSchoolAddress() {
        return this.abroadInternshipSchoolAddress;
    }

    private String taxHouseholdPhone;

    public final void setTaxHouseholdPhone(final String taxHouseholdPhone) {
        this.taxHouseholdPhone = taxHouseholdPhone;
    }


    /**
     * @hibernate.property
     *  column="tax_household_phone"
     *  length="10"
     */
    public final String getTaxHouseholdPhone() {
        return this.taxHouseholdPhone;
    }

    private String bankAgency;

    public final void setBankAgency(final String bankAgency) {
        this.bankAgency = bankAgency;
    }


    /**
     * @hibernate.property
     *  column="bank_agency"
     */
    public final String getBankAgency() {
        return this.bankAgency;
    }

    private String taxHouseholdLastName;

    public final void setTaxHouseholdLastName(final String taxHouseholdLastName) {
        this.taxHouseholdLastName = taxHouseholdLastName;
    }


    /**
     * @hibernate.property
     *  column="tax_household_last_name"
     *  length="38"
     */
    public final String getTaxHouseholdLastName() {
        return this.taxHouseholdLastName;
    }

    private String accountNumber;

    public final void setAccountNumber(final String accountNumber) {
        this.accountNumber = accountNumber;
    }


    /**
     * @hibernate.property
     *  column="account_number"
     */
    public final String getAccountNumber() {
        return this.accountNumber;
    }

    private fr.cg95.cvq.business.request.school.DistanceType distance;

    public final void setDistance(final fr.cg95.cvq.business.request.school.DistanceType distance) {
        this.distance = distance;
    }


    /**
     * @hibernate.property
     *  column="distance"
     */
    public final fr.cg95.cvq.business.request.school.DistanceType getDistance() {
        return this.distance;
    }

    private String subjectMobilePhone;

    public final void setSubjectMobilePhone(final String subjectMobilePhone) {
        this.subjectMobilePhone = subjectMobilePhone;
    }


    /**
     * @hibernate.property
     *  column="subject_mobile_phone"
     *  length="10"
     */
    public final String getSubjectMobilePhone() {
        return this.subjectMobilePhone;
    }

    private Boolean isInLastYear;

    public final void setIsInLastYear(final Boolean isInLastYear) {
        this.isInLastYear = isInLastYear;
    }


    /**
     * @hibernate.property
     *  column="is_in_last_year"
     */
    public final Boolean getIsInLastYear() {
        return this.isInLastYear;
    }

    private String abroadInternshipSchoolName;

    public final void setAbroadInternshipSchoolName(final String abroadInternshipSchoolName) {
        this.abroadInternshipSchoolName = abroadInternshipSchoolName;
    }


    /**
     * @hibernate.property
     *  column="abroad_internship_school_name"
     */
    public final String getAbroadInternshipSchoolName() {
        return this.abroadInternshipSchoolName;
    }

    private String otherHelpInformations;

    public final void setOtherHelpInformations(final String otherHelpInformations) {
        this.otherHelpInformations = otherHelpInformations;
    }


    /**
     * @hibernate.property
     *  column="other_help_informations"
     */
    public final String getOtherHelpInformations() {
        return this.otherHelpInformations;
    }

    private String accountKey;

    public final void setAccountKey(final String accountKey) {
        this.accountKey = accountKey;
    }


    /**
     * @hibernate.property
     *  column="account_key"
     */
    public final String getAccountKey() {
        return this.accountKey;
    }

    private String otherStudiesLabel;

    public final void setOtherStudiesLabel(final String otherStudiesLabel) {
        this.otherStudiesLabel = otherStudiesLabel;
    }


    /**
     * @hibernate.property
     *  column="other_studies_label"
     */
    public final String getOtherStudiesLabel() {
        return this.otherStudiesLabel;
    }

    private String subjectBirthPlace;

    public final void setSubjectBirthPlace(final String subjectBirthPlace) {
        this.subjectBirthPlace = subjectBirthPlace;
    }


    /**
     * @hibernate.property
     *  column="subject_birth_place"
     */
    public final String getSubjectBirthPlace() {
        return this.subjectBirthPlace;
    }

    private String futureDiplomaLevel;

    public final void setFutureDiplomaLevel(final String futureDiplomaLevel) {
        this.futureDiplomaLevel = futureDiplomaLevel;
    }


    /**
     * @hibernate.property
     *  column="future_diploma_level"
     */
    public final String getFutureDiplomaLevel() {
        return this.futureDiplomaLevel;
    }

    private String lastYearDate;

    public final void setLastYearDate(final String lastYearDate) {
        this.lastYearDate = lastYearDate;
    }


    /**
     * @hibernate.property
     *  column="last_year_date"
     */
    public final String getLastYearDate() {
        return this.lastYearDate;
    }

    private Double taxHouseholdIncome;

    public final void setTaxHouseholdIncome(final Double taxHouseholdIncome) {
        this.taxHouseholdIncome = taxHouseholdIncome;
    }


    /**
     * @hibernate.property
     *  column="tax_household_income"
     */
    public final Double getTaxHouseholdIncome() {
        return this.taxHouseholdIncome;
    }

    private Boolean hasOtherHelp;

    public final void setHasOtherHelp(final Boolean hasOtherHelp) {
        this.hasOtherHelp = hasOtherHelp;
    }


    /**
     * @hibernate.property
     *  column="has_other_help"
     */
    public final Boolean getHasOtherHelp() {
        return this.hasOtherHelp;
    }

    private String futureDiplomaName;

    public final void setFutureDiplomaName(final String futureDiplomaName) {
        this.futureDiplomaName = futureDiplomaName;
    }


    /**
     * @hibernate.property
     *  column="future_diploma_name"
     */
    public final String getFutureDiplomaName() {
        return this.futureDiplomaName;
    }

    private fr.cg95.cvq.business.users.Address subjectAddress;

    public final void setSubjectAddress(final fr.cg95.cvq.business.users.Address subjectAddress) {
        this.subjectAddress = subjectAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="subject_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getSubjectAddress() {
        return this.subjectAddress;
    }

    private String subjectPhone;

    public final void setSubjectPhone(final String subjectPhone) {
        this.subjectPhone = subjectPhone;
    }


    /**
     * @hibernate.property
     *  column="subject_phone"
     *  length="10"
     */
    public final String getSubjectPhone() {
        return this.subjectPhone;
    }

}
