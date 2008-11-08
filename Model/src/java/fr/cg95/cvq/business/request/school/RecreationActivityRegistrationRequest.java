package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.school.*;

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
 *  table="recreation_activity_registration_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class RecreationActivityRegistrationRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public RecreationActivityRegistrationRequest() {
        super();
        childPhotoExploitationPermission = Boolean.valueOf(false);
        hospitalizationPermission = Boolean.valueOf(false);
        classTripPermission = Boolean.valueOf(false);
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
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
        if (this.childPhotoExploitationPermission != null)
            recreationActivityRegistrationRequest.setChildPhotoExploitationPermission(this.childPhotoExploitationPermission.booleanValue());
        if (this.recreationCenter != null)
            recreationActivityRegistrationRequest.setRecreationCenter(RecreationCenter.modelToXml(this.recreationCenter));
        if (this.hospitalizationPermission != null)
            recreationActivityRegistrationRequest.setHospitalizationPermission(this.hospitalizationPermission.booleanValue());
        if (this.classTripPermission != null)
            recreationActivityRegistrationRequest.setClassTripPermission(this.classTripPermission.booleanValue());
        int i = 0;
        if (otherIndividual != null) {
            fr.cg95.cvq.xml.request.school.OtherIndividualType[] otherIndividualTypeTab = new fr.cg95.cvq.xml.request.school.OtherIndividualType[otherIndividual.size()];
            Iterator otherIndividualIt = otherIndividual.iterator();
            while (otherIndividualIt.hasNext()) {
                OtherIndividual object = (OtherIndividual) otherIndividualIt.next();
                otherIndividualTypeTab[i] = OtherIndividual.modelToXml(object);
                i = i + 1;
            }
            recreationActivityRegistrationRequest.setOtherIndividualArray(otherIndividualTypeTab);
        }
        if (this.rulesAndRegulationsAcceptance != null)
            recreationActivityRegistrationRequest.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance.booleanValue());
        recreationActivityRegistrationRequest.setUrgencyPhone(this.urgencyPhone);
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
        return recreationActivityRegistrationRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        RecreationActivityRegistrationRequestDocument recreationActivityRegistrationRequestDoc =
            (RecreationActivityRegistrationRequestDocument) modelToXml();
        return recreationActivityRegistrationRequestDoc.getRecreationActivityRegistrationRequest();
    }

    public static RecreationActivityRegistrationRequest xmlToModel(RecreationActivityRegistrationRequestDocument recreationActivityRegistrationRequestDoc) {

        RecreationActivityRegistrationRequestDocument.RecreationActivityRegistrationRequest recreationActivityRegistrationRequestXml = recreationActivityRegistrationRequestDoc.getRecreationActivityRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        RecreationActivityRegistrationRequest recreationActivityRegistrationRequest = new RecreationActivityRegistrationRequest();
        recreationActivityRegistrationRequest.fillCommonModelInfo(recreationActivityRegistrationRequest,recreationActivityRegistrationRequestXml);
        recreationActivityRegistrationRequest.setChildPhotoExploitationPermission(Boolean.valueOf(recreationActivityRegistrationRequestXml.getChildPhotoExploitationPermission()));
        if (recreationActivityRegistrationRequestXml.getRecreationCenter() != null)
            recreationActivityRegistrationRequest.setRecreationCenter(RecreationCenter.xmlToModel(recreationActivityRegistrationRequestXml.getRecreationCenter()));
        recreationActivityRegistrationRequest.setHospitalizationPermission(Boolean.valueOf(recreationActivityRegistrationRequestXml.getHospitalizationPermission()));
        recreationActivityRegistrationRequest.setClassTripPermission(Boolean.valueOf(recreationActivityRegistrationRequestXml.getClassTripPermission()));
        List<fr.cg95.cvq.business.request.school.OtherIndividual> otherIndividualList = new ArrayList<fr.cg95.cvq.business.request.school.OtherIndividual> ();
        if ( recreationActivityRegistrationRequestXml.sizeOfOtherIndividualArray() > 0) {
            for (int i = 0; i < recreationActivityRegistrationRequestXml.getOtherIndividualArray().length; i++) {
                otherIndividualList.add(OtherIndividual.xmlToModel(recreationActivityRegistrationRequestXml.getOtherIndividualArray(i)));
            }
        }
        recreationActivityRegistrationRequest.setOtherIndividual(otherIndividualList);
        recreationActivityRegistrationRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(recreationActivityRegistrationRequestXml.getRulesAndRegulationsAcceptance()));
        recreationActivityRegistrationRequest.setUrgencyPhone(recreationActivityRegistrationRequestXml.getUrgencyPhone());
        List<fr.cg95.cvq.business.users.LocalReferentialData> recreationActivityList = new ArrayList<fr.cg95.cvq.business.users.LocalReferentialData> ();
        if ( recreationActivityRegistrationRequestXml.sizeOfRecreationActivityArray() > 0) {
            for (int i = 0; i < recreationActivityRegistrationRequestXml.getRecreationActivityArray().length; i++) {
                recreationActivityList.add(LocalReferentialData.xmlToModel(recreationActivityRegistrationRequestXml.getRecreationActivityArray(i)));
            }
        }
        recreationActivityRegistrationRequest.setRecreationActivity(recreationActivityList);
        return recreationActivityRegistrationRequest;
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

    private List<fr.cg95.cvq.business.request.school.OtherIndividual> otherIndividual;

    public final void setOtherIndividual(final List<fr.cg95.cvq.business.request.school.OtherIndividual> otherIndividual) {
        this.otherIndividual = otherIndividual;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  cascade="all"
     *  table="recreation_activity_registration_request_other_individual"
     * @hibernate.key
     *  column="recreation_activity_registration_request_id"
     * @hibernate.list-index
     *  column="other_individual_index"
     * @hibernate.many-to-many
     *  column="other_individual_id"
     *  class="fr.cg95.cvq.business.request.school.OtherIndividual"
     */
    public final List<fr.cg95.cvq.business.request.school.OtherIndividual> getOtherIndividual() {
        return this.otherIndividual;
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

    private List<fr.cg95.cvq.business.users.LocalReferentialData> recreationActivity;

    public final void setRecreationActivity(final List<fr.cg95.cvq.business.users.LocalReferentialData> recreationActivity) {
        this.recreationActivity = recreationActivity;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  cascade="all"
     *  table="recreation_activity_registration_request_recreation_activity"
     * @hibernate.key
     *  column="recreation_activity_registration_request_id"
     * @hibernate.list-index
     *  column="recreation_activity_index"
     * @hibernate.many-to-many
     *  column="recreation_activity_id"
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     */
    public final List<fr.cg95.cvq.business.users.LocalReferentialData> getRecreationActivity() {
        return this.recreationActivity;
    }

}
