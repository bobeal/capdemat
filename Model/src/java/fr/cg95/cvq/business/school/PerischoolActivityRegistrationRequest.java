package fr.cg95.cvq.business.school;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.school.*;

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
 *  table="perischool_activity_registration_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class PerischoolActivityRegistrationRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public PerischoolActivityRegistrationRequest() {
        super();
        childPhotoExploitationPermission = Boolean.valueOf(false);
        hospitalizationPermission = Boolean.valueOf(false);
        classTripPermission = Boolean.valueOf(false);
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
        section = fr.cg95.cvq.business.authority.SectionType.UNKNOWN;
    }


    public final String modelToXmlString() {

        PerischoolActivityRegistrationRequestDocument object = (PerischoolActivityRegistrationRequestDocument) this.modelToXml();
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
        PerischoolActivityRegistrationRequestDocument perischoolActivityRegistrationRequestDoc = PerischoolActivityRegistrationRequestDocument.Factory.newInstance();
        PerischoolActivityRegistrationRequestDocument.PerischoolActivityRegistrationRequest perischoolActivityRegistrationRequest = perischoolActivityRegistrationRequestDoc.addNewPerischoolActivityRegistrationRequest();
        super.fillCommonXmlInfo(perischoolActivityRegistrationRequest);
        if (this.childPhotoExploitationPermission != null)
            perischoolActivityRegistrationRequest.setChildPhotoExploitationPermission(this.childPhotoExploitationPermission.booleanValue());
        if (this.school != null)
            perischoolActivityRegistrationRequest.setSchool(School.modelToXml(this.school));
        if (this.hospitalizationPermission != null)
            perischoolActivityRegistrationRequest.setHospitalizationPermission(this.hospitalizationPermission.booleanValue());
        if (this.classTripPermission != null)
            perischoolActivityRegistrationRequest.setClassTripPermission(this.classTripPermission.booleanValue());
        int i = 0;
        if (otherIndividual != null) {
            fr.cg95.cvq.xml.school.OtherIndividualType[] otherIndividualTypeTab = new fr.cg95.cvq.xml.school.OtherIndividualType[otherIndividual.size()];
            Iterator otherIndividualIt = otherIndividual.iterator();
            while (otherIndividualIt.hasNext()) {
                OtherIndividual object = (OtherIndividual) otherIndividualIt.next();
                otherIndividualTypeTab[i] = OtherIndividual.modelToXml(object);
                i = i + 1;
            }
            perischoolActivityRegistrationRequest.setOtherIndividualArray(otherIndividualTypeTab);
        }
        if (this.rulesAndRegulationsAcceptance != null)
            perischoolActivityRegistrationRequest.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance.booleanValue());
        perischoolActivityRegistrationRequest.setUrgencyPhone(this.urgencyPhone);
        i = 0;
        if (perischoolActivity != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] perischoolActivityTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[perischoolActivity.size()];
            Iterator perischoolActivityIt = perischoolActivity.iterator();
            while (perischoolActivityIt.hasNext()) {
                LocalReferentialData object = (LocalReferentialData) perischoolActivityIt.next();
                perischoolActivityTypeTab[i] = LocalReferentialData.modelToXml(object);
                i = i + 1;
            }
            perischoolActivityRegistrationRequest.setPerischoolActivityArray(perischoolActivityTypeTab);
        }
        if (this.section != null)
            perischoolActivityRegistrationRequest.setSection(fr.cg95.cvq.xml.common.SectionType.Enum.forString(this.section.toString()));
        return perischoolActivityRegistrationRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        PerischoolActivityRegistrationRequestDocument perischoolActivityRegistrationRequestDoc =
            (PerischoolActivityRegistrationRequestDocument) modelToXml();
        return perischoolActivityRegistrationRequestDoc.getPerischoolActivityRegistrationRequest();
    }

    public static PerischoolActivityRegistrationRequest xmlToModel(PerischoolActivityRegistrationRequestDocument perischoolActivityRegistrationRequestDoc) {

        PerischoolActivityRegistrationRequestDocument.PerischoolActivityRegistrationRequest perischoolActivityRegistrationRequestXml = perischoolActivityRegistrationRequestDoc.getPerischoolActivityRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        PerischoolActivityRegistrationRequest perischoolActivityRegistrationRequest = new PerischoolActivityRegistrationRequest();
        perischoolActivityRegistrationRequest.fillCommonModelInfo(perischoolActivityRegistrationRequest,perischoolActivityRegistrationRequestXml);
        perischoolActivityRegistrationRequest.setChildPhotoExploitationPermission(Boolean.valueOf(perischoolActivityRegistrationRequestXml.getChildPhotoExploitationPermission()));
        if (perischoolActivityRegistrationRequestXml.getSchool() != null)
            perischoolActivityRegistrationRequest.setSchool(School.xmlToModel(perischoolActivityRegistrationRequestXml.getSchool()));
        perischoolActivityRegistrationRequest.setHospitalizationPermission(Boolean.valueOf(perischoolActivityRegistrationRequestXml.getHospitalizationPermission()));
        perischoolActivityRegistrationRequest.setClassTripPermission(Boolean.valueOf(perischoolActivityRegistrationRequestXml.getClassTripPermission()));
        HashSet otherIndividualSet = new HashSet();
        if ( perischoolActivityRegistrationRequestXml.sizeOfOtherIndividualArray() > 0) {
            for (int i = 0; i < perischoolActivityRegistrationRequestXml.getOtherIndividualArray().length; i++) {
                otherIndividualSet.add(OtherIndividual.xmlToModel(perischoolActivityRegistrationRequestXml.getOtherIndividualArray(i)));
            }
        }
        perischoolActivityRegistrationRequest.setOtherIndividual(otherIndividualSet);
        perischoolActivityRegistrationRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(perischoolActivityRegistrationRequestXml.getRulesAndRegulationsAcceptance()));
        perischoolActivityRegistrationRequest.setUrgencyPhone(perischoolActivityRegistrationRequestXml.getUrgencyPhone());
        HashSet perischoolActivitySet = new HashSet();
        if ( perischoolActivityRegistrationRequestXml.sizeOfPerischoolActivityArray() > 0) {
            for (int i = 0; i < perischoolActivityRegistrationRequestXml.getPerischoolActivityArray().length; i++) {
                perischoolActivitySet.add(LocalReferentialData.xmlToModel(perischoolActivityRegistrationRequestXml.getPerischoolActivityArray(i)));
            }
        }
        perischoolActivityRegistrationRequest.setPerischoolActivity(perischoolActivitySet);
        if (perischoolActivityRegistrationRequestXml.getSection() != null)
            perischoolActivityRegistrationRequest.setSection(fr.cg95.cvq.business.authority.SectionType.forString(perischoolActivityRegistrationRequestXml.getSection().toString()));
        else
            perischoolActivityRegistrationRequest.setSection(fr.cg95.cvq.business.authority.SectionType.getDefaultSectionType());
        return perischoolActivityRegistrationRequest;
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

    private fr.cg95.cvq.business.authority.School school;

    public final void setSchool(final fr.cg95.cvq.business.authority.School school) {
        this.school = school;
    }


    /**
     * @hibernate.many-to-one
     *  column="school_id"
     *  class="fr.cg95.cvq.business.authority.School"
     */
    public final fr.cg95.cvq.business.authority.School getSchool() {
        return this.school;
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

    private Set otherIndividual;

    public final void setOtherIndividual(final Set otherIndividual) {
        this.otherIndividual = otherIndividual;
    }


    /**
     * @hibernate.set
     *  inverse="false"
     *  cascade="all"
     *  table="perischool_activity_registration_request_other_individual"
     * @hibernate.key
     *  column="perischool_activity_registration_request_id"
     * @hibernate.many-to-many
     *  column="other_individual_id"
     *  class="fr.cg95.cvq.business.school.OtherIndividual"
     */
    public final Set getOtherIndividual() {
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

    private Set perischoolActivity;

    public final void setPerischoolActivity(final Set perischoolActivity) {
        this.perischoolActivity = perischoolActivity;
    }


    /**
     * @hibernate.set
     *  inverse="false"
     *  cascade="all"
     *  table="perischool_activity_registration_request_perischool_activity"
     * @hibernate.key
     *  column="perischool_activity_registration_request_id"
     * @hibernate.many-to-many
     *  column="perischool_activity_id"
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     */
    public final Set getPerischoolActivity() {
        return this.perischoolActivity;
    }

    private fr.cg95.cvq.business.authority.SectionType section;

    public final void setSection(final fr.cg95.cvq.business.authority.SectionType section) {
        this.section = section;
    }


    /**
     * @hibernate.property
     *  column="section"
     *  length="32"
     */
    public final fr.cg95.cvq.business.authority.SectionType getSection() {
        return this.section;
    }

}
