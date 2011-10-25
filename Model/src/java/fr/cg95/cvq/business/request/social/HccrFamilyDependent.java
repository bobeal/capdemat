
package fr.cg95.cvq.business.request.social;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
@Table(name="hccr_family_dependent")
public class HccrFamilyDependent implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        HandicapCompensationChildRequest.conditions;

    public HccrFamilyDependent() {
        super();
      
    }

    public final String modelToXmlString() {
        HccrFamilyDependentType object = (HccrFamilyDependentType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final HccrFamilyDependentType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LocalTime localTime = new LocalTime();
        HccrFamilyDependentType hccrFamilyDependent = HccrFamilyDependentType.Factory.newInstance();
        int i = 0;
    
        hccrFamilyDependent.setReferentFamilyDependentFirstName(this.referentFamilyDependentFirstName);
      
        date = this.referentFamilyDependentBirthDate;
        if (date != null) {
            calendar.setTime(date);
            hccrFamilyDependent.setReferentFamilyDependentBirthDate(calendar);
        }
      
        if (this.referentFamilyDependentActualSituation != null)
            hccrFamilyDependent.setReferentFamilyDependentActualSituation(fr.cg95.cvq.xml.request.social.HccrReferentFamilyDependentActualSituationType.Enum.forString(this.referentFamilyDependentActualSituation.toString()));
      
        hccrFamilyDependent.setReferentFamilyDependentLastName(this.referentFamilyDependentLastName);
      
        return hccrFamilyDependent;
    }

    public static HccrFamilyDependent xmlToModel(HccrFamilyDependentType hccrFamilyDependentDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        HccrFamilyDependent hccrFamilyDependent = new HccrFamilyDependent();
    
        hccrFamilyDependent.setReferentFamilyDependentFirstName(hccrFamilyDependentDoc.getReferentFamilyDependentFirstName());
      
        calendar = hccrFamilyDependentDoc.getReferentFamilyDependentBirthDate();
        if (calendar != null) {
            hccrFamilyDependent.setReferentFamilyDependentBirthDate(calendar.getTime());
        }
      
        if (hccrFamilyDependentDoc.getReferentFamilyDependentActualSituation() != null)
            hccrFamilyDependent.setReferentFamilyDependentActualSituation(fr.cg95.cvq.business.request.social.HccrReferentFamilyDependentActualSituationType.forString(hccrFamilyDependentDoc.getReferentFamilyDependentActualSituation().toString()));
        else
            hccrFamilyDependent.setReferentFamilyDependentActualSituation(fr.cg95.cvq.business.request.social.HccrReferentFamilyDependentActualSituationType.getDefaultHccrReferentFamilyDependentActualSituationType());
      
        hccrFamilyDependent.setReferentFamilyDependentLastName(hccrFamilyDependentDoc.getReferentFamilyDependentLastName());
      
        return hccrFamilyDependent;
    }

    @Override
    public HccrFamilyDependent clone() {
        HccrFamilyDependent result = new HccrFamilyDependent();
        
          
            
        result.setReferentFamilyDependentFirstName(referentFamilyDependentFirstName);
      
          
        
          
            
        result.setReferentFamilyDependentBirthDate(referentFamilyDependentBirthDate);
      
          
        
          
            
        if (referentFamilyDependentActualSituation != null)
            result.setReferentFamilyDependentActualSituation(referentFamilyDependentActualSituation);
        else
            result.setReferentFamilyDependentActualSituation(fr.cg95.cvq.business.request.social.HccrReferentFamilyDependentActualSituationType.getDefaultHccrReferentFamilyDependentActualSituationType());
      
          
        
          
            
        result.setReferentFamilyDependentLastName(referentFamilyDependentLastName);
      
          
        
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
        
        
        profiles = {"subject"},
        message = "referentFamilyDependentFirstName"
      )
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "referentFamilyDependentFirstName"
      )
    
      @NotBlank(
        
        
        profiles = {"subject"},
        message = "referentFamilyDependentFirstName"
      )
    
    private String referentFamilyDependentFirstName;

    public void setReferentFamilyDependentFirstName(final String referentFamilyDependentFirstName) {
        this.referentFamilyDependentFirstName = referentFamilyDependentFirstName;
    }


    @Column(name="referent_family_dependent_first_name" , length=38 )
      
    public String getReferentFamilyDependentFirstName() {
        return this.referentFamilyDependentFirstName;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "referentFamilyDependentBirthDate"
      )
    
    private java.util.Date referentFamilyDependentBirthDate;

    public void setReferentFamilyDependentBirthDate(final java.util.Date referentFamilyDependentBirthDate) {
        this.referentFamilyDependentBirthDate = referentFamilyDependentBirthDate;
    }


    @Column(name="referent_family_dependent_birth_date"  )
      
    public java.util.Date getReferentFamilyDependentBirthDate() {
        return this.referentFamilyDependentBirthDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "referentFamilyDependentActualSituation"
      )
    
    private fr.cg95.cvq.business.request.social.HccrReferentFamilyDependentActualSituationType referentFamilyDependentActualSituation;

    public void setReferentFamilyDependentActualSituation(final fr.cg95.cvq.business.request.social.HccrReferentFamilyDependentActualSituationType referentFamilyDependentActualSituation) {
        this.referentFamilyDependentActualSituation = referentFamilyDependentActualSituation;
    }


    @Enumerated(EnumType.STRING)
    @Column(name="referent_family_dependent_actual_situation"  )
      
    public fr.cg95.cvq.business.request.social.HccrReferentFamilyDependentActualSituationType getReferentFamilyDependentActualSituation() {
        return this.referentFamilyDependentActualSituation;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"subject"},
        message = "referentFamilyDependentLastName"
      )
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "referentFamilyDependentLastName"
      )
    
      @NotBlank(
        
        
        profiles = {"subject"},
        message = "referentFamilyDependentLastName"
      )
    
    private String referentFamilyDependentLastName;

    public void setReferentFamilyDependentLastName(final String referentFamilyDependentLastName) {
        this.referentFamilyDependentLastName = referentFamilyDependentLastName;
    }


    @Column(name="referent_family_dependent_last_name" , length=38 )
      
    public String getReferentFamilyDependentLastName() {
        return this.referentFamilyDependentLastName;
    }
  
}
