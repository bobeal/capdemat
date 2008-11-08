package fr.cg95.cvq.business.request.reservation;

import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.reservation.*;

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
 *  table="place_reservation_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class PlaceReservationRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public PlaceReservationRequest() {
        super();
        isSubscriber = Boolean.valueOf(false);
    }


    public final String modelToXmlString() {

        PlaceReservationRequestDocument object = (PlaceReservationRequestDocument) this.modelToXml();
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
        PlaceReservationRequestDocument placeReservationRequestDoc = PlaceReservationRequestDocument.Factory.newInstance();
        PlaceReservationRequestDocument.PlaceReservationRequest placeReservationRequest = placeReservationRequestDoc.addNewPlaceReservationRequest();
        super.fillCommonXmlInfo(placeReservationRequest);
        placeReservationRequest.setSubscriberNumber(this.subscriberNumber);
        if (this.isSubscriber != null)
            placeReservationRequest.setIsSubscriber(this.isSubscriber.booleanValue());
        int i = 0;
        if (placeReservation != null) {
            fr.cg95.cvq.xml.common.PlaceReservationDataType[] placeReservationTypeTab = new fr.cg95.cvq.xml.common.PlaceReservationDataType[placeReservation.size()];
            Iterator placeReservationIt = placeReservation.iterator();
            while (placeReservationIt.hasNext()) {
                PlaceReservationData object = (PlaceReservationData) placeReservationIt.next();
                placeReservationTypeTab[i] = PlaceReservationData.modelToXml(object);
                i = i + 1;
            }
            placeReservationRequest.setPlaceReservationArray(placeReservationTypeTab);
        }
        placeReservationRequest.setPaymentReference(this.paymentReference);
        return placeReservationRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        PlaceReservationRequestDocument placeReservationRequestDoc =
            (PlaceReservationRequestDocument) modelToXml();
        return placeReservationRequestDoc.getPlaceReservationRequest();
    }

    public static PlaceReservationRequest xmlToModel(PlaceReservationRequestDocument placeReservationRequestDoc) {

        PlaceReservationRequestDocument.PlaceReservationRequest placeReservationRequestXml = placeReservationRequestDoc.getPlaceReservationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        PlaceReservationRequest placeReservationRequest = new PlaceReservationRequest();
        placeReservationRequest.fillCommonModelInfo(placeReservationRequest,placeReservationRequestXml);
        placeReservationRequest.setSubscriberNumber(placeReservationRequestXml.getSubscriberNumber());
        placeReservationRequest.setIsSubscriber(Boolean.valueOf(placeReservationRequestXml.getIsSubscriber()));
        List<fr.cg95.cvq.business.users.PlaceReservationData> placeReservationList = new ArrayList<fr.cg95.cvq.business.users.PlaceReservationData> ();
        if ( placeReservationRequestXml.sizeOfPlaceReservationArray() > 0) {
            for (int i = 0; i < placeReservationRequestXml.getPlaceReservationArray().length; i++) {
                placeReservationList.add(PlaceReservationData.xmlToModel(placeReservationRequestXml.getPlaceReservationArray(i)));
            }
        }
        placeReservationRequest.setPlaceReservation(placeReservationList);
        placeReservationRequest.setPaymentReference(placeReservationRequestXml.getPaymentReference());
        return placeReservationRequest;
    }

    private String subscriberNumber;

    public final void setSubscriberNumber(final String subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }


    /**
     * @hibernate.property
     *  column="subscriber_number"
     */
    public final String getSubscriberNumber() {
        return this.subscriberNumber;
    }

    private Boolean isSubscriber;

    public final void setIsSubscriber(final Boolean isSubscriber) {
        this.isSubscriber = isSubscriber;
    }


    /**
     * @hibernate.property
     *  column="is_subscriber"
     */
    public final Boolean getIsSubscriber() {
        return this.isSubscriber;
    }

    private List<fr.cg95.cvq.business.users.PlaceReservationData> placeReservation;

    public final void setPlaceReservation(final List<fr.cg95.cvq.business.users.PlaceReservationData> placeReservation) {
        this.placeReservation = placeReservation;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  cascade="all"
     *  table="place_reservation_request_place_reservation"
     * @hibernate.key
     *  column="place_reservation_request_id"
     * @hibernate.list-index
     *  column="place_reservation_index"
     * @hibernate.many-to-many
     *  column="place_reservation_id"
     *  class="fr.cg95.cvq.business.users.PlaceReservationData"
     */
    public final List<fr.cg95.cvq.business.users.PlaceReservationData> getPlaceReservation() {
        return this.placeReservation;
    }

    private String paymentReference;

    public final void setPaymentReference(final String paymentReference) {
        this.paymentReference = paymentReference;
    }


    /**
     * @hibernate.property
     *  column="payment_reference"
     */
    public final String getPaymentReference() {
        return this.paymentReference;
    }

}
