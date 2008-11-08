package fr.cg95.cvq.business.request.leisure;

import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.leisure.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.xml.common.RequestType;

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
        if (this.subscription != null)
            smsNotificationRequest.setSubscription(this.subscription.booleanValue());
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
        smsNotificationRequest.fillCommonModelInfo(smsNotificationRequest,smsNotificationRequestXml);
        smsNotificationRequest.setCleverSmsContactId(smsNotificationRequestXml.getCleverSmsContactId());
        smsNotificationRequest.setSubscription(Boolean.valueOf(smsNotificationRequestXml.getSubscription()));
        List<fr.cg95.cvq.business.users.LocalReferentialData> interestsList = new ArrayList<fr.cg95.cvq.business.users.LocalReferentialData> ();
        if ( smsNotificationRequestXml.sizeOfInterestsArray() > 0) {
            for (int i = 0; i < smsNotificationRequestXml.getInterestsArray().length; i++) {
                interestsList.add(LocalReferentialData.xmlToModel(smsNotificationRequestXml.getInterestsArray(i)));
            }
        }
        smsNotificationRequest.setInterests(interestsList);
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

    private List<fr.cg95.cvq.business.users.LocalReferentialData> interests;

    public final void setInterests(final List<fr.cg95.cvq.business.users.LocalReferentialData> interests) {
        this.interests = interests;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  cascade="all"
     *  table="sms_notification_request_interests"
     * @hibernate.key
     *  column="sms_notification_request_id"
     * @hibernate.list-index
     *  column="interests_index"
     * @hibernate.many-to-many
     *  column="interests_id"
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     */
    public final List<fr.cg95.cvq.business.users.LocalReferentialData> getInterests() {
        return this.interests;
    }

}
