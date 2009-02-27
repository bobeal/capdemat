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
 *  table="hccr_other_benefit"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HccrOtherBenefit implements Serializable {

    private static final long serialVersionUID = 1L;



    public HccrOtherBenefit() {
        super();
    }


    public final String modelToXmlString() {

        HccrOtherBenefitType object = (HccrOtherBenefitType) this.modelToXml();
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
        HccrOtherBenefitType hccrOtherBenefit = HccrOtherBenefitType.Factory.newInstance();
        hccrOtherBenefit.setOtherBenefitName(this.otherBenefitName);
        return hccrOtherBenefit;
    }

    public static HccrOtherBenefit xmlToModel(HccrOtherBenefitType hccrOtherBenefitDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HccrOtherBenefit hccrOtherBenefit = new HccrOtherBenefit();
        hccrOtherBenefit.setOtherBenefitName(hccrOtherBenefitDoc.getOtherBenefitName());
        return hccrOtherBenefit;
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

    private String otherBenefitName;

    public final void setOtherBenefitName(final String otherBenefitName) {
        this.otherBenefitName = otherBenefitName;
    }


    /**
     * @hibernate.property
     *  column="other_benefit_name"
     *  length="60"
     */
    public final String getOtherBenefitName() {
        return this.otherBenefitName;
    }

}
