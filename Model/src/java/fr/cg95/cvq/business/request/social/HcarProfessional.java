
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
 *  table="hcar_professional"
 *  lazy="false"
 */
public class HcarProfessional implements Serializable {

    private static final long serialVersionUID = 1L;

    public HcarProfessional() {
        super();
      
    }

    public final String modelToXmlString() {
        HcarProfessionalType object = (HcarProfessionalType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final HcarProfessionalType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        HcarProfessionalType hcarProfessional = HcarProfessionalType.Factory.newInstance();
        int i = 0;
    
        hcarProfessional.setProfessionalLastName(this.professionalLastName);
      
        hcarProfessional.setProfessionalFirstName(this.professionalFirstName);
      
        if (this.professionalAddress != null)
            hcarProfessional.setProfessionalAddress(Address.modelToXml(this.professionalAddress));
      
        return hcarProfessional;
    }

    public static HcarProfessional xmlToModel(HcarProfessionalType hcarProfessionalDoc) {
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HcarProfessional hcarProfessional = new HcarProfessional();
    
        hcarProfessional.setProfessionalLastName(hcarProfessionalDoc.getProfessionalLastName());
      
        hcarProfessional.setProfessionalFirstName(hcarProfessionalDoc.getProfessionalFirstName());
      
        if (hcarProfessionalDoc.getProfessionalAddress() != null)
            hcarProfessional.setProfessionalAddress(Address.xmlToModel(hcarProfessionalDoc.getProfessionalAddress()));
      
        return hcarProfessional;
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
        message = "professionalLastName"
      )
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "professionalLastName"
      )
    
      @NotBlank(
        
        
        profiles = {"aid"},
        message = "professionalLastName"
      )
    
    private String professionalLastName;

    public final void setProfessionalLastName(final String professionalLastName) {
        this.professionalLastName = professionalLastName;
    }

    /**
  
        * @hibernate.property
        *  column="professional_last_name"
        *  length="38"
      
    */
    public final String getProfessionalLastName() {
        return this.professionalLastName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"aid"},
        message = "professionalFirstName"
      )
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "professionalFirstName"
      )
    
      @NotBlank(
        
        
        profiles = {"aid"},
        message = "professionalFirstName"
      )
    
    private String professionalFirstName;

    public final void setProfessionalFirstName(final String professionalFirstName) {
        this.professionalFirstName = professionalFirstName;
    }

    /**
  
        * @hibernate.property
        *  column="professional_first_name"
        *  length="38"
      
    */
    public final String getProfessionalFirstName() {
        return this.professionalFirstName;
    }
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "professionalAddress"
      )
    
      @AssertValid(
        
        
        profiles = {"aid"},
        message = "professionalAddress"
      )
    
    private fr.cg95.cvq.business.users.Address professionalAddress;

    public final void setProfessionalAddress(final fr.cg95.cvq.business.users.Address professionalAddress) {
        this.professionalAddress = professionalAddress;
    }

    /**
  
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="professional_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getProfessionalAddress() {
        return this.professionalAddress;
    }
  
}
