

package fr.cg95.cvq.business.request.leisure.culture;

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
@Table(name="limoges_library_registration_request")
public class LimogesLibraryRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public LimogesLibraryRegistrationRequestData() {
      
        mailingList = Boolean.valueOf(false);
      
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
      
    }

    @Override
    public LimogesLibraryRegistrationRequestData clone() {
        LimogesLibraryRegistrationRequestData result = new LimogesLibraryRegistrationRequestData();
        
          
            
        result.setLlrrBirthDate(llrrBirthDate);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> llrrCareerList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : llrrCareer) {
            llrrCareerList.add(object.clone());
        }
        result.setLlrrCareer(llrrCareerList);
      
          
        
          
            
        result.setLlrrSchoolClass(llrrSchoolClass);
      
          
        
          
            
        result.setLlrrSchoolName(llrrSchoolName);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> llrrSchoolTypeList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : llrrSchoolType) {
            llrrSchoolTypeList.add(object.clone());
        }
        result.setLlrrSchoolType(llrrSchoolTypeList);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> llrrSubscriptionList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : llrrSubscription) {
            llrrSubscriptionList.add(object.clone());
        }
        result.setLlrrSubscription(llrrSubscriptionList);
      
          
        
          
            
        result.setMailingList(mailingList);
      
          
        
          
            
        result.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
      
          
        
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
        
        
        profiles = {"registration"},
        message = "llrrBirthDate"
      )
    
    private java.util.Date llrrBirthDate;

    public void setLlrrBirthDate(final java.util.Date llrrBirthDate) {
        this.llrrBirthDate = llrrBirthDate;
    }

 
    @Column(name="llrr_birth_date"  )
      
    public java.util.Date getLlrrBirthDate() {
        return this.llrrBirthDate;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"registration"},
        message = "llrrCareer"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"registration"},
        message = "llrrCareer"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> llrrCareer;

    public void setLlrrCareer(final List<fr.cg95.cvq.business.request.LocalReferentialData> llrrCareer) {
        this.llrrCareer = llrrCareer;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="limoges_library_registration_request_llrr_career",
            joinColumns=
                @JoinColumn(name="limoges_library_registration_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="llrr_career_id"))
    @OrderColumn(name="llrr_career_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getLlrrCareer() {
        return this.llrrCareer;
    }
  
    
    private String llrrSchoolClass;

    public void setLlrrSchoolClass(final String llrrSchoolClass) {
        this.llrrSchoolClass = llrrSchoolClass;
    }

 
    @Column(name="llrr_school_class"  )
      
    public String getLlrrSchoolClass() {
        return this.llrrSchoolClass;
    }
  
    
    private String llrrSchoolName;

    public void setLlrrSchoolName(final String llrrSchoolName) {
        this.llrrSchoolName = llrrSchoolName;
    }

 
    @Column(name="llrr_school_name"  )
      
    public String getLlrrSchoolName() {
        return this.llrrSchoolName;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"registration"},
        message = "llrrSchoolType"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> llrrSchoolType;

    public void setLlrrSchoolType(final List<fr.cg95.cvq.business.request.LocalReferentialData> llrrSchoolType) {
        this.llrrSchoolType = llrrSchoolType;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="limoges_library_registration_request_llrr_school_type",
            joinColumns=
                @JoinColumn(name="limoges_library_registration_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="llrr_school_type_id"))
    @OrderColumn(name="llrr_school_type_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getLlrrSchoolType() {
        return this.llrrSchoolType;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"registration"},
        message = "llrrSubscription"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"registration"},
        message = "llrrSubscription"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> llrrSubscription;

    public void setLlrrSubscription(final List<fr.cg95.cvq.business.request.LocalReferentialData> llrrSubscription) {
        this.llrrSubscription = llrrSubscription;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="limoges_library_registration_request_llrr_subscription",
            joinColumns=
                @JoinColumn(name="limoges_library_registration_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="llrr_subscription_id"))
    @OrderColumn(name="llrr_subscription_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getLlrrSubscription() {
        return this.llrrSubscription;
    }
  
    
      @NotNull(
        
        
        profiles = {"rules"},
        message = "mailingList"
      )
    
    private Boolean mailingList;

    public void setMailingList(final Boolean mailingList) {
        this.mailingList = mailingList;
    }

 
    @Column(name="mailing_list"  )
      
    public Boolean getMailingList() {
        return this.mailingList;
    }
  
    
      @NotNull(
        
        
        profiles = {"rules"},
        message = "rulesAndRegulationsAcceptance"
      )
    
    private Boolean rulesAndRegulationsAcceptance;

    public void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
    }

 
    @Column(name="rules_and_regulations_acceptance"  )
      
    public Boolean getRulesAndRegulationsAcceptance() {
        return this.rulesAndRegulationsAcceptance;
    }
  
}
