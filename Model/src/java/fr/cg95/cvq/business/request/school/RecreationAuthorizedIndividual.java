package fr.cg95.cvq.business.request.school;

import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.school.*;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.util.*;

import java.math.BigInteger;

/**
 * @hibernate.class
 *  table="recreation_authorized_individual"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class RecreationAuthorizedIndividual implements Serializable {

    private static final long serialVersionUID = 1L;



    public RecreationAuthorizedIndividual() {
        super();
    }


    public final String modelToXmlString() {

        RecreationAuthorizedIndividualType object = (RecreationAuthorizedIndividualType) this.modelToXml();
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
        RecreationAuthorizedIndividualType recreationAuthorizedIndividual = RecreationAuthorizedIndividualType.Factory.newInstance();
        recreationAuthorizedIndividual.setOfficePhone(this.officePhone);
        if (this.address != null)
            recreationAuthorizedIndividual.setAddress(Address.modelToXml(this.address));
        recreationAuthorizedIndividual.setFirstName(this.firstName);
        recreationAuthorizedIndividual.setLastName(this.lastName);
        recreationAuthorizedIndividual.setHomePhone(this.homePhone);
        return recreationAuthorizedIndividual;
    }

    public static RecreationAuthorizedIndividual xmlToModel(RecreationAuthorizedIndividualType recreationAuthorizedIndividualDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        RecreationAuthorizedIndividual recreationAuthorizedIndividual = new RecreationAuthorizedIndividual();
        recreationAuthorizedIndividual.setOfficePhone(recreationAuthorizedIndividualDoc.getOfficePhone());
        if (recreationAuthorizedIndividualDoc.getAddress() != null)
            recreationAuthorizedIndividual.setAddress(Address.xmlToModel(recreationAuthorizedIndividualDoc.getAddress()));
        recreationAuthorizedIndividual.setFirstName(recreationAuthorizedIndividualDoc.getFirstName());
        recreationAuthorizedIndividual.setLastName(recreationAuthorizedIndividualDoc.getLastName());
        recreationAuthorizedIndividual.setHomePhone(recreationAuthorizedIndividualDoc.getHomePhone());
        return recreationAuthorizedIndividual;
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

    private String officePhone;

    public final void setOfficePhone(final String officePhone) {
        this.officePhone = officePhone;
    }


    /**
     * @hibernate.property
     *  column="office_phone"
     *  length="10"
     */
    public final String getOfficePhone() {
        return this.officePhone;
    }

    private fr.cg95.cvq.business.users.Address address;

    public final void setAddress(final fr.cg95.cvq.business.users.Address address) {
        this.address = address;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getAddress() {
        return this.address;
    }

    private String firstName;

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }


    /**
     * @hibernate.property
     *  column="first_name"
     *  length="38"
     */
    public final String getFirstName() {
        return this.firstName;
    }

    private String lastName;

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }


    /**
     * @hibernate.property
     *  column="last_name"
     *  length="38"
     */
    public final String getLastName() {
        return this.lastName;
    }

    private String homePhone;

    public final void setHomePhone(final String homePhone) {
        this.homePhone = homePhone;
    }


    /**
     * @hibernate.property
     *  column="home_phone"
     *  length="10"
     */
    public final String getHomePhone() {
        return this.homePhone;
    }

}
