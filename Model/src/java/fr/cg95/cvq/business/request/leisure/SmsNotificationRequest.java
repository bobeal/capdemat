
package fr.cg95.cvq.business.request.leisure;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.xmlbeans.XmlOptions;

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.leisure.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="sms_notification_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class SmsNotificationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public SmsNotificationRequest() {
        super();
      
        subscription = Boolean.valueOf(false);
      
    }

    @Override
    public final String modelToXmlString() {
        SmsNotificationRequestDocument object = (SmsNotificationRequestDocument) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final SmsNotificationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        SmsNotificationRequestDocument smsNotificationRequestDoc = SmsNotificationRequestDocument.Factory.newInstance();
        SmsNotificationRequestDocument.SmsNotificationRequest smsNotificationRequest = smsNotificationRequestDoc.addNewSmsNotificationRequest();
        super.fillCommonXmlInfo(smsNotificationRequest);
        int i = 0;
    
        smsNotificationRequest.setCleverSmsContactId(this.cleverSmsContactId);
      
        smsNotificationRequest.setMobilePhone(this.mobilePhone);
      
        i = 0;
        if (interests != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] interestsTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[interests.size()];
            for (LocalReferentialData object : interests) {
              interestsTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            smsNotificationRequest.setInterestsArray(interestsTypeTab);
        }
      
        if (this.subscription != null)
            smsNotificationRequest.setSubscription(this.subscription.booleanValue());
      
        return smsNotificationRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        SmsNotificationRequestDocument smsNotificationRequestDoc =
            (SmsNotificationRequestDocument) modelToXml();
        return smsNotificationRequestDoc.getSmsNotificationRequest();
    }

    public static SmsNotificationRequest xmlToModel(SmsNotificationRequestDocument smsNotificationRequestDoc) {
        SmsNotificationRequestDocument.SmsNotificationRequest smsNotificationRequestXml = smsNotificationRequestDoc.getSmsNotificationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        SmsNotificationRequest smsNotificationRequest = new SmsNotificationRequest();
        smsNotificationRequest.fillCommonModelInfo(smsNotificationRequest, smsNotificationRequestXml);
    
        smsNotificationRequest.setCleverSmsContactId(smsNotificationRequestXml.getCleverSmsContactId());
      
        smsNotificationRequest.setMobilePhone(smsNotificationRequestXml.getMobilePhone());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> interestsList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(smsNotificationRequestXml.sizeOfInterestsArray());
        for (LocalReferentialDataType object : smsNotificationRequestXml.getInterestsArray()) {
            interestsList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        smsNotificationRequest.setInterests(interestsList);
      
        smsNotificationRequest.setSubscription(Boolean.valueOf(smsNotificationRequestXml.getSubscription()));
      
        return smsNotificationRequest;
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
