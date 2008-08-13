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
 *  table="dhr_personal_estate_and_saving"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class DhrPersonalEstateAndSaving implements Serializable {

    private static final long serialVersionUID = 1L;



    public DhrPersonalEstateAndSaving() {
        super();
    }


    public final String modelToXmlString() {

        DhrPersonalEstateAndSavingType object = (DhrPersonalEstateAndSavingType) this.modelToXml();
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
        DhrPersonalEstateAndSavingType dhrPersonalEstateAndSaving = DhrPersonalEstateAndSavingType.Factory.newInstance();
        dhrPersonalEstateAndSaving.setPaybookNumber(this.paybookNumber);
        if (this.paybookAmount != null)
            dhrPersonalEstateAndSaving.setPaybookAmount(new BigInteger(this.paybookAmount.toString()));
        return dhrPersonalEstateAndSaving;
    }

    public static DhrPersonalEstateAndSaving xmlToModel(DhrPersonalEstateAndSavingType dhrPersonalEstateAndSavingDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        DhrPersonalEstateAndSaving dhrPersonalEstateAndSaving = new DhrPersonalEstateAndSaving();
        dhrPersonalEstateAndSaving.setPaybookNumber(dhrPersonalEstateAndSavingDoc.getPaybookNumber());
        dhrPersonalEstateAndSaving.setPaybookAmount(dhrPersonalEstateAndSavingDoc.getPaybookAmount());
        return dhrPersonalEstateAndSaving;
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

    private String paybookNumber;

    public final void setPaybookNumber(final String paybookNumber) {
        this.paybookNumber = paybookNumber;
    }


    /**
     * @hibernate.property
     *  column="paybook_number"
     *  length="30"
     */
    public final String getPaybookNumber() {
        return this.paybookNumber;
    }

    private java.math.BigInteger paybookAmount;

    public final void setPaybookAmount(final java.math.BigInteger paybookAmount) {
        this.paybookAmount = paybookAmount;
    }


    /**
     * @hibernate.property
     *  column="paybook_amount"
     *  type="serializable"
     */
    public final java.math.BigInteger getPaybookAmount() {
        return this.paybookAmount;
    }

}
