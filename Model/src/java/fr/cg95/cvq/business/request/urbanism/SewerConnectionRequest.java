package fr.cg95.cvq.business.request.urbanism;

import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.urbanism.*;

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
 *  table="sewer_connection_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class SewerConnectionRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public SewerConnectionRequest() {
        super();
        requesterQuality = fr.cg95.cvq.business.request.urbanism.ScrRequesterQualityType.OWNER;
        moreThanTwoYears = Boolean.valueOf(false);
    }


    @Override
    public final String modelToXmlString() {

        SewerConnectionRequestDocument object = (SewerConnectionRequestDocument) this.modelToXml();
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
        SewerConnectionRequestDocument sewerConnectionRequestDoc = SewerConnectionRequestDocument.Factory.newInstance();
        SewerConnectionRequestDocument.SewerConnectionRequest sewerConnectionRequest = sewerConnectionRequestDoc.addNewSewerConnectionRequest();
        super.fillCommonXmlInfo(sewerConnectionRequest);
        sewerConnectionRequest.setOwnerLastName(this.ownerLastName);
        sewerConnectionRequest.setOwnerFirstNames(this.ownerFirstNames);
        if (this.ownerAddress != null)
            sewerConnectionRequest.setOwnerAddress(Address.modelToXml(this.ownerAddress));
        if (this.requesterQuality != null)
            sewerConnectionRequest.setRequesterQuality(fr.cg95.cvq.xml.request.urbanism.ScrRequesterQualityType.Enum.forString(this.requesterQuality.toString()));
        if (this.moreThanTwoYears != null)
            sewerConnectionRequest.setMoreThanTwoYears(this.moreThanTwoYears.booleanValue());
        sewerConnectionRequest.setTransportationRoute(this.transportationRoute);
        sewerConnectionRequest.setLocality(this.locality);
        if (this.number != null)
            sewerConnectionRequest.setNumber(new BigInteger(this.number.toString()));
        sewerConnectionRequest.setSection(this.section);
        return sewerConnectionRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        SewerConnectionRequestDocument sewerConnectionRequestDoc =
            (SewerConnectionRequestDocument) modelToXml();
        return sewerConnectionRequestDoc.getSewerConnectionRequest();
    }

    public static SewerConnectionRequest xmlToModel(SewerConnectionRequestDocument sewerConnectionRequestDoc) {

        SewerConnectionRequestDocument.SewerConnectionRequest sewerConnectionRequestXml = sewerConnectionRequestDoc.getSewerConnectionRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        SewerConnectionRequest sewerConnectionRequest = new SewerConnectionRequest();
        sewerConnectionRequest.fillCommonModelInfo(sewerConnectionRequest,sewerConnectionRequestXml);
        sewerConnectionRequest.setOwnerLastName(sewerConnectionRequestXml.getOwnerLastName());
        sewerConnectionRequest.setOwnerFirstNames(sewerConnectionRequestXml.getOwnerFirstNames());
        if (sewerConnectionRequestXml.getOwnerAddress() != null)
            sewerConnectionRequest.setOwnerAddress(Address.xmlToModel(sewerConnectionRequestXml.getOwnerAddress()));
        if (sewerConnectionRequestXml.getRequesterQuality() != null)
            sewerConnectionRequest.setRequesterQuality(fr.cg95.cvq.business.request.urbanism.ScrRequesterQualityType.forString(sewerConnectionRequestXml.getRequesterQuality().toString()));
        else
            sewerConnectionRequest.setRequesterQuality(fr.cg95.cvq.business.request.urbanism.ScrRequesterQualityType.getDefaultScrRequesterQualityType());
        sewerConnectionRequest.setMoreThanTwoYears(Boolean.valueOf(sewerConnectionRequestXml.getMoreThanTwoYears()));
        sewerConnectionRequest.setTransportationRoute(sewerConnectionRequestXml.getTransportationRoute());
        sewerConnectionRequest.setLocality(sewerConnectionRequestXml.getLocality());
        sewerConnectionRequest.setNumber(sewerConnectionRequestXml.getNumber());
        sewerConnectionRequest.setSection(sewerConnectionRequestXml.getSection());
        return sewerConnectionRequest;
    }

    private String ownerLastName;

    public final void setOwnerLastName(final String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }


    /**
     * @hibernate.property
     *  column="owner_last_name"
     *  length="38"
     */
    public final String getOwnerLastName() {
        return this.ownerLastName;
    }

    private String ownerFirstNames;

    public final void setOwnerFirstNames(final String ownerFirstNames) {
        this.ownerFirstNames = ownerFirstNames;
    }


    /**
     * @hibernate.property
     *  column="owner_first_names"
     */
    public final String getOwnerFirstNames() {
        return this.ownerFirstNames;
    }

    private fr.cg95.cvq.business.users.Address ownerAddress;

    public final void setOwnerAddress(final fr.cg95.cvq.business.users.Address ownerAddress) {
        this.ownerAddress = ownerAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="owner_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getOwnerAddress() {
        return this.ownerAddress;
    }

    private fr.cg95.cvq.business.request.urbanism.ScrRequesterQualityType requesterQuality;

    public final void setRequesterQuality(final fr.cg95.cvq.business.request.urbanism.ScrRequesterQualityType requesterQuality) {
        this.requesterQuality = requesterQuality;
    }


    /**
     * @hibernate.property
     *  column="requester_quality"
     */
    public final fr.cg95.cvq.business.request.urbanism.ScrRequesterQualityType getRequesterQuality() {
        return this.requesterQuality;
    }

    private Boolean moreThanTwoYears;

    public final void setMoreThanTwoYears(final Boolean moreThanTwoYears) {
        this.moreThanTwoYears = moreThanTwoYears;
    }


    /**
     * @hibernate.property
     *  column="more_than_two_years"
     */
    public final Boolean getMoreThanTwoYears() {
        return this.moreThanTwoYears;
    }

    private String transportationRoute;

    public final void setTransportationRoute(final String transportationRoute) {
        this.transportationRoute = transportationRoute;
    }


    /**
     * @hibernate.property
     *  column="transportation_route"
     */
    public final String getTransportationRoute() {
        return this.transportationRoute;
    }

    private String locality;

    public final void setLocality(final String locality) {
        this.locality = locality;
    }


    /**
     * @hibernate.property
     *  column="locality"
     */
    public final String getLocality() {
        return this.locality;
    }

    private java.math.BigInteger number;

    public final void setNumber(final java.math.BigInteger number) {
        this.number = number;
    }


    /**
     * @hibernate.property
     *  column="number"
     *  type="serializable"
     */
    public final java.math.BigInteger getNumber() {
        return this.number;
    }

    private String section;

    public final void setSection(final String section) {
        this.section = section;
    }


    /**
     * @hibernate.property
     *  column="section"
     */
    public final String getSection() {
        return this.section;
    }

}
