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
 *  table="har_professional"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HarProfessional implements Serializable {

    private static final long serialVersionUID = 1L;



    public HarProfessional() {
        super();
    }


    public final String modelToXmlString() {

        HarProfessionalType object = (HarProfessionalType) this.modelToXml();
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
        HarProfessionalType harProfessional = HarProfessionalType.Factory.newInstance();
        harProfessional.setHarProfessionalCity(this.harProfessionalCity);
        harProfessional.setHarProfessionalLastName(this.harProfessionalLastName);
        harProfessional.setHarProfessionalAddress(this.harProfessionalAddress);
        harProfessional.setHarProfessionalPostalCode(this.harProfessionalPostalCode);
        harProfessional.setHarProfessionalFirstName(this.harProfessionalFirstName);
        return harProfessional;
    }

    public static HarProfessional xmlToModel(HarProfessionalType harProfessionalDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HarProfessional harProfessional = new HarProfessional();
        harProfessional.setHarProfessionalCity(harProfessionalDoc.getHarProfessionalCity());
        harProfessional.setHarProfessionalLastName(harProfessionalDoc.getHarProfessionalLastName());
        harProfessional.setHarProfessionalAddress(harProfessionalDoc.getHarProfessionalAddress());
        harProfessional.setHarProfessionalPostalCode(harProfessionalDoc.getHarProfessionalPostalCode());
        harProfessional.setHarProfessionalFirstName(harProfessionalDoc.getHarProfessionalFirstName());
        return harProfessional;
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

    private String harProfessionalCity;

    public final void setHarProfessionalCity(final String harProfessionalCity) {
        this.harProfessionalCity = harProfessionalCity;
    }


    /**
     * @hibernate.property
     *  column="har_professional_city"
     *  length="32"
     */
    public final String getHarProfessionalCity() {
        return this.harProfessionalCity;
    }

    private String harProfessionalLastName;

    public final void setHarProfessionalLastName(final String harProfessionalLastName) {
        this.harProfessionalLastName = harProfessionalLastName;
    }


    /**
     * @hibernate.property
     *  column="har_professional_last_name"
     *  length="38"
     */
    public final String getHarProfessionalLastName() {
        return this.harProfessionalLastName;
    }

    private String harProfessionalAddress;

    public final void setHarProfessionalAddress(final String harProfessionalAddress) {
        this.harProfessionalAddress = harProfessionalAddress;
    }


    /**
     * @hibernate.property
     *  column="har_professional_address"
     */
    public final String getHarProfessionalAddress() {
        return this.harProfessionalAddress;
    }

    private String harProfessionalPostalCode;

    public final void setHarProfessionalPostalCode(final String harProfessionalPostalCode) {
        this.harProfessionalPostalCode = harProfessionalPostalCode;
    }


    /**
     * @hibernate.property
     *  column="har_professional_postal_code"
     *  length="5"
     */
    public final String getHarProfessionalPostalCode() {
        return this.harProfessionalPostalCode;
    }

    private String harProfessionalFirstName;

    public final void setHarProfessionalFirstName(final String harProfessionalFirstName) {
        this.harProfessionalFirstName = harProfessionalFirstName;
    }


    /**
     * @hibernate.property
     *  column="har_professional_first_name"
     *  length="38"
     */
    public final String getHarProfessionalFirstName() {
        return this.harProfessionalFirstName;
    }

}
