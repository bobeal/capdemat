
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
@Table(name="hccr_additional_fee")
public class HccrAdditionalFee implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        HandicapCompensationChildRequest.conditions;

    public HccrAdditionalFee() {
        super();
      
    }

    public final String modelToXmlString() {
        HccrAdditionalFeeType object = (HccrAdditionalFeeType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final HccrAdditionalFeeType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LocalTime localTime = new LocalTime();
        HccrAdditionalFeeType hccrAdditionalFee = HccrAdditionalFeeType.Factory.newInstance();
        int i = 0;
    
        hccrAdditionalFee.setAdditionalFeeKind(this.additionalFeeKind);
      
        hccrAdditionalFee.setAdditionalFeePeriodicity(this.additionalFeePeriodicity);
      
        hccrAdditionalFee.setAdditionalFeeCost(this.additionalFeeCost);
      
        return hccrAdditionalFee;
    }

    public static HccrAdditionalFee xmlToModel(HccrAdditionalFeeType hccrAdditionalFeeDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        HccrAdditionalFee hccrAdditionalFee = new HccrAdditionalFee();
    
        hccrAdditionalFee.setAdditionalFeeKind(hccrAdditionalFeeDoc.getAdditionalFeeKind());
      
        hccrAdditionalFee.setAdditionalFeePeriodicity(hccrAdditionalFeeDoc.getAdditionalFeePeriodicity());
      
        hccrAdditionalFee.setAdditionalFeeCost(hccrAdditionalFeeDoc.getAdditionalFeeCost());
      
        return hccrAdditionalFee;
    }

    @Override
    public HccrAdditionalFee clone() {
        HccrAdditionalFee result = new HccrAdditionalFee();
        
          
            
        result.setAdditionalFeeKind(additionalFeeKind);
      
          
        
          
            
        result.setAdditionalFeePeriodicity(additionalFeePeriodicity);
      
          
        
          
            
        result.setAdditionalFeeCost(additionalFeeCost);
      
          
        
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
        
          value = 30,
        
        
        profiles = {"benefits"},
        message = "additionalFeeKind"
      )
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "additionalFeeKind"
      )
    
      @NotBlank(
        
        
        profiles = {"benefits"},
        message = "additionalFeeKind"
      )
    
    private String additionalFeeKind;

    public void setAdditionalFeeKind(final String additionalFeeKind) {
        this.additionalFeeKind = additionalFeeKind;
    }


    @Column(name="additional_fee_kind" , length=30 )
      
    public String getAdditionalFeeKind() {
        return this.additionalFeeKind;
    }
  
    
      @MaxLength(
        
          value = 30,
        
        
        profiles = {"benefits"},
        message = "additionalFeePeriodicity"
      )
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "additionalFeePeriodicity"
      )
    
      @NotBlank(
        
        
        profiles = {"benefits"},
        message = "additionalFeePeriodicity"
      )
    
    private String additionalFeePeriodicity;

    public void setAdditionalFeePeriodicity(final String additionalFeePeriodicity) {
        this.additionalFeePeriodicity = additionalFeePeriodicity;
    }


    @Column(name="additional_fee_periodicity" , length=30 )
      
    public String getAdditionalFeePeriodicity() {
        return this.additionalFeePeriodicity;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "additionalFeeCost"
      )
    
      @NotBlank(
        
        
        profiles = {"benefits"},
        message = "additionalFeeCost"
      )
    
    private String additionalFeeCost;

    public void setAdditionalFeeCost(final String additionalFeeCost) {
        this.additionalFeeCost = additionalFeeCost;
    }


    @Column(name="additional_fee_cost" , length=6 )
      
    public String getAdditionalFeeCost() {
        return this.additionalFeeCost;
    }
  
}
