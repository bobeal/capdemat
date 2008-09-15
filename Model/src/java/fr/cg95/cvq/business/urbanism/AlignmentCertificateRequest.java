package fr.cg95.cvq.business.urbanism;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.urbanism.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="alignment_certificate_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class AlignmentCertificateRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public AlignmentCertificateRequest() {
        super();
    }


    public final String modelToXmlString() {

        AlignmentCertificateRequestDocument object = (AlignmentCertificateRequestDocument) this.modelToXml();
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
        AlignmentCertificateRequestDocument alignmentCertificateRequestDoc = AlignmentCertificateRequestDocument.Factory.newInstance();
        AlignmentCertificateRequestDocument.AlignmentCertificateRequest alignmentCertificateRequest = alignmentCertificateRequestDoc.addNewAlignmentCertificateRequest();
        super.fillCommonXmlInfo(alignmentCertificateRequest);
        if (this.ownerAddress != null)
            alignmentCertificateRequest.setOwnerAddress(Address.modelToXml(this.ownerAddress));
        alignmentCertificateRequest.setSection(this.section);
        alignmentCertificateRequest.setTransportationRoute(this.transportationRoute);
        alignmentCertificateRequest.setLocality(this.locality);
        alignmentCertificateRequest.setOwnerLastName(this.ownerLastName);
        if (this.number != null)
            alignmentCertificateRequest.setNumber(new BigInteger(this.number.toString()));
        alignmentCertificateRequest.setOwnerFirstNames(this.ownerFirstNames);
        if (this.requesterQuality != null)
            alignmentCertificateRequest.setRequesterQuality(fr.cg95.cvq.xml.urbanism.AcrRequesterQualityType.Enum.forString(this.requesterQuality.toString()));
        return alignmentCertificateRequestDoc;
    }

    public static AlignmentCertificateRequest xmlToModel(AlignmentCertificateRequestDocument alignmentCertificateRequestDoc) {

        AlignmentCertificateRequestDocument.AlignmentCertificateRequest alignmentCertificateRequestXml = alignmentCertificateRequestDoc.getAlignmentCertificateRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        AlignmentCertificateRequest alignmentCertificateRequest = new AlignmentCertificateRequest();
        alignmentCertificateRequest.fillCommonModelInfo(alignmentCertificateRequest,alignmentCertificateRequestXml);
        if (alignmentCertificateRequestXml.getOwnerAddress() != null)
            alignmentCertificateRequest.setOwnerAddress(Address.xmlToModel(alignmentCertificateRequestXml.getOwnerAddress()));
        alignmentCertificateRequest.setSection(alignmentCertificateRequestXml.getSection());
        alignmentCertificateRequest.setTransportationRoute(alignmentCertificateRequestXml.getTransportationRoute());
        alignmentCertificateRequest.setLocality(alignmentCertificateRequestXml.getLocality());
        alignmentCertificateRequest.setOwnerLastName(alignmentCertificateRequestXml.getOwnerLastName());
        alignmentCertificateRequest.setNumber(alignmentCertificateRequestXml.getNumber());
        alignmentCertificateRequest.setOwnerFirstNames(alignmentCertificateRequestXml.getOwnerFirstNames());
        if (alignmentCertificateRequestXml.getRequesterQuality() != null)
            alignmentCertificateRequest.setRequesterQuality(fr.cg95.cvq.business.urbanism.AcrRequesterQualityType.forString(alignmentCertificateRequestXml.getRequesterQuality().toString()));
        else
            alignmentCertificateRequest.setRequesterQuality(fr.cg95.cvq.business.urbanism.AcrRequesterQualityType.getDefaultAcrRequesterQualityType());
        return alignmentCertificateRequest;
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

    private fr.cg95.cvq.business.urbanism.AcrRequesterQualityType requesterQuality;

    public final void setRequesterQuality(final fr.cg95.cvq.business.urbanism.AcrRequesterQualityType requesterQuality) {
        this.requesterQuality = requesterQuality;
    }


    /**
     * @hibernate.property
     *  column="requester_quality"
     */
    public final fr.cg95.cvq.business.urbanism.AcrRequesterQualityType getRequesterQuality() {
        return this.requesterQuality;
    }

}
