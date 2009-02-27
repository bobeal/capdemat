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
 *  table="hcar_other_benefit"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HcarOtherBenefit implements Serializable {

    private static final long serialVersionUID = 1L;



    public HcarOtherBenefit() {
        super();
    }


    public final String modelToXmlString() {

        HcarOtherBenefitType object = (HcarOtherBenefitType) this.modelToXml();
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
        HcarOtherBenefitType hcarOtherBenefit = HcarOtherBenefitType.Factory.newInstance();
        hcarOtherBenefit.setOtherBenefitName(this.otherBenefitName);
        return hcarOtherBenefit;
    }

    public static HcarOtherBenefit xmlToModel(HcarOtherBenefitType hcarOtherBenefitDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HcarOtherBenefit hcarOtherBenefit = new HcarOtherBenefit();
        hcarOtherBenefit.setOtherBenefitName(hcarOtherBenefitDoc.getOtherBenefitName());
        return hcarOtherBenefit;
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
