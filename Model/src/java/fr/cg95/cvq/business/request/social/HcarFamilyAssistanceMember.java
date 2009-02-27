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
 *  table="hcar_family_assistance_member"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HcarFamilyAssistanceMember implements Serializable {

    private static final long serialVersionUID = 1L;



    public HcarFamilyAssistanceMember() {
        super();
    }


    public final String modelToXmlString() {

        HcarFamilyAssistanceMemberType object = (HcarFamilyAssistanceMemberType) this.modelToXml();
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
        HcarFamilyAssistanceMemberType hcarFamilyAssistanceMember = HcarFamilyAssistanceMemberType.Factory.newInstance();
        hcarFamilyAssistanceMember.setFamilyAssistanceMemberLastName(this.familyAssistanceMemberLastName);
        hcarFamilyAssistanceMember.setFamilyAssistanceMemberRelationship(this.familyAssistanceMemberRelationship);
        hcarFamilyAssistanceMember.setFamilyAssistanceMemberFirstName(this.familyAssistanceMemberFirstName);
        return hcarFamilyAssistanceMember;
    }

    public static HcarFamilyAssistanceMember xmlToModel(HcarFamilyAssistanceMemberType hcarFamilyAssistanceMemberDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HcarFamilyAssistanceMember hcarFamilyAssistanceMember = new HcarFamilyAssistanceMember();
        hcarFamilyAssistanceMember.setFamilyAssistanceMemberLastName(hcarFamilyAssistanceMemberDoc.getFamilyAssistanceMemberLastName());
        hcarFamilyAssistanceMember.setFamilyAssistanceMemberRelationship(hcarFamilyAssistanceMemberDoc.getFamilyAssistanceMemberRelationship());
        hcarFamilyAssistanceMember.setFamilyAssistanceMemberFirstName(hcarFamilyAssistanceMemberDoc.getFamilyAssistanceMemberFirstName());
        return hcarFamilyAssistanceMember;
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

    private String familyAssistanceMemberLastName;

    public final void setFamilyAssistanceMemberLastName(final String familyAssistanceMemberLastName) {
        this.familyAssistanceMemberLastName = familyAssistanceMemberLastName;
    }


    /**
     * @hibernate.property
     *  column="family_assistance_member_last_name"
     *  length="38"
     */
    public final String getFamilyAssistanceMemberLastName() {
        return this.familyAssistanceMemberLastName;
    }

    private String familyAssistanceMemberRelationship;

    public final void setFamilyAssistanceMemberRelationship(final String familyAssistanceMemberRelationship) {
        this.familyAssistanceMemberRelationship = familyAssistanceMemberRelationship;
    }


    /**
     * @hibernate.property
     *  column="family_assistance_member_relationship"
     *  length="60"
     */
    public final String getFamilyAssistanceMemberRelationship() {
        return this.familyAssistanceMemberRelationship;
    }

    private String familyAssistanceMemberFirstName;

    public final void setFamilyAssistanceMemberFirstName(final String familyAssistanceMemberFirstName) {
        this.familyAssistanceMemberFirstName = familyAssistanceMemberFirstName;
    }


    /**
     * @hibernate.property
     *  column="family_assistance_member_first_name"
     *  length="38"
     */
    public final String getFamilyAssistanceMemberFirstName() {
        return this.familyAssistanceMemberFirstName;
    }

}
