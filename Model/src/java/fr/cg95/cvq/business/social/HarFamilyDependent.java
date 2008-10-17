package fr.cg95.cvq.business.social;

import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.util.*;

import java.math.BigInteger;

/**
 * @hibernate.class
 *  table="har_family_dependent"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HarFamilyDependent implements Serializable {

    private static final long serialVersionUID = 1L;



    public HarFamilyDependent() {
        super();
    }


    public final String modelToXmlString() {

        HarFamilyDependentType object = (HarFamilyDependentType) this.modelToXml();
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
        HarFamilyDependentType harFamilyDependent = HarFamilyDependentType.Factory.newInstance();
        if (this.familyDependentActualSituation != null)
            harFamilyDependent.setFamilyDependentActualSituation(fr.cg95.cvq.xml.social.HarFamilyDependentActualSituationType.Enum.forString(this.familyDependentActualSituation.toString()));
        harFamilyDependent.setFamilyDependentLastName(this.familyDependentLastName);
        harFamilyDependent.setFamilyDependentFirstName(this.familyDependentFirstName);
        date = this.familyDependentBirthDate;
        if (date != null) {
            calendar.setTime(date);
            harFamilyDependent.setFamilyDependentBirthDate(calendar);
        }
        return harFamilyDependent;
    }

    public static HarFamilyDependent xmlToModel(HarFamilyDependentType harFamilyDependentDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HarFamilyDependent harFamilyDependent = new HarFamilyDependent();
        if (harFamilyDependentDoc.getFamilyDependentActualSituation() != null)
            harFamilyDependent.setFamilyDependentActualSituation(fr.cg95.cvq.business.social.HarFamilyDependentActualSituationType.forString(harFamilyDependentDoc.getFamilyDependentActualSituation().toString()));
        else
            harFamilyDependent.setFamilyDependentActualSituation(fr.cg95.cvq.business.social.HarFamilyDependentActualSituationType.getDefaultHarFamilyDependentActualSituationType());
        harFamilyDependent.setFamilyDependentLastName(harFamilyDependentDoc.getFamilyDependentLastName());
        harFamilyDependent.setFamilyDependentFirstName(harFamilyDependentDoc.getFamilyDependentFirstName());
        calendar = harFamilyDependentDoc.getFamilyDependentBirthDate();
        if (calendar != null) {
            harFamilyDependent.setFamilyDependentBirthDate(calendar.getTime());
        }
        return harFamilyDependent;
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

    private fr.cg95.cvq.business.social.HarFamilyDependentActualSituationType familyDependentActualSituation;

    public final void setFamilyDependentActualSituation(final fr.cg95.cvq.business.social.HarFamilyDependentActualSituationType familyDependentActualSituation) {
        this.familyDependentActualSituation = familyDependentActualSituation;
    }


    /**
     * @hibernate.property
     *  column="family_dependent_actual_situation"
     */
    public final fr.cg95.cvq.business.social.HarFamilyDependentActualSituationType getFamilyDependentActualSituation() {
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
