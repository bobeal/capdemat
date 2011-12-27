
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
@Table(name="hcar_family_dependent")
public class HcarFamilyDependent implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        HandicapCompensationAdultRequest.conditions;

    public HcarFamilyDependent() {
        super();
      
    }

    public final String modelToXmlString() {
        HcarFamilyDependentType object = (HcarFamilyDependentType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final HcarFamilyDependentType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LocalTime localTime = new LocalTime();
        HcarFamilyDependentType hcarFamilyDependent = HcarFamilyDependentType.Factory.newInstance();
        int i = 0;
    
        if (this.familyDependentActualSituation != null)
            hcarFamilyDependent.setFamilyDependentActualSituation(fr.cg95.cvq.xml.request.social.HcarFamilyDependentActualSituationType.Enum.forString(this.familyDependentActualSituation.getLegacyLabel()));
      
        hcarFamilyDependent.setFamilyDependentLastName(this.familyDependentLastName);
      
        hcarFamilyDependent.setFamilyDependentFirstName(this.familyDependentFirstName);
      
        date = this.familyDependentBirthDate;
        if (date != null) {
            calendar.setTime(date);
            hcarFamilyDependent.setFamilyDependentBirthDate(calendar);
        }
      
        return hcarFamilyDependent;
    }

    public static HcarFamilyDependent xmlToModel(HcarFamilyDependentType hcarFamilyDependentDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        HcarFamilyDependent hcarFamilyDependent = new HcarFamilyDependent();
    
        if (hcarFamilyDependentDoc.getFamilyDependentActualSituation() != null)
            hcarFamilyDependent.setFamilyDependentActualSituation(fr.cg95.cvq.business.request.social.HcarFamilyDependentActualSituationType.forString(hcarFamilyDependentDoc.getFamilyDependentActualSituation().toString()));
        else
            hcarFamilyDependent.setFamilyDependentActualSituation(fr.cg95.cvq.business.request.social.HcarFamilyDependentActualSituationType.getDefaultHcarFamilyDependentActualSituationType());
      
        hcarFamilyDependent.setFamilyDependentLastName(hcarFamilyDependentDoc.getFamilyDependentLastName());
      
        hcarFamilyDependent.setFamilyDependentFirstName(hcarFamilyDependentDoc.getFamilyDependentFirstName());
      
        calendar = hcarFamilyDependentDoc.getFamilyDependentBirthDate();
        if (calendar != null) {
            hcarFamilyDependent.setFamilyDependentBirthDate(calendar.getTime());
        }
      
        return hcarFamilyDependent;
    }

    @Override
    public HcarFamilyDependent clone() {
        HcarFamilyDependent result = new HcarFamilyDependent();
        
          
            
        if (familyDependentActualSituation != null)
            result.setFamilyDependentActualSituation(familyDependentActualSituation);
        else
            result.setFamilyDependentActualSituation(fr.cg95.cvq.business.request.social.HcarFamilyDependentActualSituationType.getDefaultHcarFamilyDependentActualSituationType());
      
          
        
          
            
        result.setFamilyDependentLastName(familyDependentLastName);
      
          
        
          
            
        result.setFamilyDependentFirstName(familyDependentFirstName);
      
          
        
          
            
        result.setFamilyDependentBirthDate(familyDependentBirthDate);
      
          
        
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
        
        
        profiles = {"subject"},
        message = "familyDependentActualSituation"
      )
    
    private fr.cg95.cvq.business.request.social.HcarFamilyDependentActualSituationType familyDependentActualSituation;

    public void setFamilyDependentActualSituation(final fr.cg95.cvq.business.request.social.HcarFamilyDependentActualSituationType familyDependentActualSituation) {
        this.familyDependentActualSituation = familyDependentActualSituation;
    }


    @Enumerated(EnumType.STRING)
    @Column(name="family_dependent_actual_situation"  )
      
    public fr.cg95.cvq.business.request.social.HcarFamilyDependentActualSituationType getFamilyDependentActualSituation() {
        return this.familyDependentActualSituation;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"subject"},
        message = "familyDependentLastName"
      )
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "familyDependentLastName"
      )
    
      @NotBlank(
        
        
        profiles = {"subject"},
        message = "familyDependentLastName"
      )
    
    private String familyDependentLastName;

    public void setFamilyDependentLastName(final String familyDependentLastName) {
        this.familyDependentLastName = familyDependentLastName;
    }


    @Column(name="family_dependent_last_name" , length=38 )
      
    public String getFamilyDependentLastName() {
        return this.familyDependentLastName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"subject"},
        message = "familyDependentFirstName"
      )
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "familyDependentFirstName"
      )
    
      @NotBlank(
        
        
        profiles = {"subject"},
        message = "familyDependentFirstName"
      )
    
    private String familyDependentFirstName;

    public void setFamilyDependentFirstName(final String familyDependentFirstName) {
        this.familyDependentFirstName = familyDependentFirstName;
    }


    @Column(name="family_dependent_first_name" , length=38 )
      
    public String getFamilyDependentFirstName() {
        return this.familyDependentFirstName;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "familyDependentBirthDate"
      )
    
    private java.util.Date familyDependentBirthDate;

    public void setFamilyDependentBirthDate(final java.util.Date familyDependentBirthDate) {
        this.familyDependentBirthDate = familyDependentBirthDate;
    }


    @Column(name="family_dependent_birth_date"  )
      
    public java.util.Date getFamilyDependentBirthDate() {
        return this.familyDependentBirthDate;
    }
  
}
