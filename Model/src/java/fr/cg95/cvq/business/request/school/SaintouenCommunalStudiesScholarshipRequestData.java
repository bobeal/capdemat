

package fr.cg95.cvq.business.request.school;

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
@Table(name="saintouen_communal_studies_scholarship_request")
public class SaintouenCommunalStudiesScholarshipRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public SaintouenCommunalStudiesScholarshipRequestData() {
      
        isOtherSituation = fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType.TENANT;
      
        isSubjectAccountHolder = Boolean.valueOf(true);
      
    }

    @Override
    public SaintouenCommunalStudiesScholarshipRequestData clone() {
        SaintouenCommunalStudiesScholarshipRequestData result = new SaintouenCommunalStudiesScholarshipRequestData();
        
          
            
        result.setAccountHolderBirthDate(accountHolderBirthDate);
      
          
        
          
            
        result.setAccountHolderFirstName(accountHolderFirstName);
      
          
        
          
            
        result.setAccountHolderLastName(accountHolderLastName);
      
          
        
          
            
        if (accountHolderTitle != null)
            result.setAccountHolderTitle(accountHolderTitle);
        else
            result.setAccountHolderTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
          
        
          
            
        if (bankAccount != null)
            result.setBankAccount(bankAccount.clone());
      
          
        
          
            
        if (isOtherSituation != null)
            result.setIsOtherSituation(isOtherSituation);
        else
            result.setIsOtherSituation(fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType.getDefaultSaintOuenSituationLogementType());
      
          
        
          
            
        result.setIsSubjectAccountHolder(isSubjectAccountHolder);
      
          
        
          
            
        result.setMontantBourse(montantBourse);
      
          
        
          
            
        if (saintOuenCurrentStudiesLevel != null)
            result.setSaintOuenCurrentStudiesLevel(saintOuenCurrentStudiesLevel);
        else
            result.setSaintOuenCurrentStudiesLevel(fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesLevelType.getDefaultSaintOuenCurrentStudiesLevelType());
      
          
        
          
            
        result.setSaintOuenEstablishmentLabel(saintOuenEstablishmentLabel);
      
          
        
          
            
        if (saintOuenIsInOtherStudies != null)
            result.setSaintOuenIsInOtherStudies(saintOuenIsInOtherStudies);
        else
            result.setSaintOuenIsInOtherStudies(fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesType.getDefaultSaintOuenCurrentStudiesType());
      
          
        
          
            
        result.setSaintOuenOtherSituationDetails(saintOuenOtherSituationDetails);
      
          
        
          
            
        result.setSaintOuenOtherStudiesLabel(saintOuenOtherStudiesLabel);
      
          
        
          
            
        result.setSubjectBirthDate(subjectBirthDate);
      
          
        
          
            
        result.setSubjectDomiciliationDate(subjectDomiciliationDate);
      
          
        
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

  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isSubjectAccountHolder'].test(_this.isSubjectAccountHolder.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"bankReference"},
        message = "accountHolderBirthDate"
      )
    
    private java.util.Date accountHolderBirthDate;

    public void setAccountHolderBirthDate(final java.util.Date accountHolderBirthDate) {
        this.accountHolderBirthDate = accountHolderBirthDate;
    }

 
    @Column(name="account_holder_birth_date"  )
      
    public java.util.Date getAccountHolderBirthDate() {
        return this.accountHolderBirthDate;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isSubjectAccountHolder'].test(_this.isSubjectAccountHolder.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"bankReference"},
        message = "accountHolderFirstName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isSubjectAccountHolder'].test(_this.isSubjectAccountHolder.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"bankReference"},
        message = "accountHolderFirstName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isSubjectAccountHolder'].test(_this.isSubjectAccountHolder.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"bankReference"},
        message = "accountHolderFirstName"
      )
    
    private String accountHolderFirstName;

    public void setAccountHolderFirstName(final String accountHolderFirstName) {
        this.accountHolderFirstName = accountHolderFirstName;
    }

 
    @Column(name="account_holder_first_name" , length=38 )
      
    public String getAccountHolderFirstName() {
        return this.accountHolderFirstName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isSubjectAccountHolder'].test(_this.isSubjectAccountHolder.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"bankReference"},
        message = "accountHolderLastName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isSubjectAccountHolder'].test(_this.isSubjectAccountHolder.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"bankReference"},
        message = "accountHolderLastName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isSubjectAccountHolder'].test(_this.isSubjectAccountHolder.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"bankReference"},
        message = "accountHolderLastName"
      )
    
    private String accountHolderLastName;

    public void setAccountHolderLastName(final String accountHolderLastName) {
        this.accountHolderLastName = accountHolderLastName;
    }

 
    @Column(name="account_holder_last_name" , length=38 )
      
    public String getAccountHolderLastName() {
        return this.accountHolderLastName;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isSubjectAccountHolder'].test(_this.isSubjectAccountHolder.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"bankReference"},
        message = "accountHolderTitle"
      )
    
    private fr.cg95.cvq.business.users.TitleType accountHolderTitle;

    public void setAccountHolderTitle(final fr.cg95.cvq.business.users.TitleType accountHolderTitle) {
        this.accountHolderTitle = accountHolderTitle;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="account_holder_title"  )
      
    public fr.cg95.cvq.business.users.TitleType getAccountHolderTitle() {
        return this.accountHolderTitle;
    }
  
    
      @NotNull(
        
        
        profiles = {"bankReference"},
        message = "bankAccount"
      )
    
      @AssertValid(
        
        
        profiles = {"bankReference"},
        message = "bankAccount"
      )
    
    private fr.cg95.cvq.business.users.BankAccount bankAccount;

    public void setBankAccount(final fr.cg95.cvq.business.users.BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="bank_account_id")
      
    public fr.cg95.cvq.business.users.BankAccount getBankAccount() {
        return this.bankAccount;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "isOtherSituation"
      )
    
    private fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType isOtherSituation;

    public void setIsOtherSituation(final fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType isOtherSituation) {
        this.isOtherSituation = isOtherSituation;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="is_other_situation"  )
      
    public fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType getIsOtherSituation() {
        return this.isOtherSituation;
    }
  
    
      @NotNull(
        
        
        profiles = {"bankReference"},
        message = "isSubjectAccountHolder"
      )
    
    private Boolean isSubjectAccountHolder;

    public void setIsSubjectAccountHolder(final Boolean isSubjectAccountHolder) {
        this.isSubjectAccountHolder = isSubjectAccountHolder;
    }

 
    @Column(name="is_subject_account_holder"  )
      
    public Boolean getIsSubjectAccountHolder() {
        return this.isSubjectAccountHolder;
    }
  
    
      @NotNull(
        
        
        profiles = {"administration"},
        message = "montantBourse"
      )
    
      @NotBlank(
        
        
        profiles = {"administration"},
        message = "montantBourse"
      )
    
    private String montantBourse;

    public void setMontantBourse(final String montantBourse) {
        this.montantBourse = montantBourse;
    }

 
    @Column(name="montant_bourse"  )
      
    public String getMontantBourse() {
        return this.montantBourse;
    }
  
    
      @NotNull(
        
        
        profiles = {"schoolingInformation"},
        message = "saintOuenCurrentStudiesLevel"
      )
    
    private fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesLevelType saintOuenCurrentStudiesLevel;

    public void setSaintOuenCurrentStudiesLevel(final fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesLevelType saintOuenCurrentStudiesLevel) {
        this.saintOuenCurrentStudiesLevel = saintOuenCurrentStudiesLevel;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="saint_ouen_current_studies_level"  )
      
    public fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesLevelType getSaintOuenCurrentStudiesLevel() {
        return this.saintOuenCurrentStudiesLevel;
    }
  
    
      @NotNull(
        
        
        profiles = {"schoolingInformation"},
        message = "saintOuenEstablishmentLabel"
      )
    
      @NotBlank(
        
        
        profiles = {"schoolingInformation"},
        message = "saintOuenEstablishmentLabel"
      )
    
    private String saintOuenEstablishmentLabel;

    public void setSaintOuenEstablishmentLabel(final String saintOuenEstablishmentLabel) {
        this.saintOuenEstablishmentLabel = saintOuenEstablishmentLabel;
    }

 
    @Column(name="saint_ouen_establishment_label"  )
      
    public String getSaintOuenEstablishmentLabel() {
        return this.saintOuenEstablishmentLabel;
    }
  
    
      @NotNull(
        
        
        profiles = {"schoolingInformation"},
        message = "saintOuenIsInOtherStudies"
      )
    
    private fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesType saintOuenIsInOtherStudies;

    public void setSaintOuenIsInOtherStudies(final fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesType saintOuenIsInOtherStudies) {
        this.saintOuenIsInOtherStudies = saintOuenIsInOtherStudies;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="saint_ouen_is_in_other_studies"  )
      
    public fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesType getSaintOuenIsInOtherStudies() {
        return this.saintOuenIsInOtherStudies;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['isOtherSituation'].test(_this.isOtherSituation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "saintOuenOtherSituationDetails"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['isOtherSituation'].test(_this.isOtherSituation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "saintOuenOtherSituationDetails"
      )
    
    private String saintOuenOtherSituationDetails;

    public void setSaintOuenOtherSituationDetails(final String saintOuenOtherSituationDetails) {
        this.saintOuenOtherSituationDetails = saintOuenOtherSituationDetails;
    }

 
    @Column(name="saint_ouen_other_situation_details"  )
      
    public String getSaintOuenOtherSituationDetails() {
        return this.saintOuenOtherSituationDetails;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['saintOuenIsInOtherStudies'].test(_this.saintOuenIsInOtherStudies.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"schoolingInformation"},
        message = "saintOuenOtherStudiesLabel"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['saintOuenIsInOtherStudies'].test(_this.saintOuenIsInOtherStudies.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"schoolingInformation"},
        message = "saintOuenOtherStudiesLabel"
      )
    
    private String saintOuenOtherStudiesLabel;

    public void setSaintOuenOtherStudiesLabel(final String saintOuenOtherStudiesLabel) {
        this.saintOuenOtherStudiesLabel = saintOuenOtherStudiesLabel;
    }

 
    @Column(name="saint_ouen_other_studies_label"  )
      
    public String getSaintOuenOtherStudiesLabel() {
        return this.saintOuenOtherStudiesLabel;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectBirthDate"
      )
    
    private java.util.Date subjectBirthDate;

    public void setSubjectBirthDate(final java.util.Date subjectBirthDate) {
        this.subjectBirthDate = subjectBirthDate;
    }

 
    @Column(name="subject_birth_date"  )
      
    public java.util.Date getSubjectBirthDate() {
        return this.subjectBirthDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectDomiciliationDate"
      )
    
    private java.util.Date subjectDomiciliationDate;

    public void setSubjectDomiciliationDate(final java.util.Date subjectDomiciliationDate) {
        this.subjectDomiciliationDate = subjectDomiciliationDate;
    }

 
    @Column(name="subject_domiciliation_date"  )
      
    public java.util.Date getSubjectDomiciliationDate() {
        return this.subjectDomiciliationDate;
    }
  
}
