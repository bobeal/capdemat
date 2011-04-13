

package fr.cg95.cvq.business.request.military;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.oval.constraint.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

import javax.persistence.*;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

/**
 * Generated class file, do not edit !
 */
@Entity
@Table(name="military_census_request")
public class MilitaryCensusRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public MilitaryCensusRequestData() {
      
        affectionOrDisease = Boolean.valueOf(false);
      
        childBirthCountry = fr.cg95.cvq.business.users.CountryType.FR;
      
        childCountry = fr.cg95.cvq.business.users.FullNationalityType.FR;
      
        childResidenceCountry = fr.cg95.cvq.business.users.CountryType.FR;
      
        childStatus = fr.cg95.cvq.business.users.FamilyStatusType.OTHER;
      
        highlyInfirm = Boolean.valueOf(false);
      
        japdExemption = Boolean.valueOf(false);
      
        motherNationality = fr.cg95.cvq.business.users.FullNationalityType.FR;
      
        prefectPupil = Boolean.valueOf(false);
      
        statePupil = Boolean.valueOf(false);
      
    }

    @Override
    public MilitaryCensusRequestData clone() {
        MilitaryCensusRequestData result = new MilitaryCensusRequestData();
        
          
            
        result.setAffectionOrDisease(affectionOrDisease);
      
          
        
          
            
        result.setAliveChildren(aliveChildren);
      
          
        
          
            
        if (childBirthCountry != null)
            result.setChildBirthCountry(childBirthCountry);
        else
            result.setChildBirthCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
          
        
          
            
        result.setChildConvention(childConvention);
      
          
        
          
            
        if (childCountry != null)
            result.setChildCountry(childCountry);
        else
            result.setChildCountry(fr.cg95.cvq.business.users.FullNationalityType.getDefaultFullNationalityType());
      
          
        
          
            
        if (childDiploma != null)
            result.setChildDiploma(childDiploma);
        else
            result.setChildDiploma(fr.cg95.cvq.business.request.military.ChildDiplomaType.getDefaultChildDiplomaType());
      
          
        
          
            
        result.setChildMail(childMail);
      
          
        
          
            
        if (childOtherCountry != null)
            result.setChildOtherCountry(childOtherCountry);
        else
            result.setChildOtherCountry(fr.cg95.cvq.business.users.FullNationalityType.getDefaultFullNationalityType());
      
          
        
          
            
        result.setChildPhone(childPhone);
      
          
        
          
            
        result.setChildProfession(childProfession);
      
          
        
          
            
        if (childResidenceCountry != null)
            result.setChildResidenceCountry(childResidenceCountry);
        else
            result.setChildResidenceCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
          
        
          
            
        if (childSituation != null)
            result.setChildSituation(childSituation);
        else
            result.setChildSituation(fr.cg95.cvq.business.request.military.ChildSituationType.getDefaultChildSituationType());
      
          
        
          
            
        result.setChildSpeciality(childSpeciality);
      
          
        
          
            
        if (childStatus != null)
            result.setChildStatus(childStatus);
        else
            result.setChildStatus(fr.cg95.cvq.business.users.FamilyStatusType.getDefaultFamilyStatusType());
      
          
        
          
            
        if (childTitle != null)
            result.setChildTitle(childTitle);
        else
            result.setChildTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
          
        
          
            
        result.setChildrenInCharge(childrenInCharge);
      
          
        
          
            
        result.setFatherBirthCity(fatherBirthCity);
      
          
        
          
            
        if (fatherBirthCountry != null)
            result.setFatherBirthCountry(fatherBirthCountry);
        else
            result.setFatherBirthCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
          
        
          
            
        result.setFatherBirthDate(fatherBirthDate);
      
          
        
          
            
        if (fatherBirthDepartment != null)
            result.setFatherBirthDepartment(fatherBirthDepartment);
        else
            result.setFatherBirthDepartment(fr.cg95.cvq.business.users.InseeDepartementCodeType.getDefaultInseeDepartementCodeType());
      
          
        
          
            
        result.setFatherFirstName(fatherFirstName);
      
          
        
          
            
        result.setFatherLastName(fatherLastName);
      
          
        
          
            
        if (fatherNationality != null)
            result.setFatherNationality(fatherNationality);
        else
            result.setFatherNationality(fr.cg95.cvq.business.users.FullNationalityType.getDefaultFullNationalityType());
      
          
        
          
            
        result.setHighlyInfirm(highlyInfirm);
      
          
        
          
            
        result.setJapdExemption(japdExemption);
      
          
        
          
            
        result.setMaidenName(maidenName);
      
          
        
          
            
        result.setMotherBirthCity(motherBirthCity);
      
          
        
          
            
        if (motherBirthCountry != null)
            result.setMotherBirthCountry(motherBirthCountry);
        else
            result.setMotherBirthCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
          
        
          
            
        result.setMotherBirthDate(motherBirthDate);
      
          
        
          
            
        if (motherBirthDepartment != null)
            result.setMotherBirthDepartment(motherBirthDepartment);
        else
            result.setMotherBirthDepartment(fr.cg95.cvq.business.users.InseeDepartementCodeType.getDefaultInseeDepartementCodeType());
      
          
        
          
            
        result.setMotherFirstName(motherFirstName);
      
          
        
          
            
        result.setMotherLastName(motherLastName);
      
          
        
          
            
        if (motherNationality != null)
            result.setMotherNationality(motherNationality);
        else
            result.setMotherNationality(fr.cg95.cvq.business.users.FullNationalityType.getDefaultFullNationalityType());
      
          
        
          
            
        result.setOtherSituation(otherSituation);
      
          
        
          
            
        result.setPrefectPupil(prefectPupil);
      
          
        
          
            
        if (prefectPupilDepartment != null)
            result.setPrefectPupilDepartment(prefectPupilDepartment);
        else
            result.setPrefectPupilDepartment(fr.cg95.cvq.business.users.InseeDepartementCodeType.getDefaultInseeDepartementCodeType());
      
          
        
          
            
        result.setStatePupil(statePupil);
      
          
        
        return result;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public final Long getId() {
        return this.id;
    }

  
    
    private Boolean affectionOrDisease;

    public void setAffectionOrDisease(final Boolean affectionOrDisease) {
        this.affectionOrDisease = affectionOrDisease;
    }

 
    @Column(name="affection_or_disease"  )
      
    public Boolean getAffectionOrDisease() {
        return this.affectionOrDisease;
    }
  
    
      @NotNull(
        
        
        profiles = {"situation"},
        message = "aliveChildren"
      )
    
    private java.math.BigInteger aliveChildren;

    public void setAliveChildren(final java.math.BigInteger aliveChildren) {
        this.aliveChildren = aliveChildren;
    }

 
    @Column(name="alive_children" , columnDefinition="bytea" )
    @Type(type="serializable") //Hack see http://capdemat.capwebct.fr/ticket/338
      
    public java.math.BigInteger getAliveChildren() {
        return this.aliveChildren;
    }
  
    
      @NotNull(
        
        
        profiles = {"census"},
        message = "childBirthCountry"
      )
    
    private fr.cg95.cvq.business.users.CountryType childBirthCountry;

    public void setChildBirthCountry(final fr.cg95.cvq.business.users.CountryType childBirthCountry) {
        this.childBirthCountry = childBirthCountry;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="child_birth_country"  )
      
    public fr.cg95.cvq.business.users.CountryType getChildBirthCountry() {
        return this.childBirthCountry;
    }
  
    
      @MaxLength(
        
          value = 255,
        
        
        profiles = {"census"},
        message = "childConvention"
      )
    
      @MatchPattern(
        
          pattern = "^[\\w\\W]{0,255}$",
        
        
        profiles = {"census"},
        message = "childConvention"
      )
    
    private String childConvention;

    public void setChildConvention(final String childConvention) {
        this.childConvention = childConvention;
    }

 
    @Column(name="child_convention" , length=255 )
      
    public String getChildConvention() {
        return this.childConvention;
    }
  
    
      @NotNull(
        
        
        profiles = {"census"},
        message = "childCountry"
      )
    
    private fr.cg95.cvq.business.users.FullNationalityType childCountry;

    public void setChildCountry(final fr.cg95.cvq.business.users.FullNationalityType childCountry) {
        this.childCountry = childCountry;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="child_country"  )
      
    public fr.cg95.cvq.business.users.FullNationalityType getChildCountry() {
        return this.childCountry;
    }
  
    
      @NotNull(
        
        
        profiles = {"situation"},
        message = "childDiploma"
      )
    
    private fr.cg95.cvq.business.request.military.ChildDiplomaType childDiploma;

    public void setChildDiploma(final fr.cg95.cvq.business.request.military.ChildDiplomaType childDiploma) {
        this.childDiploma = childDiploma;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="child_diploma"  )
      
    public fr.cg95.cvq.business.request.military.ChildDiplomaType getChildDiploma() {
        return this.childDiploma;
    }
  
    
    private String childMail;

    public void setChildMail(final String childMail) {
        this.childMail = childMail;
    }

 
    @Column(name="child_mail"  )
      
    public String getChildMail() {
        return this.childMail;
    }
  
    
    private fr.cg95.cvq.business.users.FullNationalityType childOtherCountry;

    public void setChildOtherCountry(final fr.cg95.cvq.business.users.FullNationalityType childOtherCountry) {
        this.childOtherCountry = childOtherCountry;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="child_other_country"  )
      
    public fr.cg95.cvq.business.users.FullNationalityType getChildOtherCountry() {
        return this.childOtherCountry;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"census"},
        message = "childPhone"
      )
    
      @NotNull(
        
        
        profiles = {"census"},
        message = "childPhone"
      )
    
      @NotBlank(
        
        
        profiles = {"census"},
        message = "childPhone"
      )
    
    private String childPhone;

    public void setChildPhone(final String childPhone) {
        this.childPhone = childPhone;
    }

 
    @Column(name="child_phone" , length=10 )
      
    public String getChildPhone() {
        return this.childPhone;
    }
  
    
    private String childProfession;

    public void setChildProfession(final String childProfession) {
        this.childProfession = childProfession;
    }

 
    @Column(name="child_profession"  )
      
    public String getChildProfession() {
        return this.childProfession;
    }
  
    
    private fr.cg95.cvq.business.users.CountryType childResidenceCountry;

    public void setChildResidenceCountry(final fr.cg95.cvq.business.users.CountryType childResidenceCountry) {
        this.childResidenceCountry = childResidenceCountry;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="child_residence_country"  )
      
    public fr.cg95.cvq.business.users.CountryType getChildResidenceCountry() {
        return this.childResidenceCountry;
    }
  
    
      @NotNull(
        
        
        profiles = {"situation"},
        message = "childSituation"
      )
    
    private fr.cg95.cvq.business.request.military.ChildSituationType childSituation;

    public void setChildSituation(final fr.cg95.cvq.business.request.military.ChildSituationType childSituation) {
        this.childSituation = childSituation;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="child_situation"  )
      
    public fr.cg95.cvq.business.request.military.ChildSituationType getChildSituation() {
        return this.childSituation;
    }
  
    
    private String childSpeciality;

    public void setChildSpeciality(final String childSpeciality) {
        this.childSpeciality = childSpeciality;
    }

 
    @Column(name="child_speciality"  )
      
    public String getChildSpeciality() {
        return this.childSpeciality;
    }
  
    
      @NotNull(
        
        
        profiles = {"situation"},
        message = "childStatus"
      )
    
    private fr.cg95.cvq.business.users.FamilyStatusType childStatus;

    public void setChildStatus(final fr.cg95.cvq.business.users.FamilyStatusType childStatus) {
        this.childStatus = childStatus;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="child_status"  )
      
    public fr.cg95.cvq.business.users.FamilyStatusType getChildStatus() {
        return this.childStatus;
    }
  
    
      @NotNull(
        
        
        profiles = {"census"},
        message = "childTitle"
      )
    
    private fr.cg95.cvq.business.users.TitleType childTitle;

    public void setChildTitle(final fr.cg95.cvq.business.users.TitleType childTitle) {
        this.childTitle = childTitle;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="child_title"  )
      
    public fr.cg95.cvq.business.users.TitleType getChildTitle() {
        return this.childTitle;
    }
  
    
      @NotNull(
        
        
        profiles = {"situation"},
        message = "childrenInCharge"
      )
    
    private java.math.BigInteger childrenInCharge;

    public void setChildrenInCharge(final java.math.BigInteger childrenInCharge) {
        this.childrenInCharge = childrenInCharge;
    }

 
    @Column(name="children_in_charge" , columnDefinition="bytea" )
    @Type(type="serializable") //Hack see http://capdemat.capwebct.fr/ticket/338
      
    public java.math.BigInteger getChildrenInCharge() {
        return this.childrenInCharge;
    }
  
    
    private String fatherBirthCity;

    public void setFatherBirthCity(final String fatherBirthCity) {
        this.fatherBirthCity = fatherBirthCity;
    }

 
    @Column(name="father_birth_city"  )
      
    public String getFatherBirthCity() {
        return this.fatherBirthCity;
    }
  
    
    private fr.cg95.cvq.business.users.CountryType fatherBirthCountry;

    public void setFatherBirthCountry(final fr.cg95.cvq.business.users.CountryType fatherBirthCountry) {
        this.fatherBirthCountry = fatherBirthCountry;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="father_birth_country"  )
      
    public fr.cg95.cvq.business.users.CountryType getFatherBirthCountry() {
        return this.fatherBirthCountry;
    }
  
    
    private java.util.Date fatherBirthDate;

    public void setFatherBirthDate(final java.util.Date fatherBirthDate) {
        this.fatherBirthDate = fatherBirthDate;
    }

 
    @Column(name="father_birth_date"  )
      
    public java.util.Date getFatherBirthDate() {
        return this.fatherBirthDate;
    }
  
    
    private fr.cg95.cvq.business.users.InseeDepartementCodeType fatherBirthDepartment;

    public void setFatherBirthDepartment(final fr.cg95.cvq.business.users.InseeDepartementCodeType fatherBirthDepartment) {
        this.fatherBirthDepartment = fatherBirthDepartment;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="father_birth_department"  )
      
    public fr.cg95.cvq.business.users.InseeDepartementCodeType getFatherBirthDepartment() {
        return this.fatherBirthDepartment;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"parentage"},
        message = "fatherFirstName"
      )
    
    private String fatherFirstName;

    public void setFatherFirstName(final String fatherFirstName) {
        this.fatherFirstName = fatherFirstName;
    }

 
    @Column(name="father_first_name" , length=38 )
      
    public String getFatherFirstName() {
        return this.fatherFirstName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"parentage"},
        message = "fatherLastName"
      )
    
    private String fatherLastName;

    public void setFatherLastName(final String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

 
    @Column(name="father_last_name" , length=38 )
      
    public String getFatherLastName() {
        return this.fatherLastName;
    }
  
    
    private fr.cg95.cvq.business.users.FullNationalityType fatherNationality;

    public void setFatherNationality(final fr.cg95.cvq.business.users.FullNationalityType fatherNationality) {
        this.fatherNationality = fatherNationality;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="father_nationality"  )
      
    public fr.cg95.cvq.business.users.FullNationalityType getFatherNationality() {
        return this.fatherNationality;
    }
  
    
    private Boolean highlyInfirm;

    public void setHighlyInfirm(final Boolean highlyInfirm) {
        this.highlyInfirm = highlyInfirm;
    }

 
    @Column(name="highly_infirm"  )
      
    public Boolean getHighlyInfirm() {
        return this.highlyInfirm;
    }
  
    
      @NotNull(
        
        
        profiles = {"exemption"},
        message = "japdExemption"
      )
    
    private Boolean japdExemption;

    public void setJapdExemption(final Boolean japdExemption) {
        this.japdExemption = japdExemption;
    }

 
    @Column(name="japd_exemption"  )
      
    public Boolean getJapdExemption() {
        return this.japdExemption;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"census"},
        message = "maidenName"
      )
    
    private String maidenName;

    public void setMaidenName(final String maidenName) {
        this.maidenName = maidenName;
    }

 
    @Column(name="maiden_name" , length=38 )
      
    public String getMaidenName() {
        return this.maidenName;
    }
  
    
      @NotNull(
        
        
        profiles = {"parentage"},
        message = "motherBirthCity"
      )
    
      @NotBlank(
        
        
        profiles = {"parentage"},
        message = "motherBirthCity"
      )
    
    private String motherBirthCity;

    public void setMotherBirthCity(final String motherBirthCity) {
        this.motherBirthCity = motherBirthCity;
    }

 
    @Column(name="mother_birth_city"  )
      
    public String getMotherBirthCity() {
        return this.motherBirthCity;
    }
  
    
    private fr.cg95.cvq.business.users.CountryType motherBirthCountry;

    public void setMotherBirthCountry(final fr.cg95.cvq.business.users.CountryType motherBirthCountry) {
        this.motherBirthCountry = motherBirthCountry;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="mother_birth_country"  )
      
    public fr.cg95.cvq.business.users.CountryType getMotherBirthCountry() {
        return this.motherBirthCountry;
    }
  
    
      @NotNull(
        
        
        profiles = {"parentage"},
        message = "motherBirthDate"
      )
    
    private java.util.Date motherBirthDate;

    public void setMotherBirthDate(final java.util.Date motherBirthDate) {
        this.motherBirthDate = motherBirthDate;
    }

 
    @Column(name="mother_birth_date"  )
      
    public java.util.Date getMotherBirthDate() {
        return this.motherBirthDate;
    }
  
    
    private fr.cg95.cvq.business.users.InseeDepartementCodeType motherBirthDepartment;

    public void setMotherBirthDepartment(final fr.cg95.cvq.business.users.InseeDepartementCodeType motherBirthDepartment) {
        this.motherBirthDepartment = motherBirthDepartment;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="mother_birth_department"  )
      
    public fr.cg95.cvq.business.users.InseeDepartementCodeType getMotherBirthDepartment() {
        return this.motherBirthDepartment;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"parentage"},
        message = "motherFirstName"
      )
    
      @NotNull(
        
        
        profiles = {"parentage"},
        message = "motherFirstName"
      )
    
      @NotBlank(
        
        
        profiles = {"parentage"},
        message = "motherFirstName"
      )
    
    private String motherFirstName;

    public void setMotherFirstName(final String motherFirstName) {
        this.motherFirstName = motherFirstName;
    }

 
    @Column(name="mother_first_name" , length=38 )
      
    public String getMotherFirstName() {
        return this.motherFirstName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"parentage"},
        message = "motherLastName"
      )
    
      @NotNull(
        
        
        profiles = {"parentage"},
        message = "motherLastName"
      )
    
      @NotBlank(
        
        
        profiles = {"parentage"},
        message = "motherLastName"
      )
    
    private String motherLastName;

    public void setMotherLastName(final String motherLastName) {
        this.motherLastName = motherLastName;
    }

 
    @Column(name="mother_last_name" , length=38 )
      
    public String getMotherLastName() {
        return this.motherLastName;
    }
  
    
      @NotNull(
        
        
        profiles = {"parentage"},
        message = "motherNationality"
      )
    
    private fr.cg95.cvq.business.users.FullNationalityType motherNationality;

    public void setMotherNationality(final fr.cg95.cvq.business.users.FullNationalityType motherNationality) {
        this.motherNationality = motherNationality;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="mother_nationality"  )
      
    public fr.cg95.cvq.business.users.FullNationalityType getMotherNationality() {
        return this.motherNationality;
    }
  
    
    private String otherSituation;

    public void setOtherSituation(final String otherSituation) {
        this.otherSituation = otherSituation;
    }

 
    @Column(name="other_situation"  )
      
    public String getOtherSituation() {
        return this.otherSituation;
    }
  
    
      @NotNull(
        
        
        profiles = {"situation"},
        message = "prefectPupil"
      )
    
    private Boolean prefectPupil;

    public void setPrefectPupil(final Boolean prefectPupil) {
        this.prefectPupil = prefectPupil;
    }

 
    @Column(name="prefect_pupil"  )
      
    public Boolean getPrefectPupil() {
        return this.prefectPupil;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['prefectPupil'].test(_this.prefectPupil.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"situation"},
        message = "prefectPupilDepartment"
      )
    
    private fr.cg95.cvq.business.users.InseeDepartementCodeType prefectPupilDepartment;

    public void setPrefectPupilDepartment(final fr.cg95.cvq.business.users.InseeDepartementCodeType prefectPupilDepartment) {
        this.prefectPupilDepartment = prefectPupilDepartment;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="prefect_pupil_department"  )
      
    public fr.cg95.cvq.business.users.InseeDepartementCodeType getPrefectPupilDepartment() {
        return this.prefectPupilDepartment;
    }
  
    
      @NotNull(
        
        
        profiles = {"situation"},
        message = "statePupil"
      )
    
    private Boolean statePupil;

    public void setStatePupil(final Boolean statePupil) {
        this.statePupil = statePupil;
    }

 
    @Column(name="state_pupil"  )
      
    public Boolean getStatePupil() {
        return this.statePupil;
    }
  
}
