package fr.cg95.cvq.business.military;

import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.military.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="military_census_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class MilitaryCensusRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public MilitaryCensusRequest() {
        super();
        statePupil = Boolean.valueOf(false);
        prefectPupil = Boolean.valueOf(false);
        childDiploma = fr.cg95.cvq.business.military.ChildDiplomaType.UNKNOWN;
        childResidenceCountry = fr.cg95.cvq.business.users.CountryType.FR;
        childCountry = fr.cg95.cvq.business.users.FullNationalityType.FR;
        motherNationality = fr.cg95.cvq.business.users.FullNationalityType.FR;
        affectionOrDisease = Boolean.valueOf(false);
        childStatus = fr.cg95.cvq.business.users.FamilyStatusType.OTHER;
        childTitle = fr.cg95.cvq.business.users.TitleType.UNKNOWN;
        childSituation = fr.cg95.cvq.business.military.ChildSituationType.UNKNOWN;
        childBirthCountry = fr.cg95.cvq.business.users.CountryType.FR;
        japdExemption = Boolean.valueOf(false);
        highlyInfirm = Boolean.valueOf(false);
    }


    public final String modelToXmlString() {

        MilitaryCensusRequestDocument object = (MilitaryCensusRequestDocument) this.modelToXml();
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
        MilitaryCensusRequestDocument militaryCensusRequestDoc = MilitaryCensusRequestDocument.Factory.newInstance();
        MilitaryCensusRequestDocument.MilitaryCensusRequest militaryCensusRequest = militaryCensusRequestDoc.addNewMilitaryCensusRequest();
        super.fillCommonXmlInfo(militaryCensusRequest);
        if (this.fatherBirthCountry != null)
            militaryCensusRequest.setFatherBirthCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(this.fatherBirthCountry.toString()));
        militaryCensusRequest.setMotherFirstName(this.motherFirstName);
        if (this.statePupil != null)
            militaryCensusRequest.setStatePupil(this.statePupil.booleanValue());
        militaryCensusRequest.setOtherSituation(this.otherSituation);
        if (this.motherBirthCountry != null)
            militaryCensusRequest.setMotherBirthCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(this.motherBirthCountry.toString()));
        if (this.aliveChildren != null)
            militaryCensusRequest.setAliveChildren(new BigInteger(this.aliveChildren.toString()));
        militaryCensusRequest.setFatherFirstName(this.fatherFirstName);
        militaryCensusRequest.setMaidenName(this.maidenName);
        militaryCensusRequest.setFatherBirthCity(this.fatherBirthCity);
        militaryCensusRequest.setMotherBirthCity(this.motherBirthCity);
        militaryCensusRequest.setChildSpeciality(this.childSpeciality);
        if (this.prefectPupil != null)
            militaryCensusRequest.setPrefectPupil(this.prefectPupil.booleanValue());
        if (this.childDiploma != null)
            militaryCensusRequest.setChildDiploma(fr.cg95.cvq.xml.military.ChildDiplomaType.Enum.forString(this.childDiploma.toString()));
        if (this.childResidenceCountry != null)
            militaryCensusRequest.setChildResidenceCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(this.childResidenceCountry.toString()));
        if (this.fatherNationality != null)
            militaryCensusRequest.setFatherNationality(fr.cg95.cvq.xml.common.FullNationalityType.Enum.forString(this.fatherNationality.toString()));
        if (this.childCountry != null)
            militaryCensusRequest.setChildCountry(fr.cg95.cvq.xml.common.FullNationalityType.Enum.forString(this.childCountry.toString()));
        if (this.fatherBirthDepartment != null)
            militaryCensusRequest.setFatherBirthDepartment(fr.cg95.cvq.xml.common.InseeDepartementCodeType.Enum.forString(this.fatherBirthDepartment.toString()));
        if (this.motherNationality != null)
            militaryCensusRequest.setMotherNationality(fr.cg95.cvq.xml.common.FullNationalityType.Enum.forString(this.motherNationality.toString()));
        if (this.affectionOrDisease != null)
            militaryCensusRequest.setAffectionOrDisease(this.affectionOrDisease.booleanValue());
        if (this.childStatus != null)
            militaryCensusRequest.setChildStatus(fr.cg95.cvq.xml.common.FamilyStatusType.Enum.forString(this.childStatus.toString()));
        date = this.motherBirthDate;
        if (date != null) {
            calendar.setTime(date);
            militaryCensusRequest.setMotherBirthDate(calendar);
        }
        if (this.childrenInCharge != null)
            militaryCensusRequest.setChildrenInCharge(new BigInteger(this.childrenInCharge.toString()));
        militaryCensusRequest.setMotherLastName(this.motherLastName);
        if (this.childTitle != null)
            militaryCensusRequest.setChildTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(this.childTitle.toString()));
        date = this.fatherBirthDate;
        if (date != null) {
            calendar.setTime(date);
            militaryCensusRequest.setFatherBirthDate(calendar);
        }
        militaryCensusRequest.setChildConvention(this.childConvention);
        militaryCensusRequest.setChildMail(this.childMail);
        if (this.motherBirthDepartment != null)
            militaryCensusRequest.setMotherBirthDepartment(fr.cg95.cvq.xml.common.InseeDepartementCodeType.Enum.forString(this.motherBirthDepartment.toString()));
        if (this.childSituation != null)
            militaryCensusRequest.setChildSituation(fr.cg95.cvq.xml.military.ChildSituationType.Enum.forString(this.childSituation.toString()));
        if (this.childOtherCountry != null)
            militaryCensusRequest.setChildOtherCountry(fr.cg95.cvq.xml.common.FullNationalityType.Enum.forString(this.childOtherCountry.toString()));
        militaryCensusRequest.setFatherLastName(this.fatherLastName);
        militaryCensusRequest.setChildProfession(this.childProfession);
        if (this.childBirthCountry != null)
            militaryCensusRequest.setChildBirthCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(this.childBirthCountry.toString()));
        if (this.japdExemption != null)
            militaryCensusRequest.setJapdExemption(this.japdExemption.booleanValue());
        if (this.highlyInfirm != null)
            militaryCensusRequest.setHighlyInfirm(this.highlyInfirm.booleanValue());
        if (this.prefectPupilDepartment != null)
            militaryCensusRequest.setPrefectPupilDepartment(fr.cg95.cvq.xml.common.InseeDepartementCodeType.Enum.forString(this.prefectPupilDepartment.toString()));
        militaryCensusRequest.setChildPhone(this.childPhone);
        return militaryCensusRequestDoc;
    }

    public static MilitaryCensusRequest xmlToModel(MilitaryCensusRequestDocument militaryCensusRequestDoc) {

        MilitaryCensusRequestDocument.MilitaryCensusRequest militaryCensusRequestXml = militaryCensusRequestDoc.getMilitaryCensusRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        MilitaryCensusRequest militaryCensusRequest = new MilitaryCensusRequest();
        militaryCensusRequest.fillCommonModelInfo(militaryCensusRequest,militaryCensusRequestXml);
        if (militaryCensusRequestXml.getFatherBirthCountry() != null)
            militaryCensusRequest.setFatherBirthCountry(fr.cg95.cvq.business.users.CountryType.forString(militaryCensusRequestXml.getFatherBirthCountry().toString()));
        else
            militaryCensusRequest.setFatherBirthCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
        militaryCensusRequest.setMotherFirstName(militaryCensusRequestXml.getMotherFirstName());
        militaryCensusRequest.setStatePupil(Boolean.valueOf(militaryCensusRequestXml.getStatePupil()));
        militaryCensusRequest.setOtherSituation(militaryCensusRequestXml.getOtherSituation());
        if (militaryCensusRequestXml.getMotherBirthCountry() != null)
            militaryCensusRequest.setMotherBirthCountry(fr.cg95.cvq.business.users.CountryType.forString(militaryCensusRequestXml.getMotherBirthCountry().toString()));
        else
            militaryCensusRequest.setMotherBirthCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
        militaryCensusRequest.setAliveChildren(militaryCensusRequestXml.getAliveChildren());
        militaryCensusRequest.setFatherFirstName(militaryCensusRequestXml.getFatherFirstName());
        militaryCensusRequest.setMaidenName(militaryCensusRequestXml.getMaidenName());
        militaryCensusRequest.setFatherBirthCity(militaryCensusRequestXml.getFatherBirthCity());
        militaryCensusRequest.setMotherBirthCity(militaryCensusRequestXml.getMotherBirthCity());
        militaryCensusRequest.setChildSpeciality(militaryCensusRequestXml.getChildSpeciality());
        militaryCensusRequest.setPrefectPupil(Boolean.valueOf(militaryCensusRequestXml.getPrefectPupil()));
        if (militaryCensusRequestXml.getChildDiploma() != null)
            militaryCensusRequest.setChildDiploma(fr.cg95.cvq.business.military.ChildDiplomaType.forString(militaryCensusRequestXml.getChildDiploma().toString()));
        else
            militaryCensusRequest.setChildDiploma(fr.cg95.cvq.business.military.ChildDiplomaType.getDefaultChildDiplomaType());
        if (militaryCensusRequestXml.getChildResidenceCountry() != null)
            militaryCensusRequest.setChildResidenceCountry(fr.cg95.cvq.business.users.CountryType.forString(militaryCensusRequestXml.getChildResidenceCountry().toString()));
        else
            militaryCensusRequest.setChildResidenceCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
        if (militaryCensusRequestXml.getFatherNationality() != null)
            militaryCensusRequest.setFatherNationality(fr.cg95.cvq.business.users.FullNationalityType.forString(militaryCensusRequestXml.getFatherNationality().toString()));
        else
            militaryCensusRequest.setFatherNationality(fr.cg95.cvq.business.users.FullNationalityType.getDefaultFullNationalityType());
        if (militaryCensusRequestXml.getChildCountry() != null)
            militaryCensusRequest.setChildCountry(fr.cg95.cvq.business.users.FullNationalityType.forString(militaryCensusRequestXml.getChildCountry().toString()));
        else
            militaryCensusRequest.setChildCountry(fr.cg95.cvq.business.users.FullNationalityType.getDefaultFullNationalityType());
        if (militaryCensusRequestXml.getFatherBirthDepartment() != null)
            militaryCensusRequest.setFatherBirthDepartment(fr.cg95.cvq.business.users.InseeDepartementCodeType.forString(militaryCensusRequestXml.getFatherBirthDepartment().toString()));
        else
            militaryCensusRequest.setFatherBirthDepartment(fr.cg95.cvq.business.users.InseeDepartementCodeType.getDefaultInseeDepartementCodeType());
        if (militaryCensusRequestXml.getMotherNationality() != null)
            militaryCensusRequest.setMotherNationality(fr.cg95.cvq.business.users.FullNationalityType.forString(militaryCensusRequestXml.getMotherNationality().toString()));
        else
            militaryCensusRequest.setMotherNationality(fr.cg95.cvq.business.users.FullNationalityType.getDefaultFullNationalityType());
        militaryCensusRequest.setAffectionOrDisease(Boolean.valueOf(militaryCensusRequestXml.getAffectionOrDisease()));
        if (militaryCensusRequestXml.getChildStatus() != null)
            militaryCensusRequest.setChildStatus(fr.cg95.cvq.business.users.FamilyStatusType.forString(militaryCensusRequestXml.getChildStatus().toString()));
        else
            militaryCensusRequest.setChildStatus(fr.cg95.cvq.business.users.FamilyStatusType.getDefaultFamilyStatusType());
        calendar = militaryCensusRequestXml.getMotherBirthDate();
        if (calendar != null) {
            militaryCensusRequest.setMotherBirthDate(calendar.getTime());
        }
        militaryCensusRequest.setChildrenInCharge(militaryCensusRequestXml.getChildrenInCharge());
        militaryCensusRequest.setMotherLastName(militaryCensusRequestXml.getMotherLastName());
        if (militaryCensusRequestXml.getChildTitle() != null)
            militaryCensusRequest.setChildTitle(fr.cg95.cvq.business.users.TitleType.forString(militaryCensusRequestXml.getChildTitle().toString()));
        else
            militaryCensusRequest.setChildTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
        calendar = militaryCensusRequestXml.getFatherBirthDate();
        if (calendar != null) {
            militaryCensusRequest.setFatherBirthDate(calendar.getTime());
        }
        militaryCensusRequest.setChildConvention(militaryCensusRequestXml.getChildConvention());
        militaryCensusRequest.setChildMail(militaryCensusRequestXml.getChildMail());
        if (militaryCensusRequestXml.getMotherBirthDepartment() != null)
            militaryCensusRequest.setMotherBirthDepartment(fr.cg95.cvq.business.users.InseeDepartementCodeType.forString(militaryCensusRequestXml.getMotherBirthDepartment().toString()));
        else
            militaryCensusRequest.setMotherBirthDepartment(fr.cg95.cvq.business.users.InseeDepartementCodeType.getDefaultInseeDepartementCodeType());
        if (militaryCensusRequestXml.getChildSituation() != null)
            militaryCensusRequest.setChildSituation(fr.cg95.cvq.business.military.ChildSituationType.forString(militaryCensusRequestXml.getChildSituation().toString()));
        else
            militaryCensusRequest.setChildSituation(fr.cg95.cvq.business.military.ChildSituationType.getDefaultChildSituationType());
        if (militaryCensusRequestXml.getChildOtherCountry() != null)
            militaryCensusRequest.setChildOtherCountry(fr.cg95.cvq.business.users.FullNationalityType.forString(militaryCensusRequestXml.getChildOtherCountry().toString()));
        else
            militaryCensusRequest.setChildOtherCountry(fr.cg95.cvq.business.users.FullNationalityType.getDefaultFullNationalityType());
        militaryCensusRequest.setFatherLastName(militaryCensusRequestXml.getFatherLastName());
        militaryCensusRequest.setChildProfession(militaryCensusRequestXml.getChildProfession());
        if (militaryCensusRequestXml.getChildBirthCountry() != null)
            militaryCensusRequest.setChildBirthCountry(fr.cg95.cvq.business.users.CountryType.forString(militaryCensusRequestXml.getChildBirthCountry().toString()));
        else
            militaryCensusRequest.setChildBirthCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
        militaryCensusRequest.setJapdExemption(Boolean.valueOf(militaryCensusRequestXml.getJapdExemption()));
        militaryCensusRequest.setHighlyInfirm(Boolean.valueOf(militaryCensusRequestXml.getHighlyInfirm()));
        if (militaryCensusRequestXml.getPrefectPupilDepartment() != null)
            militaryCensusRequest.setPrefectPupilDepartment(fr.cg95.cvq.business.users.InseeDepartementCodeType.forString(militaryCensusRequestXml.getPrefectPupilDepartment().toString()));
        else
            militaryCensusRequest.setPrefectPupilDepartment(fr.cg95.cvq.business.users.InseeDepartementCodeType.getDefaultInseeDepartementCodeType());
        militaryCensusRequest.setChildPhone(militaryCensusRequestXml.getChildPhone());
        return militaryCensusRequest;
    }

    private fr.cg95.cvq.business.users.CountryType fatherBirthCountry;

    public final void setFatherBirthCountry(final fr.cg95.cvq.business.users.CountryType fatherBirthCountry) {
        this.fatherBirthCountry = fatherBirthCountry;
    }


    /**
     * @hibernate.property
     *  column="father_birth_country"
     */
    public final fr.cg95.cvq.business.users.CountryType getFatherBirthCountry() {
        return this.fatherBirthCountry;
    }

    private String motherFirstName;

    public final void setMotherFirstName(final String motherFirstName) {
        this.motherFirstName = motherFirstName;
    }


    /**
     * @hibernate.property
     *  column="mother_first_name"
     *  length="38"
     */
    public final String getMotherFirstName() {
        return this.motherFirstName;
    }

    private Boolean statePupil;

    public final void setStatePupil(final Boolean statePupil) {
        this.statePupil = statePupil;
    }


    /**
     * @hibernate.property
     *  column="state_pupil"
     */
    public final Boolean getStatePupil() {
        return this.statePupil;
    }

    private String otherSituation;

    public final void setOtherSituation(final String otherSituation) {
        this.otherSituation = otherSituation;
    }


    /**
     * @hibernate.property
     *  column="other_situation"
     */
    public final String getOtherSituation() {
        return this.otherSituation;
    }

    private fr.cg95.cvq.business.users.CountryType motherBirthCountry;

    public final void setMotherBirthCountry(final fr.cg95.cvq.business.users.CountryType motherBirthCountry) {
        this.motherBirthCountry = motherBirthCountry;
    }


    /**
     * @hibernate.property
     *  column="mother_birth_country"
     */
    public final fr.cg95.cvq.business.users.CountryType getMotherBirthCountry() {
        return this.motherBirthCountry;
    }

    private java.math.BigInteger aliveChildren;

    public final void setAliveChildren(final java.math.BigInteger aliveChildren) {
        this.aliveChildren = aliveChildren;
    }


    /**
     * @hibernate.property
     *  column="alive_children"
     *  type="serializable"
     */
    public final java.math.BigInteger getAliveChildren() {
        return this.aliveChildren;
    }

    private String fatherFirstName;

    public final void setFatherFirstName(final String fatherFirstName) {
        this.fatherFirstName = fatherFirstName;
    }


    /**
     * @hibernate.property
     *  column="father_first_name"
     *  length="38"
     */
    public final String getFatherFirstName() {
        return this.fatherFirstName;
    }

    private String maidenName;

    public final void setMaidenName(final String maidenName) {
        this.maidenName = maidenName;
    }


    /**
     * @hibernate.property
     *  column="maiden_name"
     *  length="38"
     */
    public final String getMaidenName() {
        return this.maidenName;
    }

    private String fatherBirthCity;

    public final void setFatherBirthCity(final String fatherBirthCity) {
        this.fatherBirthCity = fatherBirthCity;
    }


    /**
     * @hibernate.property
     *  column="father_birth_city"
     */
    public final String getFatherBirthCity() {
        return this.fatherBirthCity;
    }

    private String motherBirthCity;

    public final void setMotherBirthCity(final String motherBirthCity) {
        this.motherBirthCity = motherBirthCity;
    }


    /**
     * @hibernate.property
     *  column="mother_birth_city"
     */
    public final String getMotherBirthCity() {
        return this.motherBirthCity;
    }

    private String childSpeciality;

    public final void setChildSpeciality(final String childSpeciality) {
        this.childSpeciality = childSpeciality;
    }


    /**
     * @hibernate.property
     *  column="child_speciality"
     */
    public final String getChildSpeciality() {
        return this.childSpeciality;
    }

    private Boolean prefectPupil;

    public final void setPrefectPupil(final Boolean prefectPupil) {
        this.prefectPupil = prefectPupil;
    }


    /**
     * @hibernate.property
     *  column="prefect_pupil"
     */
    public final Boolean getPrefectPupil() {
        return this.prefectPupil;
    }

    private fr.cg95.cvq.business.military.ChildDiplomaType childDiploma;

    public final void setChildDiploma(final fr.cg95.cvq.business.military.ChildDiplomaType childDiploma) {
        this.childDiploma = childDiploma;
    }


    /**
     * @hibernate.property
     *  column="child_diploma"
     */
    public final fr.cg95.cvq.business.military.ChildDiplomaType getChildDiploma() {
        return this.childDiploma;
    }

    private fr.cg95.cvq.business.users.CountryType childResidenceCountry;

    public final void setChildResidenceCountry(final fr.cg95.cvq.business.users.CountryType childResidenceCountry) {
        this.childResidenceCountry = childResidenceCountry;
    }


    /**
     * @hibernate.property
     *  column="child_residence_country"
     */
    public final fr.cg95.cvq.business.users.CountryType getChildResidenceCountry() {
        return this.childResidenceCountry;
    }

    private fr.cg95.cvq.business.users.FullNationalityType fatherNationality;

    public final void setFatherNationality(final fr.cg95.cvq.business.users.FullNationalityType fatherNationality) {
        this.fatherNationality = fatherNationality;
    }


    /**
     * @hibernate.property
     *  column="father_nationality"
     */
    public final fr.cg95.cvq.business.users.FullNationalityType getFatherNationality() {
        return this.fatherNationality;
    }

    private fr.cg95.cvq.business.users.FullNationalityType childCountry;

    public final void setChildCountry(final fr.cg95.cvq.business.users.FullNationalityType childCountry) {
        this.childCountry = childCountry;
    }


    /**
     * @hibernate.property
     *  column="child_country"
     */
    public final fr.cg95.cvq.business.users.FullNationalityType getChildCountry() {
        return this.childCountry;
    }

    private fr.cg95.cvq.business.users.InseeDepartementCodeType fatherBirthDepartment;

    public final void setFatherBirthDepartment(final fr.cg95.cvq.business.users.InseeDepartementCodeType fatherBirthDepartment) {
        this.fatherBirthDepartment = fatherBirthDepartment;
    }


    /**
     * @hibernate.property
     *  column="father_birth_department"
     */
    public final fr.cg95.cvq.business.users.InseeDepartementCodeType getFatherBirthDepartment() {
        return this.fatherBirthDepartment;
    }

    private fr.cg95.cvq.business.users.FullNationalityType motherNationality;

    public final void setMotherNationality(final fr.cg95.cvq.business.users.FullNationalityType motherNationality) {
        this.motherNationality = motherNationality;
    }


    /**
     * @hibernate.property
     *  column="mother_nationality"
     */
    public final fr.cg95.cvq.business.users.FullNationalityType getMotherNationality() {
        return this.motherNationality;
    }

    private Boolean affectionOrDisease;

    public final void setAffectionOrDisease(final Boolean affectionOrDisease) {
        this.affectionOrDisease = affectionOrDisease;
    }


    /**
     * @hibernate.property
     *  column="affection_or_disease"
     */
    public final Boolean getAffectionOrDisease() {
        return this.affectionOrDisease;
    }

    private fr.cg95.cvq.business.users.FamilyStatusType childStatus;

    public final void setChildStatus(final fr.cg95.cvq.business.users.FamilyStatusType childStatus) {
        this.childStatus = childStatus;
    }


    /**
     * @hibernate.property
     *  column="child_status"
     */
    public final fr.cg95.cvq.business.users.FamilyStatusType getChildStatus() {
        return this.childStatus;
    }

    private java.util.Date motherBirthDate;

    public final void setMotherBirthDate(final java.util.Date motherBirthDate) {
        this.motherBirthDate = motherBirthDate;
    }


    /**
     * @hibernate.property
     *  column="mother_birth_date"
     */
    public final java.util.Date getMotherBirthDate() {
        return this.motherBirthDate;
    }

    private java.math.BigInteger childrenInCharge;

    public final void setChildrenInCharge(final java.math.BigInteger childrenInCharge) {
        this.childrenInCharge = childrenInCharge;
    }


    /**
     * @hibernate.property
     *  column="children_in_charge"
     *  type="serializable"
     */
    public final java.math.BigInteger getChildrenInCharge() {
        return this.childrenInCharge;
    }

    private String motherLastName;

    public final void setMotherLastName(final String motherLastName) {
        this.motherLastName = motherLastName;
    }


    /**
     * @hibernate.property
     *  column="mother_last_name"
     *  length="38"
     */
    public final String getMotherLastName() {
        return this.motherLastName;
    }

    private fr.cg95.cvq.business.users.TitleType childTitle;

    public final void setChildTitle(final fr.cg95.cvq.business.users.TitleType childTitle) {
        this.childTitle = childTitle;
    }


    /**
     * @hibernate.property
     *  column="child_title"
     */
    public final fr.cg95.cvq.business.users.TitleType getChildTitle() {
        return this.childTitle;
    }

    private java.util.Date fatherBirthDate;

    public final void setFatherBirthDate(final java.util.Date fatherBirthDate) {
        this.fatherBirthDate = fatherBirthDate;
    }


    /**
     * @hibernate.property
     *  column="father_birth_date"
     */
    public final java.util.Date getFatherBirthDate() {
        return this.fatherBirthDate;
    }

    private String childConvention;

    public final void setChildConvention(final String childConvention) {
        this.childConvention = childConvention;
    }


    /**
     * @hibernate.property
     *  column="child_convention"
     */
    public final String getChildConvention() {
        return this.childConvention;
    }

    private String childMail;

    public final void setChildMail(final String childMail) {
        this.childMail = childMail;
    }


    /**
     * @hibernate.property
     *  column="child_mail"
     */
    public final String getChildMail() {
        return this.childMail;
    }

    private fr.cg95.cvq.business.users.InseeDepartementCodeType motherBirthDepartment;

    public final void setMotherBirthDepartment(final fr.cg95.cvq.business.users.InseeDepartementCodeType motherBirthDepartment) {
        this.motherBirthDepartment = motherBirthDepartment;
    }


    /**
     * @hibernate.property
     *  column="mother_birth_department"
     */
    public final fr.cg95.cvq.business.users.InseeDepartementCodeType getMotherBirthDepartment() {
        return this.motherBirthDepartment;
    }

    private fr.cg95.cvq.business.military.ChildSituationType childSituation;

    public final void setChildSituation(final fr.cg95.cvq.business.military.ChildSituationType childSituation) {
        this.childSituation = childSituation;
    }


    /**
     * @hibernate.property
     *  column="child_situation"
     */
    public final fr.cg95.cvq.business.military.ChildSituationType getChildSituation() {
        return this.childSituation;
    }

    private fr.cg95.cvq.business.users.FullNationalityType childOtherCountry;

    public final void setChildOtherCountry(final fr.cg95.cvq.business.users.FullNationalityType childOtherCountry) {
        this.childOtherCountry = childOtherCountry;
    }


    /**
     * @hibernate.property
     *  column="child_other_country"
     */
    public final fr.cg95.cvq.business.users.FullNationalityType getChildOtherCountry() {
        return this.childOtherCountry;
    }

    private String fatherLastName;

    public final void setFatherLastName(final String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }


    /**
     * @hibernate.property
     *  column="father_last_name"
     *  length="38"
     */
    public final String getFatherLastName() {
        return this.fatherLastName;
    }

    private String childProfession;

    public final void setChildProfession(final String childProfession) {
        this.childProfession = childProfession;
    }


    /**
     * @hibernate.property
     *  column="child_profession"
     */
    public final String getChildProfession() {
        return this.childProfession;
    }

    private fr.cg95.cvq.business.users.CountryType childBirthCountry;

    public final void setChildBirthCountry(final fr.cg95.cvq.business.users.CountryType childBirthCountry) {
        this.childBirthCountry = childBirthCountry;
    }


    /**
     * @hibernate.property
     *  column="child_birth_country"
     */
    public final fr.cg95.cvq.business.users.CountryType getChildBirthCountry() {
        return this.childBirthCountry;
    }

    private Boolean japdExemption;

    public final void setJapdExemption(final Boolean japdExemption) {
        this.japdExemption = japdExemption;
    }


    /**
     * @hibernate.property
     *  column="japd_exemption"
     */
    public final Boolean getJapdExemption() {
        return this.japdExemption;
    }

    private Boolean highlyInfirm;

    public final void setHighlyInfirm(final Boolean highlyInfirm) {
        this.highlyInfirm = highlyInfirm;
    }


    /**
     * @hibernate.property
     *  column="highly_infirm"
     */
    public final Boolean getHighlyInfirm() {
        return this.highlyInfirm;
    }

    private fr.cg95.cvq.business.users.InseeDepartementCodeType prefectPupilDepartment;

    public final void setPrefectPupilDepartment(final fr.cg95.cvq.business.users.InseeDepartementCodeType prefectPupilDepartment) {
        this.prefectPupilDepartment = prefectPupilDepartment;
    }


    /**
     * @hibernate.property
     *  column="prefect_pupil_department"
     */
    public final fr.cg95.cvq.business.users.InseeDepartementCodeType getPrefectPupilDepartment() {
        return this.prefectPupilDepartment;
    }

    private String childPhone;

    public final void setChildPhone(final String childPhone) {
        this.childPhone = childPhone;
    }


    /**
     * @hibernate.property
     *  column="child_phone"
     *  length="10"
     */
    public final String getChildPhone() {
        return this.childPhone;
    }

}
