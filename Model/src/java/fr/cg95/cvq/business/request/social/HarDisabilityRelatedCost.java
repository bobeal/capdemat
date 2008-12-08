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
 *  table="har_disability_related_cost"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HarDisabilityRelatedCost implements Serializable {

    private static final long serialVersionUID = 1L;



    public HarDisabilityRelatedCost() {
        super();
    }


    public final String modelToXmlString() {

        HarDisabilityRelatedCostType object = (HarDisabilityRelatedCostType) this.modelToXml();
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
        HarDisabilityRelatedCostType harDisabilityRelatedCost = HarDisabilityRelatedCostType.Factory.newInstance();
        harDisabilityRelatedCost.setHarPeriodicity(this.harPeriodicity);
        harDisabilityRelatedCost.setHarCostKind(this.harCostKind);
        return harDisabilityRelatedCost;
    }

    public static HarDisabilityRelatedCost xmlToModel(HarDisabilityRelatedCostType harDisabilityRelatedCostDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HarDisabilityRelatedCost harDisabilityRelatedCost = new HarDisabilityRelatedCost();
        harDisabilityRelatedCost.setHarPeriodicity(harDisabilityRelatedCostDoc.getHarPeriodicity());
        harDisabilityRelatedCost.setHarCostKind(harDisabilityRelatedCostDoc.getHarCostKind());
        return harDisabilityRelatedCost;
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

    private Short harCost;

    public final void setHarCost(final Short harCost) {
        this.harCost = harCost;
    }


    /**
     * @hibernate.property
     *  column="har_cost"
     */
    public final Short getHarCost() {
        return this.harCost;
    }

    private String harPeriodicity;

    public final void setHarPeriodicity(final String harPeriodicity) {
        this.harPeriodicity = harPeriodicity;
    }


    /**
     * @hibernate.property
     *  column="har_periodicity"
     */
    public final String getHarPeriodicity() {
        return this.harPeriodicity;
    }

    private String harCostKind;

    public final void setHarCostKind(final String harCostKind) {
        this.harCostKind = harCostKind;
    }


    /**
     * @hibernate.property
     *  column="har_cost_kind"
     */
    public final String getHarCostKind() {
        return this.harCostKind;
    }

}
