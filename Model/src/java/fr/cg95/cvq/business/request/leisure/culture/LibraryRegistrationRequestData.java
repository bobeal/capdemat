
package fr.cg95.cvq.business.request.leisure.culture;

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
 *  table="library_registration_request"
 *  lazy="false"
 */
public class LibraryRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public LibraryRegistrationRequestData() {
      
        parentalAuthorization = Boolean.valueOf(false);
      
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
      
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

  
    private String registrationNumber;

    public final void setRegistrationNumber(final String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
 
        * @hibernate.property
        *  column="registration_number"
        
      
    */
    public final String getRegistrationNumber() {
        return this.registrationNumber;
    }
  
    private Boolean parentalAuthorization;

    public final void setParentalAuthorization(final Boolean parentalAuthorization) {
        this.parentalAuthorization = parentalAuthorization;
    }

    /**
 
        * @hibernate.property
        *  column="parental_authorization"
        
      
    */
    public final Boolean getParentalAuthorization() {
        return this.parentalAuthorization;
    }
  
    private Short subscriptionPrice;

    public final void setSubscriptionPrice(final Short subscriptionPrice) {
        this.subscriptionPrice = subscriptionPrice;
    }

    /**
 
        * @hibernate.property
        *  column="subscription_price"
        
      
    */
    public final Short getSubscriptionPrice() {
        return this.subscriptionPrice;
    }
  
    private List<fr.cg95.cvq.business.request.LocalReferentialData> subscription;

    public final void setSubscription(final List<fr.cg95.cvq.business.request.LocalReferentialData> subscription) {
        this.subscription = subscription;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="library_registration_request_subscription"
        * @hibernate.key
        *  column="library_registration_request_id"
        * @hibernate.list-index
        *  column="subscription_index"
        * @hibernate.many-to-many
        *  column="subscription_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getSubscription() {
        return this.subscription;
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
  
}
