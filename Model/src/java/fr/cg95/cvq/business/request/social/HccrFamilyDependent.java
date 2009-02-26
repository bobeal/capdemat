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
 *  table="hccr_family_dependent"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HccrFamilyDependent implements Serializable {

    private static final long serialVersionUID = 1L;



    public HccrFamilyDependent() {
        super();
    }


    public final String modelToXmlString() {

        HccrFamilyDependentType object = (HccrFamilyDependentType) this.modelToXml();
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
        HccrFamilyDependentType hccrFamilyDependent = HccrFamilyDependentType.Factory.newInstance();
        hccrFamilyDependent.setReferentFamilyDependentFirstName(this.referentFamilyDependentFirstName);
        date = this.referentFamilyDependentBirthDate;
        if (date != null) {
            calendar.setTime(date);
            hccrFamilyDependent.setReferentFamilyDependentBirthDate(calendar);
        }
        if (this.referentFamilyDependentActualSituation != null)
            hccrFamilyDependent.setReferentFamilyDependentActualSituation(fr.cg95.cvq.xml.request.social.HccrReferentFamilyDependentActualSituationType.Enum.forString(this.referentFamilyDependentActualSituation.toString()));
        hccrFamilyDependent.setReferentFamilyDependentLastName(this.referentFamilyDependentLastName);
        return hccrFamilyDependent;
    }

    public static HccrFamilyDependent xmlToModel(HccrFamilyDependentType hccrFamilyDependentDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HccrFamilyDependent hccrFamilyDependent = new HccrFamilyDependent();
        hccrFamilyDependent.setReferentFamilyDependentFirstName(hccrFamilyDependentDoc.getReferentFamilyDependentFirstName());
        calendar = hccrFamilyDependentDoc.getReferentFamilyDependentBirthDate();
        if (calendar != null) {
            hccrFamilyDependent.setReferentFamilyDependentBirthDate(calendar.getTime());
        }
        if (hccrFamilyDependentDoc.getReferentFamilyDependentActualSituation() != null)
            hccrFamilyDependent.setReferentFamilyDependentActualSituation(fr.cg95.cvq.business.request.social.HccrReferentFamilyDependentActualSituationType.forString(hccrFamilyDependentDoc.getReferentFamilyDependentActualSituation().toString()));
        else
            hccrFamilyDependent.setReferentFamilyDependentActualSituation(fr.cg95.cvq.business.request.social.HccrReferentFamilyDependentActualSituationType.getDefaultHccrReferentFamilyDependentActualSituationType());
        hccrFamilyDependent.setReferentFamilyDependentLastName(hccrFamilyDependentDoc.getReferentFamilyDependentLastName());
        return hccrFamilyDependent;
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

    private String referentFamilyDependentFirstName;

    public final void setReferentFamilyDependentFirstName(final String referentFamilyDependentFirstName) {
        this.referentFamilyDependentFirstName = referentFamilyDependentFirstName;
    }


    /**
     * @hibernate.property
     *  column="referent_family_dependent_first_name"
     *  length="38"
     */
    public final String getReferentFamilyDependentFirstName() {
        return this.referentFamilyDependentFirstName;
    }

    private java.util.Date referentFamilyDependentBirthDate;

    public final void setReferentFamilyDependentBirthDate(final java.util.Date referentFamilyDependentBirthDate) {
        this.referentFamilyDependentBirthDate = referentFamilyDependentBirthDate;
    }


    /**
     * @hibernate.property
     *  column="referent_family_dependent_birth_date"
     */
    public final java.util.Date getReferentFamilyDependentBirthDate() {
        return this.referentFamilyDependentBirthDate;
    }

    private fr.cg95.cvq.business.request.social.HccrReferentFamilyDependentActualSituationType referentFamilyDependentActualSituation;

    public final void setReferentFamilyDependentActualSituation(final fr.cg95.cvq.business.request.social.HccrReferentFamilyDependentActualSituationType referentFamilyDependentActualSituation) {
        this.referentFamilyDependentActualSituation = referentFamilyDependentActualSituation;
    }


    /**
     * @hibernate.property
     *  column="referent_family_dependent_actual_situation"
     */
    public final fr.cg95.cvq.business.request.social.HccrReferentFamilyDependentActualSituationType getReferentFamilyDependentActualSituation() {
        return this.referentFamilyDependentActualSituation;
    }

    private String referentFamilyDependentLastName;

    public final void setReferentFamilyDependentLastName(final String referentFamilyDependentLastName) {
        this.referentFamilyDependentLastName = referentFamilyDependentLastName;
    }


    /**
     * @hibernate.property
     *  column="referent_family_dependent_last_name"
     *  length="38"
     */
    public final String getReferentFamilyDependentLastName() {
        return this.referentFamilyDependentLastName;
    }

}
