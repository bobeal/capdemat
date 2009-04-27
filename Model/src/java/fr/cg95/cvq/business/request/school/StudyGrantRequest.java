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
        hasOtherHelp = Boolean.valueOf(false);
        hasRegionalCouncilHelp = Boolean.valueOf(false);
        hasCROUSHelp = Boolean.valueOf(false);
        hasEuropeHelp = Boolean.valueOf(false);
        sandwichCourses = Boolean.valueOf(false);
        abroadInternship = Boolean.valueOf(false);
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
        SubjectInformationsType subjectInformationsTypeSubjectInformations = studyGrantRequest.addNewSubjectInformations();
        date = this.subjectBirthDate;
        if (date != null) {
            calendar.setTime(date);
            subjectInformationsTypeSubjectInformations.setSubjectBirthDate(calendar);
        }
        SgrCurrentSchoolType sgrCurrentSchoolTypeCurrentSchool = studyGrantRequest.addNewCurrentSchool();
        sgrCurrentSchoolTypeCurrentSchool.setCurrentSchoolCity(this.currentSchoolCity);
        subjectInformationsTypeSubjectInformations.setSubjectEmail(this.subjectEmail);
        studyGrantRequest.setTaxHouseholdCity(this.taxHouseholdCity);
        studyGrantRequest.setTaxHouseholdPostalCode(this.taxHouseholdPostalCode);
        if (this.hasOtherHelp != null)
            studyGrantRequest.setHasOtherHelp(this.hasOtherHelp.booleanValue());
        subjectInformationsTypeSubjectInformations.setSubjectPhone(this.subjectPhone);
        CurrentStudiesInformationsType currentStudiesInformationsTypeCurrentStudiesInformations = studyGrantRequest.addNewCurrentStudiesInformations();
        if (this.currentStudies != null)
            currentStudiesInformationsTypeCurrentStudiesInformations.setCurrentStudies(fr.cg95.cvq.xml.request.school.CurrentStudiesType.Enum.forString(this.currentStudies.toString()));
        ALevelsInformationsType aLevelsInformationsTypeALevelsInformations = studyGrantRequest.addNewALevelsInformations();
        aLevelsInformationsTypeALevelsInformations.setAlevelsDate(this.alevelsDate);
        studyGrantRequest.setCounterCode(this.counterCode);
        sgrCurrentSchoolTypeCurrentSchool.setCurrentSchoolName(this.currentSchoolName);
        if (this.abroadInternshipSchoolCountry != null)
            currentStudiesInformationsTypeCurrentStudiesInformations.setAbroadInternshipSchoolCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(this.abroadInternshipSchoolCountry.toString()));
        studyGrantRequest.setTaxHouseholdLastName(this.taxHouseholdLastName);
        currentStudiesInformationsTypeCurrentStudiesInformations.setAbroadInternshipSchoolName(this.abroadInternshipSchoolName);
        studyGrantRequest.setAccountKey(this.accountKey);
        if (this.hasRegionalCouncilHelp != null)
            studyGrantRequest.setHasRegionalCouncilHelp(this.hasRegionalCouncilHelp.booleanValue());
        if (this.currentStudiesLevel != null)
            currentStudiesInformationsTypeCurrentStudiesInformations.setCurrentStudiesLevel(fr.cg95.cvq.xml.request.school.CurrentStudiesLevelType.Enum.forString(this.currentStudiesLevel.toString()));
        sgrCurrentSchoolTypeCurrentSchool.setCurrentSchoolPostalCode(this.currentSchoolPostalCode);
        date = this.abroadInternshipStartDate;
        if (date != null) {
            calendar.setTime(date);
            currentStudiesInformationsTypeCurrentStudiesInformations.setAbroadInternshipStartDate(calendar);
        }
        if (this.hasCROUSHelp != null)
            studyGrantRequest.setHasCROUSHelp(this.hasCROUSHelp.booleanValue());
        studyGrantRequest.setAccountNumber(this.accountNumber);
        if (this.distance != null)
            studyGrantRequest.setDistance(fr.cg95.cvq.xml.request.school.DistanceType.Enum.forString(this.distance.toString()));
        if (this.alevels != null)
            aLevelsInformationsTypeALevelsInformations.setAlevels(fr.cg95.cvq.xml.request.school.ALevelsType.Enum.forString(this.alevels.toString()));
        subjectInformationsTypeSubjectInformations.setSubjectMobilePhone(this.subjectMobilePhone);
        currentStudiesInformationsTypeCurrentStudiesInformations.setOtherStudiesLabel(this.otherStudiesLabel);
        if (this.taxHouseholdIncome != null)
            studyGrantRequest.setTaxHouseholdIncome(this.taxHouseholdIncome.doubleValue());
        if (this.currentSchoolCountry != null)
            sgrCurrentSchoolTypeCurrentSchool.setCurrentSchoolCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(this.currentSchoolCountry.toString()));
        if (this.subjectAddress != null)
            subjectInformationsTypeSubjectInformations.setSubjectAddress(Address.modelToXml(this.subjectAddress));
        date = this.abroadInternshipEndDate;
        if (date != null) {
            calendar.setTime(date);
            currentStudiesInformationsTypeCurrentStudiesInformations.setAbroadInternshipEndDate(calendar);
        }
        if (this.hasEuropeHelp != null)
            studyGrantRequest.setHasEuropeHelp(this.hasEuropeHelp.booleanValue());
        studyGrantRequest.setTaxHouseholdFirstName(this.taxHouseholdFirstName);
        studyGrantRequest.setBankCode(this.bankCode);
        if (this.sandwichCourses != null)
            currentStudiesInformationsTypeCurrentStudiesInformations.setSandwichCourses(this.sandwichCourses.booleanValue());
        if (this.abroadInternship != null)
            currentStudiesInformationsTypeCurrentStudiesInformations.setAbroadInternship(this.abroadInternship.booleanValue());
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
        calendar = studyGrantRequestXml.getSubjectInformations().getSubjectBirthDate();
        if (calendar != null) {
            studyGrantRequest.setSubjectBirthDate(calendar.getTime());
        }
        studyGrantRequest.setCurrentSchoolCity(studyGrantRequestXml.getCurrentSchool().getCurrentSchoolCity());
        studyGrantRequest.setSubjectEmail(studyGrantRequestXml.getSubjectInformations().getSubjectEmail());
        studyGrantRequest.setTaxHouseholdCity(studyGrantRequestXml.getTaxHouseholdCity());
        studyGrantRequest.setTaxHouseholdPostalCode(studyGrantRequestXml.getTaxHouseholdPostalCode());
        studyGrantRequest.setHasOtherHelp(Boolean.valueOf(studyGrantRequestXml.getHasOtherHelp()));
        studyGrantRequest.setSubjectPhone(studyGrantRequestXml.getSubjectInformations().getSubjectPhone());
        if (studyGrantRequestXml.getCurrentStudiesInformations().getCurrentStudies() != null)
            studyGrantRequest.setCurrentStudies(fr.cg95.cvq.business.request.school.CurrentStudiesType.forString(studyGrantRequestXml.getCurrentStudiesInformations().getCurrentStudies().toString()));
        else
            studyGrantRequest.setCurrentStudies(fr.cg95.cvq.business.request.school.CurrentStudiesType.getDefaultCurrentStudiesType());
        studyGrantRequest.setAlevelsDate(studyGrantRequestXml.getALevelsInformations().getAlevelsDate());
        studyGrantRequest.setCounterCode(studyGrantRequestXml.getCounterCode());
        studyGrantRequest.setCurrentSchoolName(studyGrantRequestXml.getCurrentSchool().getCurrentSchoolName());
        if (studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternshipSchoolCountry() != null)
            studyGrantRequest.setAbroadInternshipSchoolCountry(fr.cg95.cvq.business.users.CountryType.forString(studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternshipSchoolCountry().toString()));
        else
            studyGrantRequest.setAbroadInternshipSchoolCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
        studyGrantRequest.setTaxHouseholdLastName(studyGrantRequestXml.getTaxHouseholdLastName());
        studyGrantRequest.setAbroadInternshipSchoolName(studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternshipSchoolName());
        studyGrantRequest.setAccountKey(studyGrantRequestXml.getAccountKey());
        studyGrantRequest.setHasRegionalCouncilHelp(Boolean.valueOf(studyGrantRequestXml.getHasRegionalCouncilHelp()));
        if (studyGrantRequestXml.getCurrentStudiesInformations().getCurrentStudiesLevel() != null)
            studyGrantRequest.setCurrentStudiesLevel(fr.cg95.cvq.business.request.school.CurrentStudiesLevelType.forString(studyGrantRequestXml.getCurrentStudiesInformations().getCurrentStudiesLevel().toString()));
        else
            studyGrantRequest.setCurrentStudiesLevel(fr.cg95.cvq.business.request.school.CurrentStudiesLevelType.getDefaultCurrentStudiesLevelType());
        studyGrantRequest.setCurrentSchoolPostalCode(studyGrantRequestXml.getCurrentSchool().getCurrentSchoolPostalCode());
        calendar = studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternshipStartDate();
        if (calendar != null) {
            studyGrantRequest.setAbroadInternshipStartDate(calendar.getTime());
        }
        studyGrantRequest.setHasCROUSHelp(Boolean.valueOf(studyGrantRequestXml.getHasCROUSHelp()));
        studyGrantRequest.setAccountNumber(studyGrantRequestXml.getAccountNumber());
        if (studyGrantRequestXml.getDistance() != null)
            studyGrantRequest.setDistance(fr.cg95.cvq.business.request.school.DistanceType.forString(studyGrantRequestXml.getDistance().toString()));
        else
            studyGrantRequest.setDistance(fr.cg95.cvq.business.request.school.DistanceType.getDefaultDistanceType());
        if (studyGrantRequestXml.getALevelsInformations().getAlevels() != null)
            studyGrantRequest.setAlevels(fr.cg95.cvq.business.request.school.ALevelsType.forString(studyGrantRequestXml.getALevelsInformations().getAlevels().toString()));
        else
            studyGrantRequest.setAlevels(fr.cg95.cvq.business.request.school.ALevelsType.getDefaultALevelsType());
        studyGrantRequest.setSubjectMobilePhone(studyGrantRequestXml.getSubjectInformations().getSubjectMobilePhone());
        studyGrantRequest.setOtherStudiesLabel(studyGrantRequestXml.getCurrentStudiesInformations().getOtherStudiesLabel());
        studyGrantRequest.setTaxHouseholdIncome(new Double(studyGrantRequestXml.getTaxHouseholdIncome()));
        if (studyGrantRequestXml.getCurrentSchool().getCurrentSchoolCountry() != null)
            studyGrantRequest.setCurrentSchoolCountry(fr.cg95.cvq.business.users.CountryType.forString(studyGrantRequestXml.getCurrentSchool().getCurrentSchoolCountry().toString()));
        else
            studyGrantRequest.setCurrentSchoolCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
        if (studyGrantRequestXml.getSubjectInformations().getSubjectAddress() != null)
            studyGrantRequest.setSubjectAddress(Address.xmlToModel(studyGrantRequestXml.getSubjectInformations().getSubjectAddress()));
        calendar = studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternshipEndDate();
        if (calendar != null) {
            studyGrantRequest.setAbroadInternshipEndDate(calendar.getTime());
        }
        studyGrantRequest.setHasEuropeHelp(Boolean.valueOf(studyGrantRequestXml.getHasEuropeHelp()));
        studyGrantRequest.setTaxHouseholdFirstName(studyGrantRequestXml.getTaxHouseholdFirstName());
        studyGrantRequest.setBankCode(studyGrantRequestXml.getBankCode());
        studyGrantRequest.setSandwichCourses(Boolean.valueOf(studyGrantRequestXml.getCurrentStudiesInformations().getSandwichCourses()));
        studyGrantRequest.setAbroadInternship(Boolean.valueOf(studyGrantRequestXml.getCurrentStudiesInformations().getAbroadInternship()));
        return studyGrantRequest;
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

    private String currentSchoolCity;

    public final void setCurrentSchoolCity(final String currentSchoolCity) {
        this.currentSchoolCity = currentSchoolCity;
    }


    /**
     * @hibernate.property
     *  column="current_school_city"
     *  length="32"
     */
    public final String getCurrentSchoolCity() {
        return this.currentSchoolCity;
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

    private String taxHouseholdCity;

    public final void setTaxHouseholdCity(final String taxHouseholdCity) {
        this.taxHouseholdCity = taxHouseholdCity;
    }


    /**
     * @hibernate.property
     *  column="tax_household_city"
     *  length="32"
     */
    public final String getTaxHouseholdCity() {
        return this.taxHouseholdCity;
    }

    private String taxHouseholdPostalCode;

    public final void setTaxHouseholdPostalCode(final String taxHouseholdPostalCode) {
        this.taxHouseholdPostalCode = taxHouseholdPostalCode;
    }


    /**
     * @hibernate.property
     *  column="tax_household_postal_code"
     *  length="5"
     */
    public final String getTaxHouseholdPostalCode() {
        return this.taxHouseholdPostalCode;
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

    private String alevelsDate;

    public final void setAlevelsDate(final String alevelsDate) {
        this.alevelsDate = alevelsDate;
    }


    /**
     * @hibernate.property
     *  column="alevels_date"
     *  length="4"
     */
    public final String getAlevelsDate() {
        return this.alevelsDate;
    }

    private String counterCode;

    public final void setCounterCode(final String counterCode) {
        this.counterCode = counterCode;
    }


    /**
     * @hibernate.property
     *  column="counter_code"
     *  length="5"
     */
    public final String getCounterCode() {
        return this.counterCode;
    }

    private String currentSchoolName;

    public final void setCurrentSchoolName(final String currentSchoolName) {
        this.currentSchoolName = currentSchoolName;
    }


    /**
     * @hibernate.property
     *  column="current_school_name"
     */
    public final String getCurrentSchoolName() {
        return this.currentSchoolName;
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

    private String accountKey;

    public final void setAccountKey(final String accountKey) {
        this.accountKey = accountKey;
    }


    /**
     * @hibernate.property
     *  column="account_key"
     *  length="2"
     */
    public final String getAccountKey() {
        return this.accountKey;
    }

    private Boolean hasRegionalCouncilHelp;

    public final void setHasRegionalCouncilHelp(final Boolean hasRegionalCouncilHelp) {
        this.hasRegionalCouncilHelp = hasRegionalCouncilHelp;
    }


    /**
     * @hibernate.property
     *  column="has_regional_council_help"
     */
    public final Boolean getHasRegionalCouncilHelp() {
        return this.hasRegionalCouncilHelp;
    }

    private fr.cg95.cvq.business.request.school.CurrentStudiesLevelType currentStudiesLevel;

    public final void setCurrentStudiesLevel(final fr.cg95.cvq.business.request.school.CurrentStudiesLevelType currentStudiesLevel) {
        this.currentStudiesLevel = currentStudiesLevel;
    }


    /**
     * @hibernate.property
     *  column="current_studies_level"
     */
    public final fr.cg95.cvq.business.request.school.CurrentStudiesLevelType getCurrentStudiesLevel() {
        return this.currentStudiesLevel;
    }

    private String currentSchoolPostalCode;

    public final void setCurrentSchoolPostalCode(final String currentSchoolPostalCode) {
        this.currentSchoolPostalCode = currentSchoolPostalCode;
    }


    /**
     * @hibernate.property
     *  column="current_school_postal_code"
     *  length="5"
     */
    public final String getCurrentSchoolPostalCode() {
        return this.currentSchoolPostalCode;
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

    private String accountNumber;

    public final void setAccountNumber(final String accountNumber) {
        this.accountNumber = accountNumber;
    }


    /**
     * @hibernate.property
     *  column="account_number"
     *  length="11"
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

    private fr.cg95.cvq.business.request.school.ALevelsType alevels;

    public final void setAlevels(final fr.cg95.cvq.business.request.school.ALevelsType alevels) {
        this.alevels = alevels;
    }


    /**
     * @hibernate.property
     *  column="alevels"
     */
    public final fr.cg95.cvq.business.request.school.ALevelsType getAlevels() {
        return this.alevels;
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

    private fr.cg95.cvq.business.users.CountryType currentSchoolCountry;

    public final void setCurrentSchoolCountry(final fr.cg95.cvq.business.users.CountryType currentSchoolCountry) {
        this.currentSchoolCountry = currentSchoolCountry;
    }


    /**
     * @hibernate.property
     *  column="current_school_country"
     */
    public final fr.cg95.cvq.business.users.CountryType getCurrentSchoolCountry() {
        return this.currentSchoolCountry;
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

    private Boolean hasEuropeHelp;

    public final void setHasEuropeHelp(final Boolean hasEuropeHelp) {
        this.hasEuropeHelp = hasEuropeHelp;
    }


    /**
     * @hibernate.property
     *  column="has_europe_help"
     */
    public final Boolean getHasEuropeHelp() {
        return this.hasEuropeHelp;
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

    private String bankCode;

    public final void setBankCode(final String bankCode) {
        this.bankCode = bankCode;
    }


    /**
     * @hibernate.property
     *  column="bank_code"
     *  length="5"
     */
    public final String getBankCode() {
        return this.bankCode;
    }

    private Boolean sandwichCourses;

    public final void setSandwichCourses(final Boolean sandwichCourses) {
        this.sandwichCourses = sandwichCourses;
    }


    /**
     * @hibernate.property
     *  column="sandwich_courses"
     */
    public final Boolean getSandwichCourses() {
        return this.sandwichCourses;
    }

    private Boolean abroadInternship;

    public final void setAbroadInternship(final Boolean abroadInternship) {
        this.abroadInternship = abroadInternship;
    }


    /**
     * @hibernate.property
     *  column="abroad_internship"
     */
    public final Boolean getAbroadInternship() {
        return this.abroadInternship;
    }

}
