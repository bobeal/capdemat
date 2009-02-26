package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.util.*;

import java.math.BigInteger;

/**
 * @hibernate.class
 *  table="hcar_family_dependent"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HcarFamilyDependent implements Serializable {

    private static final long serialVersionUID = 1L;



    public HcarFamilyDependent() {
        super();
    }


    public final String modelToXmlString() {

        HcarFamilyDependentType object = (HcarFamilyDependentType) this.modelToXml();
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
        HcarFamilyDependentType hcarFamilyDependent = HcarFamilyDependentType.Factory.newInstance();
        if (this.familyDependentActualSituation != null)
            hcarFamilyDependent.setFamilyDependentActualSituation(fr.cg95.cvq.xml.request.social.HcarFamilyDependentActualSituationType.Enum.forString(this.familyDependentActualSituation.toString()));
        hcarFamilyDependent.setFamilyDependentLastName(this.familyDependentLastName);
        hcarFamilyDependent.setFamilyDependentFirstName(this.familyDependentFirstName);
        date = this.familyDependentBirthDate;
        if (date != null) {
            calendar.setTime(date);
            hcarFamilyDependent.setFamilyDependentBirthDate(calendar);
        }
        return hcarFamilyDependent;
    }

    public static HcarFamilyDependent xmlToModel(HcarFamilyDependentType hcarFamilyDependentDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HcarFamilyDependent hcarFamilyDependent = new HcarFamilyDependent();
        if (hcarFamilyDependentDoc.getFamilyDependentActualSituation() != null)
            hcarFamilyDependent.setFamilyDependentActualSituation(fr.cg95.cvq.business.request.social.HcarFamilyDependentActualSituationType.forString(hcarFamilyDependentDoc.getFamilyDependentActualSituation().toString()));
        else
            hcarFamilyDependent.setFamilyDependentActualSituation(fr.cg95.cvq.business.request.social.HcarFamilyDependentActualSituationType.getDefaultHcarFamilyDependentActualSituationType());
        hcarFamilyDependent.setFamilyDependentLastName(hcarFamilyDependentDoc.getFamilyDependentLastName());
        hcarFamilyDependent.setFamilyDependentFirstName(hcarFamilyDependentDoc.getFamilyDependentFirstName());
        calendar = hcarFamilyDependentDoc.getFamilyDependentBirthDate();
        if (calendar != null) {
            hcarFamilyDependent.setFamilyDependentBirthDate(calendar.getTime());
        }
        return hcarFamilyDependent;
    }

    private Long id;


    public final void setId(final Long id) {
        this.id = id;
    }


    /**
     * @hibernate.id
     *  column="id"
     *  generator-class="sequence"
     */
    public final Long getId() {
        return this.id;
    }

    private fr.cg95.cvq.business.request.social.HcarFamilyDependentActualSituationType familyDependentActualSituation;

    public final void setFamilyDependentActualSituation(final fr.cg95.cvq.business.request.social.HcarFamilyDependentActualSituationType familyDependentActualSituation) {
        this.familyDependentActualSituation = familyDependentActualSituation;
    }


    /**
     * @hibernate.property
     *  column="family_dependent_actual_situation"
     */
    public final fr.cg95.cvq.business.request.social.HcarFamilyDependentActualSituationType getFamilyDependentActualSituation() {
        return this.familyDependentActualSituation;
    }

    private String familyDependentLastName;

    public final void setFamilyDependentLastName(final String familyDependentLastName) {
        this.familyDependentLastName = familyDependentLastName;
    }


    /**
     * @hibernate.property
     *  column="family_dependent_last_name"
     *  length="38"
     */
    public final String getFamilyDependentLastName() {
        return this.familyDependentLastName;
    }

    private String familyDependentFirstName;

    public final void setFamilyDependentFirstName(final String familyDependentFirstName) {
        this.familyDependentFirstName = familyDependentFirstName;
    }


    /**
     * @hibernate.property
     *  column="family_dependent_first_name"
     *  length="38"
     */
    public final String getFamilyDependentFirstName() {
        return this.familyDependentFirstName;
    }

    private java.util.Date familyDependentBirthDate;

    public final void setFamilyDependentBirthDate(final java.util.Date familyDependentBirthDate) {
        this.familyDependentBirthDate = familyDependentBirthDate;
    }


    /**
     * @hibernate.property
     *  column="family_dependent_birth_date"
     */
    public final java.util.Date getFamilyDependentBirthDate() {
        return this.familyDependentBirthDate;
    }

}
