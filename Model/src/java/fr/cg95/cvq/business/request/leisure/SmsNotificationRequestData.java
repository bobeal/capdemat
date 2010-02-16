
package fr.cg95.cvq.business.request.leisure;

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
 *  table="sms_notification_request"
 *  lazy="false"
 */
public class SmsNotificationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public SmsNotificationRequestData() {
      
        subscription = Boolean.valueOf(false);
      
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

  
    private String cleverSmsContactId;

    public final void setCleverSmsContactId(final String cleverSmsContactId) {
        this.cleverSmsContactId = cleverSmsContactId;
    }

    /**
 
        * @hibernate.property
        *  column="clever_sms_contact_id"
        
      
    */
    public final String getCleverSmsContactId() {
        return this.cleverSmsContactId;
    }
  
    private String mobilePhone;

    public final void setMobilePhone(final String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
 
        * @hibernate.property
        *  column="mobile_phone"
        *  length="10"
      
    */
    public final String getMobilePhone() {
        return this.mobilePhone;
    }
  
    private List<fr.cg95.cvq.business.request.LocalReferentialData> interests;

    public final void setInterests(final List<fr.cg95.cvq.business.request.LocalReferentialData> interests) {
        this.interests = interests;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="sms_notification_request_interests"
        * @hibernate.key
        *  column="sms_notification_request_id"
        * @hibernate.list-index
        *  column="interests_index"
        * @hibernate.many-to-many
        *  column="interests_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getInterests() {
        return this.interests;
    }
  
    private Boolean subscription;

    public final void setSubscription(final Boolean subscription) {
        this.subscription = subscription;
    }

    /**
 
        * @hibernate.property
        *  column="subscription"
        
      
    */
    public final Boolean getSubscription() {
        return this.subscription;
    }
  
}
