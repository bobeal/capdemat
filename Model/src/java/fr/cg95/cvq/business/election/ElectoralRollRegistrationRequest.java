package fr.cg95.cvq.business.election;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.election.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="electoral_roll_registration_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class ElectoralRollRegistrationRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public ElectoralRollRegistrationRequest() {
        super();
    }


    public final String modelToXmlString() {

        ElectoralRollRegistrationRequestDocument object = (ElectoralRollRegistrationRequestDocument) this.modelToXml();
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
        ElectoralRollRegistrationRequestDocument electoralRollRegistrationRequestDoc = ElectoralRollRegistrationRequestDocument.Factory.newInstance();
        ElectoralRollRegistrationRequestDocument.ElectoralRollRegistrationRequest electoralRollRegistrationRequest = electoralRollRegistrationRequestDoc.addNewElectoralRollRegistrationRequest();
        super.fillCommonXmlInfo(electoralRollRegistrationRequest);
        if (this.pollingStation != null)
            electoralRollRegistrationRequest.setPollingStation(this.pollingStation.longValue());
        electoralRollRegistrationRequest.setPollingSchoolName(this.pollingSchoolName);
        if (this.electoralNumber != null)
            electoralRollRegistrationRequest.setElectoralNumber(this.electoralNumber.longValue());
        electoralRollRegistrationRequest.setSubjectOldCity(this.subjectOldCity);
        if (this.motive != null)
            electoralRollRegistrationRequest.setMotive(fr.cg95.cvq.xml.election.ElectoralMotiveType.Enum.forString(this.motive.toString()));
        electoralRollRegistrationRequest.setSubjectNationality(this.subjectNationality);
        if (this.subjectAddressOutsideCity != null)
            electoralRollRegistrationRequest.setSubjectAddressOutsideCity(Address.modelToXml(this.subjectAddressOutsideCity));
        return electoralRollRegistrationRequestDoc;
    }

    public static ElectoralRollRegistrationRequest xmlToModel(ElectoralRollRegistrationRequestDocument electoralRollRegistrationRequestDoc) {

        ElectoralRollRegistrationRequestDocument.ElectoralRollRegistrationRequest electoralRollRegistrationRequestXml = electoralRollRegistrationRequestDoc.getElectoralRollRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        ElectoralRollRegistrationRequest electoralRollRegistrationRequest = new ElectoralRollRegistrationRequest();
        electoralRollRegistrationRequest.fillCommonModelInfo(electoralRollRegistrationRequest,electoralRollRegistrationRequestXml);
        if (electoralRollRegistrationRequestXml.getPollingStation() != 0)
            electoralRollRegistrationRequest.setPollingStation(new Long(electoralRollRegistrationRequestXml.getPollingStation()));
        electoralRollRegistrationRequest.setPollingSchoolName(electoralRollRegistrationRequestXml.getPollingSchoolName());
        if (electoralRollRegistrationRequestXml.getElectoralNumber() != 0)
            electoralRollRegistrationRequest.setElectoralNumber(new Long(electoralRollRegistrationRequestXml.getElectoralNumber()));
        electoralRollRegistrationRequest.setSubjectOldCity(electoralRollRegistrationRequestXml.getSubjectOldCity());
        if (electoralRollRegistrationRequestXml.getMotive() != null)
            electoralRollRegistrationRequest.setMotive(fr.cg95.cvq.business.election.ElectoralMotiveType.forString(electoralRollRegistrationRequestXml.getMotive().toString()));
        else
            electoralRollRegistrationRequest.setMotive(fr.cg95.cvq.business.election.ElectoralMotiveType.getDefaultElectoralMotiveType());
        electoralRollRegistrationRequest.setSubjectNationality(electoralRollRegistrationRequestXml.getSubjectNationality());
        if (electoralRollRegistrationRequestXml.getSubjectAddressOutsideCity() != null)
            electoralRollRegistrationRequest.setSubjectAddressOutsideCity(Address.xmlToModel(electoralRollRegistrationRequestXml.getSubjectAddressOutsideCity()));
        return electoralRollRegistrationRequest;
    }

    private Long pollingStation;

    public final void setPollingStation(final Long pollingStation) {
        this.pollingStation = pollingStation;
    }


    /**
     * @hibernate.property
     *  column="polling_station"
     */
    public final Long getPollingStation() {
        return this.pollingStation;
    }

    private String pollingSchoolName;

    public final void setPollingSchoolName(final String pollingSchoolName) {
        this.pollingSchoolName = pollingSchoolName;
    }


    /**
     * @hibernate.property
     *  column="polling_school_name"
     */
    public final String getPollingSchoolName() {
        return this.pollingSchoolName;
    }

    private Long electoralNumber;

    public final void setElectoralNumber(final Long electoralNumber) {
        this.electoralNumber = electoralNumber;
    }


    /**
     * @hibernate.property
     *  column="electoral_number"
     */
    public final Long getElectoralNumber() {
        return this.electoralNumber;
    }

    private String subjectOldCity;

    public final void setSubjectOldCity(final String subjectOldCity) {
        this.subjectOldCity = subjectOldCity;
    }


    /**
     * @hibernate.property
     *  column="subject_old_city"
     *  length="32"
     */
    public final String getSubjectOldCity() {
        return this.subjectOldCity;
    }

    private fr.cg95.cvq.business.election.ElectoralMotiveType motive;

    public final void setMotive(final fr.cg95.cvq.business.election.ElectoralMotiveType motive) {
        this.motive = motive;
    }


    /**
     * @hibernate.property
     *  column="motive"
     */
    public final fr.cg95.cvq.business.election.ElectoralMotiveType getMotive() {
        return this.motive;
    }

    private String subjectNationality;

    public final void setSubjectNationality(final String subjectNationality) {
        this.subjectNationality = subjectNationality;
    }


    /**
     * @hibernate.property
     *  column="subject_nationality"
     */
    public final String getSubjectNationality() {
        return this.subjectNationality;
    }

    private fr.cg95.cvq.business.users.Address subjectAddressOutsideCity;

    public final void setSubjectAddressOutsideCity(final fr.cg95.cvq.business.users.Address subjectAddressOutsideCity) {
        this.subjectAddressOutsideCity = subjectAddressOutsideCity;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="subject_address_outside_city_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getSubjectAddressOutsideCity() {
        return this.subjectAddressOutsideCity;
    }

}
