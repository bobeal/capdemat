package fr.cg95.cvq.business.request.leisure.culture;

import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.leisure.culture.*;

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
 *  table="library_registration_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class LibraryRegistrationRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public LibraryRegistrationRequest() {
        super();
        parentalAuthorization = Boolean.valueOf(false);
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
    }


    @Override
    public final String modelToXmlString() {

        LibraryRegistrationRequestDocument object = (LibraryRegistrationRequestDocument) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final XmlObject modelToXml() {

        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LibraryRegistrationRequestDocument libraryRegistrationRequestDoc = LibraryRegistrationRequestDocument.Factory.newInstance();
        LibraryRegistrationRequestDocument.LibraryRegistrationRequest libraryRegistrationRequest = libraryRegistrationRequestDoc.addNewLibraryRegistrationRequest();
        super.fillCommonXmlInfo(libraryRegistrationRequest);
        libraryRegistrationRequest.setRegistrationNumber(this.registrationNumber);
        if (this.parentalAuthorization != null)
            libraryRegistrationRequest.setParentalAuthorization(this.parentalAuthorization.booleanValue());
        int i = 0;
        if (subscription != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] subscriptionTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[subscription.size()];
            Iterator subscriptionIt = subscription.iterator();
            while (subscriptionIt.hasNext()) {
                LocalReferentialData object = (LocalReferentialData) subscriptionIt.next();
                subscriptionTypeTab[i] = LocalReferentialData.modelToXml(object);
                i = i + 1;
            }
            libraryRegistrationRequest.setSubscriptionArray(subscriptionTypeTab);
        }
        if (this.rulesAndRegulationsAcceptance != null)
            libraryRegistrationRequest.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance.booleanValue());
        return libraryRegistrationRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        LibraryRegistrationRequestDocument libraryRegistrationRequestDoc =
            (LibraryRegistrationRequestDocument) modelToXml();
        return libraryRegistrationRequestDoc.getLibraryRegistrationRequest();
    }

    public static LibraryRegistrationRequest xmlToModel(LibraryRegistrationRequestDocument libraryRegistrationRequestDoc) {

        LibraryRegistrationRequestDocument.LibraryRegistrationRequest libraryRegistrationRequestXml = libraryRegistrationRequestDoc.getLibraryRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        LibraryRegistrationRequest libraryRegistrationRequest = new LibraryRegistrationRequest();
        libraryRegistrationRequest.fillCommonModelInfo(libraryRegistrationRequest,libraryRegistrationRequestXml);
        libraryRegistrationRequest.setRegistrationNumber(libraryRegistrationRequestXml.getRegistrationNumber());
        libraryRegistrationRequest.setParentalAuthorization(Boolean.valueOf(libraryRegistrationRequestXml.getParentalAuthorization()));
        List<fr.cg95.cvq.business.users.LocalReferentialData> subscriptionList = new ArrayList<fr.cg95.cvq.business.users.LocalReferentialData> ();
        if ( libraryRegistrationRequestXml.sizeOfSubscriptionArray() > 0) {
            for (int i = 0; i < libraryRegistrationRequestXml.getSubscriptionArray().length; i++) {
                subscriptionList.add(LocalReferentialData.xmlToModel(libraryRegistrationRequestXml.getSubscriptionArray(i)));
            }
        }
        libraryRegistrationRequest.setSubscription(subscriptionList);
        libraryRegistrationRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(libraryRegistrationRequestXml.getRulesAndRegulationsAcceptance()));
        return libraryRegistrationRequest;
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

    private List<fr.cg95.cvq.business.users.LocalReferentialData> subscription;

    public final void setSubscription(final List<fr.cg95.cvq.business.users.LocalReferentialData> subscription) {
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
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     */
    public final List<fr.cg95.cvq.business.users.LocalReferentialData> getSubscription() {
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
