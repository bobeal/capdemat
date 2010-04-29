
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
 *  table="hcar_care_service"
 *  lazy="false"
 */
public class HcarCareService implements Serializable {

    private static final long serialVersionUID = 1L;

    public HcarCareService() {
        super();
      
        careServiceCareServiceEmployer = Boolean.valueOf(false);
      
    }

    public final String modelToXmlString() {
        HcarCareServiceType object = (HcarCareServiceType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final HcarCareServiceType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        HcarCareServiceType hcarCareService = HcarCareServiceType.Factory.newInstance();
        int i = 0;
    
        if (this.careServiceCareServiceEmployer != null)
            hcarCareService.setCareServiceCareServiceEmployer(this.careServiceCareServiceEmployer.booleanValue());
      
        hcarCareService.setCareServiceKind(this.careServiceKind);
      
        hcarCareService.setCareServiceProviderName(this.careServiceProviderName);
      
        if (this.careServiceProviderAddress != null)
            hcarCareService.setCareServiceProviderAddress(Address.modelToXml(this.careServiceProviderAddress));
      
        return hcarCareService;
    }

    public static HcarCareService xmlToModel(HcarCareServiceType hcarCareServiceDoc) {
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HcarCareService hcarCareService = new HcarCareService();
    
        hcarCareService.setCareServiceCareServiceEmployer(Boolean.valueOf(hcarCareServiceDoc.getCareServiceCareServiceEmployer()));
      
        hcarCareService.setCareServiceKind(hcarCareServiceDoc.getCareServiceKind());
      
        hcarCareService.setCareServiceProviderName(hcarCareServiceDoc.getCareServiceProviderName());
      
        if (hcarCareServiceDoc.getCareServiceProviderAddress() != null)
            hcarCareService.setCareServiceProviderAddress(Address.xmlToModel(hcarCareServiceDoc.getCareServiceProviderAddress()));
      
        return hcarCareService;
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

  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "careServiceCareServiceEmployer"
      )
    
    private Boolean careServiceCareServiceEmployer;

    public final void setCareServiceCareServiceEmployer(final Boolean careServiceCareServiceEmployer) {
        this.careServiceCareServiceEmployer = careServiceCareServiceEmployer;
    }

    /**
  
        * @hibernate.property
        *  column="care_service_care_service_employer"
        
      
    */
    public final Boolean getCareServiceCareServiceEmployer() {
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

    public final void setCareServiceKind(final String careServiceKind) {
        this.careServiceKind = careServiceKind;
    }

    /**
  
        * @hibernate.property
        *  column="care_service_kind"
        
      
    */
    public final String getCareServiceKind() {
        return this.careServiceKind;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['hcarCareService.careServiceCareServiceEmployer'].test(_this.careServiceCareServiceEmployer.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "careServiceProviderName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['hcarCareService.careServiceCareServiceEmployer'].test(_this.careServiceCareServiceEmployer.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "careServiceProviderName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['hcarCareService.careServiceCareServiceEmployer'].test(_this.careServiceCareServiceEmployer.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "careServiceProviderName"
      )
    
    private String careServiceProviderName;

    public final void setCareServiceProviderName(final String careServiceProviderName) {
        this.careServiceProviderName = careServiceProviderName;
    }

    /**
  
        * @hibernate.property
        *  column="care_service_provider_name"
        *  length="38"
      
    */
    public final String getCareServiceProviderName() {
        return this.careServiceProviderName;
    }
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['hcarCareService.careServiceCareServiceEmployer'].test(_this.careServiceCareServiceEmployer.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "careServiceProviderAddress"
      )
    
    private fr.cg95.cvq.business.users.Address careServiceProviderAddress;

    public final void setCareServiceProviderAddress(final fr.cg95.cvq.business.users.Address careServiceProviderAddress) {
        this.careServiceProviderAddress = careServiceProviderAddress;
    }

    /**
  
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="care_service_provider_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getCareServiceProviderAddress() {
        return this.careServiceProviderAddress;
    }
  
}
