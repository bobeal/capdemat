

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
@Table(name="library_registration_request")
public class LibraryRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public LibraryRegistrationRequestData() {
      
        adultContentAuthorization = Boolean.valueOf(false);
      
        parentalAuthorization = Boolean.valueOf(false);
      
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
      
    }

    @Override
    public LibraryRegistrationRequestData clone() {
        LibraryRegistrationRequestData result = new LibraryRegistrationRequestData();
        
          
            
        result.setAdultContentAuthorization(adultContentAuthorization);
      
          
        
          
            
        result.setParentalAuthorization(parentalAuthorization);
      
          
        
          
            
        result.setRegistrationNumber(registrationNumber);
      
          
        
          
            
        result.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> subscriptionList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : subscription) {
            subscriptionList.add(object.clone());
        }
        result.setSubscription(subscriptionList);
      
          
        
          
            
        result.setSubscriptionPrice(subscriptionPrice);
      
          
        
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

  
    
    private Boolean adultContentAuthorization;

    public void setAdultContentAuthorization(final Boolean adultContentAuthorization) {
        this.adultContentAuthorization = adultContentAuthorization;
    }

 
    @Column(name="adult_content_authorization"  )
      
    public Boolean getAdultContentAuthorization() {
        return this.adultContentAuthorization;
    }
  
    
    private Boolean parentalAuthorization;

    public void setParentalAuthorization(final Boolean parentalAuthorization) {
        this.parentalAuthorization = parentalAuthorization;
    }

 
    @Column(name="parental_authorization"  )
      
    public Boolean getParentalAuthorization() {
        return this.parentalAuthorization;
    }
  
    
    private String registrationNumber;

    public void setRegistrationNumber(final String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

 
    @Column(name="registration_number"  )
      
    public String getRegistrationNumber() {
        return this.registrationNumber;
    }
  
    
    private Boolean rulesAndRegulationsAcceptance;

    public void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
    }

 
    @Column(name="rules_and_regulations_acceptance"  )
      
    public Boolean getRulesAndRegulationsAcceptance() {
        return this.rulesAndRegulationsAcceptance;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"registration"},
        message = "subscription"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"registration"},
        message = "subscription"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> subscription;

    public void setSubscription(final List<fr.cg95.cvq.business.request.LocalReferentialData> subscription) {
        this.subscription = subscription;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="library_registration_request_subscription",
            joinColumns=
                @JoinColumn(name="library_registration_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="subscription_id"))
    @OrderColumn(name="subscription_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getSubscription() {
        return this.subscription;
    }
  
    
      @NotNull(
        
        
        profiles = {"administration"},
        message = "subscriptionPrice"
      )
    
    private java.math.BigDecimal subscriptionPrice;

    public void setSubscriptionPrice(final java.math.BigDecimal subscriptionPrice) {
        this.subscriptionPrice = subscriptionPrice;
    }

 
    @Column(name="subscription_price"  )
      
    public java.math.BigDecimal getSubscriptionPrice() {
        return this.subscriptionPrice;
    }
  
}
