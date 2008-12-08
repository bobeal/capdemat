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
 *  table="har_family_carer"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HarFamilyCarer implements Serializable {

    private static final long serialVersionUID = 1L;



    public HarFamilyCarer() {
        super();
    }


    public final String modelToXmlString() {

        HarFamilyCarerType object = (HarFamilyCarerType) this.modelToXml();
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
        HarFamilyCarerType harFamilyCarer = HarFamilyCarerType.Factory.newInstance();
        harFamilyCarer.setHarFamilyCarerRelationship(this.harFamilyCarerRelationship);
        harFamilyCarer.setHarFamilyCarerLastName(this.harFamilyCarerLastName);
        harFamilyCarer.setHarFamilyCarerFirstName(this.harFamilyCarerFirstName);
        return harFamilyCarer;
    }

    public static HarFamilyCarer xmlToModel(HarFamilyCarerType harFamilyCarerDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HarFamilyCarer harFamilyCarer = new HarFamilyCarer();
        harFamilyCarer.setHarFamilyCarerRelationship(harFamilyCarerDoc.getHarFamilyCarerRelationship());
        harFamilyCarer.setHarFamilyCarerLastName(harFamilyCarerDoc.getHarFamilyCarerLastName());
        harFamilyCarer.setHarFamilyCarerFirstName(harFamilyCarerDoc.getHarFamilyCarerFirstName());
        return harFamilyCarer;
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

    private String harFamilyCarerRelationship;

    public final void setHarFamilyCarerRelationship(final String harFamilyCarerRelationship) {
        this.harFamilyCarerRelationship = harFamilyCarerRelationship;
    }


    /**
     * @hibernate.property
     *  column="har_family_carer_relationship"
     */
    public final String getHarFamilyCarerRelationship() {
        return this.harFamilyCarerRelationship;
    }

    private String harFamilyCarerLastName;

    public final void setHarFamilyCarerLastName(final String harFamilyCarerLastName) {
        this.harFamilyCarerLastName = harFamilyCarerLastName;
    }


    /**
     * @hibernate.property
     *  column="har_family_carer_last_name"
     *  length="38"
     */
    public final String getHarFamilyCarerLastName() {
        return this.harFamilyCarerLastName;
    }

    private String harFamilyCarerFirstName;

    public final void setHarFamilyCarerFirstName(final String harFamilyCarerFirstName) {
        this.harFamilyCarerFirstName = harFamilyCarerFirstName;
    }


    /**
     * @hibernate.property
     *  column="har_family_carer_first_name"
     *  length="38"
     */
    public final String getHarFamilyCarerFirstName() {
        return this.harFamilyCarerFirstName;
    }

}
