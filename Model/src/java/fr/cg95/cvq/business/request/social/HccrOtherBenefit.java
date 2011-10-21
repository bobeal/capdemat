
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
@Table(name="hccr_other_benefit")
public class HccrOtherBenefit implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        HandicapCompensationChildRequest.conditions;

    public HccrOtherBenefit() {
        super();
      
    }

    public final String modelToXmlString() {
        HccrOtherBenefitType object = (HccrOtherBenefitType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final HccrOtherBenefitType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LocalTime localTime = new LocalTime();
        HccrOtherBenefitType hccrOtherBenefit = HccrOtherBenefitType.Factory.newInstance();
        int i = 0;
    
        hccrOtherBenefit.setOtherBenefitName(this.otherBenefitName);
      
        return hccrOtherBenefit;
    }

    public static HccrOtherBenefit xmlToModel(HccrOtherBenefitType hccrOtherBenefitDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        HccrOtherBenefit hccrOtherBenefit = new HccrOtherBenefit();
    
        hccrOtherBenefit.setOtherBenefitName(hccrOtherBenefitDoc.getOtherBenefitName());
      
        return hccrOtherBenefit;
    }

    @Override
    public HccrOtherBenefit clone() {
        HccrOtherBenefit result = new HccrOtherBenefit();
        
          
            
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
