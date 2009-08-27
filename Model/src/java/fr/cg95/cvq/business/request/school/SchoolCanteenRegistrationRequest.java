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
 *  table="school_canteen_registration_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class SchoolCanteenRegistrationRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public SchoolCanteenRegistrationRequest() {
        super();
        foodAllergy = Boolean.valueOf(false);
        hospitalizationPermission = Boolean.valueOf(false);
        rulesAndRegulationsAcceptance = Boolean.valueOf(false);
        section = fr.cg95.cvq.business.users.SectionType.UNKNOWN;
    }


    @Override
    public final String modelToXmlString() {

        SchoolCanteenRegistrationRequestDocument object = (SchoolCanteenRegistrationRequestDocument) this.modelToXml();
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
        SchoolCanteenRegistrationRequestDocument schoolCanteenRegistrationRequestDoc = SchoolCanteenRegistrationRequestDocument.Factory.newInstance();
        SchoolCanteenRegistrationRequestDocument.SchoolCanteenRegistrationRequest schoolCanteenRegistrationRequest = schoolCanteenRegistrationRequestDoc.addNewSchoolCanteenRegistrationRequest();
        super.fillCommonXmlInfo(schoolCanteenRegistrationRequest);
        int i = 0;
        if (foodDiet != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] foodDietTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[foodDiet.size()];
            Iterator foodDietIt = foodDiet.iterator();
            while (foodDietIt.hasNext()) {
                LocalReferentialData object = (LocalReferentialData) foodDietIt.next();
                foodDietTypeTab[i] = LocalReferentialData.modelToXml(object);
                i = i + 1;
            }
            schoolCanteenRegistrationRequest.setFoodDietArray(foodDietTypeTab);
        }
        if (this.foodAllergy != null)
            schoolCanteenRegistrationRequest.setFoodAllergy(this.foodAllergy.booleanValue());
        schoolCanteenRegistrationRequest.setDoctorPhone(this.doctorPhone);
        schoolCanteenRegistrationRequest.setDoctorName(this.doctorName);
        i = 0;
        if (canteenAttendingDays != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] canteenAttendingDaysTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[canteenAttendingDays.size()];
            Iterator canteenAttendingDaysIt = canteenAttendingDays.iterator();
            while (canteenAttendingDaysIt.hasNext()) {
                LocalReferentialData object = (LocalReferentialData) canteenAttendingDaysIt.next();
                canteenAttendingDaysTypeTab[i] = LocalReferentialData.modelToXml(object);
                i = i + 1;
            }
            schoolCanteenRegistrationRequest.setCanteenAttendingDaysArray(canteenAttendingDaysTypeTab);
        }
        if (this.school != null)
            schoolCanteenRegistrationRequest.setSchool(School.modelToXml(this.school));
        if (this.hospitalizationPermission != null)
            schoolCanteenRegistrationRequest.setHospitalizationPermission(this.hospitalizationPermission.booleanValue());
        if (this.rulesAndRegulationsAcceptance != null)
            schoolCanteenRegistrationRequest.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance.booleanValue());
        schoolCanteenRegistrationRequest.setUrgencyPhone(this.urgencyPhone);
        if (this.section != null)
            schoolCanteenRegistrationRequest.setSection(fr.cg95.cvq.xml.common.SectionType.Enum.forString(this.section.toString()));
        return schoolCanteenRegistrationRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        SchoolCanteenRegistrationRequestDocument schoolCanteenRegistrationRequestDoc =
            (SchoolCanteenRegistrationRequestDocument) modelToXml();
        return schoolCanteenRegistrationRequestDoc.getSchoolCanteenRegistrationRequest();
    }

    public static SchoolCanteenRegistrationRequest xmlToModel(SchoolCanteenRegistrationRequestDocument schoolCanteenRegistrationRequestDoc) {

        SchoolCanteenRegistrationRequestDocument.SchoolCanteenRegistrationRequest schoolCanteenRegistrationRequestXml = schoolCanteenRegistrationRequestDoc.getSchoolCanteenRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        SchoolCanteenRegistrationRequest schoolCanteenRegistrationRequest = new SchoolCanteenRegistrationRequest();
        schoolCanteenRegistrationRequest.fillCommonModelInfo(schoolCanteenRegistrationRequest,schoolCanteenRegistrationRequestXml);
        List<fr.cg95.cvq.business.users.LocalReferentialData> foodDietList = new ArrayList<fr.cg95.cvq.business.users.LocalReferentialData> ();
        if ( schoolCanteenRegistrationRequestXml.sizeOfFoodDietArray() > 0) {
            for (int i = 0; i < schoolCanteenRegistrationRequestXml.getFoodDietArray().length; i++) {
                foodDietList.add(LocalReferentialData.xmlToModel(schoolCanteenRegistrationRequestXml.getFoodDietArray(i)));
            }
        }
        schoolCanteenRegistrationRequest.setFoodDiet(foodDietList);
        schoolCanteenRegistrationRequest.setFoodAllergy(Boolean.valueOf(schoolCanteenRegistrationRequestXml.getFoodAllergy()));
        schoolCanteenRegistrationRequest.setDoctorPhone(schoolCanteenRegistrationRequestXml.getDoctorPhone());
        schoolCanteenRegistrationRequest.setDoctorName(schoolCanteenRegistrationRequestXml.getDoctorName());
        List<fr.cg95.cvq.business.users.LocalReferentialData> canteenAttendingDaysList = new ArrayList<fr.cg95.cvq.business.users.LocalReferentialData> ();
        if ( schoolCanteenRegistrationRequestXml.sizeOfCanteenAttendingDaysArray() > 0) {
            for (int i = 0; i < schoolCanteenRegistrationRequestXml.getCanteenAttendingDaysArray().length; i++) {
                canteenAttendingDaysList.add(LocalReferentialData.xmlToModel(schoolCanteenRegistrationRequestXml.getCanteenAttendingDaysArray(i)));
            }
        }
        schoolCanteenRegistrationRequest.setCanteenAttendingDays(canteenAttendingDaysList);
        if (schoolCanteenRegistrationRequestXml.getSchool() != null)
            schoolCanteenRegistrationRequest.setSchool(School.xmlToModel(schoolCanteenRegistrationRequestXml.getSchool()));
        schoolCanteenRegistrationRequest.setHospitalizationPermission(Boolean.valueOf(schoolCanteenRegistrationRequestXml.getHospitalizationPermission()));
        schoolCanteenRegistrationRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(schoolCanteenRegistrationRequestXml.getRulesAndRegulationsAcceptance()));
        schoolCanteenRegistrationRequest.setUrgencyPhone(schoolCanteenRegistrationRequestXml.getUrgencyPhone());
        if (schoolCanteenRegistrationRequestXml.getSection() != null)
            schoolCanteenRegistrationRequest.setSection(fr.cg95.cvq.business.users.SectionType.forString(schoolCanteenRegistrationRequestXml.getSection().toString()));
        else
            schoolCanteenRegistrationRequest.setSection(fr.cg95.cvq.business.users.SectionType.getDefaultSectionType());
        return schoolCanteenRegistrationRequest;
    }

    private List<fr.cg95.cvq.business.users.LocalReferentialData> foodDiet;

    public final void setFoodDiet(final List<fr.cg95.cvq.business.users.LocalReferentialData> foodDiet) {
        this.foodDiet = foodDiet;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     *  table="school_canteen_registration_request_food_diet"
     * @hibernate.key
     *  column="school_canteen_registration_request_id"
     * @hibernate.list-index
     *  column="food_diet_index"
     * @hibernate.many-to-many
     *  column="food_diet_id"
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     */
    public final List<fr.cg95.cvq.business.users.LocalReferentialData> getFoodDiet() {
        return this.foodDiet;
    }

    private Boolean foodAllergy;

    public final void setFoodAllergy(final Boolean foodAllergy) {
        this.foodAllergy = foodAllergy;
    }


    /**
     * @hibernate.property
     *  column="food_allergy"
     */
    public final Boolean getFoodAllergy() {
        return this.foodAllergy;
    }

    private String doctorPhone;

    public final void setDoctorPhone(final String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }


    /**
     * @hibernate.property
     *  column="doctor_phone"
     *  length="10"
     */
    public final String getDoctorPhone() {
        return this.doctorPhone;
    }

    private String doctorName;

    public final void setDoctorName(final String doctorName) {
        this.doctorName = doctorName;
    }


    /**
     * @hibernate.property
     *  column="doctor_name"
     */
    public final String getDoctorName() {
        return this.doctorName;
    }

    private List<fr.cg95.cvq.business.users.LocalReferentialData> canteenAttendingDays;

    public final void setCanteenAttendingDays(final List<fr.cg95.cvq.business.users.LocalReferentialData> canteenAttendingDays) {
        this.canteenAttendingDays = canteenAttendingDays;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     *  table="school_canteen_registration_request_canteen_attending_days"
     * @hibernate.key
     *  column="school_canteen_registration_request_id"
     * @hibernate.list-index
     *  column="canteen_attending_days_index"
     * @hibernate.many-to-many
     *  column="canteen_attending_days_id"
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     */
    public final List<fr.cg95.cvq.business.users.LocalReferentialData> getCanteenAttendingDays() {
        return this.canteenAttendingDays;
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
