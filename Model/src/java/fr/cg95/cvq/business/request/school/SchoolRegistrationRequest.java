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
 *  table="school_registration_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class SchoolRegistrationRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public SchoolRegistrationRequest() {
        super();
        currentSection = fr.cg95.cvq.business.users.SectionType.UNKNOWN;
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
        section = fr.cg95.cvq.business.users.SectionType.UNKNOWN;
    }


    @Override
    public final String modelToXmlString() {

        SchoolRegistrationRequestDocument object = (SchoolRegistrationRequestDocument) this.modelToXml();
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
        SchoolRegistrationRequestDocument schoolRegistrationRequestDoc = SchoolRegistrationRequestDocument.Factory.newInstance();
        SchoolRegistrationRequestDocument.SchoolRegistrationRequest schoolRegistrationRequest = schoolRegistrationRequestDoc.addNewSchoolRegistrationRequest();
        super.fillCommonXmlInfo(schoolRegistrationRequest);
        CurrentSchoolType currentSchoolTypeCurrentSchool = schoolRegistrationRequest.addNewCurrentSchool();
        currentSchoolTypeCurrentSchool.setCurrentSchoolAddress(this.currentSchoolAddress);
        currentSchoolTypeCurrentSchool.setCurrentSchoolName(this.currentSchoolName);
        if (this.currentSection != null)
            currentSchoolTypeCurrentSchool.setCurrentSection(fr.cg95.cvq.xml.common.SectionType.Enum.forString(this.currentSection.toString()));
        if (this.school != null)
            schoolRegistrationRequest.setSchool(School.modelToXml(this.school));
        if (this.rulesAndRegulationsAcceptance != null)
            schoolRegistrationRequest.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance.booleanValue());
        schoolRegistrationRequest.setUrgencyPhone(this.urgencyPhone);
        if (this.section != null)
            schoolRegistrationRequest.setSection(fr.cg95.cvq.xml.common.SectionType.Enum.forString(this.section.toString()));
        return schoolRegistrationRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        SchoolRegistrationRequestDocument schoolRegistrationRequestDoc =
            (SchoolRegistrationRequestDocument) modelToXml();
        return schoolRegistrationRequestDoc.getSchoolRegistrationRequest();
    }

    public static SchoolRegistrationRequest xmlToModel(SchoolRegistrationRequestDocument schoolRegistrationRequestDoc) {

        SchoolRegistrationRequestDocument.SchoolRegistrationRequest schoolRegistrationRequestXml = schoolRegistrationRequestDoc.getSchoolRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        SchoolRegistrationRequest schoolRegistrationRequest = new SchoolRegistrationRequest();
        schoolRegistrationRequest.fillCommonModelInfo(schoolRegistrationRequest,schoolRegistrationRequestXml);
        schoolRegistrationRequest.setCurrentSchoolAddress(schoolRegistrationRequestXml.getCurrentSchool().getCurrentSchoolAddress());
        schoolRegistrationRequest.setCurrentSchoolName(schoolRegistrationRequestXml.getCurrentSchool().getCurrentSchoolName());
        if (schoolRegistrationRequestXml.getCurrentSchool().getCurrentSection() != null)
            schoolRegistrationRequest.setCurrentSection(fr.cg95.cvq.business.users.SectionType.forString(schoolRegistrationRequestXml.getCurrentSchool().getCurrentSection().toString()));
        else
            schoolRegistrationRequest.setCurrentSection(fr.cg95.cvq.business.users.SectionType.getDefaultSectionType());
        if (schoolRegistrationRequestXml.getSchool() != null)
            schoolRegistrationRequest.setSchool(School.xmlToModel(schoolRegistrationRequestXml.getSchool()));
        schoolRegistrationRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(schoolRegistrationRequestXml.getRulesAndRegulationsAcceptance()));
        schoolRegistrationRequest.setUrgencyPhone(schoolRegistrationRequestXml.getUrgencyPhone());
        if (schoolRegistrationRequestXml.getSection() != null)
            schoolRegistrationRequest.setSection(fr.cg95.cvq.business.users.SectionType.forString(schoolRegistrationRequestXml.getSection().toString()));
        else
            schoolRegistrationRequest.setSection(fr.cg95.cvq.business.users.SectionType.getDefaultSectionType());
        return schoolRegistrationRequest;
    }

    private String currentSchoolAddress;

    public final void setCurrentSchoolAddress(final String currentSchoolAddress) {
        this.currentSchoolAddress = currentSchoolAddress;
    }


    /**
     * @hibernate.property
     *  column="current_school_address"
     */
    public final String getCurrentSchoolAddress() {
        return this.currentSchoolAddress;
    }

    private String currentSchoolName;

    public final void setCurrentSchoolName(final String currentSchoolName) {
        this.currentSchoolName = currentSchoolName;
    }


    /**
     * @hibernate.property
     *  column="current_school_name"
     */
    public final String getCurrentSchoolName() {
        return this.currentSchoolName;
    }

    private fr.cg95.cvq.business.users.SectionType currentSection;

    public final void setCurrentSection(final fr.cg95.cvq.business.users.SectionType currentSection) {
        this.currentSection = currentSection;
    }


    /**
     * @hibernate.property
     *  column="current_section"
     *  length="32"
     */
    public final fr.cg95.cvq.business.users.SectionType getCurrentSection() {
        return this.currentSection;
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
