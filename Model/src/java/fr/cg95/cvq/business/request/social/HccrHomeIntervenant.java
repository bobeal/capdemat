
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
 *  table="hccr_home_intervenant"
 *  lazy="false"
 */
public class HccrHomeIntervenant implements Serializable {

    private static final long serialVersionUID = 1L;

    public HccrHomeIntervenant() {
        super();
      
    }

    public final String modelToXmlString() {
        HccrHomeIntervenantType object = (HccrHomeIntervenantType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final HccrHomeIntervenantType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        HccrHomeIntervenantType hccrHomeIntervenant = HccrHomeIntervenantType.Factory.newInstance();
        int i = 0;
    
        if (this.homeIntervenantKind != null)
            hccrHomeIntervenant.setHomeIntervenantKind(fr.cg95.cvq.xml.request.social.HccrHomeIntervenantKindType.Enum.forString(this.homeIntervenantKind.toString()));
      
        hccrHomeIntervenant.setHomeIntervenantDetails(this.homeIntervenantDetails);
      
        return hccrHomeIntervenant;
    }

    public static HccrHomeIntervenant xmlToModel(HccrHomeIntervenantType hccrHomeIntervenantDoc) {
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HccrHomeIntervenant hccrHomeIntervenant = new HccrHomeIntervenant();
    
        if (hccrHomeIntervenantDoc.getHomeIntervenantKind() != null)
            hccrHomeIntervenant.setHomeIntervenantKind(fr.cg95.cvq.business.request.social.HccrHomeIntervenantKindType.forString(hccrHomeIntervenantDoc.getHomeIntervenantKind().toString()));
        else
            hccrHomeIntervenant.setHomeIntervenantKind(fr.cg95.cvq.business.request.social.HccrHomeIntervenantKindType.getDefaultHccrHomeIntervenantKindType());
      
        hccrHomeIntervenant.setHomeIntervenantDetails(hccrHomeIntervenantDoc.getHomeIntervenantDetails());
      
        return hccrHomeIntervenant;
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
        message = "homeIntervenantKind"
      )
    
    private fr.cg95.cvq.business.request.social.HccrHomeIntervenantKindType homeIntervenantKind;

    public final void setHomeIntervenantKind(final fr.cg95.cvq.business.request.social.HccrHomeIntervenantKindType homeIntervenantKind) {
        this.homeIntervenantKind = homeIntervenantKind;
    }

    /**
  
        * @hibernate.property
        *  column="home_intervenant_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HccrHomeIntervenantKindType getHomeIntervenantKind() {
        return this.homeIntervenantKind;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['hccrHomeIntervenant.homeIntervenantKind'].test(_this.homeIntervenantKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "homeIntervenantDetails"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['hccrHomeIntervenant.homeIntervenantKind'].test(_this.homeIntervenantKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "homeIntervenantDetails"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['hccrHomeIntervenant.homeIntervenantKind'].test(_this.homeIntervenantKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "homeIntervenantDetails"
      )
    
    private String homeIntervenantDetails;

    public final void setHomeIntervenantDetails(final String homeIntervenantDetails) {
        this.homeIntervenantDetails = homeIntervenantDetails;
    }

    /**
  
        * @hibernate.property
        *  column="home_intervenant_details"
        *  length="60"
      
    */
    public final String getHomeIntervenantDetails() {
        return this.homeIntervenantDetails;
    }
  
}
