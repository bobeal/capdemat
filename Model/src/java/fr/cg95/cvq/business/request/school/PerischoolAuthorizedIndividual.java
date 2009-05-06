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
 *  table="perischool_authorized_individual"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class PerischoolAuthorizedIndividual implements Serializable {

    private static final long serialVersionUID = 1L;



    public PerischoolAuthorizedIndividual() {
        super();
    }


    public final String modelToXmlString() {

        PerischoolAuthorizedIndividualType object = (PerischoolAuthorizedIndividualType) this.modelToXml();
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
        PerischoolAuthorizedIndividualType perischoolAuthorizedIndividual = PerischoolAuthorizedIndividualType.Factory.newInstance();
        perischoolAuthorizedIndividual.setOfficePhone(this.officePhone);
        if (this.address != null)
            perischoolAuthorizedIndividual.setAddress(Address.modelToXml(this.address));
        perischoolAuthorizedIndividual.setFirstName(this.firstName);
        perischoolAuthorizedIndividual.setLastName(this.lastName);
        perischoolAuthorizedIndividual.setHomePhone(this.homePhone);
        return perischoolAuthorizedIndividual;
    }

    public static PerischoolAuthorizedIndividual xmlToModel(PerischoolAuthorizedIndividualType perischoolAuthorizedIndividualDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        PerischoolAuthorizedIndividual perischoolAuthorizedIndividual = new PerischoolAuthorizedIndividual();
        perischoolAuthorizedIndividual.setOfficePhone(perischoolAuthorizedIndividualDoc.getOfficePhone());
        if (perischoolAuthorizedIndividualDoc.getAddress() != null)
            perischoolAuthorizedIndividual.setAddress(Address.xmlToModel(perischoolAuthorizedIndividualDoc.getAddress()));
        perischoolAuthorizedIndividual.setFirstName(perischoolAuthorizedIndividualDoc.getFirstName());
        perischoolAuthorizedIndividual.setLastName(perischoolAuthorizedIndividualDoc.getLastName());
        perischoolAuthorizedIndividual.setHomePhone(perischoolAuthorizedIndividualDoc.getHomePhone());
        return perischoolAuthorizedIndividual;
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
