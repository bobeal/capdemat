
package fr.cg95.cvq.business.request.military;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="military_census_request"
 *  lazy="false"
 */
public class MilitaryCensusRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public MilitaryCensusRequestData() {
      
        childStatus = fr.cg95.cvq.business.users.FamilyStatusType.OTHER;
      
        affectionOrDisease = Boolean.valueOf(false);
      
        statePupil = Boolean.valueOf(false);
      
        childBirthCountry = fr.cg95.cvq.business.users.CountryType.FR;
      
        motherNationality = fr.cg95.cvq.business.users.FullNationalityType.FR;
      
        highlyInfirm = Boolean.valueOf(false);
      
        japdExemption = Boolean.valueOf(false);
      
        childResidenceCountry = fr.cg95.cvq.business.users.CountryType.FR;
      
        prefectPupil = Boolean.valueOf(false);
      
        childCountry = fr.cg95.cvq.business.users.FullNationalityType.FR;
      
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * @hibernate.id
     *  column="id"
     *  generator-class="sequence"
     */
    public final Long getId() {
        return this.id;
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
  
    private fr.cg95.cvq.business.request.military.ChildDiplomaType childDiploma;

    public final void setChildDiploma(final fr.cg95.cvq.business.request.military.ChildDiplomaType childDiploma) {
        this.childDiploma = childDiploma;
    }

    /**
 
        * @hibernate.property
        *  column="child_diploma"
        
      
    */
    public final fr.cg95.cvq.business.request.military.ChildDiplomaType getChildDiploma() {
        return this.childDiploma;
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
  
    private fr.cg95.cvq.business.request.military.ChildSituationType childSituation;

    public final void setChildSituation(final fr.cg95.cvq.business.request.military.ChildSituationType childSituation) {
        this.childSituation = childSituation;
    }

    /**
 
        * @hibernate.property
        *  column="child_situation"
        
      
    */
    public final fr.cg95.cvq.business.request.military.ChildSituationType getChildSituation() {
        return this.childSituation;
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
  
}
