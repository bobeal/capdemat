
package fr.cg95.cvq.business.request.social;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.joda.time.LocalTime;

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
import javax.persistence.*;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

/**
 * Generated class file, do not edit !
 */
@Entity
@Table(name="hcar_professional")
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
        LocalTime localTime = new LocalTime();
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
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        HcarProfessional hcarProfessional = new HcarProfessional();
    
        hcarProfessional.setProfessionalLastName(hcarProfessionalDoc.getProfessionalLastName());
      
        hcarProfessional.setProfessionalFirstName(hcarProfessionalDoc.getProfessionalFirstName());
      
        if (hcarProfessionalDoc.getProfessionalAddress() != null)
            hcarProfessional.setProfessionalAddress(Address.xmlToModel(hcarProfessionalDoc.getProfessionalAddress()));
      
        return hcarProfessional;
    }

    @Override
    public HcarProfessional clone() {
        HcarProfessional result = new HcarProfessional();
        
          
            
        result.setProfessionalLastName(professionalLastName);
      
          
        
          
            
        result.setProfessionalFirstName(professionalFirstName);
      
          
        
          
            
        if (professionalAddress != null)
            result.setProfessionalAddress(professionalAddress.clone());
      
          
        
        return result;
    }

    private Long id;

    public final void setId(final Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
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

    public void setProfessionalLastName(final String professionalLastName) {
        this.professionalLastName = professionalLastName;
    }


    @Column(name="professional_last_name" , length=38 )
      
    public String getProfessionalLastName() {
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

    public void setProfessionalFirstName(final String professionalFirstName) {
        this.professionalFirstName = professionalFirstName;
    }


    @Column(name="professional_first_name" , length=38 )
      
    public String getProfessionalFirstName() {
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

    public void setProfessionalAddress(final fr.cg95.cvq.business.users.Address professionalAddress) {
        this.professionalAddress = professionalAddress;
    }


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="professional_address_id")
      
    public fr.cg95.cvq.business.users.Address getProfessionalAddress() {
        return this.professionalAddress;
    }
  
}
