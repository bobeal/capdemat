package fr.cg95.cvq.business.school;

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
 *  table="vacations_registration_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class VacationsRegistrationRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public VacationsRegistrationRequest() {
        super();
    }


    public final String modelToXmlString() {

        VacationsRegistrationRequestDocument object = (VacationsRegistrationRequestDocument) this.modelToXml();
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
        VacationsRegistrationRequestDocument vacationsRegistrationRequestDoc = VacationsRegistrationRequestDocument.Factory.newInstance();
        VacationsRegistrationRequestDocument.VacationsRegistrationRequest vacationsRegistrationRequest = vacationsRegistrationRequestDoc.addNewVacationsRegistrationRequest();
        super.fillCommonXmlInfo(vacationsRegistrationRequest);
        int i = 0;
        if (vacationsDiary != null) {
            fr.cg95.cvq.xml.school.VacationsDiaryType[] vacationsDiaryTypeTab = new fr.cg95.cvq.xml.school.VacationsDiaryType[vacationsDiary.size()];
            Iterator vacationsDiaryIt = vacationsDiary.iterator();
            while (vacationsDiaryIt.hasNext()) {
                VacationsDiary object = (VacationsDiary) vacationsDiaryIt.next();
                vacationsDiaryTypeTab[i] = (VacationsDiaryType) object.modelToXml();
                i = i + 1;
            }
            vacationsRegistrationRequest.setVacationsDiaryArray(vacationsDiaryTypeTab);
        }
        if (this.vacations != null) {
            String[] splittedValues = this.vacations.split(" ");
            List vacationsList = new ArrayList();
            for (i = 0; i < splittedValues.length; i++)
                vacationsList.add(splittedValues[i]);
            vacationsRegistrationRequest.setVacations(vacationsList);
        }
        vacationsRegistrationRequest.setUrgencyPhone(this.urgencyPhone);
        i = 0;
        if (otherIndividual != null) {
            fr.cg95.cvq.xml.school.OtherIndividualType[] otherIndividualTypeTab = new fr.cg95.cvq.xml.school.OtherIndividualType[otherIndividual.size()];
            Iterator otherIndividualIt = otherIndividual.iterator();
            while (otherIndividualIt.hasNext()) {
                OtherIndividual object = (OtherIndividual) otherIndividualIt.next();
                otherIndividualTypeTab[i] = OtherIndividual.modelToXml(object);
                i = i + 1;
            }
            vacationsRegistrationRequest.setOtherIndividualArray(otherIndividualTypeTab);
        }
        if (this.child != null)
            vacationsRegistrationRequest.setChild(Child.modelToXml(this.child));
        if (this.recreationCenter != null)
            vacationsRegistrationRequest.setRecreationCenter(RecreationCenter.modelToXml(this.recreationCenter));
        return vacationsRegistrationRequestDoc;
    }

    public static VacationsRegistrationRequest xmlToModel(VacationsRegistrationRequestDocument vacationsRegistrationRequestDoc) {

        VacationsRegistrationRequestDocument.VacationsRegistrationRequest vacationsRegistrationRequestXml = vacationsRegistrationRequestDoc.getVacationsRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        VacationsRegistrationRequest vacationsRegistrationRequest = new VacationsRegistrationRequest();
        vacationsRegistrationRequest.fillCommonModelInfo(vacationsRegistrationRequest,vacationsRegistrationRequestXml);
        HashSet vacationsDiarySet = new HashSet();
        if ( vacationsRegistrationRequestXml.sizeOfVacationsDiaryArray() > 0) {
            for (int i = 0; i < vacationsRegistrationRequestXml.getVacationsDiaryArray().length; i++) {
                vacationsDiarySet.add(VacationsDiary.xmlToModel(vacationsRegistrationRequestXml.getVacationsDiaryArray(i)));
            }
        }
        vacationsRegistrationRequest.setVacationsDiary(vacationsDiarySet);
        list = vacationsRegistrationRequestXml.getVacations();
        if (list != null) {
            String tempString = "";
            for (int i=0; i < list.size(); i++) {
                tempString = list.get(i) + " " + tempString;
            }
            vacationsRegistrationRequest.setVacations(tempString);
        }
        vacationsRegistrationRequest.setUrgencyPhone(vacationsRegistrationRequestXml.getUrgencyPhone());
        HashSet otherIndividualSet = new HashSet();
        if ( vacationsRegistrationRequestXml.sizeOfOtherIndividualArray() > 0) {
            for (int i = 0; i < vacationsRegistrationRequestXml.getOtherIndividualArray().length; i++) {
                otherIndividualSet.add(OtherIndividual.xmlToModel(vacationsRegistrationRequestXml.getOtherIndividualArray(i)));
            }
        }
        vacationsRegistrationRequest.setOtherIndividual(otherIndividualSet);
        if (vacationsRegistrationRequestXml.getChild() != null)
            vacationsRegistrationRequest.setChild(Child.xmlToModel(vacationsRegistrationRequestXml.getChild()));
        if (vacationsRegistrationRequestXml.getRecreationCenter() != null)
            vacationsRegistrationRequest.setRecreationCenter(RecreationCenter.xmlToModel(vacationsRegistrationRequestXml.getRecreationCenter()));
        return vacationsRegistrationRequest;
    }

    private Set vacationsDiary;

    public final void setVacationsDiary(final Set vacationsDiary) {
        this.vacationsDiary = vacationsDiary;
    }


    /**
     * @hibernate.set
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="vacations_registration_request_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.school.VacationsDiary"
     */
    public final Set getVacationsDiary() {
        return this.vacationsDiary;
    }

    private String vacations;

    public final void setVacations(final String vacations) {
        this.vacations = vacations;
    }


    /**
     * @hibernate.property
     *  column="vacations"
     */
    public final String getVacations() {
        return this.vacations;
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

    private Set otherIndividual;

    public final void setOtherIndividual(final Set otherIndividual) {
        this.otherIndividual = otherIndividual;
    }


    /**
     * @hibernate.set
     *  inverse="false"
     *  table="vacations_registration_request_other_individual"
     * @hibernate.key
     *  column="vacations_registration_request_id"
     * @hibernate.many-to-many
     *  column="other_individual_id"
     *  class="fr.cg95.cvq.business.school.OtherIndividual"
     */
    public final Set getOtherIndividual() {
        return this.otherIndividual;
    }

    private fr.cg95.cvq.business.users.Child child;

    public final void setChild(final fr.cg95.cvq.business.users.Child child) {
        this.child = child;
    }


    /**
     * @hibernate.many-to-one
     *  column="child_id"
     *  class="fr.cg95.cvq.business.users.Child"
     */
    public final fr.cg95.cvq.business.users.Child getChild() {
        return this.child;
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
