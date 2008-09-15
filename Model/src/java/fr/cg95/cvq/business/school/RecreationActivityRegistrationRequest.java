package fr.cg95.cvq.business.school;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.school.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="recreation_activity_registration_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class RecreationActivityRegistrationRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public RecreationActivityRegistrationRequest() {
        super();
        hospitalizationPermission = Boolean.valueOf(false);
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
        childPhotoExploitationPermission = Boolean.valueOf(false);
        classTripPermission = Boolean.valueOf(false);
    }


    public final String modelToXmlString() {

        RecreationActivityRegistrationRequestDocument object = (RecreationActivityRegistrationRequestDocument) this.modelToXml();
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
        RecreationActivityRegistrationRequestDocument recreationActivityRegistrationRequestDoc = RecreationActivityRegistrationRequestDocument.Factory.newInstance();
        RecreationActivityRegistrationRequestDocument.RecreationActivityRegistrationRequest recreationActivityRegistrationRequest = recreationActivityRegistrationRequestDoc.addNewRecreationActivityRegistrationRequest();
        super.fillCommonXmlInfo(recreationActivityRegistrationRequest);
        if (this.hospitalizationPermission != null)
            recreationActivityRegistrationRequest.setHospitalizationPermission(this.hospitalizationPermission.booleanValue());
        recreationActivityRegistrationRequest.setUrgencyPhone(this.urgencyPhone);
        if (this.rulesAndRegulationsAcceptance != null)
            recreationActivityRegistrationRequest.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance.booleanValue());
        int i = 0;
        if (otherIndividual != null) {
            fr.cg95.cvq.xml.school.OtherIndividualType[] otherIndividualTypeTab = new fr.cg95.cvq.xml.school.OtherIndividualType[otherIndividual.size()];
            Iterator otherIndividualIt = otherIndividual.iterator();
            while (otherIndividualIt.hasNext()) {
                OtherIndividual object = (OtherIndividual) otherIndividualIt.next();
                otherIndividualTypeTab[i] = OtherIndividual.modelToXml(object);
                i = i + 1;
            }
            recreationActivityRegistrationRequest.setOtherIndividualArray(otherIndividualTypeTab);
        }
        if (this.childPhotoExploitationPermission != null)
            recreationActivityRegistrationRequest.setChildPhotoExploitationPermission(this.childPhotoExploitationPermission.booleanValue());
        i = 0;
        if (recreationActivity != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] recreationActivityTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[recreationActivity.size()];
            Iterator recreationActivityIt = recreationActivity.iterator();
            while (recreationActivityIt.hasNext()) {
                LocalReferentialData object = (LocalReferentialData) recreationActivityIt.next();
                recreationActivityTypeTab[i] = LocalReferentialData.modelToXml(object);
                i = i + 1;
            }
            recreationActivityRegistrationRequest.setRecreationActivityArray(recreationActivityTypeTab);
        }
        if (this.classTripPermission != null)
            recreationActivityRegistrationRequest.setClassTripPermission(this.classTripPermission.booleanValue());
        if (this.recreationCenter != null)
            recreationActivityRegistrationRequest.setRecreationCenter(RecreationCenter.modelToXml(this.recreationCenter));
        return recreationActivityRegistrationRequestDoc;
    }

    public static RecreationActivityRegistrationRequest xmlToModel(RecreationActivityRegistrationRequestDocument recreationActivityRegistrationRequestDoc) {

        RecreationActivityRegistrationRequestDocument.RecreationActivityRegistrationRequest recreationActivityRegistrationRequestXml = recreationActivityRegistrationRequestDoc.getRecreationActivityRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        RecreationActivityRegistrationRequest recreationActivityRegistrationRequest = new RecreationActivityRegistrationRequest();
        recreationActivityRegistrationRequest.fillCommonModelInfo(recreationActivityRegistrationRequest,recreationActivityRegistrationRequestXml);
        recreationActivityRegistrationRequest.setHospitalizationPermission(Boolean.valueOf(recreationActivityRegistrationRequestXml.getHospitalizationPermission()));
        recreationActivityRegistrationRequest.setUrgencyPhone(recreationActivityRegistrationRequestXml.getUrgencyPhone());
        recreationActivityRegistrationRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(recreationActivityRegistrationRequestXml.getRulesAndRegulationsAcceptance()));
        HashSet otherIndividualSet = new HashSet();
        if ( recreationActivityRegistrationRequestXml.sizeOfOtherIndividualArray() > 0) {
            for (int i = 0; i < recreationActivityRegistrationRequestXml.getOtherIndividualArray().length; i++) {
                otherIndividualSet.add(OtherIndividual.xmlToModel(recreationActivityRegistrationRequestXml.getOtherIndividualArray(i)));
            }
        }
        recreationActivityRegistrationRequest.setOtherIndividual(otherIndividualSet);
        recreationActivityRegistrationRequest.setChildPhotoExploitationPermission(Boolean.valueOf(recreationActivityRegistrationRequestXml.getChildPhotoExploitationPermission()));
        HashSet recreationActivitySet = new HashSet();
        if ( recreationActivityRegistrationRequestXml.sizeOfRecreationActivityArray() > 0) {
            for (int i = 0; i < recreationActivityRegistrationRequestXml.getRecreationActivityArray().length; i++) {
                recreationActivitySet.add(LocalReferentialData.xmlToModel(recreationActivityRegistrationRequestXml.getRecreationActivityArray(i)));
            }
        }
        recreationActivityRegistrationRequest.setRecreationActivity(recreationActivitySet);
        recreationActivityRegistrationRequest.setClassTripPermission(Boolean.valueOf(recreationActivityRegistrationRequestXml.getClassTripPermission()));
        if (recreationActivityRegistrationRequestXml.getRecreationCenter() != null)
            recreationActivityRegistrationRequest.setRecreationCenter(RecreationCenter.xmlToModel(recreationActivityRegistrationRequestXml.getRecreationCenter()));
        return recreationActivityRegistrationRequest;
    }

    private Boolean hospitalizationPermission;

    public final void setHospitalizationPermission(final Boolean hospitalizationPermission) {
        this.hospitalizationPermission = hospitalizationPermission;
    }


    /**
     * @hibernate.property
     *  column="hospitalization_permission"
     */
    public final Boolean getHospitalizationPermission() {
        return this.hospitalizationPermission;
    }

    private String urgencyPhone;

    public final void setUrgencyPhone(final String urgencyPhone) {
        this.urgencyPhone = urgencyPhone;
    }


    /**
     * @hibernate.property
     *  column="urgency_phone"
     *  length="10"
     */
    public final String getUrgencyPhone() {
        return this.urgencyPhone;
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

    private Set otherIndividual;

    public final void setOtherIndividual(final Set otherIndividual) {
        this.otherIndividual = otherIndividual;
    }


    /**
     * @hibernate.set
     *  inverse="false"
     *  cascade="all"
     *  table="recreation_activity_registration_request_other_individual"
     * @hibernate.key
     *  column="recreation_activity_registration_request_id"
     * @hibernate.many-to-many
     *  column="other_individual_id"
     *  class="fr.cg95.cvq.business.school.OtherIndividual"
     */
    public final Set getOtherIndividual() {
        return this.otherIndividual;
    }

    private Boolean childPhotoExploitationPermission;

    public final void setChildPhotoExploitationPermission(final Boolean childPhotoExploitationPermission) {
        this.childPhotoExploitationPermission = childPhotoExploitationPermission;
    }


    /**
     * @hibernate.property
     *  column="child_photo_exploitation_permission"
     */
    public final Boolean getChildPhotoExploitationPermission() {
        return this.childPhotoExploitationPermission;
    }

    private Set recreationActivity;

    public final void setRecreationActivity(final Set recreationActivity) {
        this.recreationActivity = recreationActivity;
    }


    /**
     * @hibernate.set
     *  inverse="false"
     *  cascade="all"
     *  table="recreation_activity_registration_request_recreation_activity"
     * @hibernate.key
     *  column="recreation_activity_registration_request_id"
     * @hibernate.many-to-many
     *  column="recreation_activity_id"
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     */
    public final Set getRecreationActivity() {
        return this.recreationActivity;
    }

    private Boolean classTripPermission;

    public final void setClassTripPermission(final Boolean classTripPermission) {
        this.classTripPermission = classTripPermission;
    }


    /**
     * @hibernate.property
     *  column="class_trip_permission"
     */
    public final Boolean getClassTripPermission() {
        return this.classTripPermission;
    }

    private fr.cg95.cvq.business.authority.RecreationCenter recreationCenter;

    public final void setRecreationCenter(final fr.cg95.cvq.business.authority.RecreationCenter recreationCenter) {
        this.recreationCenter = recreationCenter;
    }


    /**
     * @hibernate.many-to-one
     *  column="recreation_center_id"
     *  class="fr.cg95.cvq.business.authority.RecreationCenter"
     */
    public final fr.cg95.cvq.business.authority.RecreationCenter getRecreationCenter() {
        return this.recreationCenter;
    }

}
