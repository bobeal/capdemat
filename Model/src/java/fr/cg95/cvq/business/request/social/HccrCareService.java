
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
@Table(name="hccr_care_service")
public class HccrCareService implements Serializable {

    private static final long serialVersionUID = 1L;

    public HccrCareService() {
        super();
      
        careServiceCareServiceEmployer = Boolean.valueOf(false);
      
    }

    public final String modelToXmlString() {
        HccrCareServiceType object = (HccrCareServiceType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final HccrCareServiceType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LocalTime localTime = new LocalTime();
        HccrCareServiceType hccrCareService = HccrCareServiceType.Factory.newInstance();
        int i = 0;
    
        if (this.careServiceCareServiceEmployer != null)
            hccrCareService.setCareServiceCareServiceEmployer(this.careServiceCareServiceEmployer.booleanValue());
      
        hccrCareService.setCareServiceKind(this.careServiceKind);
      
        hccrCareService.setCareServiceProviderName(this.careServiceProviderName);
      
        if (this.careServiceProviderAddress != null)
            hccrCareService.setCareServiceProviderAddress(Address.modelToXml(this.careServiceProviderAddress));
      
        return hccrCareService;
    }

    public static HccrCareService xmlToModel(HccrCareServiceType hccrCareServiceDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        HccrCareService hccrCareService = new HccrCareService();
    
        hccrCareService.setCareServiceCareServiceEmployer(Boolean.valueOf(hccrCareServiceDoc.getCareServiceCareServiceEmployer()));
      
        hccrCareService.setCareServiceKind(hccrCareServiceDoc.getCareServiceKind());
      
        hccrCareService.setCareServiceProviderName(hccrCareServiceDoc.getCareServiceProviderName());
      
        if (hccrCareServiceDoc.getCareServiceProviderAddress() != null)
            hccrCareService.setCareServiceProviderAddress(Address.xmlToModel(hccrCareServiceDoc.getCareServiceProviderAddress()));
      
        return hccrCareService;
    }

    @Override
    public HccrCareService clone() {
        HccrCareService result = new HccrCareService();
        
          
            
        result.setCareServiceCareServiceEmployer(careServiceCareServiceEmployer);
      
          
        
          
            
        result.setCareServiceKind(careServiceKind);
      
          
        
          
            
        result.setCareServiceProviderName(careServiceProviderName);
      
          
        
          
            
        if (careServiceProviderAddress != null)
            result.setCareServiceProviderAddress(careServiceProviderAddress.clone());
      
          
        
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

  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "careServiceCareServiceEmployer"
      )
    
    private Boolean careServiceCareServiceEmployer;

    public void setCareServiceCareServiceEmployer(final Boolean careServiceCareServiceEmployer) {
        this.careServiceCareServiceEmployer = careServiceCareServiceEmployer;
    }


    @Column(name="care_service_care_service_employer"  )
      
    public Boolean getCareServiceCareServiceEmployer() {
        return this.careServiceCareServiceEmployer;
    }
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "careServiceKind"
      )
    
      @NotBlank(
        
        
        profiles = {"aid"},
        message = "careServiceKind"
      )
    
    private String careServiceKind;

    public void setCareServiceKind(final String careServiceKind) {
        this.careServiceKind = careServiceKind;
    }


    @Column(name="care_service_kind"  )
      
    public String getCareServiceKind() {
        return this.careServiceKind;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['hccrCareService.careServiceCareServiceEmployer'].test(_this.careServiceCareServiceEmployer.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "careServiceProviderName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['hccrCareService.careServiceCareServiceEmployer'].test(_this.careServiceCareServiceEmployer.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "careServiceProviderName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['hccrCareService.careServiceCareServiceEmployer'].test(_this.careServiceCareServiceEmployer.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "careServiceProviderName"
      )
    
    private String careServiceProviderName;

    public void setCareServiceProviderName(final String careServiceProviderName) {
        this.careServiceProviderName = careServiceProviderName;
    }


    @Column(name="care_service_provider_name" , length=38 )
      
    public String getCareServiceProviderName() {
        return this.careServiceProviderName;
    }
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['hccrCareService.careServiceCareServiceEmployer'].test(_this.careServiceCareServiceEmployer.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "careServiceProviderAddress"
      )
    
    private fr.cg95.cvq.business.users.Address careServiceProviderAddress;

    public void setCareServiceProviderAddress(final fr.cg95.cvq.business.users.Address careServiceProviderAddress) {
        this.careServiceProviderAddress = careServiceProviderAddress;
    }


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="care_service_provider_address_id")
      
    public fr.cg95.cvq.business.users.Address getCareServiceProviderAddress() {
        return this.careServiceProviderAddress;
    }
  
}
