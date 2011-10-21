
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
@Table(name="hcar_other_benefit")
public class HcarOtherBenefit implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        HandicapCompensationAdultRequest.conditions;

    public HcarOtherBenefit() {
        super();
      
    }

    public final String modelToXmlString() {
        HcarOtherBenefitType object = (HcarOtherBenefitType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final HcarOtherBenefitType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LocalTime localTime = new LocalTime();
        HcarOtherBenefitType hcarOtherBenefit = HcarOtherBenefitType.Factory.newInstance();
        int i = 0;
    
        hcarOtherBenefit.setOtherBenefitName(this.otherBenefitName);
      
        return hcarOtherBenefit;
    }

    public static HcarOtherBenefit xmlToModel(HcarOtherBenefitType hcarOtherBenefitDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        HcarOtherBenefit hcarOtherBenefit = new HcarOtherBenefit();
    
        hcarOtherBenefit.setOtherBenefitName(hcarOtherBenefitDoc.getOtherBenefitName());
      
        return hcarOtherBenefit;
    }

    @Override
    public HcarOtherBenefit clone() {
        HcarOtherBenefit result = new HcarOtherBenefit();
        
          
            
        result.setOtherBenefitName(otherBenefitName);
      
          
        
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
        
          value = 60,
        
        
        profiles = {"benefits"},
        message = "otherBenefitName"
      )
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "otherBenefitName"
      )
    
      @NotBlank(
        
        
        profiles = {"benefits"},
        message = "otherBenefitName"
      )
    
    private String otherBenefitName;

    public void setOtherBenefitName(final String otherBenefitName) {
        this.otherBenefitName = otherBenefitName;
    }


    @Column(name="other_benefit_name" , length=60 )
      
    public String getOtherBenefitName() {
        return this.otherBenefitName;
    }
  
}
