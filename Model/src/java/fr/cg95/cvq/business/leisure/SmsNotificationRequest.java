package fr.cg95.cvq.business.leisure;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.leisure.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

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
    }


    public final String modelToXmlString() {

        SmsNotificationRequestDocument object = (SmsNotificationRequestDocument) this.modelToXml();
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
        SmsNotificationRequestDocument smsNotificationRequestDoc = SmsNotificationRequestDocument.Factory.newInstance();
        SmsNotificationRequestDocument.SmsNotificationRequest smsNotificationRequest = smsNotificationRequestDoc.addNewSmsNotificationRequest();
        super.fillCommonXmlInfo(smsNotificationRequest);
        smsNotificationRequest.setCleverSmsContactId(this.cleverSmsContactId);
        int i = 0;
        if (interests != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] interestsTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[interests.size()];
            Iterator interestsIt = interests.iterator();
            while (interestsIt.hasNext()) {
                LocalReferentialData object = (LocalReferentialData) interestsIt.next();
                interestsTypeTab[i] = LocalReferentialData.modelToXml(object);
                i = i + 1;
            }
            smsNotificationRequest.setInterestsArray(interestsTypeTab);
        }
        if (this.subscription != null)
            smsNotificationRequest.setSubscription(this.subscription.booleanValue());
        return smsNotificationRequestDoc;
    }

    public static SmsNotificationRequest xmlToModel(SmsNotificationRequestDocument smsNotificationRequestDoc) {

        SmsNotificationRequestDocument.SmsNotificationRequest smsNotificationRequestXml = smsNotificationRequestDoc.getSmsNotificationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        SmsNotificationRequest smsNotificationRequest = new SmsNotificationRequest();
        smsNotificationRequest.fillCommonModelInfo(smsNotificationRequest,smsNotificationRequestXml);
        smsNotificationRequest.setCleverSmsContactId(smsNotificationRequestXml.getCleverSmsContactId());
        HashSet interestsSet = new HashSet();
        if ( smsNotificationRequestXml.sizeOfInterestsArray() > 0) {
            for (int i = 0; i < smsNotificationRequestXml.getInterestsArray().length; i++) {
                interestsSet.add(LocalReferentialData.xmlToModel(smsNotificationRequestXml.getInterestsArray(i)));
            }
        }
        smsNotificationRequest.setInterests(interestsSet);
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

    private Set interests;

    public final void setInterests(final Set interests) {
        this.interests = interests;
    }


    /**
     * @hibernate.set
     *  inverse="false"
     *  cascade="all"
     *  table="sms_notification_request_interests"
     * @hibernate.key
     *  column="sms_notification_request_id"
     * @hibernate.many-to-many
     *  column="interests_id"
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     */
    public final Set getInterests() {
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
