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
 *  table="hccr_family_assistance_member"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HccrFamilyAssistanceMember implements Serializable {

    private static final long serialVersionUID = 1L;



    public HccrFamilyAssistanceMember() {
        super();
    }


    public final String modelToXmlString() {

        HccrFamilyAssistanceMemberType object = (HccrFamilyAssistanceMemberType) this.modelToXml();
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
        HccrFamilyAssistanceMemberType hccrFamilyAssistanceMember = HccrFamilyAssistanceMemberType.Factory.newInstance();
        hccrFamilyAssistanceMember.setFamilyAssistanceMemberLastName(this.familyAssistanceMemberLastName);
        hccrFamilyAssistanceMember.setFamilyAssistanceMemberRelationship(this.familyAssistanceMemberRelationship);
        hccrFamilyAssistanceMember.setFamilyAssistanceMemberFirstName(this.familyAssistanceMemberFirstName);
        return hccrFamilyAssistanceMember;
    }

    public static HccrFamilyAssistanceMember xmlToModel(HccrFamilyAssistanceMemberType hccrFamilyAssistanceMemberDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HccrFamilyAssistanceMember hccrFamilyAssistanceMember = new HccrFamilyAssistanceMember();
        hccrFamilyAssistanceMember.setFamilyAssistanceMemberLastName(hccrFamilyAssistanceMemberDoc.getFamilyAssistanceMemberLastName());
        hccrFamilyAssistanceMember.setFamilyAssistanceMemberRelationship(hccrFamilyAssistanceMemberDoc.getFamilyAssistanceMemberRelationship());
        hccrFamilyAssistanceMember.setFamilyAssistanceMemberFirstName(hccrFamilyAssistanceMemberDoc.getFamilyAssistanceMemberFirstName());
        return hccrFamilyAssistanceMember;
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
