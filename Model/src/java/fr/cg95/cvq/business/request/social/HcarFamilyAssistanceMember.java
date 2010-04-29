
package fr.cg95.cvq.business.request.social;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.sf.oval.constraint.*;
import org.apache.xmlbeans.XmlOptions;

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="hcar_family_assistance_member"
 *  lazy="false"
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

    public final HcarFamilyAssistanceMemberType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        HcarFamilyAssistanceMemberType hcarFamilyAssistanceMember = HcarFamilyAssistanceMemberType.Factory.newInstance();
        int i = 0;
    
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

  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"aid"},
        message = "familyAssistanceMemberLastName"
      )
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "familyAssistanceMemberLastName"
      )
    
      @NotBlank(
        
        
        profiles = {"aid"},
        message = "familyAssistanceMemberLastName"
      )
    
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
  
    
      @MaxLength(
        
          value = 60,
        
        
        profiles = {"aid"},
        message = "familyAssistanceMemberRelationship"
      )
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "familyAssistanceMemberRelationship"
      )
    
      @NotBlank(
        
        
        profiles = {"aid"},
        message = "familyAssistanceMemberRelationship"
      )
    
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
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"aid"},
        message = "familyAssistanceMemberFirstName"
      )
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "familyAssistanceMemberFirstName"
      )
    
      @NotBlank(
        
        
        profiles = {"aid"},
        message = "familyAssistanceMemberFirstName"
      )
    
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
