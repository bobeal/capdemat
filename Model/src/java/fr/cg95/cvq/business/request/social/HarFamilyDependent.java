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
        if (this.harFamilyDependentActualSituation != null)
            harFamilyDependent.setHarFamilyDependentActualSituation(fr.cg95.cvq.xml.request.social.HarFamilyDependentActualSituationType.Enum.forString(this.harFamilyDependentActualSituation.toString()));
        harFamilyDependent.setHarFamilyDependentFirstName(this.harFamilyDependentFirstName);
        harFamilyDependent.setHarFamilyDependentLastName(this.harFamilyDependentLastName);
        date = this.harFamilyDependentBirthDate;
        if (date != null) {
            calendar.setTime(date);
            harFamilyDependent.setHarFamilyDependentBirthDate(calendar);
        }
        return harFamilyDependent;
    }

    public static HarFamilyDependent xmlToModel(HarFamilyDependentType harFamilyDependentDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HarFamilyDependent harFamilyDependent = new HarFamilyDependent();
        if (harFamilyDependentDoc.getHarFamilyDependentActualSituation() != null)
            harFamilyDependent.setHarFamilyDependentActualSituation(fr.cg95.cvq.business.request.social.HarFamilyDependentActualSituationType.forString(harFamilyDependentDoc.getHarFamilyDependentActualSituation().toString()));
        else
            harFamilyDependent.setHarFamilyDependentActualSituation(fr.cg95.cvq.business.request.social.HarFamilyDependentActualSituationType.getDefaultHarFamilyDependentActualSituationType());
        harFamilyDependent.setHarFamilyDependentFirstName(harFamilyDependentDoc.getHarFamilyDependentFirstName());
        harFamilyDependent.setHarFamilyDependentLastName(harFamilyDependentDoc.getHarFamilyDependentLastName());
        calendar = harFamilyDependentDoc.getHarFamilyDependentBirthDate();
        if (calendar != null) {
            harFamilyDependent.setHarFamilyDependentBirthDate(calendar.getTime());
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

    private fr.cg95.cvq.business.request.social.HarFamilyDependentActualSituationType harFamilyDependentActualSituation;

    public final void setHarFamilyDependentActualSituation(final fr.cg95.cvq.business.request.social.HarFamilyDependentActualSituationType harFamilyDependentActualSituation) {
        this.harFamilyDependentActualSituation = harFamilyDependentActualSituation;
    }


    /**
     * @hibernate.property
     *  column="har_family_dependent_actual_situation"
     */
    public final fr.cg95.cvq.business.request.social.HarFamilyDependentActualSituationType getHarFamilyDependentActualSituation() {
        return this.harFamilyDependentActualSituation;
    }

    private String harFamilyDependentFirstName;

    public final void setHarFamilyDependentFirstName(final String harFamilyDependentFirstName) {
        this.harFamilyDependentFirstName = harFamilyDependentFirstName;
    }


    /**
     * @hibernate.property
     *  column="har_family_dependent_first_name"
     *  length="38"
     */
    public final String getHarFamilyDependentFirstName() {
        return this.harFamilyDependentFirstName;
    }

    private String harFamilyDependentLastName;

    public final void setHarFamilyDependentLastName(final String harFamilyDependentLastName) {
        this.harFamilyDependentLastName = harFamilyDependentLastName;
    }


    /**
     * @hibernate.property
     *  column="har_family_dependent_last_name"
     *  length="38"
     */
    public final String getHarFamilyDependentLastName() {
        return this.harFamilyDependentLastName;
    }

    private java.util.Date harFamilyDependentBirthDate;

    public final void setHarFamilyDependentBirthDate(final java.util.Date harFamilyDependentBirthDate) {
        this.harFamilyDependentBirthDate = harFamilyDependentBirthDate;
    }


    /**
     * @hibernate.property
     *  column="har_family_dependent_birth_date"
     */
    public final java.util.Date getHarFamilyDependentBirthDate() {
        return this.harFamilyDependentBirthDate;
    }

}
