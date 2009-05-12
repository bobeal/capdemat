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
 *  table="perischool_activity_registration_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class PerischoolActivityRegistrationRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public PerischoolActivityRegistrationRequest() {
        super();
        classTripPermission = Boolean.valueOf(false);
        childPhotoExploitationPermission = Boolean.valueOf(false);
        hospitalizationPermission = Boolean.valueOf(false);
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
        section = fr.cg95.cvq.business.users.SectionType.UNKNOWN;
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
        int i = 0;
        if (authorizedIndividuals != null) {
            fr.cg95.cvq.xml.request.school.PerischoolAuthorizedIndividualType[] authorizedIndividualsTypeTab = new fr.cg95.cvq.xml.request.school.PerischoolAuthorizedIndividualType[authorizedIndividuals.size()];
            Iterator authorizedIndividualsIt = authorizedIndividuals.iterator();
            while (authorizedIndividualsIt.hasNext()) {
                PerischoolAuthorizedIndividual object = (PerischoolAuthorizedIndividual) authorizedIndividualsIt.next();
                authorizedIndividualsTypeTab[i] = (PerischoolAuthorizedIndividualType) object.modelToXml();
                i = i + 1;
            }
            perischoolActivityRegistrationRequest.setAuthorizedIndividualsArray(authorizedIndividualsTypeTab);
        }
        i = 0;
        if (contactIndividuals != null) {
            fr.cg95.cvq.xml.request.school.PerischoolContactIndividualType[] contactIndividualsTypeTab = new fr.cg95.cvq.xml.request.school.PerischoolContactIndividualType[contactIndividuals.size()];
            Iterator contactIndividualsIt = contactIndividuals.iterator();
            while (contactIndividualsIt.hasNext()) {
                PerischoolContactIndividual object = (PerischoolContactIndividual) contactIndividualsIt.next();
                contactIndividualsTypeTab[i] = (PerischoolContactIndividualType) object.modelToXml();
                i = i + 1;
            }
            perischoolActivityRegistrationRequest.setContactIndividualsArray(contactIndividualsTypeTab);
        }
        if (this.classTripPermission != null)
            perischoolActivityRegistrationRequest.setClassTripPermission(this.classTripPermission.booleanValue());
        if (this.childPhotoExploitationPermission != null)
            perischoolActivityRegistrationRequest.setChildPhotoExploitationPermission(this.childPhotoExploitationPermission.booleanValue());
        if (this.school != null)
            perischoolActivityRegistrationRequest.setSchool(School.modelToXml(this.school));
        if (this.hospitalizationPermission != null)
            perischoolActivityRegistrationRequest.setHospitalizationPermission(this.hospitalizationPermission.booleanValue());
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
        List<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual> authorizedIndividualsList = new ArrayList<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual> ();
        if ( perischoolActivityRegistrationRequestXml.sizeOfAuthorizedIndividualsArray() > 0) {
            for (int i = 0; i < perischoolActivityRegistrationRequestXml.getAuthorizedIndividualsArray().length; i++) {
                authorizedIndividualsList.add(PerischoolAuthorizedIndividual.xmlToModel(perischoolActivityRegistrationRequestXml.getAuthorizedIndividualsArray(i)));
            }
        }
        perischoolActivityRegistrationRequest.setAuthorizedIndividuals(authorizedIndividualsList);
        List<fr.cg95.cvq.business.request.school.PerischoolContactIndividual> contactIndividualsList = new ArrayList<fr.cg95.cvq.business.request.school.PerischoolContactIndividual> ();
        if ( perischoolActivityRegistrationRequestXml.sizeOfContactIndividualsArray() > 0) {
            for (int i = 0; i < perischoolActivityRegistrationRequestXml.getContactIndividualsArray().length; i++) {
                contactIndividualsList.add(PerischoolContactIndividual.xmlToModel(perischoolActivityRegistrationRequestXml.getContactIndividualsArray(i)));
            }
        }
        perischoolActivityRegistrationRequest.setContactIndividuals(contactIndividualsList);
        perischoolActivityRegistrationRequest.setClassTripPermission(Boolean.valueOf(perischoolActivityRegistrationRequestXml.getClassTripPermission()));
        perischoolActivityRegistrationRequest.setChildPhotoExploitationPermission(Boolean.valueOf(perischoolActivityRegistrationRequestXml.getChildPhotoExploitationPermission()));
        if (perischoolActivityRegistrationRequestXml.getSchool() != null)
            perischoolActivityRegistrationRequest.setSchool(School.xmlToModel(perischoolActivityRegistrationRequestXml.getSchool()));
        perischoolActivityRegistrationRequest.setHospitalizationPermission(Boolean.valueOf(perischoolActivityRegistrationRequestXml.getHospitalizationPermission()));
        perischoolActivityRegistrationRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(perischoolActivityRegistrationRequestXml.getRulesAndRegulationsAcceptance()));
        perischoolActivityRegistrationRequest.setUrgencyPhone(perischoolActivityRegistrationRequestXml.getUrgencyPhone());
        List<fr.cg95.cvq.business.users.LocalReferentialData> perischoolActivityList = new ArrayList<fr.cg95.cvq.business.users.LocalReferentialData> ();
        if ( perischoolActivityRegistrationRequestXml.sizeOfPerischoolActivityArray() > 0) {
            for (int i = 0; i < perischoolActivityRegistrationRequestXml.getPerischoolActivityArray().length; i++) {
                perischoolActivityList.add(LocalReferentialData.xmlToModel(perischoolActivityRegistrationRequestXml.getPerischoolActivityArray(i)));
            }
        }
        perischoolActivityRegistrationRequest.setPerischoolActivity(perischoolActivityList);
        if (perischoolActivityRegistrationRequestXml.getSection() != null)
            perischoolActivityRegistrationRequest.setSection(fr.cg95.cvq.business.users.SectionType.forString(perischoolActivityRegistrationRequestXml.getSection().toString()));
        else
            perischoolActivityRegistrationRequest.setSection(fr.cg95.cvq.business.users.SectionType.getDefaultSectionType());
        return perischoolActivityRegistrationRequest;
    }

    private List<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual> authorizedIndividuals;

    public final void setAuthorizedIndividuals(final List<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual> authorizedIndividuals) {
        this.authorizedIndividuals = authorizedIndividuals;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="perischool_activity_registration_request_id"
     * @hibernate.list-index
     *  column="authorized_individuals_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual"
     */
    public final List<fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual> getAuthorizedIndividuals() {
        return this.authorizedIndividuals;
    }

    private List<fr.cg95.cvq.business.request.school.PerischoolContactIndividual> contactIndividuals;

    public final void setContactIndividuals(final List<fr.cg95.cvq.business.request.school.PerischoolContactIndividual> contactIndividuals) {
        this.contactIndividuals = contactIndividuals;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="perischool_activity_registration_request_id"
     * @hibernate.list-index
     *  column="contact_individuals_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.school.PerischoolContactIndividual"
     */
    public final List<fr.cg95.cvq.business.request.school.PerischoolContactIndividual> getContactIndividuals() {
        return this.contactIndividuals;
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

    private List<fr.cg95.cvq.business.users.LocalReferentialData> perischoolActivity;

    public final void setPerischoolActivity(final List<fr.cg95.cvq.business.users.LocalReferentialData> perischoolActivity) {
        this.perischoolActivity = perischoolActivity;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     *  table="perischool_activity_registration_request_perischool_activity"
     * @hibernate.key
     *  column="perischool_activity_registration_request_id"
     * @hibernate.list-index
     *  column="perischool_activity_index"
     * @hibernate.many-to-many
     *  column="perischool_activity_id"
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     */
    public final List<fr.cg95.cvq.business.users.LocalReferentialData> getPerischoolActivity() {
        return this.perischoolActivity;
    }

    private fr.cg95.cvq.business.users.SectionType section;

    public final void setSection(final fr.cg95.cvq.business.users.SectionType section) {
        this.section = section;
    }


    /**
     * @hibernate.property
     *  column="section"
     *  length="32"
     */
    public final fr.cg95.cvq.business.users.SectionType getSection() {
        return this.section;
    }

}
